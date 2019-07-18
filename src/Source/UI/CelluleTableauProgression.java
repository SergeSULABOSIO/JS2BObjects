/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.UI;


import java.awt.Color;
import java.awt.Font;
import javax.rmi.CORBA.Util;
import javax.swing.ImageIcon;
import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author user
 */
public class CelluleTableauProgression extends javax.swing.JPanel {
    
    /**
     * Creates new form PanValeurTable
     */
    
    public static final Color COULEUR_CELLULE_SELECTIONNEE = new java.awt.Color(255, 255, 51);
    
    
    public CelluleTableauProgression(String monnaie, double value, double totalDu, ImageIcon iconeProgression) {
        initComponents();
        labicone.setIcon(iconeProgression);
        setValeur(monnaie, value, totalDu);
    }
    
    
    private void ecouterLigneImpare(int row){
        if((row % 2) == 0){
            this.setBackground(Color.WHITE);
        }else{
            this.setBackground(Color.lightGray);
        }
    }
    
    public void ecouterSelection(boolean isSelected, int row, boolean hasfocus){
        if(isSelected == true){
            labicone.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
            labicone.setForeground(Color.WHITE);
            this.setBackground(Color.BLACK);
        }else{
            labicone.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 11));
            labicone.setForeground(Color.BLACK);
            ecouterLigneImpare(row);
        }
        appliquerCouleurFocusBordureCellule(hasfocus);
    }
    
    public void appliquerCouleurFocusBordureCellule(boolean hasFocus){
        if(hasFocus == true){
            this.setBorder(javax.swing.BorderFactory.createLineBorder(COULEUR_CELLULE_SELECTIONNEE, 2));
        }else{
            this.setBorder(null);
        }
    }
    
    
    public void setValeur(String monnaie, double val, double totalDu){
        this.progress.setStringPainted(true);
        this.progress.setMaximum((int)totalDu);
        this.progress.setString(getMontantFrancais(val) + " " + monnaie);
        this.progress.setValue((int)val);
    }
    
    public static String getMontantFrancais(double montant) {
        String val = "";
        int ValEntiere = (int) montant;
        char[] valInput = (ValEntiere + "").toCharArray();
        int index = 0;
        for (int i = valInput.length - 1; i >= 0; i--) {
            //System.out.println(" \t *  " + valInput[i]);
            if (index % 3 == 0 && index != 0) {
                val = valInput[i] + "." + val;
            } else {
                val = valInput[i] + val;
            }
            index++;
        }
        int ValApresVirgule = (int) (round(((montant - ValEntiere) * 100), 0));
        return val + "," + ValApresVirgule;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labicone = new javax.swing.JLabel();
        progress = new javax.swing.JProgressBar();

        setBackground(new java.awt.Color(255, 255, 255));

        labicone.setBackground(new java.awt.Color(255, 255, 255));
        labicone.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labicone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Facture01.png"))); // NOI18N
        labicone.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(labicone, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labicone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labicone;
    private javax.swing.JProgressBar progress;
    // End of variables declaration//GEN-END:variables
}
