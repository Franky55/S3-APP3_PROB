package ingredients;

/**
 * La classe IngredientEpice représente un ingrédient épicé.
 * Elle implémente l'interface IIngredients.
 */
public class IngredientEpice implements IIngredients {
    private TypeIngredient typeIngredient;
    private int quantiteRestant;
    private String uniter;

    /**
     * Constructeur de la classe IngredientEpice.
     *
     * @param quantite la quantité initiale de l'ingrédient épicé.
     * @param uniter   l'unité de mesure de l'ingrédient épicé.
     */
    IngredientEpice(int quantite, String uniter) {
        typeIngredient = TypeIngredient.EPICE;
        this.quantiteRestant = quantite;
        this.uniter = uniter;
    }

    /**
     * Retourne la quantité restante de l'ingrédient.
     *
     * @return la quantité restante.
     */
    public int GetQuantiteRestant() {
        return quantiteRestant;
    }

    /**
     * Définit la quantité restante de l'ingrédient.
     *
     * @param quantiteRestant la nouvelle quantité restante.
     */
    public void SetQuantiteRestant(int quantiteRestant) {
        this.quantiteRestant = quantiteRestant;
    }

    /**
     * Ajoute une quantité d'ingrédient à la quantité restante.
     *
     * @param quantite la quantité à ajouter.
     * @return true si l'ajout a réussi.
     */
    public Boolean AddIngredient(int quantite) {
        if (quantite < 0) {
            throw new IllegalArgumentException("Quantite cannot be negative");
        }
        quantiteRestant += quantite;
        return true;
    }

    /**
     * Retire une quantité d'ingrédient de la quantité restante.
     *
     * @param quantite la quantité à retirer.
     * @throws IllegalArgumentException si la quantité restante devient négative.
     * @return true si le retrait a réussi.
     */
    public Boolean RemoveIngredient(int quantite) {
        if (quantiteRestant - quantite < 0) {
            throw new IllegalArgumentException("Quantite Restant cannot be negative");
        }
        quantiteRestant -= quantite;
        return true;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'ingrédient.
     *
     * @return une chaîne décrivant l'ingrédient, incluant son type et sa quantité.
     */
    public String toString() {
        return "Ingredient: " + typeIngredient + " Quantite: " + quantiteRestant + uniter;
    }

    /**
     * Retourne le type d'ingrédient.
     *
     * @return le type d'ingrédient.
     */
    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    /**
     * Définit le type d'ingrédient.
     *
     * @param typeIngredient le nouveau type d'ingrédient.
     */
    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }

    /**
     * Retourne l'unité de mesure de l'ingrédient.
     *
     * @return l'unité de mesure.
     */
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
