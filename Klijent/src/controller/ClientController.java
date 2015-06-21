/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Objekat1;
import model.Objekat2;
import model.Objekat3;
import model.Objekat4;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;
import static net.Codes.*;
import net.Request;
import net.Response;

/**
 *
 * @author ivan
 */
public class ClientController {

	private static ClientController instance;

	public static ClientController getInstance() {
		if (instance == null) {
			instance = new ClientController();
		}
		return instance;
	}
	
	private Socket socket;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;

	private ClientController() {
	}

	private void connect() throws IOException {

		socket = new Socket(InetAddress.getLocalHost(), PORT);
		outputStream = new ObjectOutputStream(socket.getOutputStream());
		inputStream = new ObjectInputStream(socket.getInputStream());
	}

	private void disconnect() {
		try {
			socket.close();
		} catch (Exception ex) {

		}
		socket = null;
		inputStream = null;
		outputStream = null;
	}

	public List<Objekat2> vratiSveObjekat2() throws IOException, ClassNotFoundException, Exception {

		Request klijentZahtev = new Request();
		klijentZahtev.setOpCode(VRATI_SVE_Objekat2);

		try {
			connect();

			outputStream.writeObject(klijentZahtev);
			Response serverOdgovor = (Response) inputStream.readObject();

			int statusOperacije = serverOdgovor.getStatus();
			if (statusOperacije == STATUS_ODGOVOR_SERVER_OK) {
				return (List<Objekat2>) serverOdgovor.getResult();
			} else {
				throw new Exception((String)serverOdgovor.getError());
			}
		} finally {
			disconnect();
		}
	}
	
	public List<Objekat3> vratiSveObjekat3() throws IOException, ClassNotFoundException, Exception {

		Request klijentZahtev = new Request();
		klijentZahtev.setOpCode(VRATI_SVE_Objekat3);

		try {
			connect();

			outputStream.writeObject(klijentZahtev);
			Response serverOdgovor = (Response) inputStream.readObject();

			int statusOperacije = serverOdgovor.getStatus();
			if (statusOperacije == STATUS_ODGOVOR_SERVER_OK) {
				return (List<Objekat3>) serverOdgovor.getResult();
			} else {
				throw new Exception((String)serverOdgovor.getError());
			}
		} finally {
			disconnect();
		}
	}
	
	public List<Objekat4> vratiSveObjekat4() throws IOException, ClassNotFoundException, Exception {

		Request klijentZahtev = new Request();
		klijentZahtev.setOpCode(VRATI_SVE_Objekat4);

		try {
			connect();

			outputStream.writeObject(klijentZahtev);
			Response serverOdgovor = (Response) inputStream.readObject();

			int statusOperacije = serverOdgovor.getStatus();
			if (statusOperacije == STATUS_ODGOVOR_SERVER_OK) {
				return (List<Objekat4>) serverOdgovor.getResult();
			} else {
				throw new Exception((String)serverOdgovor.getError());
			}
		} finally {
			disconnect();
		}
	}
	
	public boolean sacuvajObjekat1(Objekat1 o) throws IOException, ClassNotFoundException, Exception {

		Request klijentZahtev = new Request();
		klijentZahtev.setOpCode(SACUVAJ_Objekat1);
		klijentZahtev.setParameter(o);

		try {
			connect();

			outputStream.writeObject(klijentZahtev);
			Response serverOdgovor = (Response) inputStream.readObject();

			int statusOperacije = serverOdgovor.getStatus();
			if (statusOperacije == STATUS_ODGOVOR_SERVER_OK) {
				return true;
			} else {
				throw new Exception((String)serverOdgovor.getError());
			}
		} finally {
			disconnect();
		}
	}
	
	public boolean sacuvajSveObjekat1(List<Objekat1> o) throws IOException, ClassNotFoundException, Exception {

		Request klijentZahtev = new Request();
		klijentZahtev.setOpCode(SACUVAJ_SVE_Objekat1);
		klijentZahtev.setParameter(o);

		try {
			connect();

			outputStream.writeObject(klijentZahtev);
			Response serverOdgovor = (Response) inputStream.readObject();

			int statusOperacije = serverOdgovor.getStatus();
			if (statusOperacije == STATUS_ODGOVOR_SERVER_OK) {
				return true;
			} else {
				throw new Exception((String)serverOdgovor.getError());
			}
		} finally {
			disconnect();
		}
	}
}
