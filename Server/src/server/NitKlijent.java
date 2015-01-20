/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Objekat1;
import domen.Objekat2;
import domen.Objekat3;
import domen.Objekat4;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.TOKlijentZahtev;
import static kodovi.Kodovi.*;
import kontroler.Kontroler;
import transfer.TOServerOdgovor;

/**
 *
 * @author ivan
 */
public class NitKlijent extends Thread {

	private final Socket soket;

	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	
	private Kontroler kontroler = Kontroler.getInstance();
		
	
	NitKlijent(Socket soket) {
		this.soket = soket;
	}

	@Override
	public void run() {
		try {
			pokreniKomunikaciju(soket);
		} catch (Exception ex) {
			Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void pokreniKomunikaciju(Socket soket) throws IOException, ClassNotFoundException {
		inputStream = new ObjectInputStream(soket.getInputStream());
		outputStream = new ObjectOutputStream(soket.getOutputStream());
		
		while (true) {
			TOKlijentZahtev klijentZahtev = (TOKlijentZahtev)inputStream.readObject();
			if (klijentZahtev == null) break;
			TOServerOdgovor odgovor = obradiZahtev(klijentZahtev);
			outputStream.writeObject(odgovor);
		}
		soket.close();
	}

	private TOServerOdgovor obradiZahtev(TOKlijentZahtev klijentZahtev) {
		
		int operacija = klijentZahtev.getOperacija();
		Object parametar = klijentZahtev.getParametar();
		TOServerOdgovor odg = new TOServerOdgovor();
		odg.setStatusIzvrsenja(STATUS_ODGOVOR_SERVER_NOT_OK);
		
		List ls;
		
		switch (operacija) {
			
			case VRATI_SVE_Objekat2:
				ls = kontroler.vratiSveObjekat2();
				if (ls != null) {
					odg.setStatusIzvrsenja(STATUS_ODGOVOR_SERVER_OK);
					odg.setRezultat(ls);
				}
				break;
			case VRATI_SVE_Objekat3:
				ls = kontroler.vratiSveObjekat3();
				if (ls != null) {
					odg.setStatusIzvrsenja(STATUS_ODGOVOR_SERVER_OK);
					odg.setRezultat(ls);
				}
				break;
			case VRATI_SVE_Objekat4:
				ls = kontroler.vratiSveObjekat4();
				if (ls != null) {
					odg.setStatusIzvrsenja(STATUS_ODGOVOR_SERVER_OK);
					odg.setRezultat(ls);
				}
				break;
				
				
				
			case SACUVAJ_Objekat1:
				boolean status = kontroler.sacuvajObjekat1((Objekat1)klijentZahtev.getParametar());
				if (status) {
					odg.setStatusIzvrsenja(STATUS_ODGOVOR_SERVER_OK);
				}
				break;
			
		}
		
		return odg;
	}
}
