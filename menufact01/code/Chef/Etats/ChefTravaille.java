package Chef.Etats;

import Chef.Chef;
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
    public void Update(PlatChoisi platChoisi, int quantite){

    }

    @Override
    public String toString(){
        return "";
    }

    public void AjouterIngredient(PlatChoisi platChoisi){

    }
}
