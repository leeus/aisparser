package com.aisparser.messages;

import com.aisparser.Position;
import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * AIS Message 21 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Message 21 class
 * Aids-to-Navigation Report
 * 
 */
public class Message21 extends Messages {
    private int             aton_type;         // 5 bits    : Type of AtoN
    private String          name;              // 120 bits  : Name of AtoN in ASCII
    private int             pos_acc;           // 1 bit     : Position Accuracy
    private Position       pos;                //           : Lat/Long 1/100000 minute
    private int             dim_bow;           // 9 bits    : GPS Ant. Distance from Bow
    private int             dim_stern;         // 9 bits    : GPS Ant. Distance from Stern
    private int             dim_port;          // 6 bits    : GPS Ant. Distance from Port
    private int             dim_starboard;     // 6 bits    : GPS Ant. Distance from Starboard
    private int             pos_type;          // 4 bits    : Type of Position Fixing Device
    private int             utc_sec;           // 6 bits    : UTC Seconds
    private int             off_position;      // 1 bit     : Off Position Flag
    private int             regional;          // 8 bits    : Regional Bits
    private int             raim;              // 1 bit     : RAIM Flag
    private int             virtual;           // 1 bit     : Virtual/Pseudo AtoN Flag
    private int             assigned;          // 1 bit     : Assigned Mode Flag
    private int             spare1;            // 1 bit     : Spare
    private String          name_ext;          // 0-84 bits : Extended name in ASCII
    private int             spare2;            // 0-6 bits  : Spare
    
    public int aton_type() { return this.aton_type; }
    public String name() { return this.name; }
    public int pos_acc() { return this.pos_acc; }
    public long longitude() { return this.pos.longitude(); }
    public long latitude() { return this.pos.latitude(); }
    public int dim_bow() { return this.dim_bow; }
    public int dim_stern() { return this.dim_stern; }
    public int dim_port() { return this.dim_port; }
    public int dim_starboard() { return this.dim_starboard; }
    public int pos_type() { return this.pos_type; }
    public int utc_sec() { return this.utc_sec; }
    public int off_position() { return this.off_position; }
    public int regional() { return this.regional; }
    public int raim() { return this.raim; }
    public int virtual() { return this.virtual; }
    public int assigned() { return this.assigned; }
    public int spare1() { return this.spare1; }
    public String name_ext() { return this.name_ext; }
    public int spare2() { return this.spare2; }

	public Message21()
	{
		super();
	}

	public Message21(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state )
		throws SixbitsExhaustedException, AISMessageException
	{
		int length = six_state.bit_length();
		if ((length < 272) || (length > 360))
			throw new AISMessageException("Message 21 wrong length");

		super.parse( 21, six_state );

	    this.aton_type      = (int)          six_state.getInt(5);
	    this.name =                          six_state.getString(120);
	    this.pos_acc       = (int)           six_state.getInt(1);

	    this.pos = new Position(10000.*60.);
	    this.pos.setLongitude((long) six_state.getSignedInt(28));
	    this.pos.setLatitude((long) six_state.getSignedInt(27));

	    this.dim_bow       = (int)           six_state.getInt(9);
	    this.dim_stern     = (int)           six_state.getInt(9);
	    this.dim_port      = (int)           six_state.getInt(6);
	    this.dim_starboard = (int)           six_state.getInt(6);
	    this.pos_type      = (int)           six_state.getInt(4);
	    this.utc_sec       = (int)           six_state.getInt(6);
	    this.off_position  = (int)           six_state.getInt(1);
	    this.regional      = (int)           six_state.getInt(8);
	    this.raim          = (int)           six_state.getInt(1);
	    this.virtual       = (int)           six_state.getInt(1);
	    this.assigned      = (int)           six_state.getInt(1);
	    this.spare1        = (int)           six_state.getInt(1);

	    if( length > 272 )
	    {
	    	this.name_ext = six_state.getString((length-272));
	    }
	}
}
