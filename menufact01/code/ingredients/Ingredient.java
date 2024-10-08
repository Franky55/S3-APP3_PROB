package ingredients;

public class Ingredient {
    private String nom;
    private String description;
    private TypeIngredient typeIngredient;

    /**
     * get le nom de l'ingredient
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * set le nom de l'ingredient
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * get la description de l'ingredient
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set la description de l'ingredient
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retourne le type de l'ingredient.
     * Sert a savoir quel classe a ete fait par la factory btw
     * @return
     */
    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    /**
     * Set le type de l'ingredient a quelque chose.
     * A eviter d'utiliser
     * @param typeIngredient
     */
    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }
}
