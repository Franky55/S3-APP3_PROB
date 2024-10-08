package ingredients;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientViandeTest {

    @Test
    void getQuantiteRestant() {
        IngredientViande IngredientViande = new IngredientViande(100, "g");
        assertEquals(100, IngredientViande.GetQuantiteRestant());
    }

    @Test
    void setQuantiteRestant() {
        IngredientViande IngredientViande = new IngredientViande(50, "g");
        IngredientViande.SetQuantiteRestant(100);
        assertEquals(100, IngredientViande.GetQuantiteRestant());

        try {
            IngredientViande.SetQuantiteRestant(-10);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void addIngredient() {
        IngredientViande IngredientViande = new IngredientViande(100, "cm");
        IngredientViande.AddIngredient(20);

        assertEquals(120, IngredientViande.GetQuantiteRestant());

        IngredientViande.AddIngredient(-10);
        assertEquals(110, IngredientViande.GetQuantiteRestant());
    }

    @Test
    void removeIngredient() {
        IngredientViande IngredientViande = new IngredientViande(110, "cm");
        IngredientViande.RemoveIngredient(20);

        assertEquals(90, IngredientViande.GetQuantiteRestant());

        IngredientViande.RemoveIngredient(-10);
        assertEquals(100, IngredientViande.GetQuantiteRestant());

        try {
            IngredientViande.RemoveIngredient(110);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void getTypeIngredient() {
        IngredientViande IngredientViande = new IngredientViande(100, "cm");
        assertEquals(TypeIngredient.VIANDE, IngredientViande.getTypeIngredient());
    }

    @Test
    void setTypeIngredient() {
        IngredientViande IngredientViande = new IngredientViande(100, "cm");
        assertEquals(TypeIngredient.VIANDE, IngredientViande.getTypeIngredient());

        IngredientViande.setTypeIngredient(TypeIngredient.EPICE);
        assertEquals(TypeIngredient.EPICE, IngredientViande.getTypeIngredient());
    }

    @Test
    void getUniter() {
        IngredientViande IngredientViande = new IngredientViande(100, "cm");
        assertEquals("cm", IngredientViande.getUniter());

        IngredientViande.setUniter("amogus");
        assertEquals("amogus", IngredientViande.getUniter());
    }

    @Test
    void setUniter() {
        IngredientViande IngredientViande = new IngredientViande(100, "g");
        assertEquals("g", IngredientViande.getUniter());

        IngredientViande.setUniter("h");
        assertEquals("h", IngredientViande.getUniter());
    }
}