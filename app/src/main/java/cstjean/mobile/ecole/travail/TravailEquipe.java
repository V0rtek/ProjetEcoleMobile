package cstjean.mobile.ecole.travail;
import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Calendar;
import java.util.Objects;

/**
 * a.
 *
 * @author Justin Morand
 */
public class TravailEquipe extends Travail {
    private Map<Integer, String> coequipiers = new LinkedHashMap<>();

    public TravailEquipe(String nom, Calendar dateRemise) {
        super(nom, dateRemise);
    }

    void ajouterCoequipier(int DA, String nom) {
        coequipiers.put(DA, nom);
    }

    String getCoequipiers(int DA) {
        return coequipiers.get(DA);
    }

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        TravailEquipe clone = (TravailEquipe) super.clone();
        HashMap<Integer, String> coequipiers = new LinkedHashMap<>();

        for (Map.Entry<Integer, String> entry : this.coequipiers.entrySet()) {
            coequipiers.put(entry.getKey(), entry.getValue());
            // Ou entry.getValue().clone() quand c'est un objet ...
        }

        clone.coequipiers = coequipiers;

        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TravailEquipe)) return false;
        if (!super.equals(o)) return false;
        TravailEquipe that = (TravailEquipe) o;
        return coequipiers.equals(that.coequipiers);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coequipiers);
    }
}
