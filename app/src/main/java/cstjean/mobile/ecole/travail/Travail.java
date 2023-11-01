package cstjean.mobile.ecole.travail;

import java.util.Calendar;

/**
 * a.
 *
 * @author Justin Morand
 */
public class Travail {
    /**
     * A.
     */
    private final String nom;

    private final Calendar dateRemise;
    /**
     * Constructeur.
     *
     * @param nom        Ok.
     * @param dateRemise Ok.
     */
    public Travail(String nom, Calendar dateRemise) {
        this.nom = nom;
        this.dateRemise = dateRemise;
    }

    /**
     * Récupère le nom du travail.
     *
     * @return Justin.
     */
    public String getNom() {
        return nom;
    }

    public Calendar getDateRemise() {
        return dateRemise;
    }
}
