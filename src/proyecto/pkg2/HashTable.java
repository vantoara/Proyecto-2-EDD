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
    private Document[] table;
    private final int size;
    
    /**
     * Constructor de la clase
     */
    public HashTable(){
        this.size = 12289;
        this.table = new Document[size];
        for(int i = 0; i < this.size; i++){
            table[i] = null;
        }
    }
    
    /**
     * Método para obtener el valor del índice en el array "table"
     * @param user Usuario que nos interesa buscar
     * @param doc Documento correspondiente al usuario que nos interesa buscar
     * @return índice que se le asignará en el array
     */
    public int hashing(User user, Document doc){
        String key = user.getName() + doc.getName() + doc.getType() + doc.getSize();
        int hashValue = key.hashCode();
        int index = hashValue % size;
        if (index<0){ //si se obtiene un índice negativo, lo multiplica por -1 para obtener un valor positivo (los índices negativos son inválidos).
            index *= -1;
        }
        return index;
    }
    
    /**
     * Método para añadir un valor al hash table
     * @param user Usuario que nos interesa buscar
     * @param doc Documento correspondiente al usuario que nos interesa buscar
     */
    public void add(User user, Document doc){
       
        int index = hashing(user, doc);
        boolean exist = false;
        
        if(table[index] != null){
            
            Document temp = table[index];
                   
            if(temp == doc){
                exist = true;
            }
            
            while(temp.getHashNext() != null && !exist){
                temp = temp.getHashNext();
                if(temp == doc){
                    exist = true;
                } 
            }
            
            if(!exist){

                temp.setHashNext(doc);
            }
    
        } else{
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
            
            Document temp = table[index];
            Document aux;
            
            if(temp == doc){
                
                aux = temp.getHashNext();
                temp.setHashNext(null);
                table[index] = aux;
                
            } else{
                
                while(temp.getHashNext() != null){
                    aux = temp;
                    temp = temp.getHashNext();
                    if(temp == doc){
                        aux.setHashNext(temp.getHashNext());
                        temp.setHashNext(null);
                    } 
                }
            }       
            
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
        Document temp = table[index];   
        boolean exist = false;
        
        if(temp != null){
            if(temp.getHashNext() == null){
                exist = true;
            } else{
                while(temp != null && !exist){
                    if(temp == doc){
                        exist = true;
                    } else{
                        temp = temp.getHashNext();
                    }
                }
            }
        }
        
        if(exist){
            return doc.getPosition();
        } else{
            return -1;
        }   
    }
}