package cstjean.mobile.ecole.travail;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotSame;

import junit.framework.TestCase;

import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
/**
 * Allo.
 *
 * @author Justin Morand
 */
public class TestTravail {
    /**
     * a.
     */
    final Calendar dateRemise = new GregorianCalendar(2023, Calendar.SEPTEMBER, 10);

    @Test
    public void testCreer() {
        String nomDuTravail1 = "TP1";
        Travail travail1 = creerTravail(nomDuTravail1, dateRemise);
        assertEquals(nomDuTravail1, travail1.getNom());
        assertEquals(dateRemise, travail1.getDateRemise());

        String nomDuTravail2 = "TP2";
        Travail travail2 = creerTravail(nomDuTravail2, dateRemise);
        assertEquals(nomDuTravail2, travail2.getNom());
        assertEquals(dateRemise, travail2.getDateRemise());
    }

    @Test
    public void testClone() throws CloneNotSupportedException {
        Calendar dateRemise = new GregorianCalendar(2023, Calendar.SEPTEMBER, 10);
        Travail travail = creerTravail("TP1", dateRemise);
        Travail clone = (Travail) travail.clone();
        assertNotSame(travail, clone);
        assertEquals(travail.getClass(), clone.getClass());
        assertEquals(travail, clone);
    }

    @Test
    public void testEgalite() {
        Calendar dateRemise = new GregorianCalendar(2023, Calendar.SEPTEMBER, 10);

        Travail travailA = creerTravail("TP1", dateRemise);
        Travail travailB = creerTravail("TP1", dateRemise);
        assertEquals(travailA, travailB);

        Travail travailC = creerTravail("TP2", dateRemise);
        assertNotEquals(travailA, travailC);

        // Réflexivité
        assertEquals(travailA, travailA);
        assertEquals(travailB, travailA);

        // Transitivité
        Travail travailD = creerTravail("TP1", dateRemise);
        assertEquals(travailB, travailD);
        assertEquals(travailA, travailD);

        // Constance
        assertEquals(travailA, travailB);

        // Comparaison à null
        // LINT : jUnit n'appelle pas le equal si on envoit null donc on veut comparer directement
        // On veut vraiment tester le null ici...
        assertFalse(travailA.equals(null));

        // Validation
        assertNotEquals("BLABLABLA", travailA);
    }


    protected Travail creerTravail(String nom, Calendar dateRemise) {
        return new Travail(nom, dateRemise);
    }
}
