package inventaire;

import ingredients.IIngredients;

import java.util.ArrayList;

public class Inventaire {
    private ArrayList<IIngredients> ingredients = new ArrayList<>();
    private static Inventaire inventaire;

    private Inventaire() {}

    public static Inventaire getInstance(){
        if(inventaire == null){
            inventaire = new Inventaire();
        }
        return inventaire;
    }

    public void addIngredient(IIngredients ingredient){
        ingredients.add(ingredient);
    }

    public void removeIngredient(IIngredients ingredient){
        ingredients.remove(ingredient);
    }

}
