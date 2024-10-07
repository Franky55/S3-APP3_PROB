package menufact;

public class MenuController {
    private Menu menu;
    private MenuView view;

    public MenuController(Menu menu, MenuView view) {
        this.menu = menu;
        this.view = view;
    }

    public Menu GetMenu() {
        return menu;
    }

    public MenuView GetView() {
        return view;
    }

    public void UpdateAffichage() {
        view.SetView(menu.toString());
    }
}
