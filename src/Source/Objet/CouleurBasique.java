/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.Objet;

import java.awt.Color;

/**
 *
 * @author HP Pavilion
 */
public class CouleurBasique {
    public static Color COULEUR_BLEU = new Color(26, 45, 77);       //Pour plus d'infos visiter le lien https://www.colorhexa.com/1a2e4d
    public static Color COULEUR_BLEU_CLAIRE_1 = new Color(68,117,192);    //Une variante claire
    public static Color COULEUR_BLEU_CLAIRE_2 = new Color(141,171,217);    //Une variante claire
    public static Color COULEUR_ORANGE = new Color(251, 155, 12);   //Pour plus d'information, visiter le lien https://www.colorhexa.com/fb9b0c
    public static Color COULEUR_ROUGE = new Color(251,36,12);       //Une variante   
    
    private Color couleur_background_selection;
    private Color couleur_background_normal;
    private Color couleur_encadrement_selection;
    private Color couleur_foreground_objet_modifie;
    private Color couleur_foreground_objet_nouveau;
    private Color couleur_foreground_objet_existant;

    public CouleurBasique() {
        this.setCouleur_background_normal(Color.white);
        this.setCouleur_background_selection(COULEUR_BLEU);
        this.setCouleur_encadrement_selection(COULEUR_ORANGE);
        this.setCouleur_foreground_objet_existant(COULEUR_BLEU);
        this.setCouleur_foreground_objet_modifie(COULEUR_BLEU_CLAIRE_1);
        this.setCouleur_foreground_objet_nouveau(COULEUR_ROUGE);
    }

    public CouleurBasique(Color couleur_background_selection, Color couleur_background_normal, Color couleur_encadrement_selection, Color couleur_foreground_objet_modifie, Color couleur_foreground_objet_nouveau, Color couleur_foreground_objet_existant) {
        this.couleur_background_selection = couleur_background_selection;
        this.couleur_background_normal = couleur_background_normal;
        this.couleur_encadrement_selection = couleur_encadrement_selection;
        this.couleur_foreground_objet_modifie = couleur_foreground_objet_modifie;
        this.couleur_foreground_objet_nouveau = couleur_foreground_objet_nouveau;
        this.couleur_foreground_objet_existant = couleur_foreground_objet_existant;
    }

    public Color getCouleur_background_selection() {
        return couleur_background_selection;
    }

    public void setCouleur_background_selection(Color couleur_background_selection) {
        this.couleur_background_selection = couleur_background_selection;
    }

    public Color getCouleur_background_normal() {
        return couleur_background_normal;
    }

    public void setCouleur_background_normal(Color couleur_background_normal) {
        this.couleur_background_normal = couleur_background_normal;
    }

    public Color getCouleur_encadrement_selection() {
        return couleur_encadrement_selection;
    }

    public void setCouleur_encadrement_selection(Color couleur_encadrement_selection) {
        this.couleur_encadrement_selection = couleur_encadrement_selection;
    }

    public Color getCouleur_foreground_objet_modifie() {
        return couleur_foreground_objet_modifie;
    }

    public void setCouleur_foreground_objet_modifie(Color couleur_foreground_objet_modifie) {
        this.couleur_foreground_objet_modifie = couleur_foreground_objet_modifie;
    }

    public Color getCouleur_foreground_objet_nouveau() {
        return couleur_foreground_objet_nouveau;
    }

    public void setCouleur_foreground_objet_nouveau(Color couleur_foreground_objet_nouveau) {
        this.couleur_foreground_objet_nouveau = couleur_foreground_objet_nouveau;
    }

    public Color getCouleur_foreground_objet_existant() {
        return couleur_foreground_objet_existant;
    }

    public void setCouleur_foreground_objet_existant(Color couleur_foreground_objet_existant) {
        this.couleur_foreground_objet_existant = couleur_foreground_objet_existant;
    }

    @Override
    public String toString() {
        return "CouleurBasique{" + "couleur_background_selection=" + couleur_background_selection + ", couleur_background_normal=" + couleur_background_normal + ", couleur_encadrement_selection=" + couleur_encadrement_selection + ", couleur_foreground_objet_modifie=" + couleur_foreground_objet_modifie + ", couleur_foreground_objet_nouveau=" + couleur_foreground_objet_nouveau + ", couleur_foreground_objet_existant=" + couleur_foreground_objet_existant + '}';
    }
}
