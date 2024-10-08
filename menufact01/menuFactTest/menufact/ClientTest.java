package menufact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private Client client;

    @BeforeEach
    void setUp() {
        client = new Client(1, "Test Client", "1234-5678-9101-1121");
    }

    @Test
    void testGetIdClient() {
        assertEquals(1, client.getIdClient());
    }

    @Test
    void testGetNom() {
        assertEquals("Test Client", client.getNom());
    }

    @Test
    void testGetNumeroCarteCredit() {
        assertEquals("1234-5678-9101-1121", client.getNumeroCarteCredit());
    }

    @Test
    void testSetIdClient() {
        client.setIdClient(2);
        assertEquals(2, client.getIdClient());
    }

    @Test
    void testSetNom() {
        client.setNom("New Client");
        assertEquals("New Client", client.getNom());
    }

    @Test
    void testSetNumeroCarteCredit() {
        client.setNumeroCarteCredit("9876-5432-1098-7654");
        assertEquals("9876-5432-1098-7654", client.getNumeroCarteCredit());
    }

    @Test
    void testToString() {
        String expected = "menufact.Client{idClient=1, nom='Test Client', numeroCarteCredit='1234-5678-9101-1121'}";
        assertEquals(expected, client.toString());
    }
}
