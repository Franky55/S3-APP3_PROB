package ingredients;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientLegumesTest {

    @Test
    void getQuantiteRestant() {
        IngredientLegumes IngredientLegumes = new IngredientLegumes(100, "g");
        assertEquals(100, IngredientLegumes.GetQuantiteRestant());
    }

    @Test
    void setQuantiteRestant() {
        IngredientLegumes IngredientLegumes = new IngredientLegumes(50, "g");
        IngredientLegumes.SetQuantiteRestant(100);
        assertEquals(100, IngredientLegumes.GetQuantiteRestant());

        try {
            IngredientLegumes.SetQuantiteRestant(-10);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void addIngredient() {
        IngredientLegumes IngredientLegumes = new IngredientLegumes(100, "cm");
        IngredientLegumes.AddIngredient(20);

        assertEquals(120, IngredientLegumes.GetQuantiteRestant());

        IngredientLegumes.AddIngredient(-10);
        assertEquals(110, IngredientLegumes.GetQuantiteRestant());
    }

    @Test
    void removeIngredient() {
        IngredientLegumes IngredientLegumes = new IngredientLegumes(110, "cm");
        IngredientLegumes.RemoveIngredient(20);

        assertEquals(90, IngredientLegumes.GetQuantiteRestant());

        IngredientLegumes.RemoveIngredient(-10);
        assertEquals(100, IngredientLegumes.GetQuantiteRestant());

        try {
            IngredientLegumes.RemoveIngredient(110);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void getTypeIngredient() {
        IngredientLegumes IngredientLegumes = new IngredientLegumes(100, "cm");
        assertEquals(TypeIngredient.LEGUME, IngredientLegumes.getTypeIngredient());
    }

    @Test
    void setTypeIngredient() {
        IngredientLegumes IngredientLegumes = new IngredientLegumes(100, "cm");
        assertEquals(TypeIngredient.LEGUME, IngredientLegumes.getTypeIngredient());

        IngredientLegumes.setTypeIngredient(TypeIngredient.EPICE);
        assertEquals(TypeIngredient.EPICE, IngredientLegumes.getTypeIngredient());
    }

    @Test
    void getUniter() {
        IngredientLegumes IngredientLegumes = new IngredientLegumes(100, "cm");
        assertEquals("cm", IngredientLegumes.getUniter());

        IngredientLegumes.setUniter("amogus");
        assertEquals("amogus", IngredientLegumes.getUniter());
    }

    @Test
    void setUniter() {
        IngredientLegumes IngredientLegumes = new IngredientLegumes(100, "g");
        assertEquals("g", IngredientLegumes.getUniter());

        IngredientLegumes.setUniter("h");
        assertEquals("h", IngredientLegumes.getUniter());
    }
}