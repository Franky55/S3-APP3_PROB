package menufact.plats;

import ingredients.IIngredients;

import java.util.ArrayList;

public class PlatEnfant extends PlatAuMenu{
    private double proportion;

    public PlatEnfant() {
    }

    public PlatEnfant(int code, String description, double prix, ArrayList<IIngredients> ingredientsArrayList, double proportion) {
        super(code, description, prix, ingredientsArrayList);
        this.proportion = proportion;
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
