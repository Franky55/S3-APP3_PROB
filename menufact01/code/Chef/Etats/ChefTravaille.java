package Chef.Etats;

import Chef.Chef;
import menufact.plats.EtatsPlat;
import menufact.plats.PlatChoisi;

public class ChefTravaille implements IEtatChef {
    private Chef chefReference;

    /**
     * Constructeur d'un chef en etat de travail
     * @param chef
     */
    public ChefTravaille(Chef chef) {
        this.SetChef(chef);
    }

    /**
     * Definie une reference au contexte de chef.
     * @param chef
     * @return
     */
    @Override
    public boolean SetChef(Chef chef) {
        this.chefReference = chef;
        return true;
    }

    /**
     * Methode executer lorsqu'un plat est ajouter a la facture.
     * @param platChoisi
     */
    @Override
    public void Update(PlatChoisi platChoisi){
        platChoisi.setEtatsPlat(EtatsPlat.PREPARATION);
    }

    private boolean doitEtreEnAttente() {
        PlatChoisi platAFaire = chefReference.GetPlatAFaire();
        if(platAFaire == null) {
            return true;
        }
        return false;
    }

    /**
     * Fait des plats.
     * @return
     */
    @Override
    public boolean Execute() {
        if(doitEtreEnAttente()) {
            // Il n'y a plus rien a faire, faut aller en attente
            chefReference.SetEtat(EtatsChef.ATTENTE);
            return true;
        }
        PlatChoisi platAFaire = chefReference.GetPlatAFaire();
        platAFaire.setEtatsPlat(EtatsPlat.TERMINER);
        chefReference.PlatFini();

        if(doitEtreEnAttente()) {
            // Il n'y a plus rien a faire, faut aller en attente
            chefReference.SetEtat(EtatsChef.ATTENTE);
            return true;
        }

        return true;
    }

    @Override
    public String toString(){
        return "Chef en travaille.";
    }

    @Override
    public EtatsChef GetEtatsChef() {
        return EtatsChef.TRAVAILLE;
    }
}
