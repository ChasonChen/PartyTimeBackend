package com.csu.party.model;

import java.util.ArrayList;
import java.util.List;

public class PMessage {
	public String id;
    public String partyID;
    public Party party;
    public String mContent;
    public List<MState> mStates;

    public String cTime;
    
    public PMessage(){
    	this.party = new Party();
    	this.mStates = new ArrayList<MState>();
    }

}
