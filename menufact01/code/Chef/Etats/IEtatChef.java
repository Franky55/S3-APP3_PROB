package Chef.Etats;

import Chef.Chef;
import menufact.plats.EtatsPlat;
import menufact.plats.PlatChoisi;

public interface IEtatChef {
    public boolean SetChef(Chef chef);
    public void Update(PlatChoisi platChoisi, int quantite);
    public String toString();
}
