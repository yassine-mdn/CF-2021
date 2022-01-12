package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Client {
    private String nom;
    private CompteCourant compteCourant;
    private CompteEpargne compteEpargne;

    public Client(String nom, CompteCourant compteCourant, CompteEpargne compteEpargne) {
        this.nom = nom;
        this.compteCourant = compteCourant;
        this.compteEpargne = compteEpargne;
    }

    public double calcSomme(){
        return compteCourant.solde + compteEpargne.solde;
    }

    public static void trieParSoldeTotale(List<Client> clients){
        Collections.sort(clients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return (int) (o1.calcSomme() - o2.calcSomme());
            }
        });
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public CompteCourant getCompteCourant() {
        return compteCourant;
    }

    public void setCompteCourant(CompteCourant compteCourant) {
        this.compteCourant = compteCourant;
    }

    public CompteEpargne getCompteEpargne() {
        return compteEpargne;
    }

    public void setCompteEpargne(CompteEpargne compteEpargne) {
        this.compteEpargne = compteEpargne;
    }
}
