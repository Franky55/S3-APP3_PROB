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
    @Description("Tester que le chef vas en attente")
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