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

    /**
     * Constructor
     * @param username nombre del nuevo usuario creado
     * @param type tipo de prioridad del nuevo usuario creado
     */
    public User(String username, String type) {
        this.name = username;
        this.type = type;
        this.pNext = null;
        this.docs = new DocList();
    }

    /**
     * Getter del atributo name
     * @return name (el nombre del usuario)
     */
    public String getName() {
        return name;
    }

    /**
     * Setter del atributo name
     * @param name nuevo nombre del usuario
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter del atributo type
     * @return type (el tipo de prioridad del usuario)
     */
    public String getType() {
        return type;
    }

    /**
     * Setter del atributo type
     * @param type nuevo tipo de prioridad del usuario
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter del atributo pNext
     * @return pNext (nodo siguiente en la lista de usuarios)
     */
    public User getpNext() {
        return pNext;
    }

    /**
     * Setter del atributo pNext
     * @param pNext nuevo nodo siguiente al usuario en la lista de usuarios
     */
    public void setpNext(User pNext) {
        this.pNext = pNext;
    }

    /**
     * Getter del atributo docs
     * @return docs (lista de los documentos creados por el usuario)
     */
    public DocList getDocs() {
        return docs;
    }

    /**
     * Setter del atributo docs
     * @param docs nueva lista de documentos del usuario
     */
    public void setDocs(DocList docs) {
        this.docs = docs;
    }

    /**
     * Método para que el usuario cree un nuevo documento
     * @param name string con el nombre del documento a crear (el mismo no debe existir ya en su lista de documentos)
     * @param size entero que representa el tamaño en bytes del documento a crear
     * @param type string con el tipo del documento a crear
     */
    public void createNewDoc(String name, int size, String type){
        if (this.docs.isEmpty()){
            Document newDoc = new Document(name, size, type);
            this.docs.insertAtEnd(newDoc);
            JOptionPane.showMessageDialog(null, "Documento creado exitosamente.");
        }else{
            if(this.docs.isInList(name)){
                JOptionPane.showMessageDialog(null, "Ya existe un documento con ese nombre para este usuario.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else{
                Document newDoc = new Document(name, size, type);
                this.docs.insertAtEnd(newDoc);
                JOptionPane.showMessageDialog(null, "Documento creado exitosamente.");
            }
        }
    }

    /**
     * Método para mostrar los atributos del usuario
     * @return un string con todos los atributos del usuario
     */    
    public String showAttributes(){
        return "Nombre de usuario: "+this.name+"\nTipo de prioridad: "+this.type+"\nDocumento(s):\n"+this.docs.showDocs();
    }
    
}
