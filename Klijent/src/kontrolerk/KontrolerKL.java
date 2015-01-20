/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrolerk;

import domen.Objekat1;
import domen.Objekat2;
import domen.Objekat3;
import domen.Objekat4;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;
import static kodovi.Kodovi.*;
import transfer.TOKlijentZahtev;
import transfer.TOServerOdgovor;

/**
 *
 * @author ivan
 */
public class KontrolerKL {

	private static KontrolerKL instance;

	public static KontrolerKL getInstance() {
		if (instance == null) {
			instance = new KontrolerKL();
		}
		return instance;
	}
	
	private Socket soket;
	private ObjectOutputStream soketOut;
	private ObjectInputStream soketIn;

	private KontrolerKL() {
	}

	private void poveziSeSaServerom() throws IOException {

		soket = new Socket(InetAddress.getLocalHost(), PORT);
		soketOut = new ObjectOutputStream(soket.getOutputStream());
		soketIn = new ObjectInputStream(soket.getInputStream());
	}

	private void prekiniVezu() {
		try {
			soket.close();
		} catch (Exception ex) {

		}
		soket = null;
		soketIn = null;
		soketOut = null;
	}

	public List<Objekat2> vratiSveObjekat2() throws IOException, ClassNotFoundException, Exception {

		TOKlijentZahtev klijentZahtev = new TOKlijentZahtev();
		klijentZahtev.setOperacija(VRATI_SVE_Objekat2);

		try {
			poveziSeSaServerom();

			soketOut.writeObject(klijentZahtev);
			TOServerOdgovor serverOdgovor = (TOServerOdgovor) soketIn.readObject();

			int statusOperacije = serverOdgovor.getStatusIzvrsenja();
			if (statusOperacije == STATUS_ODGOVOR_SERVER_OK) {
				return (List<Objekat2>) serverOdgovor.getRezultat();
			} else {
				throw new Exception(serverOdgovor.getPoruka());
			}
		} finally {
			prekiniVezu();
		}
	}
	
	public List<Objekat3> vratiSveObjekat3() throws IOException, ClassNotFoundException, Exception {

		TOKlijentZahtev klijentZahtev = new TOKlijentZahtev();
		klijentZahtev.setOperacija(VRATI_SVE_Objekat3);

		try {
			poveziSeSaServerom();

			soketOut.writeObject(klijentZahtev);
			TOServerOdgovor serverOdgovor = (TOServerOdgovor) soketIn.readObject();

			int statusOperacije = serverOdgovor.getStatusIzvrsenja();
			if (statusOperacije == STATUS_ODGOVOR_SERVER_OK) {
				return (List<Objekat3>) serverOdgovor.getRezultat();
			} else {
				throw new Exception(serverOdgovor.getPoruka());
			}
		} finally {
			prekiniVezu();
		}
	}
	
	public List<Objekat4> vratiSveObjekat4() throws IOException, ClassNotFoundException, Exception {

		TOKlijentZahtev klijentZahtev = new TOKlijentZahtev();
		klijentZahtev.setOperacija(VRATI_SVE_Objekat4);

		try {
			poveziSeSaServerom();

			soketOut.writeObject(klijentZahtev);
			TOServerOdgovor serverOdgovor = (TOServerOdgovor) soketIn.readObject();

			int statusOperacije = serverOdgovor.getStatusIzvrsenja();
			if (statusOperacije == STATUS_ODGOVOR_SERVER_OK) {
				return (List<Objekat4>) serverOdgovor.getRezultat();
			} else {
				throw new Exception(serverOdgovor.getPoruka());
			}
		} finally {
			prekiniVezu();
		}
	}
	
	public boolean sacuvajObjekat1(Objekat1 o) throws IOException, ClassNotFoundException, Exception {

		TOKlijentZahtev klijentZahtev = new TOKlijentZahtev();
		klijentZahtev.setOperacija(SACUVAJ_Objekat1);
		klijentZahtev.setParametar(o);

		try {
			poveziSeSaServerom();

			soketOut.writeObject(klijentZahtev);
			TOServerOdgovor serverOdgovor = (TOServerOdgovor) soketIn.readObject();

			int statusOperacije = serverOdgovor.getStatusIzvrsenja();
			if (statusOperacije == STATUS_ODGOVOR_SERVER_OK) {
				return true;
			} else {
				throw new Exception(serverOdgovor.getPoruka());
			}
		} finally {
			prekiniVezu();
		}
	}
	
	public boolean sacuvajSveObjekat1(List<Objekat1> o) throws IOException, ClassNotFoundException, Exception {

		TOKlijentZahtev klijentZahtev = new TOKlijentZahtev();
		klijentZahtev.setOperacija(SACUVAJ_SVE_Objekat1);
		klijentZahtev.setParametar(o);

		try {
			poveziSeSaServerom();

			soketOut.writeObject(klijentZahtev);
			TOServerOdgovor serverOdgovor = (TOServerOdgovor) soketIn.readObject();

			int statusOperacije = serverOdgovor.getStatusIzvrsenja();
			if (statusOperacije == STATUS_ODGOVOR_SERVER_OK) {
				return true;
			} else {
				throw new Exception(serverOdgovor.getPoruka());
			}
		} finally {
			prekiniVezu();
		}
	}
}
