package menufact.plats;

import ingredients.IIngredients;
import ingredients.IngredientCreator;
import ingredients.TypeIngredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PlatSanteTest {

    private PlatSante platSante;
    private ArrayList<IIngredients> ingredients;

    @BeforeEach
    void setUp() {
        ingredients = new ArrayList<>();
        platSante = new PlatSante(1, "Plat Santé Test", 15.00, ingredients, 250.0, 50.0, 10.0);
    }

    @Test
    void testGetKcal() {
        assertEquals(250.0, platSante.getKcal());
    }

    @Test
    void testGetChol() {
        assertEquals(50.0, platSante.getChol());
    }

    @Test
    void testGetGras() {
        assertEquals(10.0, platSante.getGras());
    }

    @Test
    void testToString() {
        String expected = "menufact.plats.PlatSante{" +
                "kcal=250.0, chol=50.0, gras=10.0} " +
                "menufact.plats.PlatAuMenu{" +
                "code=1, description='Plat Santé Test', prix=15.0}\n";
        assertEquals(expected, platSante.toString());
    }

    @Test
    void testDefaultConstructor() {
        PlatSante defaultPlatSante = new PlatSante();
        assertEquals(0, defaultPlatSante.getCode());
        assertNull(defaultPlatSante.getDescription());
        assertEquals(0.0, defaultPlatSante.getPrix());
        assertEquals(0.0, defaultPlatSante.getKcal());
        assertEquals(0.0, defaultPlatSante.getChol());
        assertEquals(0.0, defaultPlatSante.getGras());
        assertNull(defaultPlatSante.getIngredients());
    }

    @Test
    void testSetIngredients() {
        ArrayList<IIngredients> newIngredients = new ArrayList<>();
        platSante.setIngredients(newIngredients);
        assertEquals(newIngredients, platSante.getIngredients());

        ArrayList<IIngredients> recette = new ArrayList<>(List.of(Objects.requireNonNull(IngredientCreator.CreateNewIngredient(TypeIngredient.FRUIT, 1, "g"))));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.VIANDE, 2, "g"));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LAITIER, 3, "ml"));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LEGUME, 4, "g"));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.EPICE, 5, "g"));

        platSante.setIngredients(recette);
        assertEquals(recette, platSante.getIngredients());
    }
}
