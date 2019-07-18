/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.Interface;

import Source.Objet.Echeance;
import java.util.Vector;

/**
 *
 * @author HP Pavilion
 */
public interface InterfaceLitige {
    
    //Conatantes - BETA
    public static final int BETA_EXISTANT = 0;
    public static final int BETA_MODIFIE = 1;
    public static final int BETA_NOUVEAU = 2;
    
    public abstract int getId();
    public abstract int getIdEleve();
    public abstract int getIdClasse();
    public abstract Vector<Echeance> getListeEcheances();
    public abstract int getBeta();  // 0 = Existant, 1 =  Modifié, 2 = Nouveau
    
    public abstract void setId(int id);
    public abstract void setIdEleve(int idEleve);
    public abstract void setIdClasse(int idClasse);
    public abstract void setListeEcheances(Vector<Echeance> listeEcheances);
    public abstract void setBeta(int newbeta);
}
