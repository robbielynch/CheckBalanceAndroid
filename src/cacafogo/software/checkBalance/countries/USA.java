package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class USA extends Country {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);

    	checkNetworks();
    }

    
    
    public void checkNetworks(){
    	//verizon usa
    	if(operatorName.contains("erizon") || operatorName.contains("VERIZON")){
    		code = encodedHash + "225";
        	callUSSD(code);
    	}
    	//AT&T usa
    	else if(operatorName.contains("&")){
    		//code = "*"  + "225" + encodedHash;
    		code = "*"  + "777" + encodedHash;
        	callUSSD(code);
    	}
    	//Sprint usa
    	//else if(operatorName.contains("print")){
    	//	code = encodedHash + "225";
    	//	callUSSD(code);
    	//}
    	//T-Mobile
    	else if(operatorName.contains("T-Mobile") || operatorName.contains("T Mobile")
    			|| operatorName.contains("t-") || operatorName.contains("t-mobile")
    			|| operatorName.contains("T-") || operatorName.contains("t mobile")
    			|| operatorName.contains("TMobile") || operatorName.contains("Tmobile")){
    		code = encodedHash + "225" + encodedHash;
    		callUSSD(code);
    	}
	else{
		//if network is not found
		diyUssd();	}
    }
  
}
