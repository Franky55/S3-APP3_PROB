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
    public void Update(PlatChoisi platChoisi, int quantite){

    }

    @Override
    public String toString(){
        return "";
    }
}
