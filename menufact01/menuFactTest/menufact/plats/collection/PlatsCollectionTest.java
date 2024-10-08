package menufact.plats.collection;

import ingredients.IIngredients;
import ingredients.IngredientCreator;
import ingredients.TypeIngredient;
import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PlatsCollectionTest {

    public static PlatAuMenu p1;
    public static PlatAuMenu p2;
    public static PlatAuMenu p3;
    public static PlatAuMenu p4;
    public static PlatAuMenu p5;

    @BeforeAll
    static void setUp() {
        ArrayList<IIngredients> recette = new ArrayList<>(List.of(Objects.requireNonNull(IngredientCreator.CreateNewIngredient(TypeIngredient.FRUIT, 20, "g"))));

        p1 = new PlatAuMenu(0,"PlatAuMenu0",10, recette);
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.VIANDE, 200, "g"));
        p2 = new PlatAuMenu(1,"PlatAuMenu1",20,recette);
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LAITIER, 200, "ml"));
        p3 = new PlatAuMenu(2,"PlatAuMenu2",30,recette);
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LEGUME, 100, "g"));
        p4 = new PlatAuMenu(3,"PlatAuMenu3",40, recette);
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.EPICE, 1, "g"));
        p5 = new PlatAuMenu(4,"PlatAuMenu4",50, recette);
    }

    @Test
    void ajoute() {
        PlatsCollection platsCollection = new PlatsCollection();

        assertNull(platsCollection.getActuel());

        platsCollection.ajoute(p1);
        platsCollection.ajoute(p2);
        platsCollection.ajoute(p3);
        platsCollection.ajoute(p4);
        platsCollection.ajoute(p5);

        PlatAuMenu first = platsCollection.getActuel();
        assertEquals(p1, first);
    }

    @Test
    void suivant() {
        PlatsCollection platsCollection = new PlatsCollection();
        assertNull(platsCollection.getActuel());

        platsCollection.ajoute(p1);
        platsCollection.ajoute(p2);
        platsCollection.ajoute(p3);
        platsCollection.ajoute(p4);
        platsCollection.ajoute(p5);

        try {
            boolean result = platsCollection.Suivant();
            assertEquals(true, result);
        } catch (MenuException e) {
            e.printStackTrace();
        }

        try {
            boolean result = platsCollection.Suivant();
            assertEquals(true, result);
        } catch (MenuException e) {
            e.printStackTrace();
        }

        try {
            boolean result = platsCollection.Suivant();
            assertEquals(true, result);
        } catch (MenuException e) {
            e.printStackTrace();
        }

        try {
            boolean result = platsCollection.Suivant();
            assertEquals(true, result);
        } catch (MenuException e) {
            e.printStackTrace();
        }

        try {
            boolean result = platsCollection.Suivant();
            assertEquals(true, result);
        } catch (MenuException e) {
            System.out.println("erreur a 5");
            e.printStackTrace();
        }

        try {
            boolean result = platsCollection.Suivant();
            assertFalse(true);
        } catch (MenuException e) {
            assertTrue(true);
        }
    }

    @Test
    void setPosition() {
        PlatsCollection platsCollection = new PlatsCollection();
        assertNull(platsCollection.getActuel());

        platsCollection.ajoute(p1);
        platsCollection.ajoute(p2);
        platsCollection.ajoute(p3);
        platsCollection.ajoute(p4);
        platsCollection.ajoute(p5);

        assertTrue(platsCollection.SetPosition(0));
        assertTrue(platsCollection.SetPosition(1));
        assertTrue(platsCollection.SetPosition(2));
        assertTrue(platsCollection.SetPosition(3));
        assertTrue(platsCollection.SetPosition(4));

        assertEquals(4, platsCollection.GetPosition());
    }

    @Test
    void precedent() {
        PlatsCollection platsCollection = new PlatsCollection();
        assertNull(platsCollection.getActuel());

        platsCollection.ajoute(p1);
        platsCollection.ajoute(p2);
        platsCollection.ajoute(p3);
        platsCollection.ajoute(p4);
        platsCollection.ajoute(p5);
        platsCollection.SetPosition(4);

        try {
            boolean result = platsCollection.Precedent();
            assertEquals(true, result);
            assertEquals(3, platsCollection.GetPosition());
        } catch (MenuException e) {
            e.printStackTrace();
        }

        try {
            boolean result = platsCollection.Precedent();
            assertEquals(true, result);
            assertEquals(2, platsCollection.GetPosition());
        } catch (MenuException e) {
            e.printStackTrace();
        }

        try {
            boolean result = platsCollection.Precedent();
            assertEquals(true, result);
            assertEquals(1, platsCollection.GetPosition());
        } catch (MenuException e) {
            e.printStackTrace();
        }

        try {
            boolean result = platsCollection.Precedent();
            assertEquals(true, result);
            assertEquals(0, platsCollection.GetPosition());
        } catch (MenuException e) {
            e.printStackTrace();
        }

        try {
            boolean result = platsCollection.Precedent();
            assertEquals(false, result);
        } catch (MenuException e) {
            assertEquals(0, platsCollection.GetPosition());
        }
    }

    @Test
    void getActuel() {
        PlatsCollection platsCollection = new PlatsCollection();
        assertNull(platsCollection.getActuel());

        platsCollection.ajoute(p1);
        platsCollection.ajoute(p2);
        platsCollection.ajoute(p3);
        platsCollection.ajoute(p4);
        platsCollection.ajoute(p5);

        PlatAuMenu actuel = platsCollection.getActuel();
        assertEquals(p1, actuel);

        assertTrue(platsCollection.SetPosition(0));
        assertEquals(0, platsCollection.GetPosition());
        actuel = platsCollection.getActuel();
        System.out.println(actuel.getDescription());
        assertEquals(p1, actuel);

        try{
            assertTrue(platsCollection.Suivant());
            assertEquals(1, platsCollection.GetPosition());
            actuel = platsCollection.getActuel();
            System.out.println(actuel.getDescription());
            assertEquals(p2, actuel);
        } catch (MenuException e) {
            assertTrue(false);
        }

        assertTrue(platsCollection.SetPosition(2));
        assertEquals(2, platsCollection.GetPosition());
        actuel = platsCollection.getActuel();
        System.out.println(actuel.getDescription());
        assertEquals(p3, actuel);

        assertTrue(platsCollection.SetPosition(3));
        assertEquals(3, platsCollection.GetPosition());
        actuel = platsCollection.getActuel();
        System.out.println(actuel.getDescription());
        assertEquals(p4, actuel);

        assertTrue(platsCollection.SetPosition(4));
        assertEquals(4, platsCollection.GetPosition());
        actuel = platsCollection.getActuel();
        System.out.println(actuel.getDescription());
        assertEquals(p5, actuel);
    }

    @Test
    void getPosition() {
        PlatsCollection platsCollection = new PlatsCollection();
        assertNull(platsCollection.getActuel());

        platsCollection.ajoute(p1);
        platsCollection.ajoute(p2);
        platsCollection.ajoute(p3);
        platsCollection.ajoute(p4);
        platsCollection.ajoute(p5);

        assertTrue(platsCollection.SetPosition(0));
        assertEquals(0, platsCollection.GetPosition());

        assertTrue(platsCollection.SetPosition(1));
        assertEquals(1, platsCollection.GetPosition());

        assertTrue(platsCollection.SetPosition(2));
        assertEquals(2, platsCollection.GetPosition());

        assertTrue(platsCollection.SetPosition(3));
        assertEquals(3, platsCollection.GetPosition());

        assertTrue(platsCollection.SetPosition(4));
        assertEquals(4, platsCollection.GetPosition());
    }
}