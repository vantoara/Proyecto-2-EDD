/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

/**
 * Clase asociada al montículo binario
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
     * @return
     */
    public TestNode getMin(){
        return root;
    }
    
    /**
     * Método para corroborar si está vacío
     * @return
     */
    public boolean isEmpty(){
        return this.root == null;
    }
    
    /**
     *
     * @param added
     */
    public void swapMin(TestNode added){
        
        TestNode father = added.getParent();
        
        if(added == father){
        } else {
            if(father != null){
                if(added.getData() < father.getData()){
                    int aux = father.getData();
                    father.setData(added.getData());
                    added.setData(aux);
                    swapMin(father);
                }
            }         
        }
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
     * Método para insertar un nuevo nodo
     * @param value
     */
    public void insert(int value){
        TestNode n = new TestNode(value);
        int nextPos = size + 1; // corresponde a la posición deseada del nuevo nodo
        String path = traversal(nextPos); // obtenemos el número binario de este
        
        if(isEmpty()){
            
            root = n; // si está vacío, simplemente se iguala
            
        } else {
            
            TestNode aux = root; // Se inicia desde el root
                        
            for(int i = 1; i < path.length()-1; i++){ // Se busca hasta el penúltimo carácter para evitar null pointer errors

                char character = path.charAt(i);

                if(character == '0'){ // si el caracter es igual a 0, corresponde a un hijo izquierdo, así aux se actualizará hasta el penúltimo caracter
                    aux = aux.getLeftChild();
                } else if (character == '1') { // si el caracter es igual a 1, corresponde a un hijo derecho
                    aux = aux.getRightChild();
                }
            }
            
            char character = path.charAt(path.length()-1); // aquí obtenemos el último valor al cual en lugar de hacerle un get, se le hará un set

            if(character == '0'){
                aux.setLeftChild(n); // se hace un set y evitamos null pointer exceptions
            } else if (character == '1') {
                aux.setRightChild(n);
            }
            n.setParent(aux); // asignamos al padre de manera que el intercambio se pueda realizar sin problemas después

        }
        
        size++; // sin importar que acción se tome, se aumentará el tamaño
        
        swapMin(n);
        
    }
    
    /**
     * Método para mostrar el montículo en forma de preorden
     * @param root
     */
    public void preorder(TestNode root){
        if(root != null){
            System.out.println(root.getData());
            preorder(root.getLeftChild());
            preorder(root.getRightChild());
        }
    }
}
