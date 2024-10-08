package ingredients;

public interface IIngredients {
    int GetQuantiteRestant();
    void SetQuantiteRestant(int quantiteRestant);
    Boolean AddIngredient(int quantite);
    Boolean RemoveIngredient(int quantite);
    String getUniter();
    Boolean setUniter(String uniter);
    TypeIngredient getTypeIngredient();
    String toString();
}
