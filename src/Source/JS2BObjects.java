/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import Source.Interface.InterfaceEleve;
import Source.Objet.Eleve;
import java.util.Date;

/**
 *
 * @author HP Pavilion
 */
public class JS2BObjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Eleve eleve = new Eleve(12, 12, 1, 12, 12, 221111, "CM1", "Itaga", "+243844803514", "SULA", "BOSIO", "SERGE", InterfaceEleve.STATUS_ACTIF, InterfaceEleve.SEXE_MASCULIN, new Date(), InterfaceEleve.BETA_EXISTANT);
        System.out.println(eleve.toString());
    }
    
}
