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
public interface InterfaceCours {
    //Conatantes - BETA
    public static final int BETA_EXISTANT = 0;
    public static final int BETA_MODIFIE = 1;
    public static final int BETA_NOUVEAU = 2;
    
    
    //les getters
    public abstract int getId();
    public abstract int getIdEntreprise();
    public abstract int getIdUtilisateur();
    public abstract int getIdExercice();
    
    public abstract String getNom();
    
    public abstract String getEnseignant();
    public abstract long getSignatureEnseignant();
    public abstract int getIdEnseignant();
    
    public abstract String getClasse();
    public abstract long getSignatureClasse();
    public abstract int getIdClasse();
    
    //Les setters
    public abstract void setId(int id);
    public abstract void setIdEntreprise(int idEntreprise);
    public abstract void setIdUtilisateur(int idUtilisateur);
    public abstract void setIdExercice(int idExercice);
    public abstract void setNom(String nom);
    public abstract int getBeta();  // 0 = Existant, 1 =  Modifié, 2 = Nouveau
    
    public abstract void setEnseignant(String enseignant);
    public abstract void setSignatureEnseignant(long signature);
    public abstract void setIdEnseignant(int idEnseignant);
    public abstract void setClasse(String classe);
    public abstract void setSignatureClasse(long signature);
    public abstract void setIdClasse(int idClasse);
    public abstract void setBeta(int newbeta);
}
