package Casinos;


import java.util.Locale;

public class CasinoLegal extends Casino {

    //<editor-fold desc="CONSTRUCTEUR">
    public CasinoLegal() {
        super("Casino Legal", 3);
    }

    public CasinoLegal(String nom, int maxJoeurs) {
        super(nom, maxJoeurs);
    }

    public CasinoLegal(Casino casino) {
        super(casino);
    }
    //</editor-fold>

    public int collecterImpots() {
        int impotCollecter = 0;
        for (int i = 0; i < this.getJoueurPresents(); i++) {
            impotCollecter += (TAXE * getJoueurs()[i].getCapital());
            System.out.println("\n" + getJoueurs()[i].getNom().toUpperCase() + ", $" + (TAXE * getJoueurs()[i].getCapital())
                    + " vient d'être collecter de votre capital. ");
            getJoueurs()[i].setCapital((getJoueurs()[i].getCapital() - (int) (TAXE * getJoueurs()[i].getCapital())));
        }
        this.setCapital((this.getCapital() + impotCollecter));
        return impotCollecter;
    }

    public void debutSpectacle() {
        if (getJoueurPresents() <= 0) {
            System.out.println("\nActuellement il n'y a pas de Joueurs donc aucun spectacle ne peut débuter sans " +
                    "spectateurs.");
            return;
        }
        this.setJoueurPeutJouer(false);
    }

    public void finSpectacle() {
        if (getJoueurPeutJouer()) {
            System.out.println(("\nPas de spectacle actuellement, un spectacle ne peut cesser quand elle n'a " +
                    "pas encore commencer.").toUpperCase());
            return;
        }
        this.setJoueurPeutJouer(true);
        System.out.println("\n**** Le spectacle est terminé. Vous pouvez désormais passer vos paris.****".toUpperCase());
    }

    @Override
    public String toString() {
        return super.toString().concat("CECI EST UN CASINO LEGAL.\n**********************************************\n");
    }

    @Override
    public boolean equals(Casino autreCasino) {
        return super.equals(autreCasino);
    }

    @Override
    public void payerImpots() {
        int gainCasino = this.getCapital() - 100000;
        if (gainCasino <= 0) {
            System.out.println("\n" + getNom().toUpperCase() + " vous devez payez les impôts. C-a-d que 15% de votre " +
                    "gain en capital devrait être déduis. Mais présentement vous n'avez pas de gain, du coup on passera" +
                    " une prochaine fois. ");
            return;
        }
        double impots = TAXE * gainCasino;
        this.setCapital((int) (this.getCapital() - impots));
        System.out.print(getNom().toUpperCase() + " vous venez de payez les impôts $");
        System.out.format(Locale.CANADA, "%.2f", impots);
        System.out.print(". C-a-d que 15% de votre gain en capital vient d'être déduis.");
    }


} // fin class CasinoLegal
