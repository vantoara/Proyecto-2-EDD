/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

/**
 * Clase asociada al Hash Table
 * @author Ana Tovar
 */
public class HashTable {
    private Document table [];
    private int size;
    
    /**
     * Constructor de la clase
     */
    public HashTable(){
        this.size = 10111;
        this.table = new Document[size];
        for(int i = 0; i < this.size; i++){
            table[i] = null;
        }
    }
    
    /**
     * Método para obtener el valor del índice en el array
     * @param user Usuario que nos interesa buscar
     * @param doc Documento correspondiente al usuario que nos interesa buscar
     * @return índice que se le asignará en el array
     */
    public int hashing(User user, Document doc){
        String key = user.getName() + doc.getName() + doc.getType() + String.valueOf(doc.getSize());
        int hashValue = key.hashCode();
        int index = hashValue % size;
        
        return index;
    }
    
    /**
     * Método para añadir un valor al hash table
     * @param user Usuario que nos interesa buscar
     * @param doc Documento correspondiente al usuario que nos interesa buscar
     */
    public void add(User user, Document doc){
        
        int index = hashing(user, doc);
        if(table[index] != null){ // El slot correspondiente NO está vacío, es decir, algo más ocupa ese lugar
            while(table[index] != null){
                index++;
            }
            table[index] = doc;
        }else{ // Está vacío, se inserta
            table[index] = doc;
        }
    }
    
    /**
     * Método para eliminar un valor en el hash table
     * @param user Usuario que nos interesa buscar
     * @param doc Documento correspondiente al usuario que nos interesa buscar
     */
    
    public void delete(User user, Document doc){
        
        int index = hashing(user, doc);
        
        if(table[index] != null){
            while(table[index] != doc){
                index++;
            }
            table[index] = null;
        } else{
            // No se hace nada ya que está null, es decir, no existe
        }
    }

    /**
     * Método para obtener la posición del documento que nos interesa del hash table
     * @param user Usuario que nos interesa buscar
     * @param doc Documento correspondiente al usuario que nos interesa buscar
     * @return número correspondiente a la posición del documento en el binary heap, -1 si no se consiguió
     */  
    public int getPos(User user, Document doc){
        
        int index = hashing(user, doc);
        if(table[index] == null){
            return -1;
        }else{ // table[index] != null;
            while(table[index] != doc){ // Si no corresponde el documento guardado con el documento que está ahí, se procede a buscar ya que hubo una colisión
                index++;  
            } return table[index].getPosition();
        }
    }
}