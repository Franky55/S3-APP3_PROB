package menufact.plats;

import ingredients.IIngredients;
import menufact.plats.PlatAuMenu;

import java.util.ArrayList;

public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    private EtatsPlat etatsPlat = EtatsPlat.CHOISI;

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                '}';
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public PlatAuMenu getPlat() {
        return plat;
    }

    public EtatsPlat getEtatsPlat() {
        return etatsPlat;
    }

    public void setEtatsPlat(EtatsPlat etatsPlat) {
        this.etatsPlat = etatsPlat;
    }

    public ArrayList<IIngredients> getIngredients() {
        return plat.getIngredients();
    }
}
