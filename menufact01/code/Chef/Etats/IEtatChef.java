package Chef.Etats;

import Chef.Chef;
import menufact.plats.EtatsPlat;
import menufact.plats.PlatChoisi;

/**
 * Interface de tout ce que le chef peut faire dans n'importe lequel etat.
 */
public interface IEtatChef {
    public boolean SetChef(Chef chef);
    public void Update(PlatChoisi platChoisi);
    public boolean Execute();
    public String toString();
}
