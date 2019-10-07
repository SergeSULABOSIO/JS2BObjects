/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.Objet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author user
 */
public class UtilObjet {
    public static String DOSSIER_ANNEE = "ANNEE";
    public static String DOSSIER_MONNAIE = "MONNAIE";
    public static String DOSSIER_CLASSE = "CLASSE";
    public static String DOSSIER_PERIODE = "PERIODE";
    public static String DOSSIER_AGENT = "AGENT";
    public static String DOSSIER_COURS = "COURS";
    public static String DOSSIER_REVENU = "REVENU";
    public static String DOSSIER_CHARGE = "CHARGE";
    public static String DOSSIER_FRAIS = "FRAIS";
    public static String DOSSIER_ELEVE = "ELEVE";
    public static String DOSSIER_AYANT_DROIT = "AYANTDROIT";
    public static String DOSSIER_PAIEMENT = "PAIEMENT";
    public static String DOSSIER_ENCAISSEMENT = "ENCAISSEMENT";
    public static String DOSSIER_DECAISSEMENT = "DECAISSEMENT";
    public static String DOSSIER_FICHE_DE_PAIE = "FICHE_PAIE";
    
    public static String getDateFrancais(Date date) {
        String dateS = "";
        try {
            String pattern = "dd MMM yyyy à HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            dateS = simpleDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateS;
    }
    
    public static long getSignature(){
      Random randomno = new Random();
      long value = randomno.nextLong();
      return value;
    }
    
    public static String getDateAnglais(Date date) {
        String dateS = "";
        try {
            String pattern = "yyyy-MM-dd HH:mm:ss";//2019-09-06 11:33:54
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            dateS = simpleDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateS;
    }
    
    
}














