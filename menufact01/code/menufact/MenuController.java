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

        String header = "Menu:\n" +
                " -- description:  '" + menu.getDescription() + "\'\n" +
                " -- index courant: " + menu.GetPlatsMenu().GetPosition() + "\n" +
                " ------------------------------ \n";

        String plats = "";

        for (int index = 0; index < menu.GetPlatsMenu().GetSize(); index++) {
            menu.GetPlatsMenu().SetPosition(index);
            String result = " -- " + index + ":\t";
            result += menu.GetPlatsMenu().getActuel().styledString();
            plats += result;
        }

        view.SetView(header + plats);
    }
}
