/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

import javax.swing.JOptionPane;

/**
 * Clase asociada a los usuarios de la impresora.
 * @author Liliana Nóbrega
 */
public class User {
    private String name;
    private String type;
    private User pNext;
    private DocList docs;

    public User(String username) {
        this.name = username;
        this.type = null;
        this.pNext = null;
        this.docs = new DocList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getpNext() {
        return pNext;
    }

    public void setpNext(User pNext) {
        this.pNext = pNext;
    }

    public DocList getDocs() {
        return docs;
    }

    public void setDocs(DocList docs) {
        this.docs = docs;
    }
    
    public void createNewDoc(String name, int size, String type){
        if (this.docs.isEmpty()){
            Document newDoc = new Document(name, size, type);
            this.docs.insertAtEnd(newDoc);
        }else{
            if(this.docs.isInList(name)){
                JOptionPane.showMessageDialog(null, "Ya existe un documento con ese nombre para este usuario.");
            }else{
                Document newDoc = new Document(name, size, type);
                this.docs.insertAtEnd(newDoc);
            }
        }
    }
        
    public String showAttributes(){
        return "Nombre de usuario: "+this.name+"\nTipo de prioridad: "+this.type+"\nDocumento(s):\n"+this.docs.showDocs();
    }
    
}
