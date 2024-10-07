package menufact;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import menufact.plats.collection.IIteratorPlatsMenu;
import menufact.plats.collection.PlatsCollection;

public class Menu {
    private String description;
    private IIteratorPlatsMenu platsMenu;
    private static Menu menu;

    /**
     * Constructeur de menu
     * @param description la description du menu
     */
    private Menu(String description) {
        this.description = description;
        this.platsMenu = new PlatsCollection();
    }

    /**
     * Retourne le menu cree, puisque c'est un singleton.
     * @param description
     * @return
     */
    public static Menu GetInstance(String description) {
        if(menu == null) {
            menu = new Menu(description);
        }
        return menu;
    }

    /**
     * Retourne la liste de plats dans le menu
     * @return
     */
    public IIteratorPlatsMenu GetPlatsMenu() {
        return platsMenu;
    }

    //void ajoute (PlatAuMenu p) {
    //    GetPlatsMenu().ajoute(p);
    //}

    //public void position(int i) {
    //    GetPlatsMenu().SetPosition(i);
    //}

    //public PlatAuMenu platCourant()
    //{
    //    //return GetPlatsMenu().getActuel();
    //}

    //public void positionSuivante() throws MenuException
    //{
    //   if (GetPlatsMenu().Suivant() == false)
    //        throw new MenuException("On depasse le nombre maximale de plats.");
    //}

    //public void positionPrecedente() throws MenuException
    //{
    //    if (GetPlatsMenu().Precedent() == false)
    //        throw new MenuException("On depasse le nombre minimale de plats");
    //}

    @Override
    public String toString() {
        return "menufact.Menu{" +
                "description='" + description + '\'' +
                ", courant=" + GetPlatsMenu().GetPosition() +
                ", plat=" + "\n" + GetPlatsMenu().getActuel() +
                '}';
    }
}
