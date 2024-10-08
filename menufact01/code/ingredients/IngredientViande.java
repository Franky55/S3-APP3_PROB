package ingredients;

public class IngredientViande implements IIngredients {
    private TypeIngredient typeIngredient = TypeIngredient.VIANDE;
    private int quantiteRestant;
    private String uniter;

    IngredientViande(int quantite, String uniter) {
        typeIngredient = TypeIngredient.VIANDE;
        this.quantiteRestant = quantite;
        this.uniter = uniter;
    }

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
        return "Ingredient: " + typeIngredient + " Quantite: " + quantiteRestant+ uniter;
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

    public Boolean setUniter(String uniter) {
        this.uniter = uniter;
        return true;
    }
}
