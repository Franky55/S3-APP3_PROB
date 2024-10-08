package menufact;

import ingredients.IIngredients;
import ingredients.IngredientCreator;
import ingredients.TypeIngredient;
import menufact.facture.Facture;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatSante;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestMenuFact01 {
    public static void main(String[] args) {

        try {
            System.out.println("===menufact.plats.PlatAuMenu Constructeur 3 arguments");
            ArrayList<IIngredients> recette1 = new ArrayList<>(List.of(Objects.requireNonNull(IngredientCreator.CreateNewIngredient(TypeIngredient.LEGUME, 20, "g"))));
            recette1.add(IngredientCreator.CreateNewIngredient(TypeIngredient.EPICE, 1, "g"));
            PlatAuMenu p1 = new PlatAuMenu(0, "Frites sauce", 11.50, recette1);
            System.out.println(p1);

            System.out.println("===menufact.plats.PlatAuMenu Constructeur 3 arguments");
            ArrayList<IIngredients> recette2 = new ArrayList<>(List.of(Objects.requireNonNull(IngredientCreator.CreateNewIngredient(TypeIngredient.LEGUME, 20, "g"))));
            PlatAuMenu p2 = new PlatAuMenu(1, "Frites", 10.25, recette2);
            System.out.println(p2);

            System.out.println("===menufact.plats.PlatSante Constructeur 5 arguments");
            PlatSante ps1 = new PlatSante(2, "Salade", 5.25, recette2, 100, 10, 1);
            System.out.println(ps1);

            System.out.println("===menufact.plats.PlatSante Constructeur 5 arguments");
            PlatSante ps2 = new PlatSante(3, "Salade Cesar", 8.25, recette2, 100, 10, 1);
            System.out.println(ps2);

            System.out.println("===menufact.Menu ajout avec 4 plats");
            Menu menu = Menu.GetInstance("Menu1");
            MenuView menuView = new MenuView();
            MenuController menuController = new MenuController(menu, menuView);

            menuController.GetMenu().GetPlatsMenu().ajoute(p1);
            menuController.GetMenu().GetPlatsMenu().ajoute(p2);
            menuController.GetMenu().GetPlatsMenu().ajoute(ps1);
            menuController.GetMenu().GetPlatsMenu().ajoute(ps2);
            menuController.UpdateAffichage();
            System.out.println(menuView);

            System.out.println("===menufact.Menu position 1, plat à la position 0");
            menuController.GetMenu().GetPlatsMenu().SetPosition(0);
            menuController.UpdateAffichage();
            System.out.println(menuController.GetMenu().GetPlatsMenu().getActuel());

            System.out.println("===menufact.Menu position 1, plat à la position suivante 1");
            menuController.GetMenu().GetPlatsMenu().Suivant();
            menuController.UpdateAffichage();
            System.out.println(menuController.GetMenu().GetPlatsMenu().getActuel());

            System.out.println("== Plat choisi");
            PlatChoisi pch1 = new PlatChoisi(p1, 5);
            System.out.println(pch1);

            System.out.println("== New menufact.facture.Facture");
            Facture facture = new Facture("Ma facture");
            System.out.println(facture);

            System.out.println("== Ajout d'un plat choisie à la facture");
            facture.ajoutePlat(pch1);
            System.out.println(facture);
            System.out.println(facture.sousTotal());

            System.out.println("== Ajout d'un plat choisie à la facture");
            PlatChoisi pch2 = new PlatChoisi(p2, 10);
            facture.ajoutePlat(pch2);
            System.out.println(facture);
            System.out.println(facture.sousTotal());

            System.out.println(facture.total());
            facture.ouvrir();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.fermer();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.ouvrir();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.payer();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.ouvrir();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());
        }catch (Exception fe)
        {
            System.out.println(fe.getMessage());
        }

    }
}
