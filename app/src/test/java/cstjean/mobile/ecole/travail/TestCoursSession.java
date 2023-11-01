package cstjean.mobile.ecole.travail;

import static junit.framework.TestCase.assertTrue;

import junit.framework.TestCase;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;import org.junit.Before;


public class TestCoursSession {
    private CoursSession coursSession;
    private Calendar dateRemise;

    @Before
    public void setUp() {
        coursSession = new CoursSession("Philo", "101");
        dateRemise = new GregorianCalendar(2023, Calendar.SEPTEMBER, 10);
    }

    @Test
    public void testCreer() {
        // CoursSession coursSession = new CoursSession("Philo", "101");
        assertEquals("Philo", coursSession.getDepartement());
        assertEquals("101", coursSession.getNumero());
        assertEquals("Philo 101", coursSession.getDepartementNumero());
        // assertEquals(0, coursSession.getNomGrade());

    }

    @Test
    public void testAjoutTravail() {
        // CoursSession coursSession = new CoursSession("Philo", "101");
        Travail travail1 = new Travail("TP1", dateRemise);
        coursSession.ajouterTravail(travail1);
        assertEquals(1, coursSession.getNbTravaux());
        assertEquals(travail1, coursSession.getTravail(0));

        Travail travail2 = new Travail("TP2", dateRemise);
        coursSession.ajouterTravail(travail2);
        assertEquals(2, coursSession.getNbTravaux());
        assertEquals(travail1, coursSession.getTravail(0));
        assertEquals(travail2, coursSession.getTravail(1));

        List<Travail> listDeTravauxExpectee = new ArrayList<>();
        listDeTravauxExpectee.add(travail1);
        listDeTravauxExpectee.add(travail2);
        assertEquals(listDeTravauxExpectee, coursSession.getTravaux());
    }

    /**
     * .
     */
    @Test
    public void testCompare() {
        assertEquals(0, coursSession.compareTo(new CoursSession("Philo", "101")));
        assertTrue(coursSession.compareTo(new CoursSession("Philo", "201")) < 0);
        assertTrue(coursSession.compareTo(new CoursSession("Math", "201")) > 0);
    }

    // Cours sur exeption/erreurs
    @Test
    public void testURL() throws MalformedURLException {
        final String url = "https://www.cstjean.qc.ca/philo101";
        coursSession.setUrl(url);
        assertEquals(url, coursSession.getUrl().toString());
    }

    @Test
    public void testUrlInvalidejUnit3() {
        final String url = "INVALIDE";
        try {
            coursSession.setUrl(url);
            fail("La donnée devrait être invalide");
        } catch (Exception e) {
            // On ne fait rien dans un test
        }

    }

    @Test(expected = MalformedURLException.class)
    public void testUrlInvalidejUnit4() throws MalformedURLException {
        final String url = "INVALIDE";
        coursSession.setUrl(url);
    }

    @Test(expected = PatternSyntaxException.class)
    public void testNumeroCoursInvalide() throws PatternSyntaxException {
        CoursSession coursSession = new CoursSession("Departement", "ERREUR!!");
    }
}
