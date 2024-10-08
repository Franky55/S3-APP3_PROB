package ingredients;

public class IngredientCreator {

    public static IIngredients CreateNewIngredient(TypeIngredient typeIngredient, int quantite, String uniter){
        return switch (typeIngredient) {
            case FRUIT -> new IngredientFruits(quantite, uniter);
            case LEGUME -> new IngredientLegumes(quantite, uniter);
            case VIANDE -> new IngredientViande(quantite, uniter);
            case LAITIER -> new IngredientLaitier(quantite, uniter);
            case EPICE -> new IngredientEpice(quantite, uniter);
            default -> null;
        };
    }
}
