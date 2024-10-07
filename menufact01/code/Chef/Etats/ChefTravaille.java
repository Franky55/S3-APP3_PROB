package Chef.Etats;

import Chef.Chef;
import menufact.plats.EtatsPlat;
import menufact.plats.PlatChoisi;

public class ChefTravaille implements IEtatChef {
    private Chef chefReference;

    public ChefTravaille(Chef chef) {
        this.SetChef(chef);
    }

    @Override
    public boolean SetChef(Chef chef) {
        this.chefReference = chef;
        return true;
    }

    @Override
    public void Update(PlatChoisi platChoisi){
        Execute();
    }

    @Override
    public boolean Execute() {
        PlatChoisi platAFaire = chefReference.GetPlatAFaire();
        if(platAFaire == null){
            // Il n'y a plus rien a faire, faut aller en attente
            chefReference.SetEtat(EtatsChef.ATTENTE);
            return true;
        }
        platAFaire.setEtatsPlat(EtatsPlat.TERMINER);
        return true;
    }

    @Override
    public String toString(){
        return "";
    }
}
