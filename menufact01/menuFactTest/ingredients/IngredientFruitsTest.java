package ingredients;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientFruitsTest {

    @Test
    void getQuantiteRestant() {
        IngredientFruits IngredientFruits = new IngredientFruits(100, "g");
        assertEquals(100, IngredientFruits.GetQuantiteRestant());
    }

    @Test
    void setQuantiteRestant() {
        IngredientFruits IngredientFruits = new IngredientFruits(50, "g");
        IngredientFruits.SetQuantiteRestant(100);
        assertEquals(100, IngredientFruits.GetQuantiteRestant());

        try {
            IngredientFruits.SetQuantiteRestant(-10);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void addIngredient() {
        IngredientFruits IngredientFruits = new IngredientFruits(100, "cm");
        IngredientFruits.AddIngredient(20);

        assertEquals(120, IngredientFruits.GetQuantiteRestant());

        IngredientFruits.AddIngredient(-10);
        assertEquals(110, IngredientFruits.GetQuantiteRestant());
    }

    @Test
    void removeIngredient() {
        IngredientFruits IngredientFruits = new IngredientFruits(110, "cm");
        IngredientFruits.RemoveIngredient(20);

        assertEquals(90, IngredientFruits.GetQuantiteRestant());

        IngredientFruits.RemoveIngredient(-10);
        assertEquals(100, IngredientFruits.GetQuantiteRestant());

        try {
            IngredientFruits.RemoveIngredient(110);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void getTypeIngredient() {
        IngredientFruits IngredientFruits = new IngredientFruits(100, "cm");
        assertEquals(TypeIngredient.FRUIT, IngredientFruits.getTypeIngredient());
    }

    @Test
    void setTypeIngredient() {
        IngredientFruits IngredientFruits = new IngredientFruits(100, "cm");
        assertEquals(TypeIngredient.FRUIT, IngredientFruits.getTypeIngredient());

        IngredientFruits.setTypeIngredient(TypeIngredient.EPICE);
        assertEquals(TypeIngredient.EPICE, IngredientFruits.getTypeIngredient());
    }

    @Test
    void getUniter() {
        IngredientFruits IngredientFruits = new IngredientFruits(100, "cm");
        assertEquals("cm", IngredientFruits.getUniter());

        IngredientFruits.setUniter("amogus");
        assertEquals("amogus", IngredientFruits.getUniter());
    }

    @Test
    void setUniter() {
        IngredientFruits IngredientFruits = new IngredientFruits(100, "g");
        assertEquals("g", IngredientFruits.getUniter());

        IngredientFruits.setUniter("h");
        assertEquals("h", IngredientFruits.getUniter());
    }
}