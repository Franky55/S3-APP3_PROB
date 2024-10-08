package ingredients;

public interface IIngredients {

    /**
     * Retourne la quantité restante de l'ingrédient.
     *
     * @return la quantité restante.
     */
    int GetQuantiteRestant();

    /**
     * Définit la quantité restante de l'ingrédient.
     *
     * @param quantiteRestant la nouvelle quantité restante.
     */
    void SetQuantiteRestant(int quantiteRestant);

    /**
     * Ajoute une quantité d'ingrédient à la quantité restante.
     *
     * @param quantite la quantité à ajouter.
     * @return true si l'ajout a réussi.
     */
    Boolean AddIngredient(int quantite);

    /**
     * Retire une quantité d'ingrédient de la quantité restante.
     *
     * @param quantite la quantité à retirer.
     * @throws IllegalArgumentException si la quantité restante devient négative.
     * @return true si le retrait a réussi.
     */
    Boolean RemoveIngredient(int quantite);

    /**
     * Retourne l'unité de mesure de l'ingrédient.
     *
     * @return l'unité de mesure.
     */
    String getUniter();

    /**
     * Définit l'unité de mesure de l'ingrédient.
     *
     * @param uniter la nouvelle unité de mesure.
     * @return true si la définition a réussi.
     */
    Boolean setUniter(String uniter);

    /**
     * Définit le type d'ingrédient.
     *
     * @param typeIngredient le nouveau type d'ingrédient.
     */
    void setTypeIngredient(TypeIngredient typeIngredient);

    /**
     * Retourne le type d'ingrédient.
     *
     * @return le type d'ingrédient.
     */
    TypeIngredient getTypeIngredient();

    String toString();
}
