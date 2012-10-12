package com.aisparser.messages;

import com.aisparser.Position;
import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * AIS Message 23 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Message 23 class
 * Group Assignment
 * 
 */
public class Message23 extends Messages {
    private int             spare1;            // 2 bits   : Spare
    private Position        NE_pos;            //          : NE Corner Lat/Long in 1/1000 minutes
    private Position        SW_pos;            //          : SW Corner Lat/Long in 1/1000 minutes
    private int             station_type;      // 4 bits   : Station Type
    private int             ship_type;         // 8 bits   : Type of Ship and Cargo
    private long            spare2;            // 22 bits  : Spare
    private int             txrx_mode;         // 2 bits   : TX/RX Mode
    private int             report_interval;   // 4 bits   : Reporting Interval from IEC 62287 Table 17
    private int             quiet_time;        // 4 bits   : Quiet Time in Minutes
    private int             spare3;            // 6 bits   : Spare
    
    public int spare1() { return this.spare1; }
    public long NE_longitude() { return this.NE_pos.longitude(); }
    public long NE_latitude() { return this.NE_pos.latitude(); }
    public long SW_longitude() { return this.SW_pos.longitude(); }
    public long SW_latitude() { return this.SW_pos.latitude(); }
    public int station_type() { return this.station_type; }
    public int ship_type() { return this.ship_type; }
    public long spare2() { return this.spare2; }
    public int txrx_mode() { return this.txrx_mode; }
    public int quiet_time() { return this.quiet_time; }
    public int spare3() { return this.spare3; }
    
	public Message23()
	{
		super();
	}

	public Message23(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state )
		throws SixbitsExhaustedException, AISMessageException
	{
		if (six_state.bit_length() == 168)
			throw new AISMessageException("Message 23 wrong length");

		super.parse( 23, six_state );

	    this.spare1         = (int)           six_state.getInt(2);

	    this.NE_pos = new Position(10.*60.);
	    this.NE_pos.setLongitude( (int) six_state.getSignedInt(18));
	    this.NE_pos.setLatitude( (int) six_state.getSignedInt(17));

	    this.SW_pos = new Position(10.*60.);
	    this.SW_pos.setLongitude( (int) six_state.getSignedInt(18));
	    this.SW_pos.setLatitude( (int) six_state.getSignedInt(17));

	    this.station_type   = (int)           six_state.getInt(4);
	    this.ship_type      = (int)           six_state.getInt(8);
	    this.spare2         = (long)          six_state.getInt(22);
	    this.txrx_mode      = (int)           six_state.getInt(2);
	    this.report_interval= (int)           six_state.getInt(4);
	    this.quiet_time     = (int)           six_state.getInt(4);
	    this.spare3         = (int)           six_state.getInt(6);
	}
}
