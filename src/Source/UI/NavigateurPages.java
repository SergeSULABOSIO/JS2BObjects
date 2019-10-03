/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.UI;

import ICONES.Icones;
import Source.Callbacks.ConstructeurCriteres;
import Source.Callbacks.EcouteurNavigateurPages;
import Source.Callbacks.EcouteurStandard;
import Source.Objet.CouleurBasique;
import Source.Objet.UtilObjet;
import Sources.PROPRIETE;
import Sources.UI.JS2BPanelPropriete;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class NavigateurPages extends javax.swing.JPanel {

    /**
     * Creates new form NavigateurPages
     */
    private EcouteurNavigateurPages ecouteurNavigateurPages = null;
    private Icones icones = null;
    private JFrame fenetre = null;
    private DialCriteres dialog = null;
    private ConstructeurCriteres constructeurCriteres = null;
    private CouleurBasique couleurBasique;
    private JS2BPanelPropriete prop = null;

    public NavigateurPages() {
        initComponents();
        icones = new Icones();
        couleurBasique = new CouleurBasique();
        btPagePrecedente.setIcon(icones.getGauche_01());
        btPageSuivante.setIcon(icones.getDroite_01());
        btPageActualisation.setIcon(icones.getSynchroniser_01());
        chMotCle.setIcon(icones.getChercher_01());
        btCriteres.setIcon(icones.getFiltrer_01());
        btCriteres.setForeground(couleurBasique.getCouleur_foreground_objet_existant());
        patienter(false, "Chargement...");

    }

    public String toStringCriteres() {
        //Rien à signaler
        String txt = "";
        if (dialog != null) {
            if (dialog.panProp != null) {
                for (PROPRIETE prop : dialog.panProp.getListePro()) {
                    if(prop.getType() == PROPRIETE.TYPE_CHOIX_DATE){
                        txt += prop.getNom() + ": " + UtilObjet.getDateFrancais((Date)prop.getValeurSelectionne()) + " | ";
                    }else{
                        if((prop.getValeurSelectionne()+"").trim().length() == 0){
                            txt += prop.getNom() + ": (*) | ";
                        }else{
                            txt += prop.getNom() + ": " + prop.getValeurSelectionne() + " | ";
                        }
                    }
                }
            }
        }
        return txt;
    }

    public void criteresActuels_activer() {
        btCriteres.setForeground(couleurBasique.getCouleur_foreground_objet_nouveau());
        reload();
    }

    public void criteresActuels_desactiver() {
        btCriteres.setForeground(couleurBasique.getCouleur_foreground_objet_existant());
        reload();
    }

    private void setFenetrePatent(JFrame fenetre) {
        this.fenetre = fenetre;
        //Boite de dialogue
        if (fenetre != null) {
            dialog = new DialCriteres(fenetre, true, constructeurCriteres, new EcouteurStandard() {
                @Override
                public void onDone(String message) {
                    criteresActuels_activer();
                }

                @Override
                public void onError(String message) {
                    //System.out.println("Dialogue annulé !");
                    criteresActuels_desactiver();
                }

                @Override
                public void onProcessing(String message) {

                }
            });
            setDialogBounds();
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    dialog.dispose();
                }
            });
            if (constructeurCriteres == null) {
                btCriteres.setVisible(false);
            } else if (constructeurCriteres.onInitialise() == null) {
                btCriteres.setVisible(false);
            }
        }
    }

    public void setDialogBounds() {
        dialog.setLocationRelativeTo(fenetre);
        //dialog.setBounds(fenetre.getX() + 150, fenetre.getY() + 100, dialog.getWidth(), dialog.getHeight());
    }

    public void patienter(boolean patienter, String texte) {
        progress.setIndeterminate(patienter);
        progress.setStringPainted(patienter);
        progress.setString(texte);
        progress.setVisible(patienter);
    }

    public String getMotCle() {
        return chMotCle.getText();
    }

    public void getMotCle(String motCle) {
        chMotCle.setText(motCle);
    }

    public EcouteurNavigateurPages getEcouteurNavigateurPages() {
        return ecouteurNavigateurPages;
    }

    public void initialiser(JFrame fenetre, EcouteurNavigateurPages ecouteurNavigateurPages, ConstructeurCriteres constructeurCriteres) {
        this.ecouteurNavigateurPages = ecouteurNavigateurPages;
        this.constructeurCriteres = constructeurCriteres;
        setFenetrePatent(fenetre);
        //reload();
    }

    private void actionPrecedent() {
        try {
            pageActuelle.setValue(pageActuelle.getPreviousValue());
        } catch (Exception e) {
            //e.printStackTrace();
            return;
        }
    }

    public void reload() {
        if (ecouteurNavigateurPages != null && dialog != null) {
            btCriteres.setToolTipText("Critères (" + toStringCriteres() + ").");
            if (btCriteres.getForeground() == couleurBasique.getCouleur_foreground_objet_nouveau()) {
                prop = dialog.getPanProp();
            } else {
                prop = null;
            }
            ecouteurNavigateurPages.onRecharge(getMotCle(), getPageActuelle(), getTaillePage(), prop);
        }
        
    }

    public void actionSuivant() {
        try {
            pageActuelle.setValue(pageActuelle.getNextValue());
        } catch (Exception e) {
            return;
        }
    }

    public void actionActualiser() {
        try {
            reload();
        } catch (Exception e) {
            return;
        }
    }

    public int getTaillePage() {
        int rep = 0;
        try {
            rep = Integer.parseInt(taillePage.getValue() + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rep;
    }

    public int getPageActuelle() {
        int rep = 0;
        try {
            rep = Integer.parseInt(pageActuelle.getValue() + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rep;
    }

    public void setInfos(int total, int resultat) {
        int taillePage = Integer.parseInt(this.taillePage.getValue() + "");
        int pageActuelle = Integer.parseInt(this.pageActuelle.getValue() + "");
        int nbPages = total / taillePage;
        if ((total % taillePage) > 0) {
            nbPages++;
        }
        labInfos.setText("Page n°" + pageActuelle + " sur " + nbPages + ": " + resultat + " élement(s) sur " + total);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bareNavigation = new javax.swing.JToolBar();
        btPagePrecedente = new javax.swing.JButton();
        btPageActualisation = new javax.swing.JButton();
        btPageSuivante = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLabel10 = new javax.swing.JLabel();
        taillePage = new javax.swing.JSpinner();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jLabel11 = new javax.swing.JLabel();
        pageActuelle = new javax.swing.JSpinner();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        labInfos = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        progress = new javax.swing.JProgressBar();
        chMotCle = new UI.JS2bTextField();
        btCriteres = new javax.swing.JButton();

        bareNavigation.setFloatable(false);
        bareNavigation.setRollover(true);

        btPagePrecedente.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btPagePrecedente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_Objets/Facture01.png"))); // NOI18N
        btPagePrecedente.setText("Précédent");
        btPagePrecedente.setToolTipText("Page précédente");
        btPagePrecedente.setFocusable(false);
        btPagePrecedente.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btPagePrecedente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btPagePrecedente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPagePrecedenteActionPerformed(evt);
            }
        });
        bareNavigation.add(btPagePrecedente);

        btPageActualisation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_Objets/Facture01.png"))); // NOI18N
        btPageActualisation.setText("Actualiser");
        btPageActualisation.setToolTipText("Actualiser la page");
        btPageActualisation.setFocusable(false);
        btPageActualisation.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btPageActualisation.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btPageActualisation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPageActualisationActionPerformed(evt);
            }
        });
        bareNavigation.add(btPageActualisation);

        btPageSuivante.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btPageSuivante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_Objets/Facture01.png"))); // NOI18N
        btPageSuivante.setText("Suivant");
        btPageSuivante.setToolTipText("Page suivante");
        btPageSuivante.setFocusable(false);
        btPageSuivante.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btPageSuivante.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btPageSuivante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPageSuivanteActionPerformed(evt);
            }
        });
        bareNavigation.add(btPageSuivante);
        bareNavigation.add(jSeparator1);

        jLabel10.setText("Taille:");
        bareNavigation.add(jLabel10);

        taillePage.setModel(new javax.swing.SpinnerNumberModel(10, 0, null, 1));
        taillePage.setToolTipText("Nombre d'élement par page");
        taillePage.setPreferredSize(new java.awt.Dimension(60, 30));
        taillePage.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                taillePageStateChanged(evt);
            }
        });
        bareNavigation.add(taillePage);
        bareNavigation.add(jSeparator3);

        jLabel11.setText("Page:");
        bareNavigation.add(jLabel11);

        pageActuelle.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        pageActuelle.setToolTipText("Page actuelle");
        pageActuelle.setPreferredSize(new java.awt.Dimension(60, 30));
        pageActuelle.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pageActuelleStateChanged(evt);
            }
        });
        bareNavigation.add(pageActuelle);
        bareNavigation.add(jSeparator2);

        labInfos.setText("labelInfos");
        bareNavigation.add(labInfos);
        bareNavigation.add(jSeparator5);
        bareNavigation.add(progress);

        chMotCle.setToolTipText("Mot clé de la recherche");
        chMotCle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_Objets/Facture01.png"))); // NOI18N
        chMotCle.setTextInitial("Recherche...");
        chMotCle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                chMotCleKeyReleased(evt);
            }
        });

        btCriteres.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btCriteres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_Objets/Facture01.png"))); // NOI18N
        btCriteres.setText("Critères");
        btCriteres.setToolTipText("Critère de filtrage");
        btCriteres.setFocusable(false);
        btCriteres.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btCriteres.setPreferredSize(new java.awt.Dimension(85, 30));
        btCriteres.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCriteres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCriteresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(bareNavigation, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btCriteres, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(chMotCle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chMotCle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCriteres, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(bareNavigation, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btPagePrecedenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPagePrecedenteActionPerformed
        // TODO add your handling code here:
        actionPrecedent();
    }//GEN-LAST:event_btPagePrecedenteActionPerformed

    private void btPageSuivanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPageSuivanteActionPerformed
        // TODO add your handling code here:
        actionSuivant();
    }//GEN-LAST:event_btPageSuivanteActionPerformed

    private void taillePageStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_taillePageStateChanged
        // TODO add your handling code here:
        //System.out.println("Spinner...");
        reload();
    }//GEN-LAST:event_taillePageStateChanged

    private void pageActuelleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pageActuelleStateChanged
        // TODO add your handling code here:
        //System.out.println("Spinner...");
        reload();
    }//GEN-LAST:event_pageActuelleStateChanged

    private void btPageActualisationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPageActualisationActionPerformed
        // TODO add your handling code here:
        actionActualiser();
    }//GEN-LAST:event_btPageActualisationActionPerformed

    private void chMotCleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chMotCleKeyReleased
        // TODO add your handling code here:
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (Integer.parseInt(pageActuelle.getValue() + "") == 1) {
                    reload();
                } else {
                    pageActuelle.setValue(1);
                }
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_chMotCleKeyReleased

    private void btCriteresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCriteresActionPerformed
        // TODO add your handling code here:
        if (dialog != null && fenetre != null) {
            setDialogBounds();
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_btCriteresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar bareNavigation;
    private javax.swing.JButton btCriteres;
    private javax.swing.JButton btPageActualisation;
    private javax.swing.JButton btPagePrecedente;
    private javax.swing.JButton btPageSuivante;
    private UI.JS2bTextField chMotCle;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JLabel labInfos;
    private javax.swing.JSpinner pageActuelle;
    private javax.swing.JProgressBar progress;
    private javax.swing.JSpinner taillePage;
    // End of variables declaration//GEN-END:variables
}
