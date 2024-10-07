package Chef.Etats;

import Chef.Chef;
import menufact.plats.PlatChoisi;

public class ChefAttente implements IEtatChef{
    private Chef chefReference;

    public ChefAttente(Chef chefReference) {
        this.SetChef(chefReference);
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
        PlatChoisi prochainPlat = chefReference.GetPlatAFaire();
        if (prochainPlat == null) return true;

        chefReference.SetEtat(EtatsChef.TRAVAILLE);
        return true;
    }

    @Override
    public String toString(){
        return "";
    }
}
