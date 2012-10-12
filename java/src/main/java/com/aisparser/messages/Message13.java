package com.aisparser.messages;

import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * AIS Message 13 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Message 13 class
 * Safety Related Acknowledge
 * 
 */
public class Message13 extends Messages {
    private int            spare;             // 2 bits   : Spare
    private long           destid_1;          // 30 bits  : Destination MMSI 1
    private int            sequence_1;        // 2 bits   : Sequence Number 1
    private long           destid_2;          // 30 bits  : Destination MMSI 2
    private int            sequence_2;        // 2 bits   : Sequence Number 2
    private long           destid_3;          // 30 bits  : Destination MMSI 3
    private int            sequence_3;        // 2 bits   : Sequence Number 3
    private long           destid_4;          // 30 bits  : Destination MMSI 4
    private int            sequence_4;        // 2 bits   : Sequence Number 4
    private int            num_acks;          // Number of acks 

    public int spare() { return this.spare; }
    public long destid_1() { return this.destid_1; }
    public int sequence_1() { return this.sequence_1; }
    public long destid_2() { return this.destid_2; }
    public int sequence_2() { return this.sequence_2; }
    public long destid_3() { return this.destid_3; }
    public int sequence_3() { return this.sequence_3; }
    public long destid_4() { return this.destid_4; }
    public int sequence_4() { return this.sequence_4; }
    public int num_acks() { return this.num_acks; }

	public Message13() {
		super();
	}

	public Message13(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state ) throws SixbitsExhaustedException, AISMessageException {
		int length = six_state.bit_length();
		if ((length < 72) || (length > 168))
			throw new AISMessageException("Message 13 wrong length");

		super.parse( 13, six_state );

	    this.spare        = (int)   six_state.getInt(2);
	    this.destid_1     = (long)  six_state.getInt(30);
	    this.sequence_1   = (int)   six_state.getInt(2);
	    this.num_acks = 1;

	    if( length > 72 ) {
	        this.destid_2     = (long)  six_state.getInt(30);
	        this.sequence_2   = (int)   six_state.getInt(2);
	        this.num_acks++;
	    }

	    if( length > 104 ) {
	        this.destid_3     = (long)  six_state.getInt(30);
	        this.sequence_3   = (int)   six_state.getInt(2);
	        this.num_acks++;
	    }

	    if( length > 136 ) {
	        this.destid_4     = (long)  six_state.getInt(30);
	        this.sequence_4   = (int)   six_state.getInt(2);
	        this.num_acks++;
	    }
	}
}
