package com.company;

public class CompteEpargne extends  CompteCourant{
    private double tauxIntere;

    public CompteEpargne(double solde, double tauxIntere) {
        super(solde,false);
        this.tauxIntere = tauxIntere;
        super.decouvert =false;
    }

    public CompteEpargne() {
        super();
    }

    public double getTauxIntere() {
        return tauxIntere;
    }

    public void setTauxIntere(double tauxIntere) {
        this.tauxIntere = tauxIntere;
    }
}
