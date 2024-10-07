package menufact;

import menufact.exceptions.MenuViewException;

public class MenuView {
    private String contenue = "";

    public MenuView() {
        contenue = "Initialisee";
    }

    public void SetView(String contenue) {
        if (contenue == null)
            throw new MenuViewException("Message ne peut pas etre null");
        this.contenue = contenue;
    }

    public void affiche() {
        System.out.println(contenue);
    }

    @Override
    public String toString() {
        return contenue;
    }
}
