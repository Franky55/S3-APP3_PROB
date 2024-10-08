package menufact;

import ingredients.IIngredients;
import ingredients.IngredientCreator;
import ingredients.TypeIngredient;
import inventaire.Inventaire;
import menufact.Menu;
import menufact.plats.PlatAuMenu;
import menufact.plats.collection.IIteratorPlatsMenu;
import menufact.plats.collection.PlatsCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = Menu.GetInstance("Menu de Test");
    }

    @Test
    void testGetInstance() {
        Menu anotherMenu = Menu.GetInstance("Autre Menu");
        assertSame(menu, anotherMenu, "GetInstance should return the same instance");
    }

    @Test
    void testGetDescription() {
        assertEquals("Menu de Test", menu.getDescription());
    }

    @Test
    void testGetPlatsMenu() {
        IIteratorPlatsMenu platsMenu = menu.GetPlatsMenu();
        assertNotNull(platsMenu, "Plats menu should not be null");
    }

    @Test
    void testToString() {
        String expected = "menufact.Menu{" +
                "description='Menu de Test'" +
                ", courant=" + menu.GetPlatsMenu().GetPosition() +
                ", plat=" + "\n" + menu.GetPlatsMenu().getActuel() +
                '}';
        assertEquals(expected, menu.toString());
    }
}
