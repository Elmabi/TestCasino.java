package Jeux;

public class PileOuFace extends Jeu {

    //<editor-fold desc="CONSTRUCTEUR">
    public PileOuFace() {
        super("Pile ou Face");
    }

    public PileOuFace(String nom) {
        super(nom);
    }

    public PileOuFace(Jeu nouveauJeu) {
        super(nouveauJeu);
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "\n\t\t\t\t\tLE JEU * PILE OU FACE *\n " +
                "Dans le jeu de pile ou face, vous avez 50% de chance de gagner."
                + "\nOn assume que le joueur choisit pile.";

    }

    @Override
    public boolean equals(Jeu autre) {
        return super.equals(autre);
    }

    @Override
    public String getNom() {
        return super.getNom();
    }

    @Override
    public void setNom(String nom) {
        super.setNom(nom);
    }

    public int calculerGains(int mise) {

        double resultat = Math.random();
        if (resultat < 0.5) {
            System.out.println("\t\t\t\t\t\t\t** PILE **. GAGNEEE!!! (2 x votre mise).");
            return 2 * mise;
        }
        System.out.println("\t\t\t\t\t\t\t** FACE **. PERDU");
        return mise;
    }
}
