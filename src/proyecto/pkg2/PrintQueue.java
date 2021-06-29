/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

import javax.swing.JOptionPane;


/**
 * Clase cola hecha para cola de impresion
 * @author Guillermo Sanfuentes
 */
public class PrintQueue {
    private Nodo head;
    private Nodo tail;
    private int size;
    
    /**
     * Constructor de la cola
     */
    public PrintQueue(){
        this.head = this.tail = null;
        this.size = 0;
    };
    
    /**
     * Saber si la cola esta vacia
     * @return False si no esta vacia
     */
    public boolean isEmpty(){
        return head == null;
    }
    
    /**
     * Vacia la cola de impresion
     */
    public void empty(){
        this.head = this.tail = null;
        this.size = 0;
    }
    
    /**
     * Encola un nuevo documento
     * @param nuevo el documento como nodo
     */
    public void queue(Nodo nuevo){
        if (this.isEmpty()){
            head = tail = nuevo;
        }else{
            tail.setNnext(nuevo);
            tail = nuevo;
        }
        size++;
    }
    
    public void dequeue(){
        if(this.isEmpty()){
            JOptionPane.showMessageDialog(null, "El documento no existe en la cola.");
        }else if (size == 1){
            this.empty();
        }else{
            head = head.getNnext();
            size--;
        }
    }
    
    public String print(){
        if (!this.isEmpty()){
            String printQueue="";
            for (int i = 0; i < size; i++){
                Nodo actual = head;
                dequeue();
                printQueue += actual.getDocumento() + "\n";
                queue(actual);
            }
            return printQueue;
        }else{
        JOptionPane.showMessageDialog(null, "El documento no existe en la cola.");
        }
        return null;
    }
    
}
