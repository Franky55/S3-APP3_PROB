package ingredients;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientEpiceTest {

    @Test
    void getQuantiteRestant() {
        IngredientEpice ingredientEpice = new IngredientEpice(100, "g");
        assertEquals(100, ingredientEpice.GetQuantiteRestant());
    }

    @Test
    void setQuantiteRestant() {
        IngredientEpice ingredientEpice = new IngredientEpice(50, "g");
        ingredientEpice.SetQuantiteRestant(100);
        assertEquals(100, ingredientEpice.GetQuantiteRestant());

        // Disabled.
        try {
            ingredientEpice.SetQuantiteRestant(-10);
            assertTrue(true);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void addIngredient() {
        IngredientEpice ingredientEpice = new IngredientEpice(100, "cm");
        ingredientEpice.AddIngredient(20);

        assertEquals(120, ingredientEpice.GetQuantiteRestant());

        try {
            ingredientEpice.AddIngredient(-10);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        assertEquals(120, ingredientEpice.GetQuantiteRestant());
    }

    @Test
    void removeIngredient() {
        IngredientEpice ingredientEpice = new IngredientEpice(110, "cm");
        ingredientEpice.RemoveIngredient(20);

        assertEquals(90, ingredientEpice.GetQuantiteRestant());

        ingredientEpice.RemoveIngredient(-10);
        assertEquals(100, ingredientEpice.GetQuantiteRestant());

        try {
            ingredientEpice.RemoveIngredient(110);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void getTypeIngredient() {
        IngredientEpice ingredientEpice = new IngredientEpice(100, "cm");
        assertEquals(TypeIngredient.EPICE, ingredientEpice.getTypeIngredient());
    }

    @Test
    void setTypeIngredient() {
        IngredientEpice ingredientEpice = new IngredientEpice(100, "cm");
        assertEquals(TypeIngredient.EPICE, ingredientEpice.getTypeIngredient());

        ingredientEpice.setTypeIngredient(TypeIngredient.FRUIT);
        assertEquals(TypeIngredient.FRUIT, ingredientEpice.getTypeIngredient());
    }

    @Test
    void getUniter() {
        IngredientEpice ingredientEpice = new IngredientEpice(100, "cm");
        assertEquals("cm", ingredientEpice.getUniter());

        ingredientEpice.setUniter("amogus");
        assertEquals("amogus", ingredientEpice.getUniter());
    }

    @Test
    void setUniter() {
        IngredientEpice ingredientEpice = new IngredientEpice(100, "g");
        assertEquals("g", ingredientEpice.getUniter());

        ingredientEpice.setUniter("h");
        assertEquals("h", ingredientEpice.getUniter());
    }
}