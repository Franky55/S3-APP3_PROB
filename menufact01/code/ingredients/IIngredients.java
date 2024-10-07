package ingredients;

public interface IIngredients {
    int GetQuantiteRestant();
    Boolean AddIngredient(int quantite);
    Boolean RemoveIngredient(int quantite);
    String getUniter();
    Boolean setUniter(String uniter);
    TypeIngredient getTypeIngredient();
    String toString();
}
