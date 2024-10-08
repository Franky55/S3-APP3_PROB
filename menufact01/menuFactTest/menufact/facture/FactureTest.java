package menufact.facture;

import Chef.Chef;
import Chef.Etats.EtatsChef;
import menufact.Client;
import menufact.facture.exceptions.FactureException;
import menufact.plats.EtatsPlat;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FactureTest {

    private Facture facture;
    private Client client;
    private PlatChoisi platChoisi;

    @BeforeEach
    void setUp() {
        client = new Client(10, "bruh", "get wifi everywhere you go");
        facture = new Facture("Facture Test");
        facture.associerClient(client);
        platChoisi = new PlatChoisi(new PlatAuMenu(1, "Plat Test", 20.0, new ArrayList<>()), 2);
    }

    @Test
    void testSousTotal() {
        try {
            facture.ajoutePlat(platChoisi);
        } catch (FactureException e) {
            assertFalse(true);
        }
        assertEquals(40.0, facture.sousTotal());
    }

    @Test
    void testTotal() {
        try {
            facture.ajoutePlat(platChoisi);
        } catch (FactureException e) {
            assertFalse(true);
        }
        System.out.println(facture.sousTotal());
        System.out.println(facture.total());
        System.out.println(facture.tps());
        System.out.println(facture.tvq());
        assertEquals(40.0 + facture.tps() + facture.tvq(), facture.total());
    }

    @Test
    void testPayer() {
        facture.payer();
        assertEquals(FactureEtat.PAYEE, facture.getEtat());
        try {
            facture.ouvrir();
            assertTrue(true);
        } catch (FactureException e) {
            assertFalse(false);
        }
        assertEquals(FactureEtat.PAYEE, facture.getEtat());
    }

    @Test
    void testFermer() {
        facture.fermer();
        assertEquals(FactureEtat.FERMEE, facture.getEtat());
    }

    @Test
    void testOuvrir() throws FactureException {
        facture.fermer();
        assertEquals(FactureEtat.FERMEE, facture.getEtat());
        facture.ouvrir();
        assertEquals(FactureEtat.OUVERTE, facture.getEtat());
    }

    @Test
    void testGenererFacture() throws FactureException {
        facture.associerClient(client);
        facture.ajoutePlat(platChoisi);
        PlatChoisi bruh = new PlatChoisi(new PlatAuMenu(2, "Plat chevre", 30.0, new ArrayList<>()), 1);

        facture.ajoutePlat(bruh);
        String generatedInvoice = facture.genererFacture();

        assertTrue(generatedInvoice.contains("Facture generee."));
        assertTrue(generatedInvoice.contains("Description: Facture Test"));
        assertTrue(generatedInvoice.contains("Client:bruh"));
        assertTrue(generatedInvoice.contains("Plat Test"));
        assertTrue(generatedInvoice.contains("80.4825")); // Expected total
    }

    @Test
    void testNotifySubscribers() {
        Chef chef = Chef.GetInstance();
        chef.SetEtat(EtatsChef.TRAVAILLE);
        assertEquals(EtatsChef.TRAVAILLE, chef.GetEtat());
        chef.SetEtat(EtatsChef.ATTENTE);
        assertEquals(EtatsChef.ATTENTE, chef.GetEtat());

        facture.attach(chef);
        facture.notify(platChoisi);

        // Le plat est en preparation une fois ajouter.
        assertEquals(EtatsPlat.PREPARATION, platChoisi.getEtatsPlat());
        // Le chef reste en attente temps que y'e pas executer.
        assertEquals(EtatsChef.ATTENTE, chef.GetEtat());


        chef.Execute();
        // Le chef se met en travail.
        assertEquals(EtatsChef.TRAVAILLE, chef.GetEtat());
        // Le plat est pas encore fait.
        assertEquals(EtatsPlat.PREPARATION, platChoisi.getEtatsPlat());

        chef.Execute();
        // Il a terminer le plat.
        assertEquals(EtatsPlat.TERMINER, platChoisi.getEtatsPlat());
        // Il est de retour en attente
        assertEquals(EtatsChef.ATTENTE, chef.GetEtat());
    }
}
