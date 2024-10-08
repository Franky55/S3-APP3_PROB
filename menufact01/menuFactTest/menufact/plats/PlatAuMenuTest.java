package menufact.plats;

import ingredients.IIngredients;
import ingredients.IngredientCreator;
import ingredients.TypeIngredient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PlatAuMenuTest {

    private PlatAuMenu plat;
    private ArrayList<IIngredients> ingredients;

    @BeforeEach
    void setUp() {
        ingredients = new ArrayList<>();
        plat = new PlatAuMenu(1, "Plat Test", 12.50, ingredients);
    }

    @Test
    void testGetCode() {
        assertEquals(1, plat.getCode());
    }

    @Test
    void testSetCode() {
        plat.setCode(2);
        assertEquals(2, plat.getCode());
        plat.setCode(1000);
        assertEquals(1000, plat.getCode());
        plat.setCode(-1);
        assertEquals(-1, plat.getCode());
    }

    @Test
    void testGetDescription() {
        assertEquals("Plat Test", plat.getDescription());
    }

    @Test
    void testSetDescription() {
        plat.setDescription("Nouveau Plat");
        assertEquals("Nouveau Plat", plat.getDescription());
    }

    @Test
    void testGetPrix() {
        assertEquals(12.50, plat.getPrix());
    }

    @Test
    void testSetPrix() {
        plat.setPrix(15.00);
        assertEquals(15.00, plat.getPrix());
    }

    @Test
    void testGetIngredients() {
        assertEquals(ingredients, plat.getIngredients());
    }

    @Test
    void testSetIngredients() {
        ArrayList<IIngredients> newIngredients = new ArrayList<>();
        plat.setIngredients(newIngredients);
        assertEquals(newIngredients, plat.getIngredients());

        ArrayList<IIngredients> recette = new ArrayList<>(List.of(Objects.requireNonNull(IngredientCreator.CreateNewIngredient(TypeIngredient.FRUIT, 1, "g"))));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.VIANDE, 2, "g"));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LAITIER, 3, "ml"));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LEGUME, 4, "g"));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.EPICE, 5, "g"));

        plat.setIngredients(recette);
        assertEquals(recette, plat.getIngredients());
    }

    @Test
    void testToString() {
        String expected = "menufact.plats.PlatAuMenu{" +
                "code=1, description='Plat Test', prix=12.5}\n";
        assertEquals(expected, plat.toString());
    }

    @Test
    void testDefaultConstructor() {
        PlatAuMenu defaultPlat = new PlatAuMenu();
        assertEquals(0, defaultPlat.getCode());
        assertNull(defaultPlat.getDescription());
        assertEquals(0.0, defaultPlat.getPrix());
        assertNull(defaultPlat.getIngredients());
    }
}
