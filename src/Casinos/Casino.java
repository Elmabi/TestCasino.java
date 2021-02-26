package Casinos;

import Interface.ImpotsFonciers;
import Jeux.*;
import Joueurs.*;
import java.util.Arrays;


public abstract class Casino implements Comparable, ImpotsFonciers {


    //<editor-fold desc="ATTRIBUTS">
    private String nom;
    private Joueur[] joueurs;
    private int joueurPresents;
    private int maxJoeurs;
    private int capital;
    private Jeu[] jeux;
    private int sommeCapitalJoueursPresent;
    private boolean joueurPeutJouer;
    //</editor-fold>

    //<editor-fold desc="CONSTRUCTEURS">
    public Casino() {
        this("Casino", 5);
    }

    /**
     * @param nom       Le nom du Casino.
     * @param maxJoeurs le nombre maximum de joueurs que le casino peut prendre.
     */
    public Casino(String nom, int maxJoeurs) {
        this.nom = nom;
        this.maxJoeurs = maxJoeurs;
        this.joueurs = new Joueur[maxJoeurs];
        this.joueurPresents = 0;
        this.capital = 100000;
        this.sommeCapitalJoueursPresent = 0;
        this.jeux = new Jeu[]{new LottoBoolean(), new PileOuFace()};
        setJoueurPeutJouer(true);
    }

    public Casino(Casino casino) {
        this(casino.nom, casino.maxJoeurs);
    }

    //</editor-fold>

    public void ajouterJoueur(Joueur joueur) {
        if (!isPeutEntrer(joueur)) {
            return;
        }
        if (joueurPresents != maxJoeurs) {
            joueurs[joueurPresents] = joueur;
            joueurPresents++;
            System.out.println("\n" + joueur.getNom().toUpperCase() + " viens d'entrer dans le casino "
                    + this.nom.toUpperCase() + " avec succès.");
        } else {
            System.out.println("\nDésolé le casino est plein. " + joueur.getNom().toUpperCase()
                    + " ne peut pas être ajouter.");
        }
    }

    public void enleverJoueur(Joueur joueur) {
        int indexJoueurTrouve = indexJoueurTrouve(joueur);
        if (indexJoueurTrouve >= 0) {
            for (int i = indexJoueurTrouve; i < joueurPresents - 1; i++) {
                joueurs[i] = joueurs[i + 1];
            }
            joueurPresents--;
            joueur.setCasino(null);
            System.out.println("\n" + joueur.getNom().toUpperCase() + " viens de quitter le casino "
                    + this.nom.toUpperCase() + " avec succès.");
        } else {
            System.out.println("\n" + joueur.getNom().toUpperCase() + " n'est pas actuellement joueur dans le casino "
                    + this.nom.toUpperCase() + " et ne peut donc pas quitter.");
        }
    }

    public void jouer(Joueur joueur, int mise, Jeu jeu) {
        if (!joueurPeutJouer) {
            System.out.println("\nActuellement Mr Grégory Charles nous livre un spectacle et personne ne peut manquer à" +
                    " ça. Aucun joueur ne peut donc jouer. Merci pour votre attention! ");
            return;
        }

        if (indexJoueurTrouve(joueur) < 0) {
            System.out.println("\n" + joueur.getNom().toUpperCase() + " n'est pas actuellement joueur dans un casino et" +
                    " ne peut donc pas miser ou jouer.");
            return;
        }

        if (mise > joueur.getCapital()) {
            System.out.println("\n" + joueur.getNom().toUpperCase() + " Votre mise $" + mise + " dépasse votre " +
                    "capital, $" + joueur.getCapital() + " vous ne pouvez donc pas miser.");
            return;
        }

        if (isBonJeu(jeu, joueur)) {
            int nouveauCapitalJoueur = joueur.getCapital() - mise;
            System.out.println("\n" + joueur.getNom().toUpperCase() + " avec un capital de $" + joueur.getCapital()
                    + " vient de miser $" + mise + " dans le Jeu " + jeu.getNom().toUpperCase() + ".");
            int gain = jeu.calculerGains(mise);
            calculerCapitalJoueur(joueur, mise, nouveauCapitalJoueur, gain);
        }
    }

    public String toString() {
        StringBuilder chaine = new StringBuilder("\nBIENVENUE DANS LE CASINO " + nom.toUpperCase() +
                ", elle contient actuellement " + joueurPresents + " joueurs.\nCe casino a un capital initial de $100 000" +
                " et prend maximum " + maxJoeurs + " Joueurs.\n" + "Ici vous pouvez notamment jouer au Jeux " + Arrays.toString(jeux)
                + "\n*********************************************\n");
        if (joueurPresents <= 0) {
            chaine.append(this.nom.toUpperCase()).append(" ne contient pas de joueurs actuellement.\n");
        } else {
            chaine.append("\t\t\t").append(this.nom.toUpperCase()).append(" CONTIENT ACTUELLEMENT\n");
            for (int i = 0; i < joueurPresents; i++) {
                chaine.append(this.joueurs[i]).append("\n");
            }
        }
        chaine.append("***********************************************\n");
        return chaine.toString();
    }

