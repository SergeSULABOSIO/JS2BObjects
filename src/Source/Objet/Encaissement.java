/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.Objet;


import Source.Interface.InterfaceEncaissement;
import java.util.Date;

/**
 *
 * @author user
 */
public class Encaissement implements InterfaceEncaissement{
    public int id;
    public int destination;
    public String reference;
    public Date date;
    public double montant;
    public int idMonnaie;
    public String monnaie;
    public String effectuePar;
    public String motif;
    public int idRevenu;
    public String revenu;
    public int idEntreprise;
    public int idExercice;
    public int idUtilisateur;
    public long signature;
    public int beta;

    public Encaissement(int id, int destination, String reference, Date date, double montant, int idMonnaie, String monnaie, String effectuePar, String motif, int idRevenu, String revenu, int idEntreprise, int idExercice, int idUtilisateur, long signature, int beta) {
        this.id = id;
        this.destination = destination;
        this.reference = reference;
        this.date = date;
        this.montant = montant;
        this.idMonnaie = idMonnaie;
        this.monnaie = monnaie;
        this.effectuePar = effectuePar;
        this.motif = motif;
        this.idRevenu = idRevenu;
        this.revenu = revenu;
        this.idEntreprise = idEntreprise;
        this.idExercice = idExercice;
        this.idUtilisateur = idUtilisateur;
        this.signature = signature;
        this.beta = beta;
    }

    public Encaissement() {
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

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
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

    public String getEffectuePar() {
        return effectuePar;
    }

    public void setEffectuePar(String effectuePar) {
        this.effectuePar = effectuePar;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public int getIdRevenu() {
        return idRevenu;
    }

    public void setIdRevenu(int idRevenu) {
        this.idRevenu = idRevenu;
    }

    public String getRevenu() {
        return revenu;
    }

    public void setRevenu(String revenu) {
        this.revenu = revenu;
    }

    public int getBeta() {
        return beta;
    }

    public void setBeta(int beta) {
        this.beta = beta;
    }

    @Override
    public String toString() {
        return "Encaissement{" + "id=" + id + ", destination=" + destination + ", reference=" + reference + ", date=" + date + ", montant=" + montant + ", idMonnaie=" + idMonnaie + ", monnaie=" + monnaie + ", effectuePar=" + effectuePar + ", motif=" + motif + ", idRevenu=" + idRevenu + ", revenu=" + revenu + ", idEntreprise=" + idEntreprise + ", idExercice=" + idExercice + ", idUtilisateur=" + idUtilisateur + ", signature=" + signature + ", beta=" + beta + '}';
    }
}










