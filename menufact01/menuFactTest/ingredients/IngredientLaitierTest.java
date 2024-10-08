package ingredients;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientLaitierTest {

    @Test
    void getQuantiteRestant() {
        IngredientLaitier IngredientLaitier = new IngredientLaitier(100, "g");
        assertEquals(100, IngredientLaitier.GetQuantiteRestant());
    }

    @Test
    void setQuantiteRestant() {
        IngredientLaitier IngredientLaitier = new IngredientLaitier(50, "g");
        IngredientLaitier.SetQuantiteRestant(100);
        assertEquals(100, IngredientLaitier.GetQuantiteRestant());

        try {
            IngredientLaitier.SetQuantiteRestant(-10);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void addIngredient() {
        IngredientLaitier IngredientLaitier = new IngredientLaitier(100, "cm");
        IngredientLaitier.AddIngredient(20);

        assertEquals(120, IngredientLaitier.GetQuantiteRestant());

        IngredientLaitier.AddIngredient(-10);
        assertEquals(110, IngredientLaitier.GetQuantiteRestant());
    }

    @Test
    void removeIngredient() {
        IngredientLaitier IngredientLaitier = new IngredientLaitier(110, "cm");
        IngredientLaitier.RemoveIngredient(20);

        assertEquals(90, IngredientLaitier.GetQuantiteRestant());

        IngredientLaitier.RemoveIngredient(-10);
        assertEquals(100, IngredientLaitier.GetQuantiteRestant());

        try {
            IngredientLaitier.RemoveIngredient(110);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void getTypeIngredient() {
        IngredientLaitier IngredientLaitier = new IngredientLaitier(100, "cm");
        assertEquals(TypeIngredient.LAITIER, IngredientLaitier.getTypeIngredient());
    }

    @Test
    void setTypeIngredient() {
        IngredientLaitier IngredientLaitier = new IngredientLaitier(100, "cm");
        assertEquals(TypeIngredient.LAITIER, IngredientLaitier.getTypeIngredient());

        IngredientLaitier.setTypeIngredient(TypeIngredient.EPICE);
        assertEquals(TypeIngredient.EPICE, IngredientLaitier.getTypeIngredient());
    }

    @Test
    void getUniter() {
        IngredientLaitier IngredientLaitier = new IngredientLaitier(100, "cm");
        assertEquals("cm", IngredientLaitier.getUniter());

        IngredientLaitier.setUniter("amogus");
        assertEquals("amogus", IngredientLaitier.getUniter());
    }

    @Test
    void setUniter() {
        IngredientLaitier IngredientLaitier = new IngredientLaitier(100, "g");
        assertEquals("g", IngredientLaitier.getUniter());

        IngredientLaitier.setUniter("h");
        assertEquals("h", IngredientLaitier.getUniter());
    }
}