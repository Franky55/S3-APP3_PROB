package menufact;

import ingredients.IIngredients;
import ingredients.IngredientCreator;
import ingredients.TypeIngredient;
import menufact.facture.exceptions.FactureException;
import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatSante;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestMenuFact02 {

    public static void main(String[] args) {
        boolean trace = true;

        TestMenuFact02 t = new TestMenuFact02();

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


        PlatSante ps1 = new PlatSante(10,"PlatSante0",10,recette,11,11,11);
        PlatSante ps2 = new PlatSante(11,"PlatSante1",20,recette, 11,11,11);
        PlatSante ps3 = new PlatSante(12,"PlatSante2",30,recette,11,11,11);
        PlatSante ps4 = new PlatSante(13,"PlatSante3",40,recette,11,11,11);
        PlatSante ps5 = new PlatSante(14,"PlatSante4",50,recette,11,11,11);


        Menu m1 = Menu.GetInstance("menufact.Menu 1");
        Menu m2 = Menu.GetInstance("menufact.Menu 2");
        MenuView mv1 = new MenuView();
        MenuView mv2 = new MenuView();
        MenuController mc1 = new MenuController(m1, mv1);
        MenuController mc2 = new MenuController(m2, mv2);

        Facture f1 = new Facture("Ma facture");

        Client c1 = new Client(1,"Mr Client","1234567890");


        t.test1_AffichePlatsAuMenu(trace, p1,p2,p3,p4,p5);
        t. test2_AffichePlatsSante(trace, ps1,ps2,ps3,ps4,ps5);

        t.test4_AjoutPlatsAuMenu(trace, mc1, p1, p2, ps1, ps2, mc2, p3, p4, ps3, ps4, mv1, mv2);


        try {
            t.test5_DeplacementMenuAvancer(mc1);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
        }

        try {
            t.test6_DeplacementMenuReculer(mc1);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
        }

        try {
            t.test7_CreerFacture(f1, mc1);
        } catch (FactureException e) {
            System.out.println(e.getMessage());
        }


        t.test8_AjouterClientFacture(f1, c1);

        try {
            t.test8_AjouterPlatsFacture(f1, mc1,1);
        } catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }
        catch (MenuException me)
        {
            System.out.println(me);
        }

        t.test9_PayerFacture(f1);

        try {
            t.test8_AjouterPlatsFacture(f1, mc1,1);
        } catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }
        catch (MenuException me)
        {
            System.out.println(me);
        }

        try {
            f1.ouvrir();
        } catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }






        System.out.println("FIN DE TOUS LES TESTS...");

        System.out.println(f1.genererFacture());
    }

    private void test1_AffichePlatsAuMenu(boolean trace, PlatAuMenu p1, PlatAuMenu p2,
                                                 PlatAuMenu p3, PlatAuMenu p4, PlatAuMenu p5)
    {
        System.out.println("\n\n\n=== test1_AffichePlatsAuMenu");
        if(trace)
        {
            System.out.print(p1);
            System.out.print(p2);
            System.out.print(p3);
            System.out.print(p4);
            System.out.print(p5);
        }
    }


   private void test2_AffichePlatsSante(boolean trace, PlatSante ps1, PlatSante ps2,
                                               PlatSante ps3, PlatSante ps4, PlatSante ps5)
    {
        System.out.println("\n\n\n=== test2_AffichePlatsSante");

        if(trace)
        {
            System.out.print(ps1);
            System.out.print(ps2);
            System.out.print(ps3);
            System.out.print(ps4);
            System.out.print(ps5);
        }
    }


    private static void test3_AjoutMenu(boolean trace, Menu m1, Menu m2)
    {
        System.out.println("\n\n\n=== test3_AjoutMenu");

        if(trace) {
            System.out.println(m1);
            System.out.println(m2);
        }
    }


    private void test4_AjoutPlatsAuMenu(boolean trace, MenuController m1,
                                        PlatAuMenu p1, PlatAuMenu p2,
                                        PlatSante ps1, PlatSante ps2,
                                        MenuController m2,
                                        PlatAuMenu p3, PlatAuMenu p4,
                                        PlatSante ps3, PlatSante ps4, MenuView menuView1, MenuView menuView2)
    {
        System.out.println("\n\n\n=== test4_AjoutPlatsAuMenu");
        System.out.println("=== Ajout de plats au menu 1");
        m1.GetMenu().GetPlatsMenu().ajoute(p1);
        m1.GetMenu().GetPlatsMenu().ajoute(p2);
        m1.GetMenu().GetPlatsMenu().ajoute(ps1);
        m1.GetMenu().GetPlatsMenu().ajoute(ps2);


        System.out.println("\n=== Ajout de plats au menu 2");
        m2.GetMenu().GetPlatsMenu().ajoute(p3);
        m2.GetMenu().GetPlatsMenu().ajoute(p4);
        m2.GetMenu().GetPlatsMenu().ajoute(ps3);
        m2.GetMenu().GetPlatsMenu().ajoute(ps4);

        if(trace) {
            m1.UpdateAffichage();
            m2.UpdateAffichage();

            System.out.println(menuView1);
            System.out.println(menuView2);
        }
    }


    private void test5_DeplacementMenuAvancer(MenuController m1) throws MenuException
    {
        System.out.println("\n\n\n=== test5_DeplacementMenuAvancer");

        System.out.println("===Selectionner un plat du menu 0");
        m1.GetMenu().GetPlatsMenu().SetPosition(0);

        System.out.println("\n=== Afficher le plat courant");
        System.out.println(m1.GetMenu().GetPlatsMenu().getActuel());
        try {
            System.out.println("\n=== Avancer le plat courant");
            System.out.println("1.");
            System.out.print(m1.GetMenu().GetPlatsMenu().getActuel().toString());
            m1.GetMenu().GetPlatsMenu().Suivant();
            System.out.println("2.");
            System.out.print(m1.GetMenu().GetPlatsMenu().getActuel().toString());
            m1.GetMenu().GetPlatsMenu().Suivant();
            System.out.println("3.");
            System.out.print(m1.GetMenu().GetPlatsMenu().getActuel().toString());
            m1.GetMenu().GetPlatsMenu().Suivant();
            System.out.println("4.");
            System.out.print(m1.GetMenu().GetPlatsMenu().getActuel().toString());
            m1.GetMenu().GetPlatsMenu().Suivant();
            System.out.println("5.");
            System.out.print(m1.GetMenu().GetPlatsMenu().getActuel().toString());
            m1.GetMenu().GetPlatsMenu().Suivant();
        }
        catch (MenuException me)
        {
                throw me;
        }
    }


    private void test6_DeplacementMenuReculer(MenuController m1) throws MenuException
    {
        System.out.println("\n\n\n===test6_DeplacementMenuReculer");

        System.out.println("===Selectionner un plat du menu 3");
        m1.GetMenu().GetPlatsMenu().SetPosition(3);

        System.out.println("\n=== Afficher le plat courant");
        System.out.println(m1.GetMenu().GetPlatsMenu().getActuel());
        try {
            System.out.println("\n=== Reculer le plat courant");
            System.out.println("2.");
            m1.GetMenu().GetPlatsMenu().Precedent();
            System.out.println("1.");
            m1.GetMenu().GetPlatsMenu().Precedent();
            System.out.println("0.");
            m1.GetMenu().GetPlatsMenu().Precedent();
            System.out.println("-1.");
            m1.GetMenu().GetPlatsMenu().Precedent();
            System.out.println("-2.");
            m1.GetMenu().GetPlatsMenu().Precedent();
        }
        catch (MenuException me)
        {
            throw me;
        }
    }

    private void test7_CreerFacture(Facture f1, MenuController m1) throws FactureException
    {
        System.out.println("\n\n\n===test7_CreerFacture");

        PlatChoisi platChoisi = new PlatChoisi(m1.GetMenu().GetPlatsMenu().getActuel(),5);
        try
        {
            f1.ajoutePlat(platChoisi);
        }
        catch (FactureException fe)
        {
            throw fe;
        }
        System.out.println(f1);
    }


    private void test8_AjouterClientFacture(Facture f1,Client c1) {
        System.out.println("\n\n\n===test8_AjouterClientFacture");
        f1.associerClient(c1);
        System.out.println(f1);
    }
    private void test8_AjouterPlatsFacture(Facture f1, MenuController m1, int pos) throws MenuException,FactureException
    {
        System.out.println("\n\n\n===test8_AjouterPlatsFacture");

        try{
            for (int i=0; i< pos; i++)
                m1.GetMenu().GetPlatsMenu().Precedent();
        }
        catch (MenuException me)
        {
            throw me;
        }

        PlatChoisi platChoisi = new PlatChoisi(m1.GetMenu().GetPlatsMenu().getActuel(),5);
        try
        {
            f1.ajoutePlat(platChoisi);
        }
        catch (FactureException fe)
        {
            throw fe;
        }
        System.out.println(f1);
    }

    private void test9_PayerFacture(Facture f1)
    {
        System.out.println("\n\n\n===test9_PayerFacture");

        System.out.println("Avant payer la facture");
        System.out.println(f1);
        f1.payer();
        System.out.println("\nApres avoir paye la facture");
        System.out.println(f1);
    }
}
