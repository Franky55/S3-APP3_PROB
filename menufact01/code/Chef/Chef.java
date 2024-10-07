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

    /**
     * Constructeur singleton.
     */
    private Chef() {
        this.SetEtat(EtatsChef.ATTENTE);
    }

    /**
     * Reset le chef completement.
     * Ca enleve ses plats a faire... ses etats... tout.
     * Replace le chef par un nouveau.
     * @return
     */
    public static boolean Fire() {
        if(chefSingleton == null) {return false;}
        chefSingleton = new Chef();
        return true;
    }

    /**
     * Retourne le chef de la cuisine.
     * @return
     */
    public static Chef GetInstance() {
        if(chefSingleton == null){
            chefSingleton = new Chef();
        }
        return chefSingleton;
    }

    /**
     * Methode appeller lorsque la facture change et que des plats
     * son ajoutee, que le chef doit faire.
     * @param platChoisi
     */
    @Override
    public void Update(PlatChoisi platChoisi) {

        // Ajouter le plat a sa liste de plats a faire
        plats.add(platChoisi);

        vraiChef.Update(platChoisi);
    }

    /**
     * Retourne l'etat du chef.
     * @return
     */
    public EtatsChef GetEtat() {
        return vraiChef.GetEtatsChef();
    }

    /**
     * Change l'etat du chef.
     * Pour qu'il commence a travailler ou qu'il aille en attente.
     * @param nouveauxEtat
     * @return
     */
    public boolean SetEtat(EtatsChef nouveauxEtat) {
        etatsChef = nouveauxEtat;
        switch (etatsChef) {
            case ATTENTE:
                vraiChef = new ChefAttente(this);
                etatsChef = EtatsChef.ATTENTE;
                break;
            case TRAVAILLE:
                vraiChef = new ChefTravaille(this);
                etatsChef = EtatsChef.TRAVAILLE;
                break;
            default:
                return false;
        }
        return true;
    }

    /**
     * Retourne le prochain plat a faire.
     * null si y'a rien a faire.
     * @return
     */
    public PlatChoisi GetPlatAFaire() {
        if (plats.size()==0) return null;
        return plats.get(0);
    }

    public boolean PlatFini() {
        if (plats.size()==0) return false;
        plats.remove(0);
        return true;
    }

    /**
     * Execute ce que le chef doit faire
     * @return true: aucun probleme.
     */
    public boolean Execute() {
        return vraiChef.Execute();
    }

    public String toString() {
        return vraiChef.toString();
    }
}
