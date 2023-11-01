package cstjean.mobile.ecole.travail;

/**
 * .
 */
public abstract class Compteur {
    /**
     *  a.
     */
    private static int _compteurCoursSession;

    /**
     * a.
     */
    public static void incrementer_compteurCoursSession() {
        _compteurCoursSession++;
    }

    /**
     * Getter.
     *
     * @return Nombre de classes CoursSession.
     */
    public static int get_compteurCoursSession() {
        return _compteurCoursSession;
    }

    /**
     * .
     */
    public static void reinitialiserCompteur() {
        _compteurCoursSession = 0;
    }
}
