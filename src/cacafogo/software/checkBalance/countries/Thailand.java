package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class Thailand extends Country {

	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
	        //setContentView(R.layout.main);

	    	checkNetworks();
	    }
	    
	    
	    
	    public void checkNetworks(){
	    	//build ussd code based on operator
	    	
	        //DTAC Thailand
	        if(operatorName.contains("DTAC") || operatorName.contains("Dtac") || operatorName.contains("dtac")){
	        	code = "*" + "121" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //AIS Thailand
	        else if(operatorName.contains("AIS") || operatorName.contains("ais") || operatorName.contains("Ais")){
	        	code = "*" + "139" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //Truemove Thailand
	        else if(operatorName.contains("True") || operatorName.contains("true") || operatorName.contains("TRUE")){
	        	code = encodedHash + "123" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
}
