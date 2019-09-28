/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.UI;

import ICONES.Icones;
import Source.Callbacks.ConstructeurCriteres;
import Source.Callbacks.EcouteurStandard;
import Sources.CHAMP_LOCAL;
import Sources.PROPRIETE;
import Sources.UI.JS2BPanelPropriete;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author HP Pavilion
 */
public class DialCriteres extends javax.swing.JDialog {

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;
    public JS2BPanelPropriete panProp = null;
    private Icones icones = null;
    private ConstructeurCriteres constructeurCriteres;
    private EcouteurStandard ecouteurStandard;
    
    /**
     * Creates new form DialCriteres
     */
    
    public DialCriteres(java.awt.Frame parent, boolean modal, ConstructeurCriteres constructeurCriteres, EcouteurStandard ecouteurStandard) {
        super(parent, modal);
        this.initComponents();
        this.constructeurCriteres = constructeurCriteres;
        this.ecouteurStandard = ecouteurStandard;
        this.icones = new Icones();
        this.initFormulaire();
        this.initBoutonsSoumission();
    }

    public JS2BPanelPropriete getPanProp() {
        return panProp;
    }
    
    private void initBoutonsSoumission() {
        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
        btAppliquer.setIcon(icones.getOk_01());
        btNePasAppliquer.setIcon(icones.getAnnuler_01());
    }

    public void chargerData() {

        Vector listeClasses = new Vector();
        listeClasses.add("TOUTES LES CLASSES");
        listeClasses.add("G1");
        listeClasses.add("G2");
        listeClasses.add("G3");
        listeClasses.add("L1");
        listeClasses.add("L2");

        panProp = new JS2BPanelPropriete(icones.getFiltrer_01(), "Critères avancés", true);
        panProp.viderListe();
        panProp.AjouterPropriete(new CHAMP_LOCAL(icones.getClasse_01(), "Classe", "cls", listeClasses, listeClasses.firstElement(), PROPRIETE.TYPE_CHOIX_LISTE), 0);
        panProp.AjouterPropriete(new CHAMP_LOCAL(icones.getClasse_01(), "Enseignant", "cls", listeClasses, listeClasses.firstElement(), PROPRIETE.TYPE_CHOIX_LISTE), 0);
        panProp.AjouterPropriete(new CHAMP_LOCAL(icones.getClasse_01(), "Solvabilité", "cls", listeClasses, listeClasses.firstElement(), PROPRIETE.TYPE_CHOIX_LISTE), 0);
        panProp.AjouterPropriete(new CHAMP_LOCAL(icones.getClasse_01(), "Cours", "cls", listeClasses, listeClasses.firstElement(), PROPRIETE.TYPE_CHOIX_LISTE), 0);
        panProp.AjouterPropriete(new CHAMP_LOCAL(icones.getClasse_01(), "Période", "cls", listeClasses, listeClasses.firstElement(), PROPRIETE.TYPE_CHOIX_LISTE), 0);
        panProp.AjouterPropriete(new CHAMP_LOCAL(icones.getClasse_01(), "Frais", "cls", listeClasses, listeClasses.firstElement(), PROPRIETE.TYPE_CHOIX_LISTE), 0);
    }

    private void initFormulaire() {
        //chargerData(); on utilisait cette méthode pour des raisons de test
        if (constructeurCriteres != null) {
            panProp = constructeurCriteres.onInitialise();
            if (panProp != null) {
                panProp = constructeurCriteres.onInitialise();
                panProp.chargerPanel(jTabbedPane1);
            }
        }
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btAppliquer = new javax.swing.JButton();
        btNePasAppliquer = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setTitle("Crières");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        btAppliquer.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btAppliquer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_Objets/Facture01.png"))); // NOI18N
        btAppliquer.setText("Appliquer");
        btAppliquer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAppliquerActionPerformed(evt);
            }
        });

        btNePasAppliquer.setForeground(new java.awt.Color(255, 51, 0));
        btNePasAppliquer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_Objets/Facture01.png"))); // NOI18N
        btNePasAppliquer.setText("Ne pas appliquer");
        btNePasAppliquer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNePasAppliquerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addComponent(btAppliquer, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNePasAppliquer)
                .addContainerGap())
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNePasAppliquer)
                    .addComponent(btAppliquer))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(btAppliquer);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAppliquerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAppliquerActionPerformed
        if (ecouteurStandard != null) {
            //panProp.tableauPrincipal.setRowSelectionInterval(0, 0);;
            ecouteurStandard.onDone("validé");
        }
        doClose(RET_OK);
    }//GEN-LAST:event_btAppliquerActionPerformed

    private void btNePasAppliquerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNePasAppliquerActionPerformed
        if (ecouteurStandard != null) {
            ecouteurStandard.onError("Annulé");
        }
        doClose(RET_CANCEL);
    }//GEN-LAST:event_btNePasAppliquerActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

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
            java.util.logging.Logger.getLogger(DialCriteres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialCriteres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialCriteres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialCriteres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialCriteres dialog = new DialCriteres(new javax.swing.JFrame(), true, null, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAppliquer;
    private javax.swing.JButton btNePasAppliquer;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
}