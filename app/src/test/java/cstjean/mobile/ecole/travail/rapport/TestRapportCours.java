package cstjean.mobile.ecole.travail.rapport;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.Travail;
import java.util.Calendar;
import java.util.GregorianCalendar;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Allo.
 *
 * @author Justin Morand
 */
public class TestRapportCours {
    /**
     * ok.
     */
    @Test
    public void testRapport() {
        RapportCours rapport = new RapportCours();
        rapport.ajouterTravail(new CoursSession("FRANÇAIS", "201"));
        rapport.ajouterTravail(new CoursSession("PHILO", "301"));

        assertEquals("FRANÇAIS 201\nPHILO 301\n", rapport.getRapportCours());
    }
}