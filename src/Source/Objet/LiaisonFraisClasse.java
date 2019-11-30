/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.Objet;

/**
 *
 * @author HP Pavilion
 */
public class LiaisonFraisClasse {
    private int idClasse;
    private String nomClasse;
    private long signatureClasse;
    private double montant;

    public LiaisonFraisClasse() {
    }

    public LiaisonFraisClasse(int idClasse, String nomClasse, long signatureClasse, double montant) {
        this.idClasse = idClasse;
        this.nomClasse = nomClasse;
        this.signatureClasse = signatureClasse;
        this.montant = montant;
    }

    public long getSignatureClasse() {
        return signatureClasse;
    }

    public void setSignatureClasse(long signatureClasse) {
        this.signatureClasse = signatureClasse;
    }

    

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    
    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "LiaisonFraisClasse{" + "idClasse=" + idClasse + ", nomClasse=" + nomClasse + ", signatureClasse=" + signatureClasse + ", montant=" + montant + '}';
    }
}













