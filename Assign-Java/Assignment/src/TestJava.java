import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class TestJava {

	public static void main(String args[]){		
		try{	
			
			FileInputStream finput = new FileInputStream("C:\\Java.log");
			BufferedReader read = new BufferedReader(new InputStreamReader(finput));
			
			String strLine;	
			String startTime ;
		    String endTime ;
		    String[] arr ;
		    
		    Date start; 
		    Date end;
		    
		    JSONArray list = new JSONArray();

		    FileWriter file = new FileWriter("C:\\Users\\ADMIN\\Desktop\\Assignment\\assign-test\\src\\data\\payment.json");
		     
				while ((strLine = read.readLine()) != null) {
					String line = strLine;
					arr = line.split("\\|");
					startTime = arr[1];
				    endTime = arr[2];   
				    String arr2[] ;
				    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
				    start = format.parse(startTime);	
			        end = format.parse(endTime);    
			        
			        long cal = calculate(start,end);
	        
			       	if(arr[4].equals("P1")) 
			        	{	JSONObject obj = new JSONObject();	        		
					        obj.put("tel", arr[3]);
					        obj.put("total",cal);					        
					        
					        list.add(obj);			
					        		        			        
					        System.out.println(obj);					      					        
			        	}

				} 

				file.write(list.toJSONString());
		        file.flush();
				
			finput.close();

		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
				
	}
	
//============================================================================================
	
	public static long calculate(Date start, Date end) {
		
		long diff = end.getTime()-start.getTime(); 	           
        
        long hours = diff / (60*60*1000);
        long hr = diff % (60*60*1000);
        long minutes = hr / (60*1000);
        long min = hr % (60*1000);
	    long seconds = min / 1000 % 60;
	    
		long result=0;
		long h=0,s=0,m=0;
			for(long i=seconds ;i>=0 ;i--) {
				if( seconds>0){
					s=3;
					if (minutes>0 && hours>0) {
						m=minutes*1;
						h=hours*1*60;
					}else if(minutes>0 && hours==0) {
						m=minutes*1;
					}   
				}
				result = h+m+s ;
			}
		return(result);
	} 
	
}