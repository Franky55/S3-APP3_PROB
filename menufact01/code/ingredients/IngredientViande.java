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

    public void SetQuantiteRestant(int quantiteRestant) {
        if (quantiteRestant < 0) {
            throw new IllegalArgumentException("Quantite cannot be negative");
        }
        this.quantiteRestant = quantiteRestant;
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

    /**
     * Définit l'unité de mesure de l'ingrédient.
     *
     * @param uniter la nouvelle unité de mesure.
     * @return true si la définition a réussi.
     */
    public Boolean setUniter(String uniter) {
        this.uniter = uniter;
        return true;
    }
}
