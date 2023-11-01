package cstjean.mobile.ecole.travail.rapport;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.Travail;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * .
 */
public class RapportTravaux extends Rapport {
    /**
     * .
     */
    static final String ENTETE_RAPPORT = "---------- TRAVAUX ----------\n";

    /**
     * .
     */
    static final String PIEDDEPAGE_RAPPORT = "\n-----------------------------";

    /**
     * .
     *
     * @param coursSession .
     * @return .
     */
    public static String getRapportTravaux(CoursSession coursSession) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA);

        StringBuilder textRapport = new StringBuilder(ENTETE_RAPPORT);

        for (int i = 0; i < coursSession.getNbTravaux(); i++) {
            Travail travail = coursSession.getTravail(i);
            textRapport.append(travail.getNom())
                    .append(" - ")
                    .append(formatDate.format(travail.getDateRemise().getTime()))
                    .append("\n");
        }

        textRapport.append("Total : ")
                .append(coursSession.getNbTravaux())
                .append(PIEDDEPAGE_RAPPORT);

        return textRapport.toString();
    }
}
