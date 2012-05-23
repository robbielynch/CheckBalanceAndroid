package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class Sweden extends Country {
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
	        //setContentView(R.layout.main);

	    	checkNetworks();
	    }

	    
	    
	    
	    public void checkNetworks(){
	    	//build ussd code based on operator
	    	
	        //TELE 2
	        if(operatorName.contains("Tele2") || operatorName.contains("ele") || operatorName.contains("ELE")){
	        	code = "*111" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //Telia
	        if(operatorName.contains("Telia") || operatorName.contains("TELIA") || operatorName.contains("elia")){
	        	code = "*120" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
}
