package menufact.plats;

import ingredients.IIngredients;
import ingredients.IngredientCreator;
import ingredients.TypeIngredient;

import java.util.ArrayList;

public class PlatEnfant extends PlatAuMenu{
    private double proportion;
    public PlatEnfant() {
    }

    public PlatEnfant(int code, String description, double prix, ArrayList<IIngredients> ingredientsArrayList, double proportion) {
        super(code, description, prix, ingredientsArrayList);
        this.proportion = proportion;
        this.ajusterQuantite();
    }

    @Override
    public String styledString() {
        return "PlatEnfant: \n" +
                "\t\t" + "- description: " + this.getDescription() + "\n" +
                "\t\t" + "- code:        " + this.getCode() + "\n" +
                "\t\t" + "- prix:        " + this.getPrix() + "\n" +
                "\t\t" + "- ingredient:  " + this.getIngredients().toString() + "\n" +
                "\t\t" + "- proportion:  " + this.getProportion() + "\n";
    }

    private void ajusterQuantite() {
        ArrayList<IIngredients> ingredientsTemp = new ArrayList<IIngredients>();
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
