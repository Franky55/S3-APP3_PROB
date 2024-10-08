package menufact.plats.collection;

import ingredients.IIngredients;
import ingredients.IngredientCreator;
import ingredients.TypeIngredient;
import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PlatsCollectionTest {

    @Test
    void ajoute() {
        PlatsCollection platsCollection = new PlatsCollection();
        ArrayList<IIngredients> recette = new ArrayList<>(List.of(Objects.requireNonNull(IngredientCreator.CreateNewIngredient(TypeIngredient.FRUIT, 20, "g"))));

        PlatAuMenu p1 = new PlatAuMenu(0,"PlatAuMenu0",10, recette);
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.VIANDE, 200, "g"));
        PlatAuMenu p2 = new PlatAuMenu(1,"PlatAuMenu1",20,recette);
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LAITIER, 200, "ml"));
        PlatAuMenu p3 = new PlatAuMenu(2,"PlatAuMenu2",30,recette);
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LEGUME, 100, "g"));
        PlatAuMenu p4 = new PlatAuMenu(3,"PlatAuMenu3",40, recette);
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.EPICE, 1, "g"));
        PlatAuMenu p5 = new PlatAuMenu(4,"PlatAuMenu4",50, recette);

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