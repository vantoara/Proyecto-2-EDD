/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 * Clase relacionada a la lectura y escritura en archivo csv
 * @author Liliana Nóbrega
 */
public class csvFile {
    
    /**
     * Función para leer un archivo csv y obtener de sus datos una lista de usuarios registrados
     * @param path string con la dirección del archivo csv del que se leerán los datos
     * @return la lista de usuarios registrados obtenida de los datos del csv o null si hay un error en la lectura del archivo
     */
    public static UserList readCSV(String path){
        if (path != null){
            UserList users = new UserList();
            String text = "";
            String line;
            File file = new File(path);
            try{

                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty() && !line.equals("usuario, tipo")) {
                        text += line + "\n";
                    }
                }
                if (!"".equals(text)) {
                    String[] nodes = text.split("\n");
                    for (String node : nodes){
                        String [] nodoInfo = node.split(",");
                        if (nodoInfo[1].contains("prioridad_alta") || nodoInfo[1].contains("prioridad_media") || nodoInfo[1].contains("prioridad_baja")){
                            users.insertAtEnd(nodoInfo[0], nodoInfo[1].trim());
                        }else{
                            throw new Exception();
                        }
                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null, "Archivo cargado exitosamente.");
                return users;
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error al leer el archivo de csv. Se procederá sin usuarios registrados.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }    
    
    /**
     * Función para escribir en un archivo csv los datos de la lista de usuarios registrados.
     * @param path string con la dirección del archivo csv en el que se escribirán los datos.
     * @param users lista de usuarios registrados usada en el proyecto.
     */
    public static void writeCSV(String path, UserList users){

        try{
            String text = "usuario, tipo\n";
            if (!users.isEmpty()){
                User pAux = users.getpFirst();
                while (pAux != null) {
                    text += pAux.getName();
                    text += ", "+pAux.getType();
                    text += "\n";
                    pAux = pAux.getpNext();
                }
            }
            PrintWriter pw = new PrintWriter(path);
            pw.print(text);
            pw.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al guardar en el archivo de csv. Los cambios no serán guardados.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
