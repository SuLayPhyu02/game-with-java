package model;

import java.security.*;
import java.util.regex.Pattern;

public class Checker {
	public static boolean isValidName(String s)
	{
		String reg="^[A-Z][a-z]*( [A-Z][a-z]+)*$";
		return Pattern.matches(reg, s);
	}
	public static String digestMsg(String str)
	{
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte arr[]=md.digest();
			return new String(arr);
		}catch(Exception e)
		{
			return "unsuccesse";
		}
	}
}


