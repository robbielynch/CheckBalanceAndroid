package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class Poland extends Country {

	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
	        //setContentView(R.layout.main);

	    	checkNetworks();
	    }
	    
	    
	    
	    public void checkNetworks(){
	    	//build ussd code based on operator
	    	
	        //Simplus Poland
	        if(operatorName.contains("Simplus") || operatorName.contains("implus") || operatorName.contains("SIMPLUS")
	        		 || operatorName.contains("PLUS") || operatorName.contains("Plus") || operatorName.contains("plus")){
	        	code = "*" + "100" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //play Poland
	        else if(operatorName.contains("Play") || operatorName.contains("play") || operatorName.contains("PLAY")){
	        	code = "*" + "101" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
}
