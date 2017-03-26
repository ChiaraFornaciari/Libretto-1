package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.libretto.model.Esame;

/**
 * Classe DAO per accedere alla tabella Esame del database 'libretto'
 * @author Fulvio
 *
 */
public class EsameDAO {

	public Esame find(String codice) {
		final String sql = "SELECT codice, titolo, docente, superato, voto, data_esame "+
				"FROM esame " +
				"WHERE codice=?"  ;
		
		Esame result = null ;
		
		try {
			Connection conn = DBConnect.getConnection() ;
			
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setString(1, codice);
			
			ResultSet rs = st.executeQuery() ;
			
			if(rs.next()) {
				// found
				Esame esame = new Esame(rs.getString("codice"), rs.getString("titolo"), rs.getString("docente")) ;
				if( rs.getBoolean("superato")) {
					esame.supera(rs.getInt("voto"), rs.getDate("data_esame").toLocalDate());
				}
				result = esame ;
			}
			
			return result ; 
			

		} catch(SQLException e) {
			System.err.println("Errore nell'esecuzione della query: "+e.getMessage()) ;
			e.printStackTrace();
			return null ;
		}
	}
	
	public boolean create(Esame esame) {
		
		final String sqlNonSuperato = "INSERT INTO esame (codice, titolo, docente) "+
				"VALUES (?, ?, ?);" ;

		final String sqlSuperato = "INSERT INTO esame (codice, titolo, docente, superato, voto, data_esame) "+
				"VALUES (?, ?, ?, 1, ?, ?);" ;
		
		try {
			Connection conn = DBConnect.getConnection() ;
			
			PreparedStatement st ;
			
			if(esame.isSuperato()) {
				st = conn.prepareStatement(sqlSuperato) ;
				st.setString(1, esame.getCodice());
				st.setString(2, esame.getTitolo());
				st.setString(3, esame.getDocente());
				st.setInt(4, esame.getVoto());
				st.setDate(5, Date.valueOf(esame.getDataSuperamento()));
			} else {
				st = conn.prepareStatement(sqlNonSuperato) ;
				st.setString(1, esame.getCodice());
				st.setString(2, esame.getTitolo());
				st.setString(3, esame.getDocente());
			}
						
			int res = st.executeUpdate() ;
			
			st.close();
			conn.close();
			
			if(res ==1 ) {
				return true ;
			} else {
				return false ;
			}
			

		} catch(SQLException e) {
			System.err.println("Impossibile collegarsi al database: "+e.getMessage()) ;
			e.printStackTrace();
			return false ;
		}
	}
}
