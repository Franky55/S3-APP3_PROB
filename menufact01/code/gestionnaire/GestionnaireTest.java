package gestionnaire;

import ingredients.IIngredients;
import ingredients.IngredientCreator;
import ingredients.TypeIngredient;
import inventaire.Inventaire;
import menufact.facture.Facture;
import menufact.plats.EtatsPlat;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
class GestionnaireTest {

    @Test
    void ajoutePlatAFacture() {
        Facture facture = new Facture("bruh bruh bruh");

        Inventaire inventaire = Inventaire.getInstance();
        inventaire.addIngredient(IngredientCreator.CreateNewIngredient(TypeIngredient.FRUIT, 2, "g"));
        inventaire.addIngredient(IngredientCreator.CreateNewIngredient(TypeIngredient.EPICE, 2, "g"));
        inventaire.addIngredient(IngredientCreator.CreateNewIngredient(TypeIngredient.LAITIER, 2, "ml"));
        inventaire.addIngredient(IngredientCreator.CreateNewIngredient(TypeIngredient.LEGUME, 2, "g"));
        inventaire.addIngredient(IngredientCreator.CreateNewIngredient(TypeIngredient.VIANDE, 2, "g"));

        ArrayList<IIngredients> recette = new ArrayList<>(List.of(Objects.requireNonNull(IngredientCreator.CreateNewIngredient(TypeIngredient.FRUIT, 1, "g"))));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.VIANDE, 1, "g"));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LAITIER, 1, "ml"));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LEGUME, 1, "g"));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.EPICE, 1, "g"));

        PlatAuMenu shrooms = new PlatAuMenu(0,"Recette vraiment élaboré",100, recette);
        PlatChoisi iWantShrooms = new PlatChoisi(shrooms, 1);

        Gestionnaire gestionnaire = new Gestionnaire(facture, inventaire);

        assertTrue(gestionnaire.ajoutePlatAFacture(iWantShrooms));
        assertTrue(gestionnaire.ajoutePlatAFacture(iWantShrooms));
        assertFalse(gestionnaire.ajoutePlatAFacture(iWantShrooms));

        assertEquals(0, inventaire.getIngredient(TypeIngredient.VIANDE).GetQuantiteRestant());
        assertEquals(0, inventaire.getIngredient(TypeIngredient.EPICE).GetQuantiteRestant());
        assertEquals(0, inventaire.getIngredient(TypeIngredient.LAITIER).GetQuantiteRestant());
        assertEquals(0, inventaire.getIngredient(TypeIngredient.FRUIT).GetQuantiteRestant());
        assertEquals(0, inventaire.getIngredient(TypeIngredient.LEGUME).GetQuantiteRestant());

        assertEquals(EtatsPlat.IMPOSSIBLE, iWantShrooms.getEtatsPlat());
    }

    @Test
    void ajoutePlatAFactureMultiple() {
        Facture facture = new Facture("bruh bruh bruh");

        Inventaire inventaire = Inventaire.getInstance();
        inventaire.addIngredient(IngredientCreator.CreateNewIngredient(TypeIngredient.FRUIT, 2, "g"));
        inventaire.addIngredient(IngredientCreator.CreateNewIngredient(TypeIngredient.EPICE, 2, "g"));
        inventaire.addIngredient(IngredientCreator.CreateNewIngredient(TypeIngredient.LAITIER, 2, "ml"));
        inventaire.addIngredient(IngredientCreator.CreateNewIngredient(TypeIngredient.LEGUME, 2, "g"));
        inventaire.addIngredient(IngredientCreator.CreateNewIngredient(TypeIngredient.VIANDE, 2, "g"));

        ArrayList<IIngredients> recette = new ArrayList<>(List.of(Objects.requireNonNull(IngredientCreator.CreateNewIngredient(TypeIngredient.FRUIT, 2, "g"))));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.VIANDE, 2, "g"));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LAITIER, 2, "ml"));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LEGUME, 2, "g"));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.EPICE, 2, "g"));

        PlatAuMenu shrooms = new PlatAuMenu(0,"Recette vraiment élaboré",100, recette);
        PlatChoisi iWantShrooms = new PlatChoisi(shrooms, 2);

        Gestionnaire gestionnaire = new Gestionnaire(facture, inventaire);

        assertTrue(gestionnaire.ajoutePlatAFacture(iWantShrooms));
        assertFalse(gestionnaire.ajoutePlatAFacture(iWantShrooms));

        assertEquals(0, inventaire.getIngredient(TypeIngredient.VIANDE).GetQuantiteRestant());
        assertEquals(0, inventaire.getIngredient(TypeIngredient.EPICE).GetQuantiteRestant());
        assertEquals(0, inventaire.getIngredient(TypeIngredient.LAITIER).GetQuantiteRestant());
        assertEquals(0, inventaire.getIngredient(TypeIngredient.FRUIT).GetQuantiteRestant());
        assertEquals(0, inventaire.getIngredient(TypeIngredient.LEGUME).GetQuantiteRestant());

        assertEquals(EtatsPlat.IMPOSSIBLE, iWantShrooms.getEtatsPlat());
    }

    @Test
    void ajoutePlatChoisiUnPeuWeird() {
        Facture facture = new Facture("bruh bruh bruh");

        Inventaire inventaire = Inventaire.getInstance();
        inventaire.addIngredient(IngredientCreator.CreateNewIngredient(TypeIngredient.FRUIT, 1, "g"));
        inventaire.addIngredient(IngredientCreator.CreateNewIngredient(TypeIngredient.EPICE, 2, "g"));
        inventaire.addIngredient(IngredientCreator.CreateNewIngredient(TypeIngredient.LAITIER, 3, "ml"));
        inventaire.addIngredient(IngredientCreator.CreateNewIngredient(TypeIngredient.LEGUME, 4, "g"));
        inventaire.addIngredient(IngredientCreator.CreateNewIngredient(TypeIngredient.VIANDE, 5, "g"));

        ArrayList<IIngredients> recette = new ArrayList<>(List.of(Objects.requireNonNull(IngredientCreator.CreateNewIngredient(TypeIngredient.FRUIT, 1, "g"))));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.VIANDE, 1, "g"));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LAITIER, 1, "ml"));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.LEGUME, 1, "g"));
        recette.add(IngredientCreator.CreateNewIngredient(TypeIngredient.EPICE, 1, "g"));

        PlatAuMenu shrooms = new PlatAuMenu(0,"Recette vraiment élaboré",100, recette);
        PlatChoisi iWantShrooms = new PlatChoisi(shrooms, 1);

        Gestionnaire gestionnaire = new Gestionnaire(facture, inventaire);

        assertTrue(gestionnaire.ajoutePlatAFacture(iWantShrooms));
        assertTrue(gestionnaire.ajoutePlatAFacture(iWantShrooms));
        assertFalse(gestionnaire.ajoutePlatAFacture(iWantShrooms));

        assertEquals(4, inventaire.getIngredient(TypeIngredient.VIANDE).GetQuantiteRestant());
        assertEquals(1, inventaire.getIngredient(TypeIngredient.EPICE).GetQuantiteRestant());
        assertEquals(2, inventaire.getIngredient(TypeIngredient.LAITIER).GetQuantiteRestant());
        assertEquals(0, inventaire.getIngredient(TypeIngredient.FRUIT).GetQuantiteRestant());
        assertEquals(3, inventaire.getIngredient(TypeIngredient.LEGUME).GetQuantiteRestant());

        assertEquals(EtatsPlat.IMPOSSIBLE, iWantShrooms.getEtatsPlat());
    }
}