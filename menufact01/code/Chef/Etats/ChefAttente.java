package Chef.Etats;

import Chef.Chef;
import menufact.plats.EtatsPlat;
import menufact.plats.PlatChoisi;

public class ChefAttente implements IEtatChef{
    private Chef chefReference;

    /**
     * Constructeur d'un chef en attente de faire dequoi.
     * @param chefReference
     */
    public ChefAttente(Chef chefReference) {
        this.SetChef(chefReference);
    }

    /**
     * Definie la reference au contexte de chef.
     * @param chef
     * @return
     */
    @Override
    public boolean SetChef(Chef chef) {
        this.chefReference = chef;
        return true;
    }

    /**
     * Methode appeller lorsque une facteur se fait ajouter un plat.
     * @param platChoisi
     */
    @Override
    public void Update(PlatChoisi platChoisi){
        platChoisi.setEtatsPlat(EtatsPlat.PREPARATION);
    }

    /**
     * Reste en attente temps que y'a pas de plats dans la liste a faire.
     * @return
     */
    @Override
    public boolean Execute() {
        PlatChoisi prochainPlat = chefReference.GetPlatAFaire();
        if (prochainPlat == null) return true;

        chefReference.SetEtat(EtatsChef.TRAVAILLE);
        return true;
    }

    @Override
    public String toString(){
        return "Chef en attente";
    }
}
