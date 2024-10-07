package menufact;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import menufact.plats.collection.IIteratorPlatsMenu;
import menufact.plats.collection.PlatsCollection;

import java.util.ArrayList;

public class Menu {
    private String description;
    private IIteratorPlatsMenu platsMenu;
    //private int courant;
    //private ArrayList<PlatAuMenu> plat = new ArrayList<PlatAuMenu>();
    private static Menu menu;

    private Menu(String description) {
        this.description = description;
        this.platsMenu = new PlatsCollection();
    }

    public static Menu GetInstance(String description) {
        if(menu == null) {
            menu = new Menu(description);
        }
        return menu;
    }

    public IIteratorPlatsMenu GetPlatsMenu() {
        return platsMenu;
    }

    void ajoute (PlatAuMenu p) {
        GetPlatsMenu().ajoute(p);
    }

    public void position(int i) {
        courant = i;
    }

    public PlatAuMenu platCourant()
    {
        return plat.get(courant);
    }

    public void positionSuivante() throws MenuException
    {
        if (courant+1 >= plat.size())
            throw new MenuException("On depasse le nombre maximale de plats.");
        else
            courant++;
    }

    public void positionPrecedente() throws MenuException
    {
        if (courant-1 < 0)
            throw new MenuException("On depasse le nombre minimale de plats");
        else
            courant--;
    }


    @Override
    public String toString() {
        return "menufact.Menu{" +
                "description='" + description + '\'' +
                ", courant=" + courant +
                ", plat=" + "\n" + plat +
                '}';
    }
}
