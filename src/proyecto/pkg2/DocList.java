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

    public DocList() {
        this.pFirst = this.pLast = null;
        this.size = 0;
    }
    
    public void destructor(){
        this.pFirst = this.pLast = null;
        this.size = 0;
    }

    public Document getpFirst() {
        return pFirst;
    }

    public void setpFirst(Document pFirst) {
        this.pFirst = pFirst;
    }

    public Document getpLast() {
        return pLast;
    }

    public void setpLast(Document pLast) {
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
    
    public void insertAtEnd(Document newDoc){
        if (this.isEmpty()){
            pFirst = pLast = newDoc;
        }else{
            pLast.setpNext(newDoc);
            pLast = newDoc;
        }
        size++;
    }
    
    public void deleteDoc(String name){
        int position = this.getDocIndex(name);
        if (position == -1){
            JOptionPane.showMessageDialog(null, "El documento a eliminar no se encuentra en la lista de documentos de este usuario.");
        }else{
            this.deleteAtPosition(position);
            JOptionPane.showMessageDialog(null, "El documento \""+name+"\" fue eliminado exitosamente.");
        }
    }
    
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
        return this.getDocIndex(name) !=-1;
    }
    
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
    
    public String showDocs(){
        String docs = "";
        if (!this.isEmpty()){
            Document pAux = pFirst;
            for (int i = 1; i<=this.size; i++){
                docs += "\n------"+i+"-------------------\n"+pAux.showAttributes();
                pAux = pAux.getpNext();
            }
            return docs;
        }else{
            return "\n\tAún no se han creado documentos.\n";
        }
    }
}
