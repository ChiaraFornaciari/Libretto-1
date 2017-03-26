package it.polito.tdp.libretto.model;

public class TestModel {

	public static void main(String[] args) {
		Model m = new Model() ;
		
		System.out.println(m.addEsame(new Esame("03FYZ", "Tecniche di Programmazione", "Fulvio Corno"))) ;
		System.out.println(m.addEsame(new Esame("01QZP", "Ambient Intelligence", "Fulvio Corno"))) ;
		System.out.println(m.addEsame(new Esame("03FYZ", "Tecniche di Programmazione", "Fulvio Corno"))) ;

		System.out.println(m.trovaEsame("03FYZ"));
		System.out.println(m.trovaEsame("01QZP"));
		System.out.println(m.trovaEsame("99QQQ"));

	}

}
