/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.Interface;

/**
 *
 * @author HP Pavilion
 */
public interface InterfaceRevenu {
    //Conatantes - BETA
    public static final int BETA_EXISTANT = 0;
    public static final int BETA_MODIFIE = 1;
    public static final int BETA_NOUVEAU = 2;
    
    public abstract int getId();
    public abstract int getIdEntreprise();
    public abstract int getIdUtilisateur();
    public abstract int getIdExercice();
    public abstract int getIdMonnaie();
    public abstract long getSignatureMonnaie();
    public abstract String getNom();
    public abstract String getMonnaie();
    public abstract double getVolumeAnnuel();
    public abstract long getSignature();
    public abstract int getBeta();  // 0 = Existant, 1 =  Modifié, 2 = Nouveau
    
    public abstract void setId(int id);
    public abstract void setIdEntreprise(int idEntreprise);
    public abstract void setIdUtilisateur(int idUtilisateur);
    public abstract void setIdExercice(int idExercice);
    public abstract void setIdMonnaie(int idMonnaie);
    public abstract void setSignatureMonnaie(long signature);
    public abstract void setNom(String nom);
    public abstract void setMonnaie(String monnaie);
    public abstract void setVolumeAnnuel(double volume);
    public abstract void setSignature(long signature);
    public abstract void setBeta(int newbeta);
}




