package com.aisparser.messages;

import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * AIS Message 6 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;


/**
 * AIS Message 6 class
 * Binary Addressed Message
 * 
 */
public class Message06 extends Messages {
    private int            sequence;          // 2 bits   : Sequence number
    private long           destination;       // 30 bits  : Destination MMSI
    private int            retransmit;        // 1 bit    : Retransmit
    private int            spare;             // 1 bit    : Spare
    private int            app_id;            // 16 bits  : Application ID
    private Sixbit         data;              // 960 bits : Data payload

    public int sequence() { return this.sequence; }
    public long destination() { return this.destination; }
    public int retransmit() { return this.retransmit; }
    public int spare() { return this.spare; }
    public int app_id() { return this.app_id; }
    public Sixbit data() { return this.data; }
    
	public Message06()
	{
		super();
	}

	public Message06(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state )
		throws SixbitsExhaustedException, AISMessageException
	{
		if ((six_state.bit_length() < 88) || (six_state.bit_length() > 1008))
			throw new AISMessageException("Message 6 wrong length");

		super.parse( 6, six_state );

	    this.sequence     = (int)   six_state.getInt(2);
	    this.destination  = (long)  six_state.getInt(30);
	    this.retransmit   = (int)   six_state.getInt(1);
	    this.spare        = (int)   six_state.getInt(1);
	    this.app_id       = (int)   six_state.getInt(16);

	    /* Store the remaining payload of the packet for further processing */
		this.data = six_state;

	}
}
