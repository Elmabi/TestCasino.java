package Joueurs;

import Casinos.Casino;
import java.time.LocalDate;


public class JoueurPauvre extends Joueur {


    //<editor-fold desc="CONSTRUCTEUR">
    public JoueurPauvre(String nom, int capital) {
        super(nom, capital);
    }

    public JoueurPauvre(Joueur joueur) {
        super(joueur);
    }

    public JoueurPauvre(String nom) {
        this(nom, 10);
    }
    //</editor-fold>

    public int collecterCheque() {
        if (LocalDate.now().getDayOfMonth() == 1) {
            this.setCapital(this.getCapital() + 700);
            System.out.println("\nYeah " + getNom().toUpperCase() + ", nous sommes le 1er de ce mois ("
                    + LocalDate.now().getMonth() + ") et vous encaissez un chèque de $700. \nDonc votre nouveau " +
                    "capital est de $" + this.getCapital());
        } else {
            System.out.println(getNom().toUpperCase() + " nous sommes le " + LocalDate.now().getDayOfMonth() + " du mois " +
                    LocalDate.now().getMonth() + " et malheureusement vous n'avez aucun chèque en encaissez.");
        }

        return this.getCapital();
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
    public void joindreCasino(Casino casino) {
        super.joindreCasino(casino);
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
    public String toString() {
        return super.toString().concat(" Il est un joueur PAUVRE.");
    }

    @Override
    public boolean equals(Joueur autre) {
        return super.equals(autre);
    }

} // fin class JoueurPauvre
