package Jeux;

public class Lotto3 extends Jeu {


    //<editor-fold desc="CONSTRUCTEUR">
    public Lotto3() {
        super("Lotto 3");
    }

    public Lotto3(String nom) {
        super(nom);
    }

    public Lotto3(Jeu nouveauJeu) {
        super(nouveauJeu);
    }
    //</editor-fold>

    @Override
    public int calculerGains(int mise) {
        System.out.println("\n\t\t\t * LOTTO 3 * NOMBRES GAGNANTS SUIVANT : ");
        int lotto = (int) (25 * Math.random());
        switch (lotto) {
            case 5:
                System.out.println("\t Nombre 1" + ": " + lotto + " (2 x votre mise).");
                mise *= 2;
            case 10:
                System.out.println("\t Nombre 2" + ": " + lotto + " (4 x votre mise).");
                mise *= 4;
                break;
            case 20:
                System.out.println("\t Nombre 3"  + ": " + lotto + " (8 x votre mise).");
                mise *= 8;
                break;
            default:
                System.out.println("\t\t\t\t\t\t\tAUCUN. PERDU!!!");
                break;
        }

        return mise;
    }

    @Override
    public String toString() {
        return "\n\t\t\t\t\tLE JEU * LOTTO 3 *\n" +
                "Une série de 10 nombres (allant de 0 à 25) est lancée au hasard\n" +
                "et sur les dix nombres vous avez 3 chances de gagner et votre mise s'accumule. Si :\n" +
                "- Le nombre 5 apparait, vous recevez 2 fois votre mise.\n" +
                "- Le nombre 10 apparait, vous recevez 4 fois votre mise.\n" +
                "- Le nombre 20 apparait, vous recevez 8 fois votre mise.\n" +
                "- Si aucun de ses nombres n'apparait vous perdez votre mise.\n" +
                "Exemple: Si vous misez $2 et que 10 apparait 2 fois, vous recevrez 2 x 2 x 2 = $8\n";
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
}
