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
    
    private TestNode root;
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
    public TestNode getMin(){
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
    public TestNode getNode(int position){
        
        if(position > getSize()){
            return null;
        }
        
        String path = traversal(position);
        
        TestNode aux = root;
        
        for(int i = 1; i < path.length(); i++){
            
            char character = path.charAt(i);
            
            if(character == '0'){ // si el caracter es igual a 0, corresponde a un hijo izquierdo, así aux se actualizará hasta el penúltimo caracter
                aux = aux.getLeftChild();
            } else if (character == '1') { // si el caracter es igual a 1, corresponde a un hijo derecho
                aux = aux.getRightChild();
            }
        }
        
        return aux;
    }
    
    /**
     * Método para retornar el padre de un nodo en la posición dada. Solo se utiliza para el método insertar!
     * @param position posición del nodo hijo
     * @return se obtiene el padre del nodo
     */
    public TestNode getNodeParent(int position){
        
        if(position > getSize() + 1){
            return null;
        }
        
        String path = traversal(position); // obtenemos el número binario de este
        
        TestNode aux = root; // Se inicia desde el root

        for(int i = 1; i < path.length()-1; i++){ // Se busca hasta el penúltimo carácter para evitar null pointer errors

            char character = path.charAt(i);

            if(character == '0'){ // si el caracter es igual a 0, corresponde a un hijo izquierdo, así aux se actualizará hasta el penúltimo caracter
                aux = aux.getLeftChild();
            } else if (character == '1') { // si el caracter es igual a 1, corresponde a un hijo derecho
                aux = aux.getRightChild();
            }
        }
        
        return aux;
    }
    
    /**
     * Método para intercambiar nodos
     * @param a uno de los nodos que se desea intercambiar
     * @param b otro de los nodos que se desea intercambiar
     */
    public void swap(TestNode a, TestNode b){
        if(a != b){
            TestNode temp = new TestNode(a.getData());
            a.setData(b.getData());
            b.setData(temp.getData());
        }
    }
    
    
    /**
     * Método para ir moviendo el nodo que se inserta hacia arriba, si es necesario
     * @param node, nodo desde el cual se comienza a hacer el proceso
     */
    public void heapUp(TestNode node){
        
        TestNode father = node.getParent();
        
        if(node == father){
        } else {
            if(father != null){
                if(node.getData() < father.getData()){
                    swap(father, node);
                    heapUp(father);
                }
            }         
        }
    }
        
    /**
     * Método para insertar un nuevo nodo
     * @param value, valor del nodo nuevo (CAMBIAR PARA DOCUMENTO)
     */
    public void insert(int value){
        TestNode n = new TestNode(value);
        
        if(isEmpty()){      
            root = n; // si está vacío, simplemente se iguala
        } else {
            
            int nextPos = getSize() + 1; // corresponde a la posición deseada del nuevo nodo
            String path = traversal(nextPos); // obtenemos el número binario de este 
            TestNode aux = getNodeParent(nextPos);
            
            char character = path.charAt(path.length()-1); // aquí obtenemos el último valor al cual en lugar de hacerle un get, se le hará un set

            if(character == '0'){
                aux.setLeftChild(n); // se hace un set y evitamos null pointer exceptions
            } else if (character == '1') {
                aux.setRightChild(n);
            }
            n.setParent(aux); // asignamos al padre de manera que el intercambio se pueda realizar sin problemas después

        }
        
        size++; // sin importar que acción se tome, se aumentará el tamaño
        heapUp(n);
        
    }
    
    /**
     * Método para mostrar el montículo en forma de preorden
     * @param root, nodo desde el cual se comienza el preorder, se irá actualizando
     */
    public void preorder(TestNode root){
        if(root != null){
            System.out.println(root.getData());
            preorder(root.getLeftChild());
            preorder(root.getRightChild());
        }
    }

    /**
     * Método para reorganizar el montículo cuando es necesario
     * @param root, inicialmente se comienza en el root, este se irá actualizando con la recursividad
     */
    public void heapSort(TestNode root){
                
        TestNode aux = root;
        TestNode leftChild = root.getLeftChild();
        TestNode rightChild = root.getRightChild();
                    
        if(leftChild != null && aux.getData() > leftChild.getData()){
            aux = leftChild;

        }if(rightChild != null && aux.getData() > rightChild.getData()){
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

                root = null;
                size --;

            }else{

                TestNode last = getNode(getSize());
                String path = traversal(getSize()); // obtenemos el número binario de este

                swap(root, last);

                TestNode aux = last.getParent();

                char character = path.charAt(path.length()-1); // aquí obtenemos el último valor

                if(character == '0'){
                    aux.setLeftChild(null); // se hace un set y evitamos null pointer exceptions
                } else if (character == '1') {
                    aux.setRightChild(null);
                }

                size--;

                heapSort(root);
            
            }
        }
          
    }
    
    /**
     * Método para eliminar un nodo dado, ya sea el root o uno distinto de este
     * @param position la posición en la que se encuante dicho nodo
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
                
                TestNode toDelete = getNode(position);
                TestNode last = getNode(getSize());
                
                swap(last, toDelete);
                
                heapSort(toDelete);
                
                swap(last, root);
                
                deleteMin();               
                
            }
            
        }
    }
}
