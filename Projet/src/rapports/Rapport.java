package rapports;

import fourmi.Fourmi;
import fourmi.etat.Adulte;
import fourmi.etat.Larve;
import fourmi.etat.Lymphe;
import fourmi.etat.Oeuf;
import fourmi.role.Ouvriere;
import fourmi.role.Reine;
import fourmi.role.Sexue;
import fourmi.role.Soldat;
import fourmiliere.Fourmiliere;

public interface Rapport {
	void traceForFourmiliere(Fourmiliere fourmiliere);
	void traceForFourmiliere(Fourmi fourmi);
	void traceForFourmiliere(Adulte adulte);
	void traceForFourmiliere(Larve larve);
	void traceForFourmiliere(Oeuf oeuf);
	void traceForFourmiliere(Lymphe lymphe);
	void traceForFourmiliere(Reine reine);
	void traceForFourmiliere(Ouvriere ouvriere);
	void traceForFourmiliere(Soldat solda);
	void traceForFourmiliere(Sexue sexue);
}
