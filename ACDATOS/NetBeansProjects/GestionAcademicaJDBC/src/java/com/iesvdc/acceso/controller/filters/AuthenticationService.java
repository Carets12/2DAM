package com.iesvdc.acceso.controller.filters;

import com.iesvdc.acceso.dao.Conexion;
import com.iesvdc.acceso.dao.DAOException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthenticationService {
	public boolean authenticate(String authCredentials) {
            boolean valor = false;
		if (null == authCredentials)
			return false;
		// header value format will be "Basic encodedstring" for Basic
		// authentication. Example "Basic YWRtaW46YWRtaW4="
		final String encodedUserPassword = authCredentials.replaceFirst("Basic"
				+ " ", "");
		String usernameAndPassword = null;
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(
					encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		final StringTokenizer tokenizer = new StringTokenizer(
				usernameAndPassword, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();

		// we have fixed the userid and password as admin
		// call some UserService/LDAP here               
                            
            try {         
                Conexion conexion = new Conexion();
                Connection con = conexion.getConexion();
                PreparedStatement pstm = con.prepareStatement(
                        "COUNT(SELECT * FROM USER WHERE username=?, password=?)");
                pstm.setString(1, username);
                pstm.setString(2, password);
                ResultSet rs = pstm.executeQuery();
                
                if (rs.next()){
                    valor = true;
                }else {
                    valor = false;
                }
                return valor; 
                
            } catch (SQLException ex) {
                Logger.getLogger(AuthenticationService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DAOException ex) {
                Logger.getLogger(AuthenticationService.class.getName()).log(Level.SEVERE, null, ex);
            }
                           
		boolean authenticationStatus = "admin".equals(username)
				&& "admin".equals(password);
		return authenticationStatus;
	}
}
