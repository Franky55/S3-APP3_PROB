package ingredients;

public class IngredientCreator {

    public IIngredients CreateNewIngredient(TypeIngredient typeIngredient){
        return switch (typeIngredient) {
            case FRUIT -> new IngredientFruits();
            case LEGUME -> new IngredientLegumes();
            case VIANDE -> new IngredientViande();
            case LAITIER -> new IngredientLaitier();
            case EPICE -> new IngredientEpice();
            default -> null;
        };
    }
}
