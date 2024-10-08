package menufact;

import menufact.plats.collection.IIteratorPlatsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
