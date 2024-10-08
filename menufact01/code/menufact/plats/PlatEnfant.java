package menufact.plats;

import ingredients.IIngredients;
import ingredients.IngredientCreator;
import ingredients.TypeIngredient;

import java.util.ArrayList;

public class PlatEnfant extends PlatAuMenu{
    private double proportion;
    private ArrayList<IIngredients> ingredientsTemp;
    public PlatEnfant() {
    }

    public PlatEnfant(int code, String description, double prix, ArrayList<IIngredients> ingredientsArrayList, double proportion) {
        super(code, description, prix, ingredientsArrayList);
        this.proportion = proportion;
        this.ajusterQuantite();
    }

    private void ajusterQuantite() {
        ingredientsTemp = new ArrayList<IIngredients>();
        for (IIngredients ingredient : getIngredients()) {
            ingredientsTemp.add(IngredientCreator.CreateNewIngredient(ingredient.getTypeIngredient(), (int)(ingredient.GetQuantiteRestant() * proportion), ingredient.getUniter()));
            //ingredient.SetQuantiteRestant((int)(ingredient.GetQuantiteRestant() * proportion));
        }
        setIngredients(ingredientsTemp);
    }

    public double getProportion() {
        return proportion;
    }

    @Override
    public String toString() {
        return "PlatEnfant{" +
                "proportion=" + proportion +
                "} " + super.toString();
    }
}
