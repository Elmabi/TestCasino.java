package Casinos;

import Joueurs.Joueur;

public class CasinoIndien extends Casino {


    //<editor-fold desc="CONSTRUCTEUR">
    public CasinoIndien() {
        super();
    }

    public CasinoIndien(String nom, int maxJoeurs) {
        super(nom, maxJoeurs);
    }

    public CasinoIndien(Casino casino) {
        super(casino);
    }
    //</editor-fold>

    public void descenteDePolice() {
        try {
            System.out.println("\n***** ATTENTION TOUT LE MONDE, NOUS AVONS ACTUELLEMENT UNE DESCENTE DE LA POLICE\n" +
                    "TOUT LE MONDE DOIT QUITTER LE CASINO " + getNom().toUpperCase() + " POUR NE PAS SE FAIRE " +
                    "ARRÊTER. ******* ");
            int i = 0;
            do {
                getJoueurs()[i].quitterCasino(this);
            }
            while (i < getJoueurPresents() && getJoueurPresents() != 0);
        } catch (NullPointerException e) {
            System.out.println("Actuellement il n'y a aucun joueurs dans le Casino.");
        }
    }

    public void trierEtExpulser(int nombreJoueursAExpulser) {
        if (getJoueurPresents() == 0) {
            System.out.println("\nCasino vide, personne ne peut être expulser.");
            return;
        }
        triParInsertion();
        if (nombreJoueursAExpulser <= getJoueurPresents()) {
            for (int i = getJoueurPresents() - 1; i >= (getJoueurPresents() - nombreJoueursAExpulser); i--) {
                System.out.println("\n" + getJoueurs()[i].getNom().toUpperCase() + " a été expulsé avec succès.");
                getJoueurs()[i].setCasino(null);
            }
            System.out.println("\n" + nombreJoueursAExpulser + " joueurs viennent d'être expulser du casino " +
                    getNom().toUpperCase() + ".");
            setJoueurPresents((getJoueurPresents() - nombreJoueursAExpulser));
        } else {
            System.out.println("\nLe nombre de joueurs que vous voulez expulser dépasse le nombre de joueurs présent.");
        }
    }

    private void triParInsertion() {
        Joueur joueurTemporaire;
        System.out.println(afficherTableauJoueurs("AVANT TRIAGE"));
        for (int i = 1; i < getMaxJoueurs(); i++) {
            for (int j = i; j > 0; j--) {
                try {
                    if (getJoueurs()[j].getCapital() > getJoueurs()[j - 1].getCapital()) {
                        joueurTemporaire = getJoueurs()[j];
                        getJoueurs()[j] = getJoueurs()[j - 1];
                        getJoueurs()[j - 1] = joueurTemporaire;
                    }
                } catch (NullPointerException e) {
                    e.getMessage();
                }
            }
        }
        System.out.println(afficherTableauJoueurs("APRES TRIAGE"));
    }

    @Override
    public String toString() {
        return super.toString().concat("CECI EST UN CASINO INDIEN.\n**********************************************\n");
    }

    @Override
    public boolean equals(Casino autreCasino) {
        return super.equals(autreCasino);
    }

    @Override
    public void payerImpots() {
        int chance = (int) (100 * Math.random());
        int chance2 = (int) (100 * Math.random());
        System.out.println("\n" + getNom().toUpperCase() + " a 1% de chance de voir 50% de son capital saisi." +
                "\nSi votre chance est à " + chance2 + ", 50% de votre capital sera saisi par Revenu Québec. " +
                "\t CHANCE: " + chance);
        if (chance == chance2) {
            setCapital(getCapital() / 2);
            System.out.println("\n" + getNom().toUpperCase() + " 50% de votre capital vient d'être saisi par Revenu Québec.");
        }
    }

    private String afficherTableauJoueurs(String avantEtApresTriage) {
        StringBuilder chaine = new StringBuilder("\n\t\t\t\t\t\tCASINO " + getNom().toUpperCase() + " TABLEAU JOUEURS " +
                avantEtApresTriage + "\n");
        for (int i = 0; i < getJoueurPresents(); i++) {
            chaine.append(this.getJoueurs()[i]).append("\n");
        }
        chaine.append("********************************************************************************************\n");
        return chaine.toString();
    }

} // FIN CLASS
