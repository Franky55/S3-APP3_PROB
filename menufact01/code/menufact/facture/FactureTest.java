import menufact.Client;
import menufact.facture.Facture;
import menufact.facture.FactureEtat;
import menufact.facture.exceptions.FactureException;
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
    }

    @Test
    void testFermer() {
        facture.fermer();
        assertEquals(FactureEtat.FERMEE, facture.getEtat());
    }

    @Test
    void testOuvrir() throws FactureException {
        facture.fermer();
        facture.ouvrir();  // Should throw an exception
        assertEquals(FactureEtat.OUVERTE, facture.getEtat());
    }

    @Test
    void testGenererFacture() throws FactureException {
        facture.associerClient(client);
        facture.ajoutePlat(platChoisi);
        String generatedInvoice = facture.genererFacture();

        System.out.println(generatedInvoice);

        assertTrue(generatedInvoice.contains("Facture generee."));
        assertTrue(generatedInvoice.contains("Description: Facture Test"));
        assertTrue(generatedInvoice.contains("Client: Test Client"));
        assertTrue(generatedInvoice.contains("Plat Test"));
        assertTrue(generatedInvoice.contains("40.0")); // Expected total
    }

    @Test
    void testNotifySubscribers() {
        // Add test for notifying subscribers if necessary
    }
}
