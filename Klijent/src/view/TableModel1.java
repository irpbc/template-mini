/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import model.Objekat1;
import java.util.List;
import java.util.UUID;
import javax.swing.table.DefaultTableModel;
import controller.ClientController;

/**
 *
 * @author Ivan
 */
public class TableModel1 extends DefaultTableModel {

	private List<Objekat1> lista;
	
	private Class[] klaseKolona = {};
	private String[] imenaKolona = {};
	
	private boolean showID;

	public TableModel1(List<Objekat1> lista) {
		this.lista = lista;
	}
	
	public void dodaj(Objekat1 o) {
		o.setId(UUID.randomUUID().getMostSignificantBits());
		lista.add(o);
		fireTableDataChanged();
	}
	
	public void obrisi(int index) {
		lista.remove(index);
		fireTableDataChanged();
	}
	
	public void sacuvaSve() throws Exception {
		ClientController kontroler = ClientController.getInstance();
		kontroler.sacuvajSveObjekat1(lista);
	}
	
	@Override
	public void setValueAt(Object aValue, int row, int column) {
		Objekat1 o = lista.get(row);
		switch (column) {
			
		}
	}

	@Override
	public Object getValueAt(int row, int column) {
		Objekat1 o = lista.get(row);
		switch (column) {
			
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public String getColumnName(int column) {
		return imenaKolona[column];
	}

	@Override
	public int getColumnCount() {
		return klaseKolona.length;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return klaseKolona[columnIndex];
	}
}
