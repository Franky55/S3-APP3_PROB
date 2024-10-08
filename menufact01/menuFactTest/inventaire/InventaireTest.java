package inventaire;

import ingredients.IIngredients;
import ingredients.IngredientCreator;
import ingredients.TypeIngredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventaireTest {

    private Inventaire inventaire;
    private IIngredients ingredient;

    @BeforeEach
    void setUp() {
        Inventaire.reset();
        inventaire = Inventaire.getInstance();
        ingredient = IngredientCreator.CreateNewIngredient(TypeIngredient.VIANDE, 10, "g"); // Remplacez par une classe mock réelle
    }

    @Test
    void testGetInstance() {
        Inventaire anotherInventaire = Inventaire.getInstance();
        assertSame(inventaire, anotherInventaire, "getInstance should return the same instance");
    }

    @Test
    void testAddIngredient() {
        inventaire.addIngredient(ingredient);
        assertEquals(ingredient, inventaire.getIngredient(ingredient));
    }

    @Test
    void testGetIngredient_ByObject() {
        inventaire.addIngredient(ingredient);
        IIngredients retrieved = inventaire.getIngredient(ingredient);
        assertNotNull(retrieved, "L'ingrédient devrait être récupérable par objet");
        assertEquals(ingredient.getTypeIngredient(), retrieved.getTypeIngredient());
    }

    @Test
    void testGetIngredient_ByType() {
        inventaire.addIngredient(ingredient);
        IIngredients retrieved = inventaire.getIngredient(TypeIngredient.VIANDE);
        assertNotNull(retrieved, "L'ingrédient devrait être récupérable par type");
        assertEquals(ingredient.getTypeIngredient(), retrieved.getTypeIngredient());
    }

    @Test
    void testRemoveIngredient() {
        inventaire.addIngredient(ingredient);
        inventaire.removeIngredient(ingredient);
        assertEquals(0, inventaire.getIngredient(ingredient).GetQuantiteRestant());
    }

    @Test
    void testRemoveIngredient_NotFound() {
        assertThrows(InventaireException.class, () -> {
            inventaire.removeIngredient(ingredient);
        }, "Une exception devrait être lancée si l'ingrédient n'existe pas dans l'inventaire");
    }

    @Test
    void testToString() {
        inventaire.addIngredient(ingredient);
        String expected = ingredient.toString() + "\n";
        String gotten = inventaire.toString();
        assertEquals(expected, gotten);
    }
}
