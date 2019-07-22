package Source.Callbacks;

import Source.Objet.Eleve;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author HP Pavilion
 */
public abstract class EcouteurCrossCanal {
    
    public abstract void onOuvrirPaiements(Eleve eleve);
    public abstract void onOuvrirInscription(Eleve eleve);
}
