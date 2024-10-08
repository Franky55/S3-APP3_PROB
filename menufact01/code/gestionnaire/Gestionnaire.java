package gestionnaire;

import ingredients.IIngredients;
import inventaire.Inventaire;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.EtatsPlat;
import menufact.plats.PlatChoisi;

public class Gestionnaire {
    private Facture facture;
    private Inventaire inventaire;

    public Gestionnaire(Facture facture, Inventaire inventaire) {
        this.facture = facture;
        this.inventaire = inventaire;
    }

    public Boolean ajoutePlatAFacture(PlatChoisi platChoisi) {

        //Verification tous les ingredients
        for (IIngredients i : platChoisi.getIngredients()){
            if(inventaire.getIngredient(i).GetQuantiteRestant() < i.GetQuantiteRestant()) {
                System.out.println("Inventaire insufisant");
                platChoisi.setEtatsPlat(EtatsPlat.IMPOSSIBLE);
                return false;
            }
        }

        try
        {
            facture.ajoutePlat(platChoisi);
            platChoisi.setEtatsPlat(EtatsPlat.COMMANDER);
            retraitIngredient(platChoisi);
        } catch (FactureException e) {
            platChoisi.setEtatsPlat(EtatsPlat.IMPOSSIBLE);
            return false;
        }

        return true;
    }

    private void retraitIngredient(PlatChoisi platChoisi) {
        for (IIngredients i : platChoisi.getIngredients()){
                inventaire.removeIngredient(i);
        }
    }
}
