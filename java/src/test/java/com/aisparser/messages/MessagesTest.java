package com.aisparser.messages;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.aisparser.Vdm;
import com.aisparser.messages.Message01;
import com.aisparser.messages.Message02;
import com.aisparser.messages.Message03;
import com.aisparser.messages.Message04;
import com.aisparser.messages.Message05;
import com.aisparser.messages.Message06;
import com.aisparser.messages.Message07;
import com.aisparser.messages.Message08;
import com.aisparser.messages.Message09;
import com.aisparser.messages.Message10;
import com.aisparser.messages.Message11;
import com.aisparser.messages.Message12;
import com.aisparser.messages.Message13;
import com.aisparser.messages.Message14;
import com.aisparser.messages.Message15;
import com.aisparser.messages.Message16;
import com.aisparser.messages.Message17;
import com.aisparser.messages.Message18;
import com.aisparser.messages.Message19;
import com.aisparser.messages.Message20;
import com.aisparser.messages.Message21;
import com.aisparser.messages.Message22;
import com.aisparser.messages.Message23;
import com.aisparser.messages.Message24;
import com.aisparser.messages.Messages;

public class MessagesTest {
	private Vdm vdm;

	@Before
	public void startup() {
		vdm  = new Vdm();
	}

	@Test
	public void testParseMessage01() throws Exception{
		vdm.add("!AIVDM,1,1,,B,14R>If001UPV>>2O1ThPshGn2<0c,0*4E");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message01);
	}

	@Test
	public void testParseMessage02() throws Exception{
		vdm.add("!AIVDM,1,1,,A,233W:T0u@G0CRsHMFeq8Snan0D8F,0*6A");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message02);
	}

	@Test
	public void testParseMessage03() throws Exception{
		vdm.add("!AIVDM,1,1,,B,342LUji0012>@s`JP<@=jUKn0P00,0*45");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message03);
	}

	@Test
	public void testParseMessage04() throws Exception{
		vdm.add("!AIVDM,1,1,,B,402M3wQuiloss0i>U8RA<si00L0O,0*58");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message04);
	}

	@Test
	public void testParseMessage05() throws Exception{
		vdm.add("!AIVDM,2,1,9,A,53Q;7V42?e>E`@e3F20P4hdV222222222222221@:h@995ii0AAj@TPC50D`8888,0*10");
		vdm.add("!AIVDM,2,2,9,A,8888882,2*2F");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message05);
	}

	@Test
	public void testParseMessage06() throws Exception{
		vdm.add("!AIVDM,1,1,,B,601uEP@rEcrv04<100,4*6F");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message06);
	}

	@Test
	public void testParseMessage07() throws Exception{
		vdm.add("!AIVDM,1,1,,A,702:Kn0mpQe`<?owJ33gI5ThvJ?:,0*3A");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message07);
	}

	@Test
	public void testParseMessage08() throws Exception{
		vdm.add("!AIVDM,1,1,,B,83aI:K@j2d<dtLMddQ4hQ?a@0100,0*65");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message08);
	}

	@Test
	public void testParseMessage09() throws Exception{
		vdm.add("!AIVDM,1,1,,A,9ce<tT0P008Vfi8Da75P0?vF0<0B,0*0A");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message09);
	}

	@Test
	public void testParseMessage10() throws Exception{
		vdm.add("!AIVDM,1,1,,B,:3P7Fs0uGOH0,0*4B");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message10);
	}

	@Test
	public void testParseMessage11() throws Exception{
		vdm.add("!AIVDM,1,1,,B,;3mMuP1uim004wnmc0Pd?8100000,0*49");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message11);
	}

	@Test
	public void testParseMessage12() throws Exception{
		vdm.add("!AIVDM,3,1,5,B,<rql3Ukcj:neieMQsrwEi3N0j91hH1Lqn<PmQrqD7cb,0*72");
		vdm.add("!AIVDM,3,2,5,B,uclGA8VvHh2Q@WSEsMd8@TqSGks;U<Mtk04<;QroJAd,0*1C");
		vdm.add("!AIVDM,3,3,5,B,P,3*43");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message12);
	}
	
	@Test
	public void testParseMessage13() throws Exception{
		vdm.add("!AIVDM,1,1,,A,=3hrieRj2rtdtMOu`Ebh0?v`249@,0*1C");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message13);
	}

	@Test
	public void testParseMessage14() throws Exception{
		vdm.add("!AIVDM,1,1,,A,>TQJ>V5IdtcP?000200HPCj31ubN0BORfL1w04p0whvrvhP9a@gN03>,2*2B");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message14);
	}

	@Test
	public void testParseMessage15() throws Exception{
		vdm.add("!AIVDM,1,1,,A,?39V250jJjepD00,2*6B");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message15);
	}

	@Test
	public void testParseMessage16() throws Exception{
		vdm.add("!AIVDM,1,1,,1,@01uEP0rEHG8<P00,0*2B");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message16);
	}

	@Test
	public void testParseMessage17() throws Exception{
		vdm.add("!AIVDM,1,1,,A,A04757QAv0agH2Jd0<d`6Opoq1pBwESVB0wsCfQ5,0*4E");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message17);
	}

	@Test
	public void testParseMessage18() throws Exception{
		vdm.add("!AIVDM,1,1,,A,B3u>BP000092?dWh0=aOOwuUoP06,0*63");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message18);
	}

	@Test
	public void testParseMessage19() throws Exception{
		vdm.add("!AIVDM,1,1,,A,C69E=KP002;jhaTBU9c7owWRV@bM0HNL?1g111111110`1p<RR07,0*50");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message19);
	}

	@Test
	public void testParseMessage20() throws Exception{
		vdm.add("!AIVDM,1,1,,A,Dh30ot2<Tnfp1=F9H1mF9H2MF9H,2*2A");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message20);
	}

	@Test
	public void testParseMessage21() throws Exception{
		vdm.add("!AIVDM,1,1,,B,E04<o22`0V6TR7h@@@@@@@@@@@@4QSmD:d3O@10888ufL0,4*71");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message21);
	}

	@Test
	public void testParseMessage22() throws Exception{
		vdm.add("!AIVDM,1,1,,B,F030p?j2N2P73FiiNesU3FR10000,0*32");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message22);
	}

	@Test
	public void testParseMessage23() throws Exception{
		vdm.add("!AIVDM,1,1,,A,Gh4<o6Bm?`e7UcbAGq000000;00,2*60");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message23);
	}

	@Test
	public void testParseMessage24() throws Exception{
		vdm.add("!AIVDM,1,1,,B,H3uBgMQHO;N18tpq<d580000000,2*7B");
		Messages m = Messages.getMessage(vdm);
		assertTrue(m instanceof Message24);
	}
}