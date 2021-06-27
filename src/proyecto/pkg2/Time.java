/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

/**
 *
 * @author vadau
 */
public class Time {
    
    private final long start;
    
    public Time(){
        start = System.currentTimeMillis();
    }
    
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
