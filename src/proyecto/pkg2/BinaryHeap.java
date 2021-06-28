/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

import javax.swing.JOptionPane;

/**
 * Clase asociada al montículo binario. Javadoc incompleto porque está hecho con nodos de prueba
 * @author Ana Tovar
 */
public class BinaryHeap {
    
    private Document root;
    private int size;
    
    /**
     * Constructor
     */
    public BinaryHeap(){
        this.root = null;
        this.size = 0;
    }
    
    /**
     * Método para retornar la raíz
     * @return nodo root, el de primera prioridad
     */
    public Document getMin(){
        return root;
    }
    
    /** Método para retornar el tamaño
     * @return tamaño
     */
    public int getSize() {
        return size;
    }
    
    
    /**
     * Método para corroborar si está vacío
     * @return
     */
    public boolean isEmpty(){
        return this.root == null;
    }
    
    /**
     * Método para hallar el recorrido para insertar un nuevo nodo
     * @param value, valor entero que corresponde con la "posición" en la que se colocará el nuevo nodo
     * @return
     */
    public String traversal(int value){
        
        if(isEmpty()){
            return "0"; // Si está vacío se retornará 0
        }
        
        String binary = ""; // a este string se concatenará los resultados obtenidos, no obstante estos se encuentran desde el bit menos significativo hasta el más significativo
        String binaryRev = ""; // este string sera el reverso del anterior, que corresponde al orden deseado
        
        while (value > 0){
            
            int remainder = value % 2; // el residuo es aquello que determina el valor que se añade
            binary += Integer.toString(remainder);
            value = value / 2; // una vez llegado a 1, esto retornará 0 y el while loop se romperá
        }
        
        for(int i = binary.length()-1; i >= 0; i--){
            binaryRev += binary.charAt(i); // se invierte el string
        }
   
        return binaryRev;
    }
    
    /**
     * Método para retornar el nodo correspondiente dada una posición
     * @param position, es la posición del nodo en el montículo binario
     * @return nodo correspondiente a esa posición
     */
    public Document getNode(int position){
        
        if(position > getSize()){
            return null;
        }
        
        String path = traversal(position);
        
        Document aux = root;
        
        for(int i = 1; i < path.length(); i++){
            
            char character = path.charAt(i);
            
            if(character == '0'){ // si el caracter es igual a 0, corresponde a un hijo izquierdo, así aux se actualizará hasta el penúltimo caracter
                aux = aux.getLeftSon();
            } else if (character == '1') { // si el caracter es igual a 1, corresponde a un hijo derecho
                aux = aux.getRightSon();
            }
        }
        
        return aux;
    }
    
    /**
     * Método para retornar el padre de un nodo en la posición dada. Solo se utiliza para el método insertar!
     * @param position posición del nodo hijo
     * @return se obtiene el padre del nodo
     */
    public Document getNodeParent(int position){
        
        if(position > getSize() + 1){
            return null;
        }
        
        String path = traversal(position); // obtenemos el número binario de este
        
        Document aux = root; // Se inicia desde el root

        for(int i = 1; i < path.length()-1; i++){ // Se busca hasta el penúltimo carácter para evitar null pointer errors

            char character = path.charAt(i);

            if(character == '0'){ // si el caracter es igual a 0, corresponde a un hijo izquierdo, así aux se actualizará hasta el penúltimo caracter
                aux = aux.getLeftSon();
            } else if (character == '1') { // si el caracter es igual a 1, corresponde a un hijo derecho
                aux = aux.getRightSon();
            }
        }
        
        return aux;
    }
    
    /**
     * Método para intercambiar nodos
     * @param a uno de los nodos que se desea intercambiar
     * @param b otro de los nodos que se desea intercambiar
     */
    public void swap(Document a, Document b){
        if(a != b){
            
            int temp = a.getPosition();
            Document tempLeft = a.getLeftSon();
            Document tempRight = a.getRightSon();
            Document tempFather = a.getFather();
            
            a.setPosition(b.getPosition());
            a.setLeftSon(b.getLeftSon());
            a.setRightSon(b.getRightSon());
            a.setFather(b.getFather());

            b.setPosition(temp);
            b.setLeftSon(tempLeft);
            b.setRightSon(tempRight);
            b.setFather(tempFather);
            
        }
    }
    
    
    /**
     * Método para ir moviendo el nodo que se inserta hacia arriba, si es necesario
     * @param node, nodo desde el cual se comienza a hacer el proceso
     */
    public void heapUp(Document node){
        
        Document father = node.getFather();
        
        if(node == father){
        } else {
            if(father != null){
                if(node.getValue() < father.getValue()){
                    swap(father, node);
                    heapUp(father);
                }
            }         
        }
    }
        
