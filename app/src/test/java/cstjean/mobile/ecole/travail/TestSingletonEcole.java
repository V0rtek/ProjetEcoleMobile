package cstjean.mobile.ecole.travail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class TestSingletonEcole {

    @Test
    public void testInstance() {
        SingletonEcole singleton1 = SingletonEcole.getInstance();
        SingletonEcole singleton2 = SingletonEcole.getInstance();
        assertSame(singleton1, singleton2);
        assertEquals(4, singleton1.getListeCoursSession().size());
    }

    @Test
    public void testAjout() {
        SingletonEcole singleton = SingletonEcole.getInstance();
        CoursSession coursSession = new CoursSession("vide", "000");

        singleton.reinitialiser();
        assertEquals(0, singleton.getNbCoursSession());

        singleton.ajouter(coursSession);
        assertEquals(1, singleton.getNbCoursSession());
        assertEquals(coursSession, singleton.getCoursSession(0));
        assertFalse(singleton.getListeCoursSession().isEmpty());

        singleton.reinitialiser();
        assertEquals(0, singleton.getNbCoursSession());
        assertTrue(singleton.getListeCoursSession().isEmpty());
    }
}
