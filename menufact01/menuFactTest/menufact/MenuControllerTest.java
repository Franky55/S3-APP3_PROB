package menufact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuControllerTest {

    private Menu menu;
    private MenuView view;
    private MenuController menuController;

    @BeforeEach
    void setUp() {
        menu = Menu.GetInstance("Menu de Test");
        view = new MenuView();
        menuController = new MenuController(menu, view);
    }

    @Test
    void testGetMenu() {
        assertSame(menu, menuController.GetMenu());
    }

    @Test
    void testGetView() {
        assertSame(view, menuController.GetView());
    }
}
