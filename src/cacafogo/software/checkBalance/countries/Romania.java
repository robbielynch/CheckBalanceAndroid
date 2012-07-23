package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class Romania extends Country {

	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
	        //setContentView(R.layout.main);

	    	checkNetworks();
	    }
	    
	    
	    
	    public void checkNetworks(){
	    	//build ussd code based on operator
	    	
	        //Romania Orange
	        if(operatorName.contains("Orange") || operatorName.contains("ORANGE") || operatorName.contains("orange")){
	        	code = "*" + "133" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //Romania cosmote
	        else if(operatorName.contains("Cosmote") || operatorName.contains("osmote") || operatorName.contains("COSMOTE")){
	        	code = "*" + "134" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
}
