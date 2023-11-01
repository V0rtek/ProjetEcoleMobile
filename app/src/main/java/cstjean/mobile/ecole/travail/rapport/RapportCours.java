package cstjean.mobile.ecole.travail.rapport;

import cstjean.mobile.ecole.travail.CoursSession;

import java.util.ArrayList;
import java.util.List;

public class RapportCours extends Rapport {
    /**
     * .
     */
    private final List<CoursSession> listeCoursSession = new ArrayList<>();


    /**
     * .
     *
     * @param coursSession .
     */
    public void ajouterTravail(CoursSession coursSession) {
        this.listeCoursSession.add(coursSession);
    }

    /**
     * .
     *
     * @return .
     */
    String getRapportCours() {
        StringBuilder textRapport = new StringBuilder();

        // Collections.sort(listeCoursSession);

        for (CoursSession cours : listeCoursSession) {
            textRapport.append(cours.getDepartement())
                    .append(" ")
                    .append(cours.getNumero())
                    .append("\n");
        }
        return textRapport.toString();
    }
}
