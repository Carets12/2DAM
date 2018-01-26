/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matinal
 */
public class Procesos2 {
    public static void main(String[] args){
        List<String> commands = new ArrayList<>();
        commands.add("ls");
        commands.add("-ls");
        ProcessBuilder pBuilder = new ProcessBuilder(commands);
        Process process = pBuilder.directory(new File("/home/psp"));
    }
}
