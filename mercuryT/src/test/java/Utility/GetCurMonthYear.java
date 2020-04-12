package Utility;

import java.util.Calendar;

public class GetCurMonthYear {
	
	Calendar cal=Calendar.getInstance();
	public String getMonth()
	{	
		String curMonth=getMonthInString(cal.get(Calendar.MONTH));
		return curMonth;
		
	}
	
	public int getYear()
	{
		
		int year=cal.get(Calendar.YEAR);
		return year;
		
	}
	
	private String getMonthInString(int month)
	{	month=month+1;
		String userMonth = "";
		switch (month) {
		case 1:
			userMonth = "January";
			break;
		case 2:
			userMonth = "Febuary";
			break;
		case 3:
			userMonth = "March";
			break;
		case 4:
			userMonth = "April";
			break;
		case 5:
			userMonth = "May";
			break;
		case 6:
			userMonth = "June";
			break;
		case 7:
			userMonth = "July";
			break;
		case 8:
			userMonth = "August";
			break;
		case 9:
			userMonth = "September";
			break;

		case 10:
			userMonth = "October";
			break;

		case 11:
			userMonth = "November";
			break;
		case 12:
			userMonth = "December";
			break;

		}
		return userMonth;
		
	}
}
