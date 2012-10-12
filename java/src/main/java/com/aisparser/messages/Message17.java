package com.aisparser.messages;

import com.aisparser.Position;
import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * AIS Message 17 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Message 17 class
 * DGNSS Broadcast binary message
 * 
 */
public class Message17 extends Messages {
    private int             spare1;            // 2 bits      : Spare
    private Position        pos;               //             : Lat/Long 1/10 minute
    private int             spare2;            // 5 bits      : Spare
    private int             msg_type;          // 6 bits      : Mesage Type from M.823
    private int             station_id;        // 10 bits     : Station ID from M.823
    private int             z_count;           // 13 bits     : Z Count
    private int             seq_num;           // 3 bits      : Sequence Number
    private int             num_words;         // 5 bits      : Number of Data Words
    private int             health;            // 3 bits      : Reference Station Health from M.823
    private Sixbit          data;              // 0-696 bits  : Data payload
    
    public int spare1() { return this.spare1; }
    public long longitude() { return this.pos.longitude(); }
    public long latitude() { return this.pos.latitude(); }
    public int spare2() { return this.spare2; }
    public int msg_type() { return this.msg_type; }
    public int station_id() { return this.station_id; }
    public int z_count() { return this.z_count; }
    public int seq_num() { return this.seq_num; }
    public int num_words() { return this.num_words; }
    public int health() { return this.health; }
    public Sixbit data() { return this.data; }
    
	public Message17()
	{
		super();
	}

	public Message17(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state )
		throws SixbitsExhaustedException, AISMessageException
	{
		int length = six_state.bit_length();
		if ((length < 80) || (length > 816))
			throw new AISMessageException("Message 17 wrong length");

		super.parse( 17, six_state );

	    this.spare1       = (int)            six_state.getInt(2);

	    this.pos = new Position(10.*60.);
	    this.pos.setLongitude((long) six_state.getSignedInt(18));
	    this.pos.setLatitude((long) six_state.getSignedInt(17));

	    this.spare2       = (int)            six_state.getInt(5);
	    this.msg_type     = (int)            six_state.getInt(6);
	    this.station_id   = (int)            six_state.getInt(10);
	    this.z_count      = (int)            six_state.getInt(13);
	    this.seq_num      = (int)            six_state.getInt(3);
	    this.num_words    = (int)            six_state.getInt(5);
	    this.health       = (int)            six_state.getInt(3);

	    this.data = six_state;
	}
}
