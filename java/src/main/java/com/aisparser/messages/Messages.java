package com.aisparser.messages;

import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * Base Class for Messages
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Message base class
 * 
 * All the messages are derived from this class which provides the msgid, 
 * repeat value and userid
 *
 */
public class Messages {
    private int    msgid;             // 6 bits  : Message ID (1)
    private int    repeat;            // 2 bits  : Repeated
    private long   userid;            // 30 bits : UserID / MMSI    

    public Messages() {}
    
    public int msgid() { return this.msgid; }
    public int repeat() { return this.repeat; }
    public long userid() { return this.userid; }
    
    // Subclasses need to override with their own parsing method
    public void parse( int msgid, Sixbit six_state )
    	throws SixbitsExhaustedException
    {
    	this.msgid = msgid;
		this.repeat = (int)  six_state.getInt(2);
		this.userid = (long) six_state.getInt(30);
    }
    
    public static Messages getMessage(Vdm vdm) throws SixbitsExhaustedException, AISMessageException 
    {
    	switch (vdm.msgid())
	    {
		    case  1: return new Message01(vdm);
		    case  2: return new Message02(vdm);
		    case  3: return new Message03(vdm);
		    case  4: return new Message04(vdm);
		    case  5: return new Message05(vdm);
		    case  6: return new Message06(vdm);
		    case  7: return new Message07(vdm);
		    case  8: return new Message08(vdm);
		    case  9: return new Message09(vdm);
		    case 10: return new Message10(vdm);
		    case 11: return new Message11(vdm);
		    case 12: return new Message12(vdm);
		    case 13: return new Message13(vdm);
		    case 14: return new Message14(vdm);
		    case 15: return new Message15(vdm);
		    case 16: return new Message16(vdm);
		    case 17: return new Message17(vdm);
		    case 18: return new Message18(vdm);
		    case 19: return new Message19(vdm);
		    case 20: return new Message20(vdm);
		    case 21: return new Message21(vdm);
		    case 22: return new Message22(vdm);
		    case 23: return new Message23(vdm);
		    case 24: return new Message24(vdm);
	    }
      System.out.println("unknown message-id: " + vdm.msgid());
      return null;
    }
}
