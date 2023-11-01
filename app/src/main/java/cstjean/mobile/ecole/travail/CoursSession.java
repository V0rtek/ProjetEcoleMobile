package cstjean.mobile.ecole.travail;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.regex.PatternSyntaxException;

/**
 * .
 */
public class CoursSession implements Comparable<CoursSession> {
    /**
     * .
     */
    private final String departement;

    /**
     * .
     */
    private final String numero;
    private URL url;
    /**
     * .
     */
    private final List<Travail> travaux = new ArrayList<>();

    /**
     * .
     * @param departement .
     * @param numero .
     */
    public CoursSession(String departement, String numero) {
        this.departement = departement;
        if (!NumeroCoursUtil.estNumeroCoursValide(numero))
            throw new PatternSyntaxException("Numéro de cours invalide", "regex", -1);

        this.numero = numero;
        Compteur.incrementer_compteurCoursSession();
    }
    public URL getUrl() {
        return url;
    }
    public void setUrl(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    /**
     * .
     * @return .
     */
    public String getDepartement() {
        return departement;
    }

    /**
     * .
     * @return .
     */
    public String getNumero() {
        return numero;
    }

    public List<Travail> getTravaux() {
        return travaux;
    }

    public int getNbTravaux() {
        return travaux.size();
    }

    /**
     * .
     * @param travail .
     */
    public void ajouterTravail(Travail travail) {
        travaux.add(travail);
    }

    /**
     * .
     * @param index s.
     * @return .
     */
    public Travail getTravail(int index) {
        return travaux.get(index);
    }

    public String getDepartementNumero() {
        return departement + " " + numero;
    }

    /**
     * Pour mettre dans le bon ordre.
     * @param o a.
     * @return a.
     */
    @Override
    public int compareTo(CoursSession o) {
        int compareDepartement = getDepartement().compareTo(o.getDepartement());

        if (compareDepartement != 0) {
            return compareDepartement;
        }

        return getNumero().compareTo(o.getNumero());
    }

}
