package com.aisparser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.aisparser.exception.ChecksumFailedException;
import com.aisparser.exception.OutOfSequenceException;
import com.aisparser.exception.StartNotFoundException;
import com.aisparser.exception.VDMSentenceException;

import static org.junit.Assert.*;


public class VdmTest {

	Vdm vdm_message;
	
	@Before
	public void setUp() {
		vdm_message = new Vdm();
	}
	
	@After
	public void tearDown() {
		vdm_message = null;
	}
	
	@Test
	public void testMsgid() {
		int result;
		
		try {
			result = vdm_message.add("!AIVDM,1,1,,B,19NS7Sp02wo?HETKA2K6mUM20<L=,0*27\r\n");
			assertEquals("Adding message 1 failed", 0, result);
			assertEquals("Message ID wrong", 1, vdm_message.msgid());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testAdd() {
		int result;
		
		try {
			result = vdm_message.add("!AIVDM,1,1,,B,19NS7Sp02wo?HETKA2K6mUM20<L=,0*27\r\n");
			assertEquals("Adding message 1 failed", 0, result);
			
			vdm_message = new Vdm();
			result = vdm_message.add("!AIVDM,2,1,6,B,55ArUT02:nkG<I8GB20nuJ0p5HTu>0hT9860TV16000006420BDi@E53,0*33\r\n");
			assertEquals("Adding message 5 part 1 failed", 1, result);
			
			result = vdm_message.add("!AIVDM,2,2,6,B,1KUDhH888888880,2*6A");
			assertEquals("Adding message 5 part 1 failed", 0, result);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testMissingPart1() throws Exception {
		try {
			int result = vdm_message.add("!AIVDM,2,2,9,B,5CQp88888888880,2*79");
			fail("Expected OutOfSequenceException");
		} catch (OutOfSequenceException e) {
			assert (true);
		}
	}

	@Test
	public void testBrokenLine() {
		int result;
		try {
			result = vdm_message.add("!AIVDM577W7=42@E5eI8L?F20<P4pN0P4pN04r0P4V2216H`PBD5O`0BU0BH0j,0*3E");
			fail("Expected Exception");
		} catch (ChecksumFailedException e) { 
		} catch (VDMSentenceException e) {
			fail ("Expected ChecksumFailedException");
		} catch (StartNotFoundException e) {
			fail ("Expected ChecksumFailedException");
		}

	}

}
