/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

/**
 *
 * @author Guillermo Sanfuentes
 */
public class Nodo {
    private String documento;
    private Nodo Nnext;
    
    /**
     * 
     * Constructor de Nodo con solo documento
     * @param documento 
     */
    public Nodo(String documento){
        this.documento = documento;
        this.Nnext = null;
    }
    
    /**
     * Constructor de Nodo con solo documento
     * @param documento
     * @param siguiente 
     */
    public Nodo(String documento, Nodo siguiente){
        this.documento = documento;
        this.Nnext = siguiente;
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the Nnext
     */
    public Nodo getNnext() {
        return Nnext;
    }

    /**
     * @param Nnext the Nnext to set
     */
    public void setNnext(Nodo Nnext) {
        this.Nnext = Nnext;
    }
}
