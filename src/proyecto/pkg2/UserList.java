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

    public UserList() {
        this.pFirst = this.pLast = null;
        this.size = 0;
    }
    
    public void destructor(){
        this.pFirst = this.pLast = null;
        this.size = 0;
    }

    public User getpFirst() {
        return pFirst;
    }

    public void setpFirst(User pFirst) {
        this.pFirst = pFirst;
    }

    public User getpLast() {
        return pLast;
    }

    public void setpLast(User pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty(){
        return (this.pFirst == null);
    }    
    
    public void insertAtEnd(User newUser){
        if (this.isEmpty()){
            pFirst = pLast = newUser;
        }else{
            pLast.setpNext(newUser);
            pLast = newUser;
        }
        size++;
    }
    
    public void deleteUser(String name){
        int position = this.getUserIndex(name);
        if (position == -1){
            JOptionPane.showMessageDialog(null, "El usuario a eliminar no se encuentra registrado.");
        }else{
            this.deleteAtPosition(position);
            JOptionPane.showMessageDialog(null, "El usuario \""+name+"\" fue exitosamente eliminado.");
        }
    }
    
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
    
    public boolean isInList(String name){
        return this.getUserIndex(name) !=-1;
    }
    
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
    
    public String showUsers(){
        String users = "";
        User pAux = pFirst;
        while (pAux != null){
            users += pAux.showAttributes();
            pAux = pAux.getpNext();
        }
        return users;
    }
}
