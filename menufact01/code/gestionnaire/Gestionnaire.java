package gestionnaire;

import inventaire.Inventaire;
import menufact.facture.Facture;
import menufact.plats.PlatChoisi;

public class Gestionnaire {
    private Facture facture;
    private Inventaire inventaire;

    public Gestionnaire(Facture facture, Inventaire inventaire) {
        this.facture = facture;
        this.inventaire = inventaire;
    }

    public Boolean ajoutePlatAFacture(PlatChoisi platChoisi) {
//Check inventaire
        //if good return true
        //else return false

        return false;
    }
}
