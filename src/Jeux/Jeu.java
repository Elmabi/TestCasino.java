package Jeux;

public abstract class Jeu {

    private String nom;

    //<editor-fold desc="CONSTRUCTEURS">
    public Jeu() {
        this("Jeu");
    }

    public Jeu(String nom) {
        this.nom = nom;
    }

    public Jeu(Jeu nouveauJeu) {
        this(nouveauJeu.nom);
    }
    //</editor-fold>

    public abstract int calculerGains(int mise);

    public abstract String toString();

    public boolean equals(Jeu autre) {
        return this.nom.equalsIgnoreCase(autre.nom);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

} // Fin class jeu
