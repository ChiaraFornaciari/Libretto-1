package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.libretto.db.EsameDAO;

public class Model {
	
	private List<Esame> esami ;
	
	public Model() {
		this.esami = new ArrayList<Esame>() ;
	}
	
	/**
	 * Aggiunge un nuovo esame all'elenco degli esami presenti,
	 * verificando che non ci sia gi�
	 * @param e
	 * @return true se l'ha inserito, false se esisteva gi� e quindi non l'ha potuto inserire
	 */
	public boolean addEsame(Esame e) {
		
		EsameDAO dao = new EsameDAO() ;
		if(dao.find(e.getCodice())==null)
			return dao.create(e) ;
		else 
			return false ;
	}
	
	/**
	 * Ricerca se esiste un esame con il codice specificato.
	 * Se esiste, lo restituisce, altrimenti restituisce null.
	 * @param codice codice dell'esame da ricercare
	 * @return l'esame trovato, oppure null se non trovato
	 */
	public Esame trovaEsame(String codice) {
		EsameDAO dao = new EsameDAO() ;
		
		return dao.find(codice) ;
	}

}
