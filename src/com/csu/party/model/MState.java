package com.csu.party.model;

public class MState {
	public String accountToken;
    public boolean isRead;
    
    public MState(){}
    
    public MState(String accountToken,boolean isRead) {
		this.accountToken = accountToken;
		this.isRead = isRead;
	}
}
