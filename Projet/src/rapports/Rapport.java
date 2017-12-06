package rapports;

import territoire.Territoire;
import territoire.entite.fourmi.Fourmi;
import territoire.entite.fourmi.etat.Adulte;
import territoire.entite.fourmi.etat.Larve;
import territoire.entite.fourmi.etat.Lymphe;
import territoire.entite.fourmi.etat.Oeuf;
import territoire.entite.fourmi.role.Ouvriere;
import territoire.entite.fourmi.role.Reine;
import territoire.entite.fourmi.role.Sexue;
import territoire.entite.fourmi.role.Soldat;
import territoire.fourmiliere.Fourmiliere;
import territoire.zone.Case;

public interface Rapport {
	void traceForFourmiliere(Fourmiliere fourmiliere);
	void traceForFourmiliere(Fourmi fourmi);
	void traceForFourmiliere(Adulte adulte);
	void traceForFourmiliere(Larve larve);
	void traceForFourmiliere(Oeuf oeuf);
	void traceForFourmiliere(Lymphe lymphe);
	void traceForFourmiliere(Reine reine);
	void traceForFourmiliere(Ouvriere ouvriere);
	void traceForFourmiliere(Soldat soldat);
	void traceForFourmiliere(Sexue sexue);
	void traceForFourmiliere(Territoire territoire);
	void traceForFourmiliere(Case caseTerritoire);
}
