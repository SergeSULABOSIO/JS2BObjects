/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.util.Vector;

/**
 *
 * @author user
 */
public class GestionEdition {

    private Vector<String> listeID = new Vector<>();

    public GestionEdition() {
        listeID = new Vector<>();
    }
    
    public void reinitialiser(){
        listeID.removeAllElements();
    }

    public void setModeEdition(int id, int indexListe, boolean confirmer) {
        String combinaison = id+"_"+indexListe;
        if (confirmer == true) {
            if (!listeID.contains(combinaison)) {
                listeID.addElement(combinaison);
            }
        } else {
            if (listeID.contains(combinaison)) {
                listeID.removeElement(combinaison);
            }
        }
    }

    public boolean isEditable(int id, int indexListe) {
        if(id == -1){
            return true;
        }else{
            return listeID.contains(id+"_"+indexListe);
        }
    }

}


























