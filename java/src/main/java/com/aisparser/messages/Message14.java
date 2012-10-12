package com.aisparser.messages;

import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * AIS Message 14 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Message 14 class
 * Safety Related Broadcast
 * 
 */
public class Message14 extends Messages {
    private int            spare;            // 2 bits   : Spare
    private String         message;          // 968 bits : Message in ASCII

    public int spare() { return this.spare; }
    public String message() { return this.message; }

	public Message14() {
		super();
	}

	public Message14(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state ) throws SixbitsExhaustedException, AISMessageException {
		int length = six_state.bit_length();
		if ((length < 40) || (length > 1008))
			throw new AISMessageException("Message 14 wrong length");

		super.parse( 14, six_state );

	    this.spare        = (int)   six_state.getInt(2);
	    this.message = six_state.getString((length-40));
	}
}
