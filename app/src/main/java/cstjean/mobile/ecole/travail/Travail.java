package cstjean.mobile.ecole.travail;

import androidx.annotation.NonNull;

import java.util.Calendar;
import java.util.Objects;

/**
 * a.
 *
 * @author Justin Morand
 */
public class Travail implements Cloneable {
    /**
     * A.
     */
    private final String nom;

    private Calendar dateRemise;
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

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // return super.clone();
        Travail clone = (Travail) super.clone();
        clone.dateRemise = (Calendar) dateRemise.clone();
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travail travail = (Travail) o;
        return nom.equals(travail.nom) && dateRemise.equals(travail.dateRemise);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nom, dateRemise);
    }
}
