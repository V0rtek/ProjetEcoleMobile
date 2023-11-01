package cstjean.mobile.ecole.travail;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Calendar;

/**
 * a.
 *
 * @author Justin Morand
 */
public class TravailEquipe extends Travail {
    private final Map<Integer, String> coequipiers = new LinkedHashMap<>();

    public TravailEquipe(String nom, Calendar dateRemise) {
        super(nom, dateRemise);
    }

    void ajouterCoequipier(int DA, String nom) {
        coequipiers.put(DA, nom);
    }

    String getCoequipiers(int DA) {
        return coequipiers.get(DA);
    }
}
