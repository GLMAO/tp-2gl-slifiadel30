package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireEmploiDuTemps implements Subject {
    private List<ICours> listeCours = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void ajouterCours(ICours cours) {
        this.listeCours.add(cours);
        System.out.println("Nouvau cours est ajoutée : " + cours.getDescription());
        notifyObservers("Nouvau cours est ajoutée : " + cours.getDescription());
    }

    public void modifierCours(ICours cours, String message) {
        System.out.println("Cours est modifiée : " + message);
        notifyObservers("Cours est modifiée : " + message);
    }

    public void setChangement(String message) {
        notifyObservers(message);
    }
}