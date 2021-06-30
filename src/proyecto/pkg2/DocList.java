/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

import javax.swing.JOptionPane;

/**
 * Clase de la lista de documentos de cada usuario (lista simplemente enlazada).
 * @author Liliana Nóbrega
 */
public class DocList {
    private Document pFirst;
    private Document pLast;
    private int size;

    /**
     * Constructor
     */
    public DocList() {
        this.pFirst = this.pLast = null;
        this.size = 0;
    }
    
    /**
     * Destructor
     */
    public void destructor(){
        this.pFirst = this.pLast = null;
        this.size = 0;
    }

    /**
     * Getter del atributo pFirst
     * @return pFirst (primer nodo de la lista)
     */
    public Document getpFirst() {
        return pFirst;
    }

    /**
     * Setter del atributo pFirst
     * @param pFirst nuevo primer nodo de la lista
     */
    public void setpFirst(Document pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Getter del atributo pLast
     * @return pLast (último nodo de la lista)
     */
    public Document getpLast() {
        return pLast;
    }

    /**
     * Setter del atributo pLast
     * @param pLast nuevo último nodo de la lista
     */
    public void setpLast(Document pLast) {
        this.pLast = pLast;
    }

    /**
     * Getter del atributo size
     * @return size (el tamaño de la lista)
     */
    public int getSize() {
        return size;
    }

    /**
     * Setter del atributo size
     * @param size el nuevo tamaño de la lista
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Método que determina si la lista está o no vacía
     * @return true si está vacía, false si no
     */
    public boolean isEmpty(){
        return (this.pFirst == null);
    }    
    
    /**
     * Método para insertar un nuevo documento al final de la lista
     * @param newDoc nuevo documento que se insertará
     */
    public void insertAtEnd(Document newDoc){
        if (this.isEmpty()){
            pFirst = pLast = newDoc;
        }else{
            pLast.setpNext(newDoc);
            pLast = newDoc;
        }
        size++;
    }
    
    /**
     * Método para eliminar un documento a partir de su nombre
     * @param name nombre del documento para eliminar
     */
    public void deleteDoc(String name){
        int position = this.getDocIndex(name);
        if (position == -1){
            JOptionPane.showMessageDialog(null, "El documento a eliminar no se encuentra en la lista de documentos de este usuario.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
            if (this.getNode(name).isInQueue()){
                JOptionPane.showMessageDialog(null, "Este documento está en la cola de impresión. Para eliminarlo permanentemente,\ndebes eliminarlo de la cola de impresión y luego eliminarlo de la lista de documentos.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }else{
                this.deleteAtPosition(position);
                JOptionPane.showMessageDialog(null, "El documento \""+name+"\" fue eliminado exitosamente.");
            }
        }
    }
    
    /**
     * Método para obtener el índice de un documento en la lista a partir de su nombre
     * @param name nombre del documento cuyo índice en la lista se busca
     * @return el índice del documento cuyo nombre se pasa por parámetro (es decir, su posición en la lista, desde el 0 hasta el tamaño de la lista menos 1) o -1 si no se consigue el documento
     */
    public int getDocIndex(String name){
        Document pAux = pFirst;
        for (int i = 0; i < size; i++) {
            if (pAux.getName().equals(name)){
                return i;
            }
            pAux = pAux.getpNext();
        }
        return -1;
    }
    
    /**
     * Método para eliminar un nodo en una determinada posición
     * @param position entero que representa el índice del nodo a eliminar (del 0 al tamaño de la lista menos 1) 
     */
    public void deleteAtPosition(int position){
        if (position >= 0 && position<size){
            if (position == 0){
                this.deleteFirstElement();
            }else if (position == size-1){
                this.deleteLastElement();
            }else{
                Document pAnt = this.getNodeAtIndex(position-1);
                if (pAnt != null){
                    pAnt.setpNext(pAnt.getpNext().getpNext());
                    size -= 1;
                }
            }
        }
    }
    
    /**
     * Método para eliminar el primer elemento de la lista
     */
    public void deleteFirstElement(){
        if (!this.isEmpty()){
            if (this.size >1){
                pFirst = pFirst.getpNext();
                size -= 1;
            }else{
                this.destructor();
            }
        }
    }
    
    /**
     * Método para eliminar el último elemento de la lista
     */
    public void deleteLastElement(){
        if (!this.isEmpty()){
            if (this.size >1){
                pLast = this.getNodeAtIndex(size-2);
                pLast.setpNext(null);
                size -= 1;
            }else{
                this.destructor();
            }
        }
    }
    
    /**
     * Método que determina si un documento está en la lista a partir de su nombre
     * @param name nombre del documento del cual se busca saber si está en la lista
     * @return true si está en la lista, false si no
     */
    public boolean isInList(String name){
        return this.getDocIndex(name) !=-1;
    }
    
    /**
     * Método que devuelve un nodo de documento a partir de su posición/índice en la lista
     * @param position entero que representa el índice del nodo a buscar (del 0 al tamaño de la lista menos 1) 
     * @return el nodo en la posición buscada de la lista o null si la posición dada es inválida
     */
    public Document getNodeAtIndex(int position){        
        if (position >= 0 && position<size){
            Document pAux = pFirst; 
            for (int i = 0; i < position; i++) {
                pAux = pAux.getpNext();
            }
            return pAux;
        }
        return null;        
    }
    
     /**
     * Método que devuelve un nodo de la lista a partir de su nombre
     * @param name nombre del documento cuyo nodo se busca
     * @return el nodo cuyo atributo name es el pasado por parámetro o null si no se encuentra en la lista
     */
    public Document getNode(String name){
        if (!this.isEmpty()){
            Document pAux = this.pFirst;
            while (pAux != null){
                if(pAux.getName().equals(name)){
                    return pAux;
                }
                pAux = pAux.getpNext();
            }
        }
        return null;
    }
    
    /**
     * Método para obtener la información de los atributos de todos los documentos en la lista
     * @return un string que contiene todos los atributos de cada documento de la lista
     */
    public String showDocs(){
        String docs = "";
        if (!this.isEmpty()){
            Document pAux = pFirst;
            for (int i = 1; i<=this.size; i++){
                docs += "------"+i+"-------------\n"+pAux.showAttributes()+"\n";
                pAux = pAux.getpNext();
            }
            return docs;
        }else{
            return "\tAún no se han creado documentos.\n";
        }
    }
    
    /**
     * Método para enviar un documento a la cola de impresión
     * @param q cola de impresión/prioridad a la que se envía el documento
     * @param name nombre del documento a enviar a la cola
     * @param user usuario que envió el documento a la cola
     * @param priority booleano que indica si el documento es de prioridad o no
     * @param timer timer que permite determinar el tiempo que debe aparecer en la etiqueta de tiempo del documento
     */
    public void sendToQueue(BinaryHeap q, String name, User user, boolean priority, Time timer, HashTable table){
        Document doc = this.getNode(name);
        if (doc == null){
            JOptionPane.showMessageDialog(null, "El documento no existe. Valide sus datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else if (!doc.isInQueue()){
            timer.setTime(priority, user, doc);
            table.add(user, doc);
            q.insert(doc);
            JOptionPane.showMessageDialog(null, "El documento \""+name+"\" fue enviado a la cola de impresión.");
        }else{
            JOptionPane.showMessageDialog(null, "El documento ya está en la cola de impresión.");
        }
    }

}
