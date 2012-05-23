package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class Armenia extends Country {
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
	        //setContentView(R.layout.main);

	    	checkNetworks();
	    }

	    
	    
	    
	    public void checkNetworks(){
	    	//build ussd code based on operator
	    	
	        //VivaCell
	        if(operatorName.contains("viva") || operatorName.contains("Viva") || operatorName.contains("VIVA")
	        		|| operatorName.contains("կենդանի") || operatorName.contains("MTS") || operatorName.contains("MTC")
	        		|| operatorName.contains("ARM 05") || operatorName.contains("RA 05") || operatorName.contains("283 05")){
	        	code = "*122" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //ArmenTel
	        else if(operatorName.contains("ArmenTel") || operatorName.contains("Armentel") || operatorName.contains("Armen Tel")
	        		|| operatorName.contains("ARMEN") || operatorName.contains("Armen") || operatorName.contains("armen")
	        		|| operatorName.contains("աղքատ") || operatorName.contains("Beeline") || operatorName.contains("BEE")
	        		|| operatorName.contains("RA-ARM") || operatorName.contains("RA-Arm") || operatorName.contains("ARMGSM")){
	        	code = "*102" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //Orange
	        else if(operatorName.contains("Orange") || operatorName.contains("orange") || operatorName.contains("ORANGE")
	        		|| operatorName.contains("նարնջի")){
	        	code = "*123" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
	  
}
