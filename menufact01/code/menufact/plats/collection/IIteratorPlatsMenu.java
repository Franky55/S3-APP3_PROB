package menufact.plats.collection;

import menufact.plats.PlatAuMenu;

public interface IIteratorPlatsMenu {
    public void ajoute(PlatAuMenu plat);
    public PlatAuMenu getActuel();
    public boolean SetPosition(int position);
    public int GetPosition();
    public boolean Suivant();
    public boolean Precedent();
}
