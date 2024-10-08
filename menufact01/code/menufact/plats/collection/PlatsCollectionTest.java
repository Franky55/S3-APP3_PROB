package menufact.plats.collection;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatsCollectionTest {

    @Test
    void ajoute() {
        PlatsCollection platsCollection = new PlatsCollection();
        PlatAuMenu p1 = new PlatAuMenu(0,"PlatAuMenu0",10);
        PlatAuMenu p2 = new PlatAuMenu(1,"PlatAuMenu1",20);
        PlatAuMenu p3 = new PlatAuMenu(2,"PlatAuMenu2",30);
        PlatAuMenu p4 = new PlatAuMenu(3,"PlatAuMenu3",40);
        PlatAuMenu p5 = new PlatAuMenu(4,"PlatAuMenu4",50);

        assertNull(platsCollection.getActuel());

        platsCollection.ajoute(p1);
        platsCollection.ajoute(p2);
        platsCollection.ajoute(p3);
        platsCollection.ajoute(p4);
        platsCollection.ajoute(p5);

        PlatAuMenu first = platsCollection.getActuel();
        assertEquals(p1, first);
    }

    @Test
    void getActuel() {
    }

    @Test
    void suivant() {
    }

    @Test
    void precedent() {
    }

    @Test
    void setPosition() {
    }

    @Test
    void getPosition() {
    }
}