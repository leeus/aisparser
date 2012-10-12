package com.aisparser.messages;

import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * AIS Message 16 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Message 16 class
 * Assignment mode command
 * 
 */
public class Message16 extends Messages {
    private int             spare1;            // 2 bits   : Spare
    private long            destid_a;          // 30 bits  : Destination MMSI A
    private int             offset_a;          // 12 bits  : Slot Offset A
    private int             increment_a;       // 10 bits  : Increment A
    private long            destid_b;          // 30 bits  : Destination MMSI B
    private int             offset_b;          // 12 bits  : Slot Offset B
    private int             increment_b;       // 10 bits  : Increment B
    private int             spare2;            // 4 bits   : Spare
    private int             num_cmds;          // Number of commands received

    public int spare1() { return this.spare1; }
    public long destid_a() { return this.destid_a; }
    public int offset_a() { return this.offset_a; }
    public int increment_a() { return this.increment_a; }
    public long destid_b() { return this.destid_b; }
    public int offset_b() { return this.offset_b; }
    public int increment_b() { return this.increment_b; }
    public int spare2() { return this.spare2; }
    public int num_cmds() { return this.num_cmds; }

	public Message16()
	{
		super();
	}

	public Message16(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state )
		throws SixbitsExhaustedException, AISMessageException
	{
		int length = six_state.bit_length();
		if ((length < 96) || (length > 144))
			throw new AISMessageException("Message 16 wrong length");

		super.parse( 16, six_state );
    
	    this.spare1       = (int)   six_state.getInt(2);
	    this.destid_a     = (long)  six_state.getInt(30);
	    this.offset_a     = (int)   six_state.getInt(12);
	    this.increment_a  = (int)   six_state.getInt(10);
	    this.num_cmds     = 1;

	    if( length == 144 )
	    {
	        this.destid_b     = (long)  six_state.getInt(30);
	        this.offset_b     = (int)   six_state.getInt(12);
	        this.increment_b  = (int)   six_state.getInt(10);
	        this.spare2       = (int)   six_state.getInt(4);
	        this.num_cmds     = 2;
	    }
	}
}
