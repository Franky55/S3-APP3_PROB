package menufact;

import menufact.MenuView;
import menufact.exceptions.MenuViewException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuViewTest {

    private MenuView menuView;

    @BeforeEach
    void setUp() {
        menuView = new MenuView();
    }

    @Test
    void testConstructor() {
        assertEquals("Initialisee", menuView.toString());
    }

    @Test
    void testSetView() {
        menuView.SetView("Nouveau Contenu");
        assertEquals("Nouveau Contenu", menuView.toString());
    }

    @Test
    void testSetView_NullValue() {
        MenuViewException exception = assertThrows(MenuViewException.class, () -> {
            menuView.SetView(null);
        });
        assertEquals("Message ne peut pas etre null", exception.getMessage());
    }

    @Test
    void testToString() {
        assertEquals("Initialisee", menuView.toString());

        menuView.SetView("Contenu Actuel");
        assertEquals("Contenu Actuel", menuView.toString());
    }
}
