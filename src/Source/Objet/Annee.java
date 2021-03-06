/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.Objet;

import java.util.Date;
import Source.Interface.InterfaceAnnee;



/**
 *
 * @author HP Pavilion
 */
public class Annee implements InterfaceAnnee{
    
    public int id;
    public int idEntreprise;
    public int idUtilisateur;
    public String nom;
    public Date debut;
    public Date fin;
    public long signature;
    public int beta;

    public Annee(int id, int idEntreprise, int idUtilisateur, String nom, Date debut, Date fin, long signature, int beta) {
        this.id = id;
        this.idEntreprise = idEntreprise;
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.debut = debut;
        this.fin = fin;
        this.signature = signature;
        this.beta = beta;
    }

    public Annee() {
    }

    public long getSignature() {
        return signature;
    }

    public void setSignature(long signature) {
        this.signature = signature;
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

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    @Override
    public String toString() {
        return "Exercice{" + "id=" + id + ", idEntreprise=" + idEntreprise + ", idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", debut=" + debut + ", fin=" + fin + ", signature=" + signature + ", beta=" + beta + '}';
    }
}









