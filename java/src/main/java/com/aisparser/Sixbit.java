package com.aisparser;

import com.aisparser.exception.SixbitsExhaustedException;

public class Sixbit {
	private String bitstring;  //Contains the bits as String of 010101
	private int numBits; //stores the original number of bits in the message

	public void init(String bits) {
		bitstring = "";
		for (int i = 0; i < bits.length(); i++) {
			bitstring += getSixBitString((int)bits.charAt(i));
		}
		numBits = bitstring.length();
	}

	public void add(String bits) {
		for (int i = 0; i < bits.length(); i++) {
			bitstring += getSixBitString((int)bits.charAt(i));
		}
		numBits = bitstring.length();
	}

	public Integer getInt(int numBits) throws SixbitsExhaustedException {
		if (numBits > bitstring.length()) throw new SixbitsExhaustedException();
		String current = bitstring.substring(0,numBits);
		bitstring = bitstring.substring(numBits);
		return Integer.parseInt(current,2);
	}

	public int getSignedInt(int numBits) throws SixbitsExhaustedException {
		if (numBits > bitstring.length()) throw new SixbitsExhaustedException();
		String current = bitstring.substring(0, numBits);
		bitstring = bitstring.substring(numBits);
		boolean minus = current.charAt(0) == '1';
		String value = current.substring(1);
		if (minus) {
			return (int) -(Math.pow(2, value.length()) - Math.abs(Integer.parseInt(value, 2)));
		} else {
			return Integer.parseInt(value, 2);
		}
	}

	public char ais2ascii( int value )
		{
		if (value > 0x3F )
			throw new IllegalArgumentException("Value is out of range (0-0x3F)");	
		if( value < 0x20 )
				return (char)(value + 0x40);
			else
				return (char)value;
		}

	public String getString(int numBits) throws SixbitsExhaustedException {
		if (numBits > bitstring.length()) throw new SixbitsExhaustedException();
		String res = "";
		for (int i = 0; i < numBits/6; i++) {
			int value = getInt(6);
			res += ais2ascii(value);
		}
		return res;
	}

	public int bit_length() {
		return numBits;
	}

	public int length() {
		return bitstring.length() / 6;
	}

	public int binfrom6bit(int v) {
		String s = getSixBitString(v);
		return Integer.parseInt(s,2);
	}

	public int binto6bit(int value) throws IllegalArgumentException {
		if (value > 0x3F)
			throw new IllegalArgumentException("Value is out of range (0-0x3F)");
		if (value < 0x28)
			return value + 0x30;
		else
			return value + 0x38;
	}

	public void padBits(int parseInt) {
		numBits -=parseInt;
	}

	private String getSixBitString(int c) {
		if( (c < 0x30) || (c > 0x77) || ((c > 0x57) && (c < 0x60)) )
			throw new IllegalArgumentException("Illegal 6-bit ASCII value");

		if (c < 0x60) {
			c = (c - 0x30) & 0x3F;
		} else {
			c = (c - 0x38) & 0x3F;
		}

		String s = Integer.toBinaryString(c);
		while (s.length() < 6) {
			s = "0" + s;
		}
		return s;
	}

	public String getBitstring(int numBits) throws SixbitsExhaustedException {
		if (numBits > bitstring.length()) throw new SixbitsExhaustedException();
		String current = bitstring.substring(0, numBits);
		bitstring = bitstring.substring(numBits);
		return current;
	}

	public static int getIntFromBitString(String bitstring, boolean signed) {
		boolean minus = false;
		String value = bitstring;

		if (signed) {
			minus = bitstring.charAt(0) == '1';
			value = bitstring.substring(1);
		}
		if (minus) {
			return (int) -(Math.pow(2, value.length()) - Math.abs(Integer
					.parseInt(value, 2)));
		} else {
			return Integer.parseInt(value, 2);
		}
	}
}
