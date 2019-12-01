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
public class LiaisonFraisEleve {
    public long signatureEleve;
    public long signatureFrais;
    public int idFrais;
    public double montant;
    public int idMonnaie;
    public String monnaie;

    public LiaisonFraisEleve(long signatureEleve, long signatureFrais, int idFrais, double montant, int idMonnaie, String monnaie) {
        this.signatureEleve = signatureEleve;
        this.signatureFrais = signatureFrais;
        this.idFrais = idFrais;
        this.montant = montant;
        this.idMonnaie = idMonnaie;
        this.monnaie = monnaie;
    }

    public LiaisonFraisEleve() {
    }

    public long getSignatureFrais() {
        return signatureFrais;
    }

    public void setSignatureFrais(long signatureFrais) {
        this.signatureFrais = signatureFrais;
    }
    
    
    public long getSignatureEleve() {
        return signatureEleve;
    }

    public void setSignatureEleve(long signatureEleve) {
        this.signatureEleve = signatureEleve;
    }

    public int getIdFrais() {
        return idFrais;
    }

    public void setIdFrais(int idFrais) {
        this.idFrais = idFrais;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getIdMonnaie() {
        return idMonnaie;
    }

    public void setIdMonnaie(int idMonnaie) {
        this.idMonnaie = idMonnaie;
    }

    public String getMonnaie() {
        return monnaie;
    }

    public void setMonnaie(String monnaie) {
        this.monnaie = monnaie;
    }

    @Override
    public String toString() {
        return "LiaisonFraisEleve{" + "signatureEleve=" + signatureEleve + ", signatureFrais=" + signatureFrais + ", idFrais=" + idFrais + ", montant=" + montant + ", idMonnaie=" + idMonnaie + ", monnaie=" + monnaie + '}';
    }
}
