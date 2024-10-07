package ingredients;

public class IngredientLaitier implements IIngredients {
    private TypeIngredient typeIngredient = TypeIngredient.LAITIER;
    private int quantiteRestant = 0;

    public int GetQuantiteRestant() {
        return quantiteRestant;
    }

    public Boolean AddIngredient(int quantite){
        quantiteRestant += quantite;
        return true;
    }

    public Boolean RemoveIngredient(int quantite){
        quantiteRestant -= quantite;
        return true;
    }

    public String toString() {
        return "Ingredient: " + typeIngredient + " Quantite: " + quantiteRestant;
    }

    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }
}
