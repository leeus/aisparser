package com.aisparser.exception;

public class IllegalNMEACharacterException extends Exception
{
	public IllegalNMEACharacterException() {}
	public IllegalNMEACharacterException( String str )
	{
		super(str);
	}
}
