package menufact.facture;

import menufact.plats.PlatChoisi;

public interface IFactureSubscriber {
    void Update(PlatChoisi plat, int quantite);
}
