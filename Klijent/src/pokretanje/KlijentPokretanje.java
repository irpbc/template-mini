/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokretanje;

import view.MainForm;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import static net.Codes.*;
import controller.ClientController;

/**
 *
 * @author ivan
 */
public class KlijentPokretanje {

	public static void main(String[] args) throws IOException {
		
		MainForm f = new MainForm();
		f.setVisible(true);
	}
}
