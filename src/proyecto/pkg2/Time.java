/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

/**
 * Clase para medir el tiempo transcurrido
 * @author Ana Tovar
 */
public class Time {
    
    private final long start;
    
    /**
     * Constructor de la clase, start es el tiempo cuando se inicia el programa
     */
    public Time(){
        start = System.currentTimeMillis();
    }
    
    /**
     * Método para settear la etiqueta de tiempo de un documento cuando se envía a imprimir
     * @param priority booleano que revisa si el documento es de prioridad o no
     * @param user nodo de usuario que ha enviado el documento a imprimir
     * @param doc nodo de documento correspondiente al que se quiere imprimir y al que se le asignará la etiqueta de tiempo
     */
    public void getTime(boolean priority, User user, Document doc){
        long current = System.currentTimeMillis();
        double now = (current - start) / 1000.0;
        
        if(priority){
            
            switch (user.getType()) {
                case "prioridad_baja":
                    now *= 0.75;
                    break;
                case "prioridad_media":
                    now *= 0.5;
                    break;
                case "prioridad_alta":
                    now*= 0.25;
                    break;
            }
        }
        
        doc.setValue(now);
    }
    
}
