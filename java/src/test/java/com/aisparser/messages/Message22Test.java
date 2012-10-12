package com.aisparser.messages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import com.aisparser.Vdm;
import com.aisparser.messages.Message22;

public class Message22Test {

	Vdm vdm_message;
	Message22 msg;
	int result;

	@Test
	public void testParse() {
		vdm_message = new Vdm();
		msg = new Message22();

		try {
			result = vdm_message.add("!AIVDM,1,1,,B,F03v7B22N2PR=b@n`TGqQVkR0000,0*50");
			assertEquals( "vdm add failed", 0, result );
			 
			msg.parse( vdm_message.sixbit() );
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertEquals( "msgid", 22, msg.msgid());
		assertEquals( "repeat", 0, msg.repeat());

	}
}
