package com.aisparser.messages;

import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * AIS Message 24 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Message 24 class
 * Class B"CS" Static Data Report
 * 
 */
public class Message24 extends Messages {
    private int            part_number;       // 2 bits   : Part Number

    //!< Message 24A 
    private String         name;              // 120 bits : Ship Name in ASCII

    //!< Message 24B 
    private int            ship_type;         // 8 bits   : Type of Ship and Cargo
    private String         vendor_id;         // 42 bits  : Vendor ID in ASCII
    private String         callsign;          // 42 bits  : Callsign in ASCII
    private int            dim_bow;           // 9 bits   : GPS Ant. Distance from Bow
    private int            dim_stern;         // 9 bits   : GPS Ant. Distance from Stern
    private int            dim_port;          // 6 bits   : GPS Ant. Distance from Port
    private int            dim_starboard;     // 6 bits   : GPS Ant. Distance from Starboard
    private int            spare;             // 6 bits   : Spare

    private int            flags;             // A/B flags - A = 1  B = 2  Both = 3  
    
    public int part_number() { return this.part_number; }
    public String name() { return this.name; }
    public int ship_type() { return this.ship_type; }
    public String vendor_id() { return this.vendor_id; }
    public String callsign() { return this.callsign; }
    public int dim_bow() { return this.dim_bow; }
    public int dim_stern() { return this.dim_stern; }
    public int dim_port() { return this.dim_port; }
    public int dim_starboard() { return this.dim_starboard; }
    public int spare() { return this.spare; }
    public int flags() { return this.flags; }
    
	public Message24()
	{
		super();
	}

	public Message24(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state )
		throws SixbitsExhaustedException, AISMessageException
	{
		int length = six_state.bit_length();
		if ((length != 160) && (length != 168))
			throw new AISMessageException("Message 24 wrong length");

		super.parse( 24, six_state );

	    this.part_number    = (int)          six_state.getInt(2);

	    if( this.part_number == 0) { // 24A
	        this.name = six_state.getString(120);
	        this.flags |= 0x01; //Indicate reception of part A
	    } else if( this.part_number == 1 ) { // 24B
	        this.ship_type = (int) six_state.getInt(8);
	        this.vendor_id = six_state.getString(42);
	        this.callsign = six_state.getString(42);
	        this.dim_bow      = (int)  six_state.getInt(9);
	        this.dim_stern    = (int)  six_state.getInt(9);
	        this.dim_port     = (int)  six_state.getInt(6);
	        this.dim_starboard= (int)  six_state.getInt(6);
	        this.spare        = (int)  six_state.getInt(6);
	        this.flags |= 0x02; // Indicate reception of part A
	    } else {
	    	throw new AISMessageException("Unknown Message 24 Part #");
	    }
	}
}
