/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import dbobjects.annotations.DbObject;
import dbobjects.annotations.PrimaryKey;
import java.io.Serializable;

/**
 *
 * @author Ivan
 */
@DbObject
public class Objekat3 implements Serializable {
	
	@PrimaryKey
	private long id;

	public Objekat3() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}

