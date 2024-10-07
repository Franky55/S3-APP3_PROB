package Chef;

import Chef.Etats.EtatsChef;
import jdk.jfr.Description;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChefTest {
    public Chef chef;

    @BeforeEach
    void setUp() {
        chef.Fire();
    }

    @Test
    @DisplayName("Fire un chef")
    @Description("test du reset d'un chef")
    void Fire() {
        Chef chef = Chef.GetInstance();
        chef.SetEtat(EtatsChef.TRAVAILLE);

        boolean result = Chef.Fire();
        assertEquals(true, result);

        chef = Chef.GetInstance();
        assertEquals(chef.GetEtat(), EtatsChef.ATTENTE);
    }

    @Test
    @DisplayName("getInstance null check")
    void getInstanceNullCheck() {
        Chef chef = Chef.GetInstance();
        assertNotNull(chef);
    }

    @Test
    @DisplayName("initial chef state")
    void getInstanceInitialChefState() {
        Chef chef = Chef.GetInstance();
        assertEquals(EtatsChef.ATTENTE, chef.GetEtat());
    }

    @Test
    @DisplayName("SetState - Travailler")
    void SetState() {
        Chef chef = Chef.GetInstance();
        // Recheck si ye en attente
        assertEquals(EtatsChef.ATTENTE, chef.GetEtat());
        chef.SetEtat(EtatsChef.TRAVAILLE);
        assertEquals(EtatsChef.TRAVAILLE, chef.GetEtat());
    }

    @Test
    @DisplayName("GetPlatAFaire - vide")
    void GetPlatAFaireInitial() {
        Chef chef = Chef.GetInstance();
        assertNull(chef.GetPlatAFaire());
    }

    @Test
    @DisplayName("PlatFini - y'avait un plan")
    @Description("Tester que le handling de terminer un plat ajouter au chef")
    void PlatFini() {
        Chef chef = Chef.GetInstance();
        boolean result = chef.PlatFini();
        assertEquals(false, result);

        PlatAuMenu platAuMenu = new PlatAuMenu(0, "Bruh", 20);
        PlatChoisi plat = new PlatChoisi(platAuMenu, 2);
        chef.Update(plat);

        result = chef.PlatFini();
        assertEquals(true, result);

        result = chef.PlatFini();
        assertEquals(false, result);
    }

    @Test
    @DisplayName("GetPlatAFaire - un plat")
    void GetPlatAFaireApresAjout() {
        Chef chef = Chef.GetInstance();
        PlatAuMenu platAuMenu = new PlatAuMenu(0, "Bruh", 20);
        PlatChoisi plat = new PlatChoisi(platAuMenu, 2);
        chef.Update(plat);

        PlatChoisi result = chef.GetPlatAFaire();

        assertEquals(EtatsChef.ATTENTE, chef.GetEtat());
        assertNotNull(result);
        assertEquals(result.getPlat().getCode(), 0);
        assertEquals(result.getPlat().getDescription(), "Bruh");
        assertEquals(result.getPlat().getPrix(), 20);
    }

    @Test
    @DisplayName("Execute - Rester en attente")
    @Description("Tester que le chef reste en attente si il est executer et que y'a rien dans sa liste")
    void ExecuteEmpty() {
        Chef chef = Chef.GetInstance();
        // Recheck si ye en attente
        boolean result = chef.Execute();
        assertEquals(true, result);
        assertEquals(EtatsChef.ATTENTE, chef.GetEtat());
    }

    @Test
    @DisplayName("Execute - Attente a travailler")
    @Description("Tester que le chef vas travailler si il est executer et que y'a des plats choisi")
    void ExecuteApresAjout() {
        Chef chef = Chef.GetInstance();
        assertEquals(EtatsChef.ATTENTE, chef.GetEtat());

        PlatAuMenu platAuMenu = new PlatAuMenu(0, "Bruh", 20);
        PlatChoisi plat = new PlatChoisi(platAuMenu, 2);
        chef.Update(plat);
        chef.Execute();

        assertEquals(EtatsChef.TRAVAILLE, chef.GetEtat());
    }

    @Test
    @DisplayName("Execute - Retour a l'attente")
    @Description("Tester que le chef vas en attente apres avoir travailler son plat.")
    void ExecuteApresApresAjout() {
        Chef chef = Chef.GetInstance();
        assertEquals(EtatsChef.ATTENTE, chef.GetEtat());

        PlatAuMenu platAuMenu = new PlatAuMenu(0, "Bruh", 20);
        PlatChoisi plat = new PlatChoisi(platAuMenu, 2);
        chef.Update(plat);
        chef.Execute();
        assertEquals(EtatsChef.TRAVAILLE, chef.GetEtat());
        chef.Execute();
        assertEquals(EtatsChef.ATTENTE, chef.GetEtat());
    }
}