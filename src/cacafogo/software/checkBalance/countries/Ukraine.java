package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class Ukraine extends Country {
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
	        		 || operatorName.contains("JEANS") || operatorName.contains("Jeans") || operatorName.contains("jeans")){
	        	code = "*101" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //Kyivstar
	        else if(operatorName.contains("Kyiv") || operatorName.contains("KYIV") || operatorName.contains("Kyiv")
	        		 || operatorName.contains("Bee") || operatorName.contains("Golden") || operatorName.contains("Vimpel")){
	        	code = "*111" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //life
	        else if(operatorName.contains("Life") || operatorName.contains("life") || operatorName.contains("LIFE")
	        		|| operatorName.contains(":)") || operatorName.contains("Turk") || operatorName.contains("SCM")){
	        	code = "*121" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
}
