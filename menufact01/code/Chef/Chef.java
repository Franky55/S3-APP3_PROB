package Chef;

import Chef.Etats.ChefAttente;
import Chef.Etats.ChefTravaille;
import Chef.Etats.EtatsChef;
import Chef.Etats.IEtatChef;
import menufact.facture.IFactureSubscriber;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

public class Chef implements IFactureSubscriber {
    private ArrayList<PlatChoisi> plats = new ArrayList<>();
    private IEtatChef vraiChef;
    private static Chef chefSingleton;
    private EtatsChef etatsChef;

    private Chef() {
    }

    public static Chef GetInstance() {
        if(chefSingleton == null){
            chefSingleton = new Chef();
        }
        return chefSingleton;
    }

    public void Update(PlatChoisi platChoisi, int nombreFois) {
        vraiChef.Update(platChoisi, nombreFois);
    }

    public EtatsChef GetEtat() {
        return etatsChef;
    }

    public boolean SetEtat(EtatsChef nouveauxEtat) {
        etatsChef = nouveauxEtat;
        switch (etatsChef) {
            case ATTENTE:
                vraiChef = new ChefAttente(this);
                break;
            case TRAVAILLE:
                vraiChef = new ChefTravaille(this);
                break;
            default:
                return false;
        }
        return true;
    }

    public PlatChoisi GetPlatAFaire() {
        return plats.get(0);
    }
}
