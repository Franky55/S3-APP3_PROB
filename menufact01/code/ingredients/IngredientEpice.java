package ingredients;

public class IngredientEpice implements IIngredients {
    private TypeIngredient typeIngredient = TypeIngredient.EPICE;
    private int quantiteRestant = 0;
    private String uniter;

    public int GetQuantiteRestant() {
        return quantiteRestant;
    }

    public Boolean AddIngredient(int quantite){
        quantiteRestant += quantite;
        return true;
    }

    public Boolean RemoveIngredient(int quantite){
        if(quantiteRestant-quantite < 0){
            throw new IllegalArgumentException("Quantite Restant cannot be negative");
        }
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

    public String getUniter() {
        return uniter;
    }
    public Boolean setUniter(String uniter){
        this.uniter = uniter;
        return true;
    }
}
