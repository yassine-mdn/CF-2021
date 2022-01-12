package com.company;

import java.util.Scanner;

public class CompteCourant {
    private int numCompte;
    double solde;
    boolean decouvert;
    private static int nbrDeComptes = 0;


    public CompteCourant() {
        this.numCompte = ++nbrDeComptes;
        this.decouvert = true;
    }

    public CompteCourant(double solde, boolean decouvert) {
        this.numCompte = ++nbrDeComptes;
        this.solde = solde;
        this.decouvert = decouvert;
    }

    public static CompteCourant creerCompte() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veiller choisir le type de compte");
        System.out.println("(1)- Compte Courant");
        System.out.println("(2)- Compte Epargne");
        int choix = sc.nextInt();
        System.out.println("Solde:");
        double solde = sc.nextDouble();
        if (choix == 1) {
            System.out.println("decouvert:");
            boolean decouvert = sc.nextLine().equals("y");
            return new CompteCourant(solde, decouvert);
        } else {
            System.out.println("taux d'interer:");
            double tauxInterer = sc.nextDouble();
            return new CompteEpargne(solde, tauxInterer);
        }
    }

    public boolean debiter(CompteCourant cb, double montant) {
        if (cb.solde > montant ) {
            if (cb.decouvert) {
                this.solde += montant;
                cb.solde -= montant;
                return true;
            } else return false;
        } else {
            this.solde += montant;
            cb.solde -= montant;
            return true;
        }

    }

    public int getNumCompte() {
        return numCompte;
    }


}
