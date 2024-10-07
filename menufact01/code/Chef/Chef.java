package Chef;

import Chef.Etats.EtatsChef;
import menufact.facture.IFactureSubscriber;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

public class Chef implements IFactureSubscriber {
    private ArrayList<PlatChoisi> plats = new ArrayList<>();
    private EtatsChef etatsChef;

    private Chef() {

    }
}
