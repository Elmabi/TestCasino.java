package Joueurs;

import Casinos.Casino;
import Jeux.Jeu;

public abstract class Joueur implements Comparable {

    private String nom;
    private int capital;
    private Casino casino;

    //<editor-fold desc="CONSTRUCTEURS">

    public Joueur(String nom, int capital) {
        this.nom = nom;
        this.capital = capital;
        this.casino = null;
    }

    public Joueur(Joueur joueur) {
        this(joueur.nom, joueur.capital);
    }
    //</editor-fold>


    public void joindreCasino(Casino casino) {
        if (capital <= 0) {
            System.out.println("\nDésolez " + nom.toUpperCase() + ", vous n'avez pas assez d'argent pour pourvoir " +
                    "joindre le casino " + casino.getNom().toUpperCase() + ".");
            return;
        }

        if (casino == this.casino) {
            System.out.println("\n" + nom.toUpperCase() + " est déjà dans le casino "
                    + casino.getNom().toUpperCase() + ".");
            return;
        }

        if ((casino.getJoueurPresents() < casino.getMaxJoueurs())) {
            this.casino = casino;
            this.casino.ajouterJoueur(this);
        } else {
            System.out.println("\nDésolé le casino est plein. " + this.nom.toUpperCase()
                    + " ne peut pas être ajouter.");
            this.casino = null;
        }

    }

    public void quitterCasino(Casino casino) {
        if (this.casino != casino) {
            System.out.println("\n" + nom.toUpperCase() + " n'est pas actuellement joueur dans le casino "
                    + casino.getNom().toUpperCase() + " et ne peut donc pas quitter.");
            return;
        }
        casino.enleverJoueur(this);
        this.casino = null;
    }

    public void jouer(int mise, Jeu jeu) {

        try {
            casino.jouer(this, mise, jeu);
        } catch (NullPointerException e) {
            System.out.println("\n" + this.nom.toUpperCase() + " n'est pas actuellement joueur dans un casino et ne peut " +
                    "donc pas miser ou jouer.\n");
        }

    }

    public boolean equals(Joueur autreJoueur) {
        return this.nom.equalsIgnoreCase(autreJoueur.nom);
    }

    @Override
    public int compareTo(Object o) {
        Joueur autre = (Joueur) o;
        if (this.getCapital() == autre.getCapital()) {
            if (nom.compareTo(autre.nom) < 0) {
                return 1;
            }
            if (nom.compareTo(autre.nom) == 0) {
                return 0;
            }
        }

        if (this.getCapital() > autre.getCapital()) {
            return 1;
        }

        return -1;
    }

    public String toString() {

        StringBuilder chaine = new StringBuilder("Joueur " + nom.toUpperCase() + " |>>" + "\tCapital: "
                + "$" + capital + " \t|>>");
        if (casino == null) {
            chaine.append("\tn'est pas dans un Casino.");
        } else {
            chaine.append("\test dans le Casino: ").append(casino.getNom().toUpperCase()).append(".");
        }
        return chaine.toString();
    }

    //<editor-fold desc="GETTERS AND SETTERS">
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public Casino getCasino() {
        return casino;
    }

    public void setCasino(Casino casino) {
        this.casino = casino;
    }
    //</editor-fold>

}// fin class Joueur
