package Joueurs;

import Casinos.Casino;

public class JoueurRiche extends Joueur {

    //<editor-fold desc="CONSTRUCTEUR">
    public JoueurRiche(String nom, int capital) {
        super(nom, capital);
    }

    public JoueurRiche(String nom) {
        super(nom, 1000);
    }

    public JoueurRiche(Joueur joueur) {
        super(joueur);
    }
    //</editor-fold>

    public void banqueRoute() {
        System.out.println("\n"+getNom().toUpperCase() +" vos investissements ont été saisi par le gouvernement et " +
                "votre capital tombe à 0. Si vous êtes dans un casino, vous êtes prié de quitter.");
        this.setCapital(0);
        try {
            quitterCasino(getCasino());
        } catch (NullPointerException e) {
            System.out.println(getNom().toUpperCase() + " n'est pas actuellement joueur dans un casino et ne peut " +
                    "donc pas quitter.");
        }
    }

    @Override
    public String getNom() {
        return super.getNom();
    }

    @Override
    public void setNom(String nom) {
        super.setNom(nom);
    }

    @Override
    public int getCapital() {
        return super.getCapital();
    }

    @Override
    public void setCapital(int capital) {
        super.setCapital(capital);
    }

    @Override
    public Casino getCasino() {
        return super.getCasino();
    }

    @Override
    public void setCasino(Casino casino) {
        super.setCasino(casino);
    }

    @Override
    public boolean equals(Joueur autreJoueur) {
        return super.equals(autreJoueur);
    }

    @Override
    public String toString() {
        return super.toString().concat(" Il est un joueur RICHE.");
    }

}
