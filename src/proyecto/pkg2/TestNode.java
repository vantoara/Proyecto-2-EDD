/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

/**
 * Nodo de prueba, por eso el javadoc está incompleto
 * @author Ana Tovar
 */
public class TestNode {

    private TestNode parent;
    private TestNode leftChild;
    private TestNode rightChild;
    private int data;
    private int position;
    
    /**
     * @return the parent
     */
    public TestNode getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(TestNode parent) {
        this.parent = parent;
    }

    /**
     * @return the leftChild
     */
    public TestNode getLeftChild() {
        return leftChild;
    }

    /**
     * @param leftChild the leftChild to set
     */
    public void setLeftChild(TestNode leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * @return the rightChild
     */
    public TestNode getRightChild() {
        return rightChild;
    }

    /**
     * @param rightChild the rightChild to set
     */
    public void setRightChild(TestNode rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
    }
    
    public TestNode(int data){
        this.data = data;
        this.position = -1;
    } 
    
    public int getPosition(){
        return position;
    }
    
    public void setPosition(int pos){
        this.position = pos;
    }
}
