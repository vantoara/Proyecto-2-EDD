/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

/**
 *
 * @author vadau
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryHeap test = new BinaryHeap();
        test.insert(1);
        test.insert(5);
        test.insert(3);
        test.insert(50);
        test.insert(10);
        test.insert(20);
        test.insert(2);

        test.preorder(test.getMin());
        
        System.out.println("test");
        TestNode node = test.getMin();
        System.out.println(node.getRightChild().getRightChild().getData());
    }
    
}
