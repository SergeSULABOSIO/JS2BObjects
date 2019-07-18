/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.Objet;

import Source.Interface.InterfacePaiement;
import java.util.Date;

/**
 *
 * @author HP Pavilion
 */
public class Paiement implements InterfacePaiement{
    public int id;
    public int idEleve;
    public int idExercice;
    public int idFrais;
    public int idPeriode;
    public int mode;
    public String reference;
    public String nomEleve;
    public String nomFrais;
    public String nomDepositaire;
    public double montant;
    public Date date;
    public int beta;

    public Paiement() {
    }

    public Paiement(int id, int idExercice, int idEleve, int idFrais, int idPeriode, String nomEleve, String nomFrais, String nomDepositaire, double montant, Date date, int mode, String reference, int beta) {
        this.id = id;
        this.idExercice = idExercice;
        this.idEleve = idEleve;
        this.idFrais = idFrais;
        this.idPeriode = idPeriode;
        this.nomEleve = nomEleve;
        this.nomFrais = nomFrais;
        this.nomDepositaire = nomDepositaire;
        this.montant = montant;
        this.date = date;
        this.mode = mode;
        this.reference = reference;
        this.beta = beta;
    }

    public int getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(int idPeriode) {
        this.idPeriode = idPeriode;
    }
    
    public int getBeta() {
        return beta;
    }

    public void setBeta(int beta) {
        this.beta = beta;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomDepositaire() {
        return nomDepositaire;
    }

    public void setNomDepositaire(String nomDepositaire) {
        this.nomDepositaire = nomDepositaire;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    @Override
    public String getReferenceTransaction() {
        return this.reference;
    }

    @Override
    public int getMode() {
        return this.mode;
    }

    @Override
    public void setReferenceTransaction(String reference) {
        this.reference = reference;
    }

    @Override
    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
    }

    

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNomEleve() {
        return nomEleve;
    }

    public void setNomEleve(String nomEleve) {
        this.nomEleve = nomEleve;
    }

    
    public int getIdExercice() {
        return idExercice;
    }

    public void setIdExercice(int idExercice) {
        this.idExercice = idExercice;
    }

    public int getIdFrais() {
        return idFrais;
    }

    public void setIdFrais(int idFrais) {
        this.idFrais = idFrais;
    }

    public String getNomFrais() {
        return nomFrais;
    }

    public void setNomFrais(String nomFrais) {
        this.nomFrais = nomFrais;
    }

    @Override
    public String toString() {
        return "Paiement{" + "id=" + id + ", idEleve=" + idEleve + ", idExercice=" + idExercice + ", idFrais=" + idFrais + ", idPeriode=" + idPeriode + ", mode=" + mode + ", reference=" + reference + ", nomEleve=" + nomEleve + ", nomFrais=" + nomFrais + ", nomDepositaire=" + nomDepositaire + ", montant=" + montant + ", date=" + date + ", beta=" + beta + '}';
    }
}
