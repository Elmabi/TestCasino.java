package Jeux;

public class LottoBoolean extends Jeu {

    public LottoBoolean() {
        super("LottoBoolean");
    }

    public LottoBoolean(String nom) {
        super(nom);
    }

    public LottoBoolean(Jeu nouveauJeu) {
        super(nouveauJeu);
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

    @Override
    public int calculerGains(int mise) {

        boolean[] tableau = new boolean[49];
        int compte = 0;
        for (int i = 0; i < tableau.length; i++) {
            int x = (int) (48 * Math.random());
            if (!tableau[x]) {
                tableau[x] = true;
            }
        }

        for (int y = (int) (10 * Math.random()); y < 10; y++) {
            if (tableau[y]) {
                compte++;
                System.out.println("Lotto Numéro " + y + " " + tableau[y]);
            }
        }

        if ((compte >= 0) && (compte <= 3)) {
            System.out.println("\t\t\t\t\tTrue est apparu moins de 4 fois donc\n\t\t\t\t\t\t\t\tPERDU!!! ");
            return mise;
        }

        System.out.println("Vrai (True) obtenu: " + compte + " fois, donc votre mise x " + compte + ".");
        return mise * compte;
    }

    @Override
    public String toString() {
        return "\n\t\t\t\t\tLE JEU * LOTTO BOOLEAN *\n" +
                "Une série de 49 nombres (contenant des TRUE ET FALSE) est lancée au hasard\n" +
                "et sur les 49 nombres vous avez 7 chances sur 10 de gagner et votre mise sera multiplié par le " +
                "nombre de fois que TRUE apparait. Si :\n" +
                "- True n'apparait pas ou apparait mois de 4 fois, vous perdez votre mise.\n" +
                "Exemple: Si vous misez $2 et que true apparait 4 fois, vous recevrez 4 fois votre mise = $8\n ";
    }
}
