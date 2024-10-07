package ingredients;

public class IngredientCreator {

    CreateNewIngredient(TypeIngredient typeIngredient){
        switch (typeIngredient){
            case FRUIT:
                return new IngredientFruits();
            case LEGUME:
                return new IngredientLegumes();
            case VIANDE:
                return new IngredientViande();
            case LAITIER:
                return new IngredientLaitier();
            case EPICE:
                return new IngredientEpice();
        }
    }
}
