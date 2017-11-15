/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.vdcarmen.dao;

import es.vdcarmen.pojo.Alumno;
import java.util.List;

/**
 *
 * @author matinal
 */
public interface AlumnoDAO {
    public void create(Alumno al) throws DAOException;
    public void update(Alumno old_al, Alumno new_al) throws DAOException;
    public void update(Integer old_id, Alumno new_al) throws DAOException;
    public void delete(Integer id) throws DAOException;
    public void delete(Alumno al)throws DAOException;
    public List findAll() throws DAOException;
    public Alumno findById(Integer Id) throws DAOException;
    public List findByNombre(String Nombre) throws DAOException;
    public List findByApellido(String Apellido) throws DAOException;
}