    @Override
    public int compareTo(Object o) {

        Casino autre = (Casino) o;
        if (autre == this) {
            return 0;
        }
        return Integer.compare(this.getSommeCapitalJoueursPresent(), autre.getSommeCapitalJoueursPresent());
    }

    @Override
    public void evaluationMunicipale() {
        if (joueurPresents <= 0) {
            System.out.println("\n" + nom.toUpperCase() + " actuellement vous n'avez pas de joueurs présent dans votre casino " +
                    "et par conséquent aucune évaluation ne peut être fait. Nous repasserons plus tard.");
            return;
        }
        int valeurTotale = TAXEMUNICIPALE * joueurPresents;
        System.out.println("\nAprès l'évaluation Municipale, la valeur totale du casino " + nom.toUpperCase()
                + " vaut $" + valeurTotale + ".");
    }

    @Override
    public abstract void payerImpots();

    public boolean equals(Casino autreCasino) {
        boolean isMemeNom = this.nom.equalsIgnoreCase(autreCasino.nom);
        boolean isMemeMaxJoueurs = this.maxJoeurs == autreCasino.maxJoeurs;
        return isMemeNom & isMemeMaxJoueurs;
    }

    public int getSommeCapitalJoueursPresent() {
        for (int i = 0; i < joueurPresents; i++) {
            sommeCapitalJoueursPresent += joueurs[i].getCapital();
        }
        return sommeCapitalJoueursPresent;
    }

    //<editor-fold desc="GETTERS AND SETTERS">
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getJoueurPresents() {
        return joueurPresents;
    }

    public void setJoueurPresents(int joueurPresents) {
        this.joueurPresents = joueurPresents;
    }

    public int getMaxJoueurs() {
        return maxJoeurs;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public boolean getJoueurPeutJouer() {
        return joueurPeutJouer;
    }

    public void setJoueurPeutJouer(boolean joueurPeutJouer) {
        this.joueurPeutJouer = joueurPeutJouer;
    }

    public Joueur[] getJoueurs() {
        return joueurs;
    }

    //</editor-fold>

    //<editor-fold desc="Méthodes Locales (Private)">

    private int indexJoueurTrouve(Joueur joueur) {
        for (int i = 0; i < joueurPresents; i++) {
            if (joueur.equals(joueurs[i])) {
                return i;
            }
        }
        return -1;
    }

    private void calculerCapitalJoueur(Joueur joueur, int mise, int nouveauCapital, int gain) {
        if (gain != mise) {
            setCapital(getCapital() - (gain - mise));
            joueur.setCapital(gain + nouveauCapital);
            System.out.println("\n" + joueur.getNom().toUpperCase() + " Votre nouveau capital est de $"
                    + joueur.getCapital() + " (Votre gain $" + (gain - mise) + ").\n"
                    + nom.toUpperCase() + " votre capital viens de diminuer, elle est maintenant de $" + capital + ".");
        } else {
            setCapital(getCapital() + mise);
            joueur.setCapital(nouveauCapital);
            System.out.println("\n" + joueur.getNom().toUpperCase() + " Vous n'avez pas gagné, donc vous perdez votre " +
                    "mise. Votre nouveau capital est de $" + joueur.getCapital() + ".\n" + nom.toUpperCase() +
                    " votre capital viens d'augmenter, elle est maintenant de $" + capital + ".");
        }
    }

    private boolean isBonJeu(Jeu jeu, Joueur joueur) {
        for (Jeu value : jeux) {
            if (jeu.equals(value)) {
                return true;
            }
        }
        System.out.println("\n" + joueur.getNom().toUpperCase() + " ce jeu " + jeu.getNom().toUpperCase()
                + " n'existe pas dans ce casino. Vous ne pouvez donc pas " +
                "jouer.\nChoisissez un autre jeu. \n" + afficherListeJeux());
        return false;
    }

    private boolean isPeutEntrer(Joueur joueur) {
        if (joueur instanceof JoueurPauvre && joueur.getCapital() < 10) {
            joueur.setCasino(null);
            System.out.println("\nDésolé " + joueur + " n'a pas assez d'argent. Il lui faut minimum $10.");
            return false;
        }

        if (joueur instanceof JoueurRiche && joueur.getCapital() < 1000) {
            joueur.setCasino(null);
            System.out.println("\nDésolé " + joueur + " n'a pas assez d'argent. Il lui faut minimum $1000.");
            return false;
        }
        return true;
    }

    private String afficherListeJeux() {
        String chaine = "";
        for (int i = 0; i < jeux.length; i++) {
            chaine += i + 1 + ": " + jeux[i].getNom().toUpperCase() + "\n";
        }
        return chaine;
    }

    //</editor-fold> Fin méthode locales


}// Fin class Casino
