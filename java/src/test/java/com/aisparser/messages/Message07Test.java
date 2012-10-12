package com.aisparser.messages;

import org.junit.Test;

import com.aisparser.Vdm;
import com.aisparser.messages.Message07;

import static org.junit.Assert.*;

public class Message07Test {

	Vdm vdm_message;
	Message07 msg;
	int result;

	@Test
	public void testParse() {
		vdm_message = new Vdm();
		msg = new Message07();

		try {
			result = vdm_message.add("!AIVDM,1,1,,A,703Owpi9lmaQ,0*3B");
			assertEquals( "vdm add failed", 0, result );
			 
			msg.parse( vdm_message.sixbit() );
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertEquals( "num_acks", 1, msg.num_acks());
		assertEquals( "msgid", 7, msg.msgid());
		assertEquals( "repeat", 0, msg.repeat());
		assertEquals( "userid", 3669987, msg.userid());
		assertEquals( "spare", 0, msg.spare());
		assertEquals( "destid_1", 309647000, msg.destid_1());
		assertEquals( "sequence_1", 1, msg.sequence_1());
	}

}
