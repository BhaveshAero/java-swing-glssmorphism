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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalTime;
import java.util.Collections;

/**
 *
 * @author RAVEN
 */
public class Main2 extends javax.swing.JFrame {

    private Color defClr = new Color(70,73,75);

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

        LocalTime cT = LocalTime.now();
        String currentTime = String.valueOf(cT).substring(0, String.valueOf(cT).lastIndexOf(":"));
        System.out.println("Current time: " + currentTime);


        clock = new JLabel(currentTime);
        clock.setPreferredSize(new Dimension(200,100));
        clock.setFont(new Font("Bahnschrift", 1, 50));

        JButton closeButton = new JButton("X");
        closeButton.setPreferredSize(new Dimension(25,25));
        closeButton.setToolTipText("Exit Program?");

        JButton pinButton = new JButton("\uD83D\uDCCC");
        pinButton.setPreferredSize(new Dimension(25,25));

        panelTransparent1.add(clock);
        panelTransparent1.add(closeButton);
        panelTransparent1.add(pinButton);

        panelTransparent1.add(jLabel1);


        add(panelTransparent1);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        closeButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                closeButton.setBackground(new Color(148,58,64));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                closeButton.setBackground(defClr);
            }
        });

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

                Thread thread = new Thread(){
                    public void run(){
                        while (true){
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            LocalTime cT = LocalTime.now();
                            String currentTime = String.valueOf(cT).substring(0, String.valueOf(cT).lastIndexOf(":"));
                            System.out.println("Current time: " + currentTime);
                            clock.setText(currentTime);
                        }
                    }
                };

                thread.start();


            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;

    private static JLabel clock;

    private PanelTransparent panelTransparent1;
}
