/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import dbobjects.annotations.DbObject;
import dbobjects.annotations.PrimaryKey;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Ivan
 */
@DbObject
public class Objekat2 implements Serializable {
	
	@PrimaryKey
	private long id;

	public Objekat2() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}

