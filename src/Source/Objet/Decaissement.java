/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.Objet;

import Source.Interface.InterfaceDecaissement;
import java.util.Date;

/**
 *
 * @author user
 */
public class Decaissement implements InterfaceDecaissement{
    public int id;
    public int source;//caisse ou banque
    public String reference;
    public Date date;
    public double montant;
    public int idMonnaie;
    public String monnaie;
    public String beneficiaire;
    public String motif;
    public int idCharge;
    public String charge;
    public int idEntreprise;
    public int idExercice;
    public int idUtilisateur;
    public long signature;
    public int beta;

    public Decaissement(int id, int source, String reference, Date date, double montant, int idMonnaie, String monnaie, String beneficiaire, String motif, int idCharge, String charge, int idEntreprise, int idExercice, int idUtilisateur, long signature, int beta) {
        this.id = id;
        this.source = source;
        this.reference = reference;
        this.date = date;
        this.montant = montant;
        this.idMonnaie = idMonnaie;
        this.monnaie = monnaie;
        this.beneficiaire = beneficiaire;
        this.motif = motif;
        this.idCharge = idCharge;
        this.charge = charge;
        this.idEntreprise = idEntreprise;
        this.idExercice = idExercice;
        this.idUtilisateur = idUtilisateur;
        this.signature = signature;
        this.beta = beta;
    }

    public Decaissement() {
    }

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }
    

    public long getSignature() {
        return signature;
    }

    public void setSignature(long signature) {
        this.signature = signature;
    }
    
    public int getIdExercice() {
        return idExercice;
    }

    public void setIdExercice(int idExercice) {
        this.idExercice = idExercice;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public int getIdCharge() {
        return idCharge;
    }

    public void setIdCharge(int idCharge) {
        this.idCharge = idCharge;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public int getBeta() {
        return beta;
    }

    public void setBeta(int beta) {
        this.beta = beta;
    }

    @Override
    public String toString() {
        return "Decaissement{" + "id=" + id + ", source=" + source + ", reference=" + reference + ", date=" + date + ", montant=" + montant + ", idMonnaie=" + idMonnaie + ", monnaie=" + monnaie + ", beneficiaire=" + beneficiaire + ", motif=" + motif + ", idCharge=" + idCharge + ", charge=" + charge + ", idEntreprise=" + idEntreprise + ", idExercice=" + idExercice + ", idUtilisateur=" + idUtilisateur + ", signature=" + signature + ", beta=" + beta + '}';
    }
}













