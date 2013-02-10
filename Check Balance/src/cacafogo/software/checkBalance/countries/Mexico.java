package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class Mexico extends Country {

	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
	        //setContentView(R.layout.main);

	    	checkNetworks();
	    }
	    
	    
	    
	    public void checkNetworks(){
	    	//build ussd code based on operator
	    	
	        //Telcel mexico
	        if(operatorName.contains("Telcel") || operatorName.contains("elCel") || operatorName.contains("TELCEL")){
	        	code = "*" + "133" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //movistar mexico
	        if(operatorName.contains("Movi") || operatorName.contains("movi") || operatorName.contains("MOVI")){
	        	code = "*" + "102" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
}
