package com.aisparser.exception;

public class ChecksumFailedException extends Exception
{
	public ChecksumFailedException() {}
	public ChecksumFailedException( String str )
	{
		super(str);
	}
}
