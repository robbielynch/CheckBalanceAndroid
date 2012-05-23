package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class Portugal extends Country {

	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
	        //setContentView(R.layout.main);

	    	checkNetworks();
	    }
	    
	    
	    
	    public void checkNetworks(){
	    	//build ussd code based on operator
	    	
	        //UZO Portugal
	        if(operatorName.contains("UZO") || operatorName.contains("Uzo") || operatorName.contains("uzo")){
	        	code = "*" + encodedHash + "123" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
}
