/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import java.io.Serializable;

/**
 *
 * @author ivan
 */
public class Response<TRes, TErr> implements Serializable{

    private TRes result;
	private TErr error;
    private int status;

    public TRes getResult() {
        return result;
    }

    public void setResult(TRes result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

	public TErr getError() {
		return error;
	}

	public void setError(TErr error) {
		this.error = error;
	}
}
