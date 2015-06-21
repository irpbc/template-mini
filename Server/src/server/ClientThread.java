/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import model.Objekat1;
import model.Objekat2;
import model.Objekat3;
import model.Objekat4;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.Request;
import static net.Codes.*;
import controller.ServerController;
import net.Response;

/**
 *
 * @author ivan
 */
public class ClientThread extends Thread {

	private final Socket soket;

	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	
	private ServerController kontroler = new ServerController();
		
	
	ClientThread(Socket soket) {
		this.soket = soket;
	}

	@Override
	public void run() {
		try {
			inputStream = new ObjectInputStream(soket.getInputStream());
			outputStream = new ObjectOutputStream(soket.getOutputStream());
		
			while (true) {
				Request klijentZahtev = (Request)inputStream.readObject();
				if (klijentZahtev == null) break;
				Response odgovor = processRequest(klijentZahtev);
				outputStream.writeObject(odgovor);
			}
			soket.close();
		} catch (Exception ex) {
			Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private Response processRequest(Request request) {
		
		int opCode = request.getOpCode();
		Object parameter = request.getParameter();
		Response odg = new Response();
		odg.setStatus(STATUS_ODGOVOR_SERVER_NOT_OK);
		
		List ls;
		
		switch (opCode) {
			
			case VRATI_SVE_Objekat2:
				ls = kontroler.vratiSveObjekat2();
				if (ls != null) {
					odg.setStatus(STATUS_ODGOVOR_SERVER_OK);
					odg.setResult(ls);
				}
				break;
			case VRATI_SVE_Objekat3:
				ls = kontroler.vratiSveObjekat3();
				if (ls != null) {
					odg.setStatus(STATUS_ODGOVOR_SERVER_OK);
					odg.setResult(ls);
				}
				break;
			case VRATI_SVE_Objekat4:
				ls = kontroler.vratiSveObjekat4();
				if (ls != null) {
					odg.setStatus(STATUS_ODGOVOR_SERVER_OK);
					odg.setResult(ls);
				}
				break;
				
				
				
			case SACUVAJ_Objekat1:
				boolean status = kontroler.sacuvajObjekat1((Objekat1)request.getParameter());
				if (status) {
					odg.setStatus(STATUS_ODGOVOR_SERVER_OK);
				}
				break;
			
		}
		
		return odg;
	}
}
