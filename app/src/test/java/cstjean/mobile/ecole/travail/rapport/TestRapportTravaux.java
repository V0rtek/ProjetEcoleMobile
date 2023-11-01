package cstjean.mobile.ecole.travail.rapport;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.Travail;
import junit.framework.TestCase;

import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;import org.junit.Before;


/**
 * Allo.
 *
 * @author Justin Morand
 */
public class TestRapportTravaux {
    /**
     * ok.
     */
    private CoursSession coursSession;
    /**
     * ok.
     */
    private Calendar dateRemise;

    /**
     * ok.
     */
    @Before
    public void setUp() {
        coursSession = new CoursSession("Philo", "101");
        dateRemise = new GregorianCalendar(2022, Calendar.SEPTEMBER, 10);
    }

    /**
     * ok.
     */
    @Test
    public void testCreer() {
        Travail travail1 = new Travail("TP1", dateRemise);
        coursSession.ajouterTravail(travail1);

        Travail travail2 = new Travail("TP2", dateRemise);
        coursSession.ajouterTravail(travail2);

        assertEquals( RapportTravaux.ENTETE_RAPPORT +
                "TP1 - 2022-09-10\nTP2 - 2022-09-10\nTotal : 2" + RapportTravaux.PIEDDEPAGE_RAPPORT,
                RapportTravaux.getRapportTravaux(coursSession));
        // utiliser RapportTravaux.ENTETE_RAPPORT comme premiere ligne?
    }
}