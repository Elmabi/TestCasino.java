package Main;

import Casinos.*;
import Jeux.*;
import Jeux.Lotto3;
import Joueurs.*;


public class TestCasino2 {

    public static void main(String[] args) {

        //<editor-fold desc="CONSTANTES">
        final String COULEUR_RESET = "\u001B[0m";
        final String COULEUR_RED = "\u001B[31m";
        //</editor-fold> FIN CONSTANTES

        System.out.println(COULEUR_RED + "\nTOUS LES TEXTES EN ROUGE SONT PRINTÉS DANS LA CLASSE TESTCASINO2 " +
                "ET PERMET DE MONTRER CE QUI SE PASSE. \nLES AUTRES AFFICHAGES DE TEXTE SONT PROPRE AU METHODES " +
                "DE CHAQUE CLASS." + COULEUR_RESET);

        //<editor-fold desc="VARIABLES ">
        Joueur joueurPauvre = new JoueurPauvre("pauvrard");
        Joueur joueurRiche = new JoueurRiche("richard");
        joueurRiche.setCapital(5000);
        Joueur niki = new JoueurPauvre("niki", 500);
        Joueur armel = new JoueurRiche("armel", 2000);
        Joueur regis = new JoueurRiche("regis", 1000);
        Joueur leonel = new JoueurPauvre(niki);
        leonel.setNom("leonel");
        Joueur geoffrey = new JoueurRiche(regis);
        geoffrey.setNom("geoffrey");
        Casino casinoLegal = new CasinoLegal("texas", 5);
        Casino casinoIndien = new CasinoIndien("Indien", 6);
        System.out.println("\n");
        Jeu lotto3 = new Lotto3();
        Jeu pileOuFace = new PileOuFace();
        Jeu lottoBoolean = new LottoBoolean();
        //</editor-fold> FIN VARIABLES

        //<editor-fold desc="TEST DES MÉTHODES DES CLASSES JOUEURS">
        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\t***** TEST DES MÉTHODES DES CLASSES JOUEURS *****" + COULEUR_RESET);

        System.out.println(niki);
        System.out.println(armel);
        System.out.println(joueurPauvre);
        System.out.println(leonel);
        System.out.println(geoffrey);
        System.out.println(regis);
        System.out.println(joueurRiche);

        System.out.println(COULEUR_RED + "\nComparaison de RICHARD à PAUVRARD: " + COULEUR_RESET
                + joueurRiche.compareTo(joueurPauvre));
        System.out.println(COULEUR_RED + "\nComparaison de ARMEL à LUI-MEME: " + COULEUR_RESET + armel.compareTo(armel));
        System.out.println(COULEUR_RED + "\nComparaison de NIKI à LEONEL: " + COULEUR_RESET
                + niki.compareTo(leonel) + "\n");
        ((JoueurPauvre) niki).collecterCheque();
        ((JoueurRiche) armel).banqueRoute();
        System.out.println(COULEUR_RED + "\nCapital ARMEL après banqueRoute : $" + COULEUR_RESET + armel.getCapital());

        //</editor-fold> FIN TEST DES MÉTHODES DES CLASSES JOUEURS


        //<editor-fold desc="TEST DES MÉTHODES DES CLASSES CASINOS">
        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\t***** TEST DES MÉTHODES DES CLASSES CASINOS *****" + COULEUR_RESET);

        System.out.println(casinoLegal);
        Casino casinoLegal2 = new CasinoLegal(casinoLegal);
        casinoLegal2.setNom("Casino Legal 2");
        System.out.println(casinoLegal2);
        System.out.println(casinoIndien);

        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\tTEST EVALUATION MUNICIPALE" + COULEUR_RESET);
        casinoIndien.evaluationMunicipale();
        casinoLegal.evaluationMunicipale();

        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\tTEST PAYER IMPÔTS" + COULEUR_RESET);
        casinoIndien.payerImpots();
        casinoLegal.payerImpots();

        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\tTEST DESCENTE POLICE, TRIER ET EXPULSER, DEBUT SPECTACLE " +
                "ET FIN SPECTACLE" + COULEUR_RESET);
        ((CasinoIndien) casinoIndien).descenteDePolice();
        ((CasinoIndien) casinoIndien).trierEtExpulser(1);
        ((CasinoLegal) casinoLegal).debutSpectacle();
        ((CasinoLegal) casinoLegal).finSpectacle();

        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\tENTREZ DES JOUEURS DANS LE CASINO LEGAL " +
                "ET TEST DE CERTAINES MÉTHODES" + COULEUR_RESET);
        Joueur carl = new JoueurPauvre("carl", 9);
        Joueur cristian = new JoueurRiche("cristian", 950);
        carl.joindreCasino(casinoLegal);
        cristian.joindreCasino(casinoIndien);

        niki.joindreCasino(casinoLegal);
        System.out.println(COULEUR_RED + "\nRappel: Après banqueRoute plus haut ARMEL a perdu tout son capital. " +
                "Son capital était devenu a $" + COULEUR_RESET + armel.getCapital());
        armel.joindreCasino(casinoLegal);
        joueurPauvre.joindreCasino(casinoLegal);
        leonel.joindreCasino(casinoLegal);
        geoffrey.joindreCasino(casinoLegal);
        regis.joindreCasino(casinoLegal);
        joueurRiche.joindreCasino(casinoLegal);

        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\tCASINO TEXAS APRÈS L'ENTRÉE DES JOUEURS" + COULEUR_RESET);
        System.out.println(casinoLegal);

        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\tTEST DES MÉTHODES DE CASINO LEGAL APRÈS " +
                "L'ENTRÉE DES JOUEURS" + COULEUR_RESET);
        casinoLegal.evaluationMunicipale();
        casinoLegal.payerImpots();
        ((CasinoLegal) casinoLegal).collecterImpots();
        System.out.println(COULEUR_RED + "\nAprès avoir collecter l'impôt voici le nouveau capital" +
                " de TEXAS $" + COULEUR_RESET + casinoLegal.getCapital());
        ((CasinoLegal) casinoLegal).debutSpectacle();
        leonel.jouer(45, lotto3);
        regis.jouer(56, pileOuFace);
        System.out.println(COULEUR_RED + "\nLeonel et regis ont essayé de jouer et malheureusement " +
                "Grégory Charles est déjà là." + COULEUR_RESET);
        ((CasinoLegal) casinoLegal).finSpectacle();

        leonel.jouer(100, lottoBoolean);
        regis.jouer(200, pileOuFace);
        geoffrey.jouer(300, lotto3);
        joueurRiche.jouer(6000, lottoBoolean);
        joueurPauvre.jouer(300, pileOuFace);

        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\tTEST METHODE PAYER IMPÔTS DE CASINO LEGAL APRÈS " +
                "QUE LES JOUEURS ONT COMMENCÉ À JOUER\n" + COULEUR_RESET);
        casinoLegal.payerImpots();
        System.out.println(COULEUR_RED + "\n Nouveau capital de TEXAS: $" + COULEUR_RESET + casinoLegal.getCapital());

        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\tAFFICHAGE DES JOUEURS" + COULEUR_RESET);
        System.out.println(niki);
        System.out.println(armel);
        System.out.println(joueurPauvre);
        System.out.println(leonel);
        System.out.println(geoffrey);
        System.out.println(regis);
        System.out.println(joueurRiche);
        System.out.println(carl);
        System.out.println(cristian);

        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\tENTREZ DES JOUEURS DANS LE CASINO INDIEN ET TEST " +
                "DE CERTAINES MÉTHODES" + COULEUR_RESET);
        armel.setCapital(6000);
        carl.setCapital(500);
        cristian.setCapital(2500);
        System.out.println(COULEUR_RED + "\nARMEL, CARL et CRISTIAN n'ont pas assez de capital du coup " +
                "je reset leurs capital." + COULEUR_RESET);
        System.out.println(COULEUR_RED + "\nARMEL nouveau capital: $" + COULEUR_RESET + armel.getCapital());
        System.out.println(COULEUR_RED + "\nCARL nouveau capital: $" + COULEUR_RESET + carl.getCapital());
        System.out.println(COULEUR_RED + "\nCRISTIAN nouveau capital: $" + COULEUR_RESET + cristian.getCapital());
        armel.joindreCasino(casinoIndien);
        carl.joindreCasino(casinoIndien);
        cristian.joindreCasino(casinoIndien);
        geoffrey.joindreCasino(casinoIndien);
        niki.joindreCasino(casinoIndien);
        joueurRiche.joindreCasino(casinoIndien);
        leonel.joindreCasino(casinoIndien);

        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\tCASINO INDIEN APRÈS L'ENTRÉE DES JOUEURS" + COULEUR_RESET);
        System.out.println(casinoIndien);

        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\tTEST DE LA METHODE COMPARE TO DES CASINOS" + COULEUR_RESET);
        System.out.println(COULEUR_RED + "\nSomme du capital des joueurs présents dans les casinos.\nCasinoLegal TEXAS: $"
                + COULEUR_RESET + casinoLegal.getSommeCapitalJoueursPresent() + COULEUR_RED
                + "\nCasinoIndien CASINO INDIEN: $" + COULEUR_RESET + casinoIndien.getSommeCapitalJoueursPresent());
        System.out.println(COULEUR_RED + "\nComparaison de CasinoLegal TEXAS à CasinoIndien: " + COULEUR_RESET
                + casinoLegal.compareTo(casinoIndien));
        System.out.println(COULEUR_RED + "\nComparaison de CasinoLegal TEXAS à lui-même: " + COULEUR_RESET
                + casinoLegal.compareTo(casinoLegal));
        System.out.println(COULEUR_RED + "\nComparaison de CasinoIndien à CasinoLegal TEXAS: " + COULEUR_RESET
                + casinoIndien.compareTo(casinoLegal));

        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\tTEST DES MÉTHODES DE CASINO INDIEN APRÈS L'ENTRÉE " +
                "DES JOUEURS" + COULEUR_RESET);

        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\tTEST DE LA METHODE TRIER ET EXPULSER" + COULEUR_RESET);
        ((CasinoIndien) casinoIndien).trierEtExpulser(2);

        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\tAFFICHAGE DU CASINO APRES TRIAGE ET EXPULSION" + COULEUR_RESET);
        System.out.println(casinoIndien);

        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\tTEST DE LA METHODE DESCENTE DE LA POLICE" + COULEUR_RESET);
        ((CasinoIndien) casinoIndien).descenteDePolice();

        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\tAFFICHAGE DU CASINO APRES DESCENTE DE LA POLICE " + COULEUR_RESET);
        System.out.println(casinoIndien);
        //</editor-fold> FIN TEST DES MÉTHODES DES CLASSES CASINOS


        //<editor-fold desc="AFFICHAGE DES JOUEURS FINAL">
        System.out.println(COULEUR_RED + "\n\t\t\t\t\t\tAFFICHAGE DES JOUEURS" + COULEUR_RESET);
        System.out.println(niki);
        System.out.println(armel);
        System.out.println(joueurPauvre);
        System.out.println(leonel);
        System.out.println(geoffrey);
        System.out.println(regis);
        System.out.println(joueurRiche);
        System.out.println(carl);
        System.out.println(cristian);
        //</editor-fold> FIN AFFICHAGE DES JOUEURS

    } // fin main

}// fin class
