package com.aisparser.messages;

import com.aisparser.Position;
import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * AIS Message 22 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Message 22 class
 * Channel Management
 * 
 */
public class Message22 extends Messages {
    private int             spare1;            // 2 bits   : Spare
    private int             channel_a;         // 12 bits  : M.1084 Channel A Frequency
    private int             channel_b;         // 12 bits  : M.1084 Channel B Frequency
    private int             txrx_mode;         // 4 bits   : TX/RX Mode
    private int             power;             // 1 bit    : Power Level
    private Position        NE_pos;            //          : NE Corner Lat/Long in 1/1000 minutes
    private long            addressed_1;       // 30 bits  : Destination MMSI 1
    private Position        SW_pos;            //          : SW Corner Lat/Long in 1/1000 minutes
    private long            addressed_2;       // 30 bits  : Destination MMSI 2
    private int             addressed;         // 1 bit    : Addressed flag
    private int             bw_a;              // 1 bit    : Channel A Bandwidth
    private int             bw_b;              // 1 bit    : Channel B Bandwidth
    private int             tz_size;           // 3 bits   : Transitional Zone size
    private long            spare2;            // 23 bits  : Spare
    
    public int spare1() { return this.spare1; }
    public int channel_a() { return this.channel_a; }
    public int channel_b() { return this.channel_b; }
    public int txrx_mode() { return this.txrx_mode; }
    public int power() { return this.power; }
    public long NE_longitude() { return this.NE_pos.longitude(); }
    public long NE_latitude() { return this.NE_pos.latitude(); }
    public long addressed_1() { return this.addressed_1; }
    public long SW_longitude() { return this.SW_pos.longitude(); }
    public long SW_latitude() { return this.SW_pos.latitude(); }
    public long addressed_2() { return this.addressed_2; }
    public int addressed() { return this.addressed; }
    public int bw_a() { return this.bw_a; }
    public int bw_b() { return this.bw_b; }
    public int tz_size() { return this.tz_size; }
    public long spare2() { return this.spare2; }
    
	public Message22()
	{
		super();
	}

	public Message22(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state )
		throws SixbitsExhaustedException, AISMessageException
	{
		if (six_state.bit_length() != 168)
			throw new AISMessageException("Message 22 wrong length");

		super.parse( 22, six_state );

	    this.spare1         = (int)          six_state.getInt(2);
	    this.channel_a      = (int)          six_state.getInt(12);
	    this.channel_b      = (int)          six_state.getInt(12);
	    this.txrx_mode      = (int)          six_state.getInt(4);
	    this.power          = (int)          six_state.getInt(1);

		String bitString1 = six_state.getBitstring(18+17);
		String bitString2 = six_state.getBitstring(18+17);

	    this.addressed      = (int)          six_state.getInt(1);
	    this.bw_a           = (int)          six_state.getInt(1);
	    this.bw_b           = (int)          six_state.getInt(1);
	    this.tz_size        = (int)          six_state.getInt(3);
	    this.spare2         = (int)          six_state.getInt(23);

	    /* Is the position actually an address? */
	    if (this.addressed == 1)
	    {
	    	this.addressed_1 = Sixbit.getIntFromBitString(bitString1.substring(0,30), false);
	    	this.addressed_2 = Sixbit.getIntFromBitString(bitString2.substring(0,30), false);
	    } else {
	    	this.NE_pos = new Position(10.*60.);
	    	this.NE_pos.setLongitude(Sixbit.getIntFromBitString(bitString1.substring(0,18),true));
	    	this.NE_pos.setLatitude(Sixbit.getIntFromBitString(bitString1.substring(18),true));
	    	this.SW_pos = new Position(10.*60.);
	    	this.SW_pos.setLongitude(Sixbit.getIntFromBitString(bitString2.substring(0,18),true));
	    	this.SW_pos.setLatitude(Sixbit.getIntFromBitString(bitString2.substring(18),true));
	    }
	}
}
