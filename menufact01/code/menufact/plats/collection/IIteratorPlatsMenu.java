package menufact.plats.collection;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;

public interface IIteratorPlatsMenu {
    public void ajoute(PlatAuMenu plat);
    public PlatAuMenu getActuel();
    public boolean SetPosition(int position);
    public int GetPosition();
    public boolean Suivant() throws MenuException;
    public boolean Precedent() throws MenuException;
    public int GetSize();
}
