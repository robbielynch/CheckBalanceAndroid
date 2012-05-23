package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class Spain extends Country {
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
	        //setContentView(R.layout.main);

	    	checkNetworks();
	    }

	    
	    
	    
	    public void checkNetworks(){
	    	//build ussd code based on operator
	    	
	        //vodafone
	        if(operatorName.contains("odafone") || operatorName.contains("VODAFONE")){
	        	code = "*134" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //movistar
	        if(operatorName.contains("ovi") || operatorName.contains("MoviStar") || operatorName.contains("ovistar")
	        		 || operatorName.contains("Movistar") || operatorName.contains("oviStar")){
	        	code = "*133" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
	  
}
