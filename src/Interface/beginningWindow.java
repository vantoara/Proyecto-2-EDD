/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;
import proyecto.pkg2.csvFile;
import proyecto.pkg2.UserList;
import javax.swing.JFileChooser;
import java.io.File; 
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase asociada con la ventana inicial del programa
 * @author Liliana Nóbrega
 */
public class beginningWindow extends javax.swing.JFrame {
    
    public String path;
    
    /** Creates new form beginningWindow */
    public beginningWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        path = null;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pathTxt = new javax.swing.JTextField();
        bChoose = new javax.swing.JButton();
        bBegin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jFileChooser1.setDialogTitle("Escoge un archivo con los usuarios registrados");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("BIENVENIDO AL CENTRO DE IMPRESIÓN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 530, 40));

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 340, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Si lo deseas, puedes cargar un archivo csv de usuarios registrados");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 400, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("o, en su defecto,  iniciar desde cero.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 350, -1));

        jPanel2.setBackground(new java.awt.Color(230, 243, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CARGAR UN ARCHIVO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(230, 243, 248));
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pathTxt.setEditable(false);
        pathTxt.setBackground(new java.awt.Color(255, 255, 255));
        pathTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathTxtActionPerformed(evt);
            }
        });
        jPanel2.add(pathTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 29, 275, 20));

        bChoose.setBackground(new java.awt.Color(255, 227, 238));
        bChoose.setText("Abrir");
        bChoose.setToolTipText("Haz click aquí para escoger el archivo que deseas cargar");
        bChoose.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 2, true));
        bChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChooseActionPerformed(evt);
            }
        });
        jPanel2.add(bChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 63, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 380, 70));

        bBegin.setBackground(new java.awt.Color(204, 255, 255));
        bBegin.setText("INICIAR");
        bBegin.setToolTipText("Haz click aquí cuando estés listo para iniciar la simulación");
        bBegin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        bBegin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBeginActionPerformed(evt);
            }
        });
        jPanel1.add(bBegin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 100, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\lilin\\Documents\\UNIMET\\6\\Estructuras de Datos\\PROYECTOS\\p2\\hand-painted-watercolor-pastel-sky-background_23-2148902771.jpg")); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pathTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pathTxtActionPerformed

    private void bChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bChooseActionPerformed
        JFileChooser jf = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos .csv", "csv");
        jf.addChoosableFileFilter(filter);
        jf.setAcceptAllFileFilterUsed(false);
        jf.showOpenDialog(this);
        File file = jf.getSelectedFile();
        if (file != null){
            this.path = file.getAbsolutePath();
            pathTxt.setText(path);
        }
    }//GEN-LAST:event_bChooseActionPerformed

    private void bBeginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBeginActionPerformed
        proyecto.pkg2.UserList users = csvFile.readCSV(path);
        if (users == null){
            this.path = null;
        }
        menuWindow mW = new menuWindow(users, path);
        this.dispose();
    }//GEN-LAST:event_bBeginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(beginningWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(beginningWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(beginningWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(beginningWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new beginningWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBegin;
    private javax.swing.JButton bChoose;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField pathTxt;
    // End of variables declaration//GEN-END:variables

}
