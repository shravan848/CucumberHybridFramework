package utils;

import java.util.Date;

public class commonUtils {
	/*  The below mothod will generate new email with the timestamp for every execution  */
    public String getEmailWithTimeStamp()
    {
    	Date date=new Date();
    	return "shravan"+date.toString().replaceAll(" ", "_").replaceAll(":","_")+"@gmail.com";    
    	}
}
