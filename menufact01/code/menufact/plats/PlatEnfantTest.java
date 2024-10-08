import ingredients.IIngredients;
import ingredients.IngredientCreator;
import ingredients.TypeIngredient;
import menufact.plats.PlatEnfant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlatEnfantTest {

    private PlatEnfant platEnfant;
    private ArrayList<IIngredients> ingredients;

    @BeforeEach
    void setUp() {
        ingredients = new ArrayList<>();
        ingredients.add(IngredientCreator.CreateNewIngredient(TypeIngredient.VIANDE, 20, "g"));
        ingredients.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LAITIER, 20, "ml"));
        ingredients.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LEGUME, 20, "g"));
        ingredients.add(IngredientCreator.CreateNewIngredient(TypeIngredient.EPICE, 20, "g"));
        platEnfant = new PlatEnfant(1, "Plat Enfant Test", 10.00, ingredients, 0.5);
    }

    @Test
    void testGetProportion() {
        assertEquals(0.5, platEnfant.getProportion());
    }

    @Test
    void testToString() {
        String expected = "PlatEnfant{" +
                "proportion=0.5} " +
                "menufact.plats.PlatAuMenu{" +
                "code=1, description='Plat Enfant Test', prix=10.0}\n";
        assertEquals(expected, platEnfant.toString());
    }

    @Test
    void testDefaultConstructor() {
        PlatEnfant defaultPlatEnfant = new PlatEnfant();
        assertEquals(0, defaultPlatEnfant.getCode());
        assertNull(defaultPlatEnfant.getDescription());
        assertEquals(0.0, defaultPlatEnfant.getPrix());
        assertEquals(0.0, defaultPlatEnfant.getProportion());
        assertNull(defaultPlatEnfant.getIngredients());
    }

    @Test
    void testProportionPlatEnfant() {
        ArrayList<IIngredients> ingredientsAvecProportion = new ArrayList<>();
        ingredientsAvecProportion.add(IngredientCreator.CreateNewIngredient(TypeIngredient.VIANDE, 10, "g"));
        ingredientsAvecProportion.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LAITIER, 10, "ml"));
        ingredientsAvecProportion.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LEGUME, 10, "g"));
        ingredientsAvecProportion.add(IngredientCreator.CreateNewIngredient(TypeIngredient.EPICE, 10, "g"));

        assertEquals(ingredientsAvecProportion.toString(), platEnfant.getIngredients().toString());
    }
}
