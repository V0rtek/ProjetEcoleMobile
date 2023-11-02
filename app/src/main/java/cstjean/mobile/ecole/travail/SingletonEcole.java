package cstjean.mobile.ecole.travail;
import java.util.ArrayList;
import java.util.List;
public class SingletonEcole {
    private static SingletonEcole instance = null;
    private final List<CoursSession> listeCoursSession = new ArrayList<>();
    private SingletonEcole() {
        // Données de tests
        listeCoursSession.add(new CoursSession("Philo", "101"));
        listeCoursSession.add(new CoursSession("Philo", "210"));
        listeCoursSession.add(new CoursSession("Math", "101"));
        listeCoursSession.add(new CoursSession("Français", "101"));
    }

    public void ajouter(CoursSession coursSession) {
        listeCoursSession.add(coursSession);
    }

    public void reinitialiser() {
        listeCoursSession.clear();
    }

    public static SingletonEcole getInstance() {
        if (instance == null) {
            instance = new SingletonEcole();
        }
        return instance;
    }

    public List<CoursSession> getListeCoursSession() { return listeCoursSession; }

    public int getNbCoursSession() { return listeCoursSession.size(); }

    public static CoursSession getCoursSession(int indexCourant) {
        return SingletonEcole.getInstance().listeCoursSession.get(indexCourant);
    }
}
