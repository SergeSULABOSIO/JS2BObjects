/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source.Objet;

import Source.Interface.InterfaceUtilisateur;
import java.awt.Desktop;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class UtilObjet {

    public static String nomApplication = "S2BFees";
    public static String pageWeb = "http://www.visiterlardc.com/s2b";

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

    //Les actions web
    public static int ACTION_LISTER_UTILISATEUR = 100;
    public static int ACTION_PAYER_LICENCE = 200;
    public static int ACTION_MODIFIER_LOGO = 300;
    public static int ACTION_MODIFIER_INFO_ECOLE = 400;
    public static int ACTION_MODIFIER_ARCHIVES = 500;
    public static int ACTION_HOME_PAGE = 0;

    public static boolean lancerPageWebAdmin(JFrame parent, Utilisateur utilisateur, Entreprise entreprise, int action, Icon iconeAlarme) {
        boolean go = false;
        Utilisateur user = utilisateur;
        if (entreprise != null && utilisateur != null) {
            boolean dExercice = user.getDroitExercice() == InterfaceUtilisateur.DROIT_CONTROLER;
            boolean dFacture = user.getDroitFacture() == InterfaceUtilisateur.DROIT_CONTROLER;
            boolean dInscription = user.getDroitInscription() == InterfaceUtilisateur.DROIT_CONTROLER;
            boolean dLitige = user.getDroitLitige() == InterfaceUtilisateur.DROIT_CONTROLER;
            boolean dPaie = user.getDroitPaie() == InterfaceUtilisateur.DROIT_CONTROLER;
            boolean dTresorerie = user.getDroitTresorerie() == InterfaceUtilisateur.DROIT_CONTROLER;
            boolean dUtilisateur = user.getDroitUtilisateur() == InterfaceUtilisateur.DROIT_CONTROLER;
            boolean typeUser = user.getType() == InterfaceUtilisateur.TYPE_ADMIN;

            if (typeUser == true && dExercice == true && dFacture == true && dInscription == true && dLitige == true && dPaie == true && dTresorerie == true && dUtilisateur == true && typeUser == true) {
                go = true;
            } else if (action == ACTION_HOME_PAGE) {
                go = true;
            }
        }

        if (go == true) {
            //http://www.visiterlardc.com/s2b/redirection.php?action=100&email=sulabosiog@gmail.com&motdepasse=abc&idEntreprise=2
            String parametres = "/redirection.php?action=" + action + "&email=" + user.getEmail() + "&motdepasse=" + user.getMotDePasse() + "&idEntreprise=" + entreprise.getId();
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(new URL(pageWeb + parametres).toURI());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(parent, "Désolé " + user.getPrenom() + ",\nVous ne pouvez pas accéder à cette fonctionnalité car vous avez un accès très limité!"
                    + "\nSi vous désirez élargir vos droits d'accès, merci de s'adresser à votre administrateur.", "Pas d'accès", JOptionPane.ERROR_MESSAGE, iconeAlarme);
        }
        return false;
    }

    public static boolean lancerPagePaiementEnLigne(Utilisateur user, Entreprise ense) {
        //http://www.visiterlardc.com/s2b/redirection.php?action=100&email=sulabosiog@gmail.com&motdepasse=abc&idEntreprise=2
        String parametres = "/redirection.php?action=" + ACTION_PAYER_LICENCE + "&email=" + user.getEmail() + "&motdepasse=" + user.getMotDePasse() + "&idEntreprise=" + ense.getId();
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(new URL(pageWeb + parametres).toURI());
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

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

    public static long getSignature() {
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








