/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbbroker.DBBroker;
import model.Objekat1;
import model.Objekat2;
import model.Objekat3;
import model.Objekat4;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivan
 */
public class ServerController {

	private DBBroker dbb = new DBBroker();

	public List<Objekat2> vratiSveObjekat2() {
		List<Objekat2> lista = null;
		try {
			dbb.ucitajDrajver();
			dbb.poveziSaBazom();
			lista = dbb.vratiSveObjekat2();
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				dbb.close();
			} catch (SQLException ex) {
				
			}
		}
		return lista;
	}
	
	public List<Objekat3> vratiSveObjekat3() {
		List<Objekat3> lista = null;
		try {
			dbb.ucitajDrajver();
			dbb.poveziSaBazom();
			lista = dbb.vratiSveObjekat3();
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				dbb.close();
			} catch (SQLException ex) {
				
			}
		}
		return lista;
	}

	public List<Objekat4> vratiSveObjekat4() {
		List<Objekat4> lista = null;
		try {
			dbb.ucitajDrajver();
			dbb.poveziSaBazom();
			lista = dbb.vratiSveObjekat4();
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				dbb.close();
			} catch (SQLException ex) {
				
			}
		}
		return lista;
	}
	 
	public boolean sacuvajObjekat1(Objekat1 ob) {
		try {
			dbb.ucitajDrajver();
			dbb.poveziSaBazom();
			dbb.sacuvajObjekat1(ob);
			dbb.commit();
		} catch (Exception ex) {
			Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
			try {
				dbb.rollback();
			} catch (SQLException ex1) {
				Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex1);
			}
			return false;
		} finally {
			try {
				dbb.close();
			} catch (SQLException ex) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean sacuvajSveObjekat1(List<Objekat1> ob) {
		try {
			dbb.ucitajDrajver();
			dbb.poveziSaBazom();
			dbb.sacuvajSveObjekat1(ob);
			dbb.commit();
		} catch (Exception ex) {
			Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
			try {
				dbb.rollback();
			} catch (SQLException ex1) {
				Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex1);
			}
			return false;
		} finally {
			try {
				dbb.close();
			} catch (SQLException ex) {
				return false;
			}
		}
		
		return true;
	}
}
