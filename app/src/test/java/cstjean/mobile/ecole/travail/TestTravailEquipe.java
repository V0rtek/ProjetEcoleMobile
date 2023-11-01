package cstjean.mobile.ecole.travail;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestTravailEquipe extends TestTravail {
    @Test
    public void testAjoutEquipier() {
        TravailEquipe travail = creerTravail("Allo", dateRemise);
        int DA1 = 2222;
        String nomCoequipier1 = "J";
        travail.ajouterCoequipier(DA1, nomCoequipier1);
        assertEquals(travail.getCoequipiers(DA1), nomCoequipier1);

        int DA2 = 3222;
        String nomCoequipier2 = "E";
        travail.ajouterCoequipier(DA2, nomCoequipier2);
        assertEquals(travail.getCoequipiers(DA2), nomCoequipier2);
    }

    @Override
    protected TravailEquipe creerTravail(String nom, Calendar dateRemise) {
        return new TravailEquipe(nom, dateRemise);
    }
}
