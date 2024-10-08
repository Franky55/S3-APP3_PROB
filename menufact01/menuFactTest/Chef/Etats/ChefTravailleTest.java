package Chef;

import Chef.Etats.ChefTravaille;
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

class ChefTravailleTest {
    private Chef chef;
    private ChefTravaille chefTravaille;
    private ArrayList<IIngredients> recette;

    @BeforeEach
    void setUp() {
        Chef.Fire();
        chef = Chef.GetInstance();
        chefTravaille = new ChefTravaille(chef);
        recette = new ArrayList<>(List.of(Objects.requireNonNull(IngredientCreator.CreateNewIngredient(TypeIngredient.FRUIT, 20, "g"))));
        chef.SetEtat(EtatsChef.TRAVAILLE);
    }

    @Test
    @DisplayName("SetChef")
    void setChef() {
        assertTrue(chefTravaille.SetChef(chef));
    }

    @Test
    @DisplayName("Update - Plat en préparation")
    void updateSetsPlatToPreparation() {
        PlatChoisi plat = new PlatChoisi(new PlatAuMenu(0, "Plat", 20, recette), 1);
        chefTravaille.Update(plat);
        assertEquals(EtatsPlat.PREPARATION, plat.getEtatsPlat());
    }

    @Test
    @DisplayName("Execute - Rester en attente")
    void executeWhenPlatAFaireIsNull() {
        assertTrue(chefTravaille.Execute());
        assertEquals(EtatsChef.ATTENTE, chef.GetEtat());
    }

    @Test
    @DisplayName("Execute - Travailler sur un plat")
    void executeWhenPlatAFaireIsNotNull() {
        PlatChoisi plat = new PlatChoisi(new PlatAuMenu(0, "Plat", 20, recette), 1);
        chef.Update(plat);
        chefTravaille.Execute();
        assertEquals(EtatsPlat.TERMINER, plat.getEtatsPlat());
        assertEquals(EtatsChef.ATTENTE, chef.GetEtat());
    }

    @Test
    @DisplayName("Execute - Retour à l'attente après avoir fini un plat")
    void executeReturnsToWaiting() {
        PlatChoisi plat = new PlatChoisi(new PlatAuMenu(0, "Plat", 20, recette), 1);
        chef.Update(plat);
        chefTravaille.Execute();
        chefTravaille.Execute();
        assertEquals(EtatsChef.ATTENTE, chef.GetEtat());
    }

    @Test
    @DisplayName("toString")
    void toStringTest() {
        assertEquals("Chef en travaille.", chefTravaille.toString());
    }

    @Test
    @DisplayName("GetEtatsChef")
    void getEtatsChef() {
        assertEquals(EtatsChef.TRAVAILLE, chefTravaille.GetEtatsChef());
    }
}
