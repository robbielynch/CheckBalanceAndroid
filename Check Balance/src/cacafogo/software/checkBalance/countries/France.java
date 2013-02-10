package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class France extends Country {
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
	        //setContentView(R.layout.main);

	    	checkNetworks();
	    }

	    
	    
	    
	    public void checkNetworks(){
	    	//build ussd code based on operator
	    	
	        //orange
	        if(operatorName.contains("range") || operatorName.contains("ORANGE")){
	        	code = encodedHash + "123" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //sfr
	        else if(operatorName.contains("sfr") || operatorName.contains("SFR") 
	        		|| operatorName.contains("Sfr")){
	        	//code = "950";
	        	//contact network provider
	        	//callUSSD(code);
	        	diyUssd();
	        }
	        
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
	  
}