    /**
     * Método para insertar un nuevo nodo
     * @param n nodo nuevo que se va a insertar
     */
    public void insert(Document n){
        
        int nextPos = getSize() + 1; // corresponde a la posición deseada del nuevo nodo
        
        if(isEmpty()){      
            root = n; // si está vacío, simplemente se iguala
        } else {
            
            
            String path = traversal(nextPos); // obtenemos el número binario de este 
            Document aux = getNodeParent(nextPos);
            
            char character = path.charAt(path.length()-1); // aquí obtenemos el último valor al cual en lugar de hacerle un get, se le hará un set

            if(character == '0'){
                aux.setLeftSon(n); // se hace un set y evitamos null pointer exceptions
            } else if (character == '1') {
                aux.setRightSon(n);
            }
            n.setFather(aux); // asignamos al padre de manera que el intercambio se pueda realizar sin problemas después

        }
        
        n.setPosition(nextPos);
        n.setInQueue(true);
        size++; // sin importar que acción se tome, se aumentará el tamaño
        heapUp(n);
        
    }
    
    /**
     * Método para mostrar el montículo en forma de preorden
     * @param root, nodo desde el cual se comienza el preorder, se irá actualizando
     */
    public void preorder(Document root){
        if(root != null){
            System.out.println(root.getValue());
            preorder(root.getLeftSon());
            preorder(root.getRightSon());
        }
    }

    /**
     * Método para reorganizar el montículo cuando es necesario
     * @param root, inicialmente se comienza en el root, este se irá actualizando con la recursividad
     */
    public void heapSort(Document root){
                
        Document aux = root;
        Document leftChild = root.getLeftSon();
        Document rightChild = root.getRightSon();
                    
        if(leftChild != null && aux.getValue() > leftChild.getValue()){
            aux = leftChild;

        }if(rightChild != null && aux.getValue() > rightChild.getValue()){
            aux = rightChild;
            
        } if(aux != root){

            swap(root, aux);
            heapSort(aux);

        }       
    }
    
    /**
     * Método para eliminar el root, es decir, el nodo de mayor prioridad
     */
    public void deleteMin(){
        
        if(!isEmpty()){

            if(getSize() == 1){
                
                root.setPosition(-1); // Se settea a -1 para validaciones
                root.setInQueue(false);
                root = null;
                
            }else{

                Document last = getNode(getSize());
                String path = traversal(getSize()); // obtenemos el número binario de este

                swap(root, last);

                Document aux = last.getFather();

                char character = path.charAt(path.length()-1); // aquí obtenemos el último valor

                if(character == '0'){
                    aux.setLeftSon(null); // se hace un set y evitamos null pointer exceptions
                } else if (character == '1') {
                    aux.setRightSon(null);
                }

                last.setPosition(-1); // Se settea a -1 para validaciones
                last.setInQueue(false);
                                
                heapSort(root);
            
            }
            
            size--;
        }
          
    }
    
    /**
     * Método para eliminar un nodo dado, ya sea el root o uno distinto de este
     * @param position la posición en la que se encuante dicho nodo, este se extraerá del hashtable con el getPosition del documento en específico
     */
    public void deletion(int position){
        
        if(isEmpty()){
            JOptionPane.showMessageDialog(null, "La cola se encuentra vacía");
            
        } else {
            if(position < 1 || position > getSize()){
                JOptionPane.showMessageDialog(null, "Posición ingresada es inválida.");
                
            } else if(position == 1){
                deleteMin();
                
            } else{
                
                Document toDelete = getNode(position);
                
                toDelete.setValue(0);
                
                heapUp(toDelete);
                
                // Lo que estaba antes para eliminar, lo de arriba ^^ falta por testear
                
//                Document last = getNode(getSize());
//                
//                swap(last, toDelete);
//                
//                heapSort(toDelete);
//                
//                swap(last, root);
                
                deleteMin();               
                
            }
            
        }
    }
}
