package menufact.plats;

import ingredients.IIngredients;
import ingredients.IngredientCreator;
import ingredients.TypeIngredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlatChoisiTest {

    private PlatAuMenu platAuMenu;
    private PlatChoisi platChoisi;
    private ArrayList<IIngredients> ingredients;

    @BeforeEach
    void setUp() {
        ingredients = new ArrayList<>();
        ingredients.add(IngredientCreator.CreateNewIngredient(TypeIngredient.VIANDE, 2, "g"));
        ingredients.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LAITIER, 3, "ml"));
        ingredients.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LEGUME, 4, "g"));
        ingredients.add(IngredientCreator.CreateNewIngredient(TypeIngredient.EPICE, 5, "g"));

        platAuMenu = new PlatAuMenu(1, "Plat Test", 12.50, ingredients);
        platChoisi = new PlatChoisi(platAuMenu, 3);
    }

    @Test
    void testGetQuantite() {
        assertEquals(3, platChoisi.getQuantite());
    }

    @Test
    void testSetQuantite() {
        platChoisi.setQuantite(5);
        assertEquals(5, platChoisi.getQuantite());
    }

    @Test
    void testGetPlat() {
        assertEquals(platAuMenu, platChoisi.getPlat());
    }

    @Test
    void testGetEtatsPlat() {
        assertEquals(EtatsPlat.CHOISI, platChoisi.getEtatsPlat());
    }

    @Test
    void testSetEtatsPlat() {
        platChoisi.setEtatsPlat(EtatsPlat.PREPARATION);
        assertEquals(EtatsPlat.PREPARATION, platChoisi.getEtatsPlat());
        platChoisi.setEtatsPlat(EtatsPlat.IMPOSSIBLE);
        assertEquals(EtatsPlat.IMPOSSIBLE, platChoisi.getEtatsPlat());
        platChoisi.setEtatsPlat(EtatsPlat.TERMINER);
        assertEquals(EtatsPlat.TERMINER, platChoisi.getEtatsPlat());
    }

    @Test
    void testGetIngredients() {
        assertEquals(ingredients, platChoisi.getIngredients());
    }

    @Test
    void testToString() {
        String expected = "menufact.plats.PlatChoisi{" +
                "quantite=3, plat=" + platAuMenu.toString() +
                '}';
        assertEquals(expected, platChoisi.toString());
    }
}
