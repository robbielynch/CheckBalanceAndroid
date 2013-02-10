package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class Belgium extends Country {
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
	        //setContentView(R.layout.main);

	    	checkNetworks();
	    }

	    
	    
	    
	    public void checkNetworks(){
	    	//build ussd code based on operator
	    	
	        //PROXIMUS
	        if(operatorName.contains("Proxi") || operatorName.contains("PROXI") || operatorName.contains("proxi")){
	        	code = encodedHash + "121" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
}
