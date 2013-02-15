package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class Russia extends Country {
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
	        //setContentView(R.layout.main);

	    	checkNetworks();
	    }

	    
	    
	    
	    public void checkNetworks(){
	    	//build ussd code based on operator
	    	
	        //MTS
	        if(operatorName.contains("MTS") || operatorName.contains("Mts") || operatorName.contains("mts")
	        		|| operatorName.contains("МТС") || operatorName.contains("Mtc") || operatorName.contains("mtc")){
	        	code = "*100" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //Megafon
	        else if(operatorName.contains("Megafon") || operatorName.contains("egafon") || operatorName.contains("MEGA")
	        		 || operatorName.contains("ME") || operatorName.contains("Me")){
	        	code = "*100" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //Beeline
	        else if(operatorName.contains("Beeline") || operatorName.contains("BEELINE") || operatorName.contains("beeline")){
	        	code = "*102" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
}
