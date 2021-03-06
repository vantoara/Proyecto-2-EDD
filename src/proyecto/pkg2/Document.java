/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

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
    private int position; // Servirá más que nada en el hashtable y la función de eliminar
    private double value;
    private Document hashNext;
    
    /**
     * Constructor
     * @param name nombre del nuevo documento creado
     * @param size tamaño en bytes del documento
     * @param type tipo del documento
     */
    public Document(String name, int size, String type) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.inQueue = false;
        this.father = this.leftSon = this.rightSon = this.pNext = this.hashNext = null;
        this.position = -1;
        this.value = -1;
    }

    /**
     * Getter del atributo name
     * @return name (el nombre del documento)
     */
    public String getName() {
        return name;
    }

    /**
     * Setter del atributo name
     * @param name nuevo nombre del documento
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter del atributo size
     * @return size (tamaño en bytes del documento)
     */
    public int getSize() {
        return size;
    }

    /**
     * Setter del atributo size
     * @param size nuevo tamaño en bytes del documento
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Getter del atributo type
     * @return type (el tipo del documento)
     */
    public String getType() {
        return type;
    }

    /**
     * Setter del atributo type
     * @param type nuevo tipo del documento
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Método que determina si el documento está o no en la cola de impresión
     * @return el valor del atributo inQueue, que es true cuando está en la cola y false cuando no
     */
    public boolean isInQueue() {
        return inQueue;
    }

    /**
     * Setter del atributo inQueue
     * @param inQueue nuevo valor del atributo inQueue (true si está en la cola de impresión, false si no)
     */
    public void setInQueue(boolean inQueue) {
        this.inQueue = inQueue;
    }

    /**
     * Getter del atributo father
     * @return father (el padre del nodo en el montículo binario)
     */
    public Document getFather() {
        return father;
    }

    /**
     * Setter del atributo father
     * @param father nuevo padre del documento en el montículo binario
     */
    public void setFather(Document father) {
        this.father = father;
    }

    /**
     * Getter del atributo leftSon
     * @return leftSon (hijo izquierdo del documento en el montículo binario)
     */
    public Document getLeftSon() {
        return leftSon;
    }

    /**
     * Setter del atributo leftSon
     * @param leftSon nuevo hijo izquierdo del documento en el montículo binario
     */
    public void setLeftSon(Document leftSon) {
        this.leftSon = leftSon;
    }

    /**
     * Getter del atributo rightSon
     * @return rightSon (hijo derecho del documento en el montículo binario)
     */
    public Document getRightSon() {
        return rightSon;
    }

    /**
     * Setter del atributo rightSon
     * @param rightSon nuevo hijo derecho del documento en el montículo binario
     */
    public void setRightSon(Document rightSon) {
        this.rightSon = rightSon;
    }

    /**
     * Getter del atributo pNext
     * @return pNext (siguiente documento en la lista de documentos)
     */
    public Document getpNext() {
        return pNext;
    }

    /**
     * Setter del atributo pNext
     * @param pNext nuevo nodo siguiente en la lista de documentos
     */
    public void setpNext(Document pNext) {
        this.pNext = pNext;
    }

    /**
     * Método para mostrar los atributos del documento
     * @return string con todos los atributos del documento
     */
    public String showAttributes(){
        return "\tNombre: \""+this.name+"\"\n\tTamaño: "+this.size+" Bytes\n\tTipo: "+this.type+"\n\tEstado: "+((this.inQueue)? "en la cola de impresión.\n" : "listo para enviar a la cola de impresión.\n");
    }
    
    /**
     * Getter del atributo position
     * @return position (posición del documento en la cola de impresión)
     * @author Ana Tovar
     */    
    public int getPosition(){
        return position;
    }

    /**
     * Setter del atributo position
     * @param pos nueva posición del documento en la cola de impresión
     * @author Ana Tovar
     */        
    public void setPosition(int pos){
        this.position = pos;
    }
    
    /**
     * Getter del atributo value
     * @return value (representa la etiqueta de tiempo que dicta la posición del documento en la cola de impresión)
     * @author Ana Tovar
     */
    public double getValue(){
        return value;
    }
    
    /**
     * Setter del atributo value
     * @param time nuevo valor para el atributo value, que representa la etiqueta de tiempo que dicta la posición del documento en la cola de impresión
     * @author Ana Tovar
     */
    public void setValue(double time){
        this.value = time;
    }
    
    /**
     * Getter del atributo hashNext
     * @return hashNext, siguiente elemento en la misma posición del hash table
     * @author Ana Tovar
     */
    public Document getHashNext(){
        return hashNext;
    }
    
    /**
     * Setter del atributo value
     * @param next nuevo nodo siguiente en la misma posición del hash table
     * @author Ana Tovar
     */
    public void setHashNext(Document next){
        this.hashNext = next;
    }
    
}
