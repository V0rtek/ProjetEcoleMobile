package cstjean.mobile.ecole.travail;

import cstjean.mobile.ecole.travail.Compteur;
import cstjean.mobile.ecole.travail.CoursSession;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;
import org.junit.Test;import org.junit.Before;

/**
 * Allo.
 *
 * @author Justin Morand
 */
public class TestCompteur {
    /**
     * .
     */
    @Before
    public void setUp() {
        Compteur.reinitialiserCompteur();
    }

    /**
     * .
     */
    @Test
    public void testReinitialisationCompteur() {
        Compteur.incrementer_compteurCoursSession();
        Compteur.reinitialiserCompteur();
        assertEquals(0, Compteur.get_compteurCoursSession());
    }

    /**
     * .
     */
    @Test
    public void testIncrementation() {
        Compteur.incrementer_compteurCoursSession();
        assertEquals(1, Compteur.get_compteurCoursSession());
    }

    /**
     * .
     */
    @Test
    public void testIncrementationAuto() {
        new CoursSession("Philo", "101");
        assertEquals(1, Compteur.get_compteurCoursSession());
    }
}
