package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class Germany extends Country {
	
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
	        	code = "*100" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //t-mobile - telekom
	        else if(operatorName.contains("t-") || operatorName.contains("T-") || operatorName.contains("T Mobile")
	        		 || operatorName.contains("elekom") || operatorName.contains("TELEKOM")){
	        	code = "*100" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //e-plus
	        else if(operatorName.contains("plus") || operatorName.contains("Plus") || operatorName.contains("PLUS")){
	        	code = "*100" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //o2
	        else if(operatorName.contains("o2") || operatorName.contains("O2")){
	        	code = "*101" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
	  
}
