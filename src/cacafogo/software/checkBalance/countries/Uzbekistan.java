
package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class Uzbekistan extends Country {
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
	        		|| operatorName.contains("МТС") || operatorName.contains("Mtc") || operatorName.contains("mtc")
	        		|| operatorName.contains("Uzdunrobita") || operatorName.contains("UZ")){
	        	code = "*111" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //Ucell
	        else if(operatorName.contains("UCell") || operatorName.contains("Ucell") || operatorName.contains("ucell")
	        		 || operatorName.contains("Cell") || operatorName.contains("cell") || operatorName.contains("CELL")){
	        	code = "*100" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //Beeline
	        /*else if(operatorName.contains("Beeline") || operatorName.contains("BEELINE") || operatorName.contains("beeline")){
	        	code = "*102" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }*/
	        
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
}
