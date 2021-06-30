/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

import javax.swing.JOptionPane;

/**
 * Clase de la lista de usuarios registrados (lista simplemente enlazada).
 * @author Liliana Nóbrega
 */
public class UserList {
    private User pFirst;
    private User pLast;
    private int size;

    /**
     * Constructor
     */
    public UserList() {
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
    public User getpFirst() {
        return pFirst;
    }

    /**
     * Setter del atributo pFirst
     * @param pFirst nuevo primer nodo de la lista
     */
    public void setpFirst(User pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Getter del atributo pLast
     * @return pLast (último nodo de la lista)
     */
    public User getpLast() {
        return pLast;
    }

    /**
     * Setter del atributo pLast
     * @param pLast nuevo último nodo de la lista
     */
    public void setpLast(User pLast) {
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
     * Método para insertar un nuevo usuario al final de la lista
     * @param name nombre del nuevo usuario que se insertará
     * @param type tipo de prioridad del nuevo usuario que se insertará
     */
    public void insertAtEnd(String name, String type){
        User newUser = new User(name, type);
        if (this.isEmpty()){
            pFirst = pLast = newUser;
        }else{
            pLast.setpNext(newUser);
            pLast = newUser;
        }
        size++;
    }

    /**
     * Método para eliminar un usuario a partir de su nombre
     * @param name nombre del usuario para eliminar
     */
    public void deleteUser(String name){
        int position = this.getUserIndex(name);
        if (position == -1){
            JOptionPane.showMessageDialog(null, "El usuario a eliminar no se encuentra registrado.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
            this.deleteAtPosition(position);
            JOptionPane.showMessageDialog(null, "El usuario \""+name+"\" fue exitosamente eliminado.");
        }
    }

    /**
     * Método para obtener el índice de un usuario en la lista a partir de su nombre
     * @param name nombre del usuario cuyo índice en la lista se busca
     * @return el índice del usuario cuyo nombre se pasa por parámetro (es decir, su posición en la lista, desde el 0 hasta el tamaño de la lista menos 1) o -1 si no se consigue al usuario
     */
    public int getUserIndex(String name){
        User pAux = pFirst;
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
                User pAnt = this.getNodeAtIndex(position-1);
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
     * Método que determina si un usuario está en la lista a partir de su nombre
     * @param name nombre del usuario del cual se busca saber si está en la lista
     * @return true si está en la lista, false si no
     */
    public boolean isInList(String name){
        return this.getUserIndex(name) !=-1;
    }

    /**
     * Método que devuelve un nodo de usuario a partir de su posición/índice en la lista
     * @param position entero que representa el índice del nodo a buscar (del 0 al tamaño de la lista menos 1) 
     * @return el nodo en la posición buscada de la lista o null si la posición dada es inválida
     */
    public User getNodeAtIndex(int position){        
        if (position >= 0 && position<size){
            User pAux = pFirst; 
            for (int i = 0; i < position; i++) {
                pAux = pAux.getpNext();
            }
            return pAux;
        }
        return null;        
    }

    /**
     * Método que devuelve un nodo de la lista a partir de su nombre
     * @param name nombre del usuario cuyo nodo se busca
     * @return el nodo cuyo atributo name es el pasado por parámetro o null si no se encuentra en la lista
     */
    public User getNode(String name){
        if (!this.isEmpty()){
            User pAux = this.pFirst;
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
     * Método para obtener la información de los atributos de todos los usuarios en la lista
     * @return un string que contiene todos los atributos de cada usuario de la lista
     */
    public String showUsers(){
        String users = "";
        User pAux = pFirst;
        while (pAux != null){
            users += pAux.showAttributes();
            users += "\n";
            pAux = pAux.getpNext();
        }
        return users;
    }
    
    /**
     * Método para conseguir el usuario que creó un documento específico.
     * @param doc documento creado por un usuario, el cual se busca.
     * @return usuario que creó el usuario o null si no se consiguió.
     */
    public User findUserOfDoc(Document doc){
        User pAux = pFirst;
        Document auxDoc;
        while (pAux!=null){
            auxDoc = pAux.getDocs().getNode(doc.getName());
            if (auxDoc != null){
                if (auxDoc.equals(doc)){
                    return pAux;
                }
            }
            pAux = pAux.getpNext();
        }
        return null;
    }
}
