package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class China extends Country {
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
	        //setContentView(R.layout.main);

	    	checkNetworks();
	    }

	    
	    
	    
	    public void checkNetworks(){
	    	//build ussd code based on operator
	    	
	        //China Mobile
	        if(operatorName.contains("China Mobile") || operatorName.contains("china Mobile") || operatorName.contains("China mobile")
	        		 || operatorName.contains("CHINA MOBILE") || operatorName.contains("ChinaMob")
	        		 || operatorName.contains("移动")){
	        	smsNumber = "10086";
	            smsText = "101";
	            //smsText = "yecx";
	            
	            sendText(smsNumber,smsText);
	        }
	        //China Unicom
	        else if(operatorName.contains("China Unicom") || operatorName.contains("china Unicom") || operatorName.contains("China unicom")
	        		|| operatorName.contains("CHINA UNICOM") || operatorName.contains("ChinaUni")
	        		|| operatorName.contains("联通")){
	        	smsNumber = "10010";
	        	smsText = "YE";
	        	//smsText = "yecx";
	        	
	        	sendText(smsNumber,smsText);
	        }
	        //China Telecom
	        else if(operatorName.contains("China Telecom") || operatorName.contains("china Telecom") || operatorName.contains("China telecom")
	        		|| operatorName.contains("CHINA TELECOM") || operatorName.contains("ChinaTel")
	        		|| operatorName.contains("电信")){
	        	code = "10000";
	        	callUSSD(code);
	        }
	        
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
}
