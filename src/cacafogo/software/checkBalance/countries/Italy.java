package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class Italy extends Country {
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
	        //setContentView(R.layout.main);

	    	checkNetworks();
	    }

	    
	    
	    
	    public void checkNetworks(){
	    	//build ussd code based on operator
	    	
	        //Wind
	        if(operatorName.contains("Wind") || operatorName.contains("WIND") || operatorName.contains("wind")){
	        	code = "*123" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //TIM
	        else if(operatorName.contains("TIM") || operatorName.contains("Tim") || operatorName.contains("tim")){
	        	smsNumber = "40916";
	            smsText = "PRE CRE SIN";
	            
	            sendText(smsNumber,smsText);
	        }
	        //Vodafone
	        else if(operatorName.contains("odafone") || operatorName.contains("Vodafone") || operatorName.contains("VODAFONE")){
	        	code = "404";
	        	//contact network provider
	        	callUSSD(code);
	        }
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
	  
}
