package Chef;

import Chef.Etats.ChefAttente;
import Chef.Etats.EtatsChef;
import ingredients.IIngredients;
import ingredients.IngredientCreator;
import ingredients.TypeIngredient;
import menufact.plats.EtatsPlat;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ChefAttenteTest {
    private Chef chef;
    private ChefAttente chefAttente;
    private ArrayList<IIngredients> recette;

    @BeforeEach
    void setUp() {
        Chef.Fire();
        chef = Chef.GetInstance();
        chefAttente = new ChefAttente(chef);
        recette = new ArrayList<>(List.of(Objects.requireNonNull(IngredientCreator.CreateNewIngredient(TypeIngredient.FRUIT, 20, "g"))));
        chef.SetEtat(EtatsChef.ATTENTE);
    }

    @Test
    @DisplayName("SetChef")
    void setChef() {
        assertTrue(chefAttente.SetChef(chef));
    }

    @Test
    @DisplayName("Update - Plat en préparation")
    void updateSetsPlatToPreparation() {
        PlatChoisi plat = new PlatChoisi(new PlatAuMenu(0, "Plat", 20, recette), 1);
        chefAttente.Update(plat);
        assertEquals(EtatsPlat.PREPARATION, plat.getEtatsPlat());
    }

    @Test
    @DisplayName("Execute - Rester en attente")
    void executeWhenPlatAFaireIsNull() {
        assertTrue(chefAttente.Execute());
        assertEquals(EtatsChef.ATTENTE, chef.GetEtat());
    }

    @Test
    @DisplayName("Execute - Passer à l'état de travail")
    void executeWhenPlatAFaireIsNotNull() {
        PlatChoisi plat = new PlatChoisi(new PlatAuMenu(0, "Plat", 20, recette), 1);
        chef.Update(plat);
        chefAttente.Execute();
        assertEquals(EtatsChef.TRAVAILLE, chef.GetEtat());
    }

    @Test
    @DisplayName("toString")
    void toStringTest() {
        assertEquals("Chef en attente", chefAttente.toString());
    }

    @Test
    @DisplayName("GetEtatsChef")
    void getEtatsChef() {
        assertEquals(EtatsChef.ATTENTE, chefAttente.GetEtatsChef());
    }
}
