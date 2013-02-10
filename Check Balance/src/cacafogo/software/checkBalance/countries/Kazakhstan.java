package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class Kazakhstan extends Country {
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
	        //setContentView(R.layout.main);

	    	checkNetworks();
	    }

	    
	    
	    
	    public void checkNetworks(){
	    	//build ussd code based on operator
	    	
	        //Kcell
	        if(operatorName.contains("KCell") || operatorName.contains("Kcell") || operatorName.contains("kcell")
	        		|| operatorName.contains("Fintir") || operatorName.contains("Kazakh")){
	        	code = "*123*3*1" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //Beeline
	        /*else if(operatorName.contains("Megafon") || operatorName.contains("egafon") || operatorName.contains("MEGA")
	        		 || operatorName.contains("ME") || operatorName.contains("Me")){
	        	code = "*100" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }*/
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
}
