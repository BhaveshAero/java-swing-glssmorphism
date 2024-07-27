/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.formdev.flatlaf.*;
import ru.krlvm.swingacrylic.SwingAcrylic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author RAVEN
 */
public class Main2 extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main2() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {
        panelTransparent1 = new PanelTransparent();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);


        JButton button = new JButton("Click me");
        button.setSize(10,10);
        button.setVisible(true);

        JList<String> list = new JList<String>();
        list.setListData(new String[] {"Hello", "World"});
        list.setPreferredSize(new Dimension(100, 100));


        panelTransparent1.add(button);
        panelTransparent1.add(list);

        panelTransparent1.add(jLabel1);


        add(panelTransparent1);

        pack();
    }


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(com.formdev.flatlaf.FlatDarkLaf);
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SwingAcrylic.prepareSwing();
                FlatLaf.setGlobalExtraDefaults( Collections.singletonMap( "@accentColor", "#DEDEDE" ) );
                FlatDarkLaf.setup();
                Main2 fram = new Main2();
                fram.setVisible(true);
                SwingAcrylic.processFrame(fram);

                fram.setExtendedState(JFrame.MAXIMIZED_BOTH);

                fram.toBack();


            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;

    private PanelTransparent panelTransparent1;
}
