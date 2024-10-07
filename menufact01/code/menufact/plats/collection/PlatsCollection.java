package menufact.plats.collection;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;

import java.util.ArrayList;

public class PlatsCollection implements IIteratorPlatsMenu{
    private ArrayList<PlatAuMenu> plats = new ArrayList<PlatAuMenu>();
    private int position = 0;

    public PlatsCollection() {
    }

    @Override
    public void ajoute(PlatAuMenu plat) {
        plats.add(plat);
    }

    @Override
    public PlatAuMenu getActuel() {
        return plats.get(0);
    }

    @Override
    public boolean Suivant() throws MenuException {
        if(position >= plats.size()-1) {
            throw new MenuException("On depasse le nombre maximale de plats.");
        }
        position++;
        return true;
    }

    @Override
    public boolean Precedent() throws MenuException {
        if(position <= 0) {
            throw new MenuException("On depasse le nombre minimale de plats");
        };
        position--;
        return true;
    }

    @Override
    public boolean SetPosition(int position) {
        if(position >= plats.size()-1) {
            return false;
        }
        if(position < 0) {
            return false;
        }
        this.position = position;
        return true;
    }

    @Override
    public int GetPosition() {
        return position;
    }
}
