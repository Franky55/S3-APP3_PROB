package menufact.plats;

import ingredients.IIngredients;
import menufact.plats.PlatAuMenu;

import java.util.ArrayList;

public class PlatSante extends PlatAuMenu {
    private double kcal;
    private double chol;
    private double gras;

    public PlatSante(int code, String description, double prix, ArrayList<IIngredients> ingredientsArrayList, double kcal, double chol, double gras) {
        super(code, description, prix, ingredientsArrayList);
        this.kcal = kcal;
        this.chol = chol;
        this.gras = gras;
    }

    public PlatSante() {
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatSante{" +
                "kcal=" + kcal +
                ", chol=" + chol +
                ", gras=" + gras +
                "} " + super.toString();
    }

    @Override
    public String styledString() {
        return "PlatSante: \n" +
                "\t\t" + "- description: " + this.getDescription() + "\n" +
                "\t\t" + "- code:        " + this.getCode() + "\n" +
                "\t\t" + "- prix:        " + this.getPrix() + "\n" +
                "\t\t" + "- ingredient:  " + this.getIngredients().toString() + "\n" +
                "\t\t" + "- kcals:       " + this.getKcal() + "\n" +
                "\t\t" + "- chol:        " + this.getChol() + "\n" +
                "\t\t" + "- gras:        " + this.getGras() + "\n";
    }

    public double getKcal() {
        return kcal;
    }

    public double getChol() {
        return chol;
    }

    public double getGras() {
        return gras;
    }
}
