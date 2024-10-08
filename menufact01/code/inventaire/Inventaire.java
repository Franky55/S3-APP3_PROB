package inventaire;

import ingredients.IIngredients;
import ingredients.TypeIngredient;

import java.util.ArrayList;

/**
 * La classe représente un inventaire d'ingrédients.
 * C'est un singleton.
 */
public class Inventaire {
    private ArrayList<IIngredients> ingredients = new ArrayList<>();
    private static Inventaire inventaire;

    private Inventaire() {}

    /**
     * Obtient l'inventaire.
     *
     * @return l'instance unique de Inventaire.
     */
    public static Inventaire getInstance(){
        if(inventaire == null){
            inventaire = new Inventaire();
        }
        return inventaire;
    }

    /**
     * Réinitialise l'inventaire en créant une nouvelle instance.
     */
    public static void reset() {
        inventaire = new Inventaire();
    }

    /**
     * Obtient un ingrédient de l'inventaire en fonction de l'objet {@code IIngredients} fourni.
     *
     * @param ingredient l'ingrédient à rechercher dans l'inventaire.
     * @return l'ingrédient trouvé ou {@code null} s'il n'existe pas.
     */
    public IIngredients getIngredient(IIngredients ingredient){
        for(IIngredients i : ingredients){
            if(i.getTypeIngredient() == ingredient.getTypeIngredient()){
                return i;
            }
        }
        return null;
    }

    /**
     * Obtient un ingrédient de l'inventaire en fonction du type d'ingrédient.
     *
     * @param typeIngredient le type d'ingrédient à rechercher.
     * @return l'ingrédient trouvé ou {@code null} s'il n'existe pas.
     */
    public IIngredients getIngredient(TypeIngredient typeIngredient){
        for(IIngredients i : ingredients){
            if(i.getTypeIngredient() == typeIngredient){
                return i;
            }
        }
        return null;
    }

    /**
     * Ajoute un ingrédient à l'inventaire.
     * Si l'ingrédient existe déjà, sa quantité restante est mise à jour.
     *
     * @param ingredient l'ingrédient à ajouter.
     */
    public void addIngredient(IIngredients ingredient){
        for (IIngredients i : ingredients) {
            if(i.getTypeIngredient() == ingredient.getTypeIngredient()){
                i.AddIngredient(ingredient.GetQuantiteRestant());
                return;
            }
        }

        ingredients.add(ingredient);
    }

    /**
     * Supprime un ingrédient de l'inventaire.
     *
     * @param ingredient l'ingrédient à supprimer.
     * @throws InventaireException si l'ingrédient n'existe pas dans l'inventaire.
     */
    public void removeIngredient(IIngredients ingredient){
        for (IIngredients i : ingredients) {
            if(i.getTypeIngredient() == ingredient.getTypeIngredient()){
                i.RemoveIngredient(ingredient.GetQuantiteRestant());
                return;
            }
        }

        throw new InventaireException("Ingrédient n'existe pas dans l'inventaire: " + ingredient.getTypeIngredient().toString());
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'inventaire.
     *
     * @return une chaîne de caractères contenant tous les ingrédients de l'inventaire.
     */
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (IIngredients i : ingredients) {
            str.append(i.toString() + "\n");
        }

        return str.toString();
    }
}
