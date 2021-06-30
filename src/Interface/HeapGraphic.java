/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Clase relacionada a la visualización en forma de árbol del montículo binario.
 * @author Liliana Nóbrega
 */
public class HeapGraphic extends JPanel{
    private proyecto.pkg2.BinaryHeap heap;
    private Graphic graphic = new Graphic();        	
    //private JPanel panel;
    /**
     * Constructor
     * @param heap montículo binario a graficar.
     */
    public HeapGraphic(proyecto.pkg2.BinaryHeap heap){
        this.heap = heap;
        this.setLayout(new BorderLayout());
        add(graphic, BorderLayout.CENTER);
        JFrame frame = new JFrame("Cola de impresión");
        frame.getContentPane().add(this, BorderLayout.CENTER);
        frame.setSize(new Dimension(900, 500));
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
        frame.setVisible(true);
    }
    
    /*
    * Clase interna para graficar el montículo en un panel.
    */
    class Graphic extends JPanel{
        private int r = 30; //radio de cada nodo
        private int levelGap = 45; //espacio entre niveles del montículo
        
        /*
        * Método básico para dibujar el árbol en el panel.
        * @param g instancia de Graphics que permite dibujar en componentes.
        */
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            if (!heap.isEmpty()){
                display(g, heap.getMin(), getWidth()/2, 30, getWidth()/4);
            }
        }
    
        /*
        * Método para visualizar un "subárbol" del montículo binario cuya raíz se pasa por parámetro.
        * @param g instancia de Graphics que permite dibujar en componentes de interfaz gráfica.
        * @param root raíz del subárbol que se está graficando.
        * @param x posición de la raíz en x
        * @param y posición de la raíz en y
        * @param gap separación horizontal entre nodos
        */
        public void display(Graphics g, proyecto.pkg2.Document root, int x, int y, int gap){
            g.drawOval(x-r, y-r, 2*r, 2*r);
            String name = (root.getName().length()>5)? root.getName().substring(0, 5)+"..." : root.getName();
            g.drawString(name, x-20, y+4);
            
            if (root.getLeftSon() != null) {
                this.connectLeftSon(g, x - gap, y + levelGap, x, y); //conecta a la raíz con su hijo izquierdo
                display(g, root.getLeftSon(), x - gap, y + levelGap, gap / 2); //se grafica el subárbol izquierdo
            }

            if (root.getRightSon() != null) {
                this.connectRightSon(g, x + gap, y + levelGap, x, y); //conecta a la raíz con su hijo derecho
                display(g, root.getRightSon(), x + gap, y + levelGap, gap / 2); //se grafica el subárbol derecho
            }
        }

        /*
        * Método para conectar un nodo padre en la posición (x2,y2) con su hijo izquierdo en (x1,y1)
        * @param g instancia de Graphics que permite dibujar en componentes de interfaz gráfica.
        * @param x1 coordenada x del hijo izquierdo
        * @param y1 coordenada y del hijo izquierdo
        * @param x2 coordenada x del padre
        * @param y2 coordenada y del padre
        */
        private void connectLeftSon(Graphics g, int x1, int y1, int x2, int y2) { 
          double d = Math.sqrt(levelGap * levelGap + (x2 - x1) * (x2 - x1));
          int x11 = (int)(x1 + r * (x2 - x1) / d);
          int y11 = (int)(y1 - r * levelGap / d);
          int x21 = (int)(x2 - r * (x2 - x1) / d);
          int y21 = (int)(y2 + r * levelGap / d);
          g.drawLine(x11, y11, x21, y21);
        }

        /*
        * Método para conectar un nodo padre en la posición (x2,y2) con su hijo izquierdo en (x1,y1)
        * @param g instancia de Graphics que permite dibujar en componentes de interfaz gráfica.
        * @param x1 coordenada x del hijo derecho
        * @param y1 coordenada y del hijo derecho
        * @param x2 coordenada x del padre
        * @param y2 coordenada y del padre
        */
        private void connectRightSon(Graphics g, int x1, int y1, int x2, int y2) {
          double d = Math.sqrt(levelGap * levelGap + (x2 - x1) * (x2 - x1));
          int x11 = (int)(x1 - r * (x1 - x2) / d);
          int y11 = (int)(y1 - r * levelGap / d);
          int x21 = (int)(x2 + r * (x1 - x2) / d);
          int y21 = (int)(y2 + r * levelGap / d);
          g.drawLine(x11, y11, x21, y21);
        }

        
    }
}
