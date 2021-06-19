/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

import javax.swing.JOptionPane;

/**
 * Clase asociada a los documentos a imprimir.
 * @author Liliana Nóbrega
 */
public class Document {
    private String name;
    private int size;
    private String type;
    private boolean inQueue;
    private Document father;
    private Document leftSon;
    private Document rightSon;
    private Document pNext;

    public Document(String name, int size, String type) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.inQueue = false;
        this.father = this.leftSon = this.rightSon = this.pNext = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isInQueue() {
        return inQueue;
    }

    public void setInQueue(boolean inQueue) {
        this.inQueue = inQueue;
    }

    public Document getFather() {
        return father;
    }

    public void setFather(Document father) {
        this.father = father;
    }

    public Document getLeftSon() {
        return leftSon;
    }

    public void setLeftSon(Document leftSon) {
        this.leftSon = leftSon;
    }

    public Document getRightSon() {
        return rightSon;
    }

    public void setRightSon(Document rightSon) {
        this.rightSon = rightSon;
    }

    public Document getpNext() {
        return pNext;
    }

    public void setpNext(Document pNext) {
        this.pNext = pNext;
    }
    
    public void sendToQueue(){
        this.inQueue = true;
        JOptionPane.showMessageDialog(null, "El documento \""+this.name+"\" fue enviado a la cola de impresión.");
    }
    
    public void printDoc(){
        this.inQueue = false;
        JOptionPane.showMessageDialog(null, "El documento \""+this.name+"\" ha sido impreso exitosamente.");
        
    }
    
    public String showAttributes(){
        return "\tNombre: \""+this.name+"\"\n\tTamaño: "+this.size+" Bytes\n\tTipo: "+this.type+"\n\tEstado: "+((this.inQueue)? "en la cola de impresión.\n" : "listo para enviar a la cola de impresión.\n");
    }
    
}
