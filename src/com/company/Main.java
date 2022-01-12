package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Client> clients = new ArrayList<Client>();

    public static void main(String[] args) {
        clients.add(new Client("yassine", new CompteCourant(10000, true), new CompteEpargne(10000, 1)));
        clients.add(new Client("Youssef", new CompteCourant(5000, false), new CompteEpargne(1000, 50)));
        clients.add(new Client("Jalal", new CompteCourant(6000, true), new CompteEpargne(500, 2)));

        try {
            System.out.println(virement(1, 3, 2000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Client.trieParSoldeTotale(clients);
    }

    public static int existeCompte(int numCompte) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getCompteCourant().getNumCompte() == numCompte)
                return i;
        }
        return -1;
    }

    public static boolean virement(int numCc1, int numCc2, double montantVir) throws CompteException, SoldeException {
        boolean virement = false;
        if (existeCompte(numCc1) == -1 && existeCompte(numCc2) == -1) {
            throw new CompteException("l'un des 2 compte n'est pas un compte Courant");
        } else if (!clients.get(existeCompte(numCc2)).getCompteCourant().decouvert || clients.get(existeCompte(numCc2)).getCompteCourant().solde < montantVir) {
            throw new SoldeException("Solde du compte numero " + numCc2 + " est inssufisant");
        } else {
            clients.get(existeCompte(numCc1)).getCompteCourant().solde += montantVir;
            clients.get(existeCompte(numCc2)).getCompteCourant().solde -= montantVir;
            virement = true;
        }
        return  virement;

    }
}
