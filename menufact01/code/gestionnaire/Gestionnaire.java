package gestionnaire;

import ingredients.IIngredients;
import inventaire.Inventaire;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

public class Gestionnaire {
    private Facture facture;
    private Inventaire inventaire;

    public Gestionnaire(Facture facture, Inventaire inventaire) {
        this.facture = facture;
        this.inventaire = inventaire;
    }

    public Boolean ajoutePlatAFacture(PlatChoisi platChoisi) {

        //Verification tout les ingredients
        for (IIngredients i : platChoisi.getIngredients()){
            if(inventaire.getIngredients(i).GetQuantiteRestant() < i.GetQuantiteRestant())
                return false;
        }
        
        try
        {
            facture.ajoutePlat(platChoisi);
            retraitIngredient(platChoisi);
        } catch (FactureException e) {
            return false;
        }

        return true;
    }

    private void retraitIngredient(PlatChoisi platChoisi) {
        for (IIngredients i : platChoisi.getIngredients()){
            if(inventaire.getIngredients(i).GetQuantiteRestant() < i.GetQuantiteRestant())
                inventaire.removeIngredient(i);
        }
    }
}
