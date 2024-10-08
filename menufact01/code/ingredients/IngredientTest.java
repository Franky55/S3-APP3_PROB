package ingredients;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientTest {
    private Ingredient ingredient;

    @BeforeEach
    public void setUp() {
        ingredient = new Ingredient();
    }

    @Test
    public void testSetAndGetNom() {
        ingredient.setNom("Sel");
        assertEquals("Sel", ingredient.getNom());
    }

    @Test
    public void testSetAndGetDescription() {
        ingredient.setDescription("Un ingrédient pour assaisonner les plats.");
        assertEquals("Un ingrédient pour assaisonner les plats.", ingredient.getDescription());
    }

    @Test
    public void testSetAndGetTypeIngredient() {
        TypeIngredient type = TypeIngredient.EPICE; // Assurez-vous que TypeIngredient est défini.
        ingredient.setTypeIngredient(type);
        assertEquals(type, ingredient.getTypeIngredient());
    }

    @Test
    public void testSetTypeIngredientAvoidUsage() {
        // On vérifie que la méthode de set ne lève pas d'exception, mais que l'utilisation est à éviter.
        TypeIngredient type = TypeIngredient.EPICE; // Assurez-vous que TypeIngredient est défini.
        ingredient.setTypeIngredient(type);
        assertEquals(type, ingredient.getTypeIngredient());
    }
}