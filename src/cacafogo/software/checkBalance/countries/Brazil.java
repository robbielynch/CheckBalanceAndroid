package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class Brazil extends Country {

	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
	        //setContentView(R.layout.main);

	    	checkNetworks();
	    }
	    
	    
	    
	    public void checkNetworks(){
	    	//build ussd code based on operator
	    	
	        //TIM Brazil
	        if(operatorName.contains("TIM") || operatorName.contains("Tim") || operatorName.contains("tim")){
	        	code = "*" + "222" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //Vivo Brazil
	        else if(operatorName.contains("Vivo") || operatorName.contains("VIVO") || operatorName.contains("vivo")){
	        	code = "*8000";
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //Claro Brazil
	        else if(operatorName.contains("Claro") || operatorName.contains("CLARO") || operatorName.contains("claro")){
	        	code = "*544" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //OI Brazil
	        else if(operatorName.contains("Oi") || operatorName.contains("OI") || operatorName.contains("oi")){
	        	code = "*805";
	        	//contact network provider
	        	callUSSD(code);
	        }
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
}
