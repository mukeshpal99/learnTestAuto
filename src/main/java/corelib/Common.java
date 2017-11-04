package corelib;

import java.time.LocalDateTime;


public class Common 

{
	/**
	 * Methotd to get only tommorow date  
	 * @return
	 */
	public static int getTommorowsDate()
	{
		LocalDateTime now = LocalDateTime.now();
		int tommorow = now.getDayOfMonth()+1;
		return tommorow;
	}
	

}
