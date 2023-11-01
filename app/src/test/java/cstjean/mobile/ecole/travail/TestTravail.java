package cstjean.mobile.ecole.travail;

import junit.framework.TestCase;

import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.junit.Assert.assertEquals;
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


    protected Travail creerTravail(String nom, Calendar dateRemise) {
        return new Travail(nom, dateRemise);
    }
}
