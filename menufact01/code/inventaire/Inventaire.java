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
        for (IIngredients i : ingredients) {
            if(i.getTypeIngredient() == ingredient.getTypeIngredient()){
                i.AddIngredient(ingredient.GetQuantiteRestant());
                return;
            }
        }

        ingredients.add(ingredient);
    }

    public void removeIngredient(IIngredients ingredient){
        for (IIngredients i : ingredients) {
            if(i.getTypeIngredient() == ingredient.getTypeIngredient()){
                i.RemoveIngredient(ingredient.GetQuantiteRestant());
                return;
            }
        }

        throw new InventaireException("Ingredient n'existe pas dans l'inventaire: " + ingredient.getTypeIngredient().toString());
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for (IIngredients i : ingredients) {
            str.append(i.toString() + "\n");
        }

        return str.toString();
    }

}
