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
    private DocList table [];
    private int size;
    
    /**
     * Constructor de la clase
     */
    public HashTable(){
        this.size = 10111;
        this.table = new DocList[size];
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
        boolean exist = false;
        
        if(table[index] != null){ // Es decir, dentro de la lista hay algo
            if(table[index].getDocIndex(doc.getName()) != -1){
                exist = true;
            }
        }
        
        if(!exist){ // Revisa si ya existe en el hashtable o no
            table[index].insertAtEnd(doc);
        }
    }
    
    /**
     * Método para eliminar un valor en el hash table
     * @param user Usuario que nos interesa buscar
     * @param doc Documento correspondiente al usuario que nos interesa buscar
     */
    public void delete(User user, Document doc){
        
        int index = hashing(user, doc);
        boolean exist = true; // Ahora asumimos que si existe
        
        if(table[index] != null){ // Es decir, dentro de la lista hay algo
            if(table[index].getDocIndex(doc.getName()) == -1){
                exist = false; // En este caso no existiría
            }
        }
        
        if(exist){
            table[index].deleteAtPosition(table[index].getDocIndex(doc.getName()));
        }
        
    }
    
    /**
     * Método para obtener la posición del documento que nos interesa del hash table
     * @param user Usuario que nos interesa buscar
     * @param doc Documento correspondiente al usuario que nos interesa buscar
     * @return número correspondiente a la posición del documento en el binary heap
     */
    public int getPos(User user, Document doc){
        
        int index = hashing(user, doc);
        Document interest = table[index].getNode(doc.getName());
        
        if(interest != null){
            return interest.getPosition();
        }
        return -1;
        
    }


//    Hash table más o menos como lo plantea Stefani en la prepa, sin encadenamiento, lo hice a las 4am, así que capaz tenga errores
    
//    private Document table[];
//    private int size;
//    
//    public HashTable(){
//        this.size = 10111;
//        this.table = new Document[size];
//    }
//    
//    public int hashing(User user, Document doc){
//        
//        String key = user.getName() + doc.getName() + doc.getType() + String.valueOf(doc.getSize());
//        int hashValue = key.hashCode();
//        int index = hashValue % size;
//        
//        return index;
//        
//    }
//    
//    public void add(User user, Document doc){
//       
//        int index = hashing(user, doc);
//        boolean exist = false;
//        
//        if(table[index] != null){
//                   
//            if(table[index] == doc){
//                exist = true;
//            } else{
//                while(table[index] != null){
//                    index++;
//                    
//                }
//                
//                if(table[index] == doc){
//                    exist = true;
//                }
//            }
//            
//            if(!exist){
//                
//                table[index] = doc;
//            }
//        } else{
//            
//            table[index] = doc;
//        }
//        
//    }
//    
//    public void delete(User user, Document doc){
//    
//        int index = hashing(user, doc);
//        
//        if(table[index] == null){
//        } else{
//            if(table[index] == doc){
//                table[index] = null;
//                
//            } else{
//                while(!(table[index] == doc)){
//                    index++;
//                }
//                
//                if(table[index] == doc){
//                    table[index] = null;
//                }
//            }       
//            
//        }
//                            
//    }
//
//    
//    
//    public int getPos(User user, Document doc){
//        
//        int index = hashing(user, doc);
//        
//        if(table[index] != null){
//            if(table[index] == doc){
//                return table[index].getPosition();
//            }
//            
//            while(table[index] != doc){
//                index++;
//            }
//            
//            if(table[index] == doc){
//                return table[index].getPosition();
//            }
//            
//        }
//        
//        return -1;
//        
//    }
    
}
