package menufact.plats;

import ingredients.IIngredients;

import java.util.ArrayList;

public class PlatAuMenu {
    private int code;
    private String description;
    private double prix;
    private ArrayList<IIngredients> ingredients;

    public PlatAuMenu(int code, String description, double prix, ArrayList<IIngredients> ingredients) {
        this.code = code;
        this.description = description;
        this.prix = prix;
        this.ingredients = ingredients;
    }

    public PlatAuMenu() {
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public ArrayList<IIngredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<IIngredients> ingredientsArrayList) {
        this.ingredients = ingredientsArrayList;
    }
}
