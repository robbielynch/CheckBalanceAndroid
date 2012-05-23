package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class India extends Country {
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
	        //setContentView(R.layout.main);

	    	checkNetworks();
	    }

	    
	    
	    
	    public void checkNetworks(){
	    	//build ussd code based on operator
	    	
	        //Vodafone India
	        if(operatorName.contains("Vodafone") || operatorName.contains("VODA") || operatorName.contains("Voda")){
	        	code = "*141" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //Bharti Airtel India
	        else if(operatorName.contains("Bharti") || operatorName.contains("BHARTI") || operatorName.contains("bharti")
	        		|| operatorName.contains("Airtel") || operatorName.contains("AIRTEL") || operatorName.contains("airtel")){
	        	//code = "*321" + encodedHash;
	        	code = "*123" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //Reliance Airtel India
	        else if(operatorName.contains("Reliance") || operatorName.contains("RELIANCE") || operatorName.contains("reliance")){
	        	code = "*369" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //Idea India
	        else if(operatorName.contains("Idea") || operatorName.contains("IDEA") || operatorName.contains("idea")){
	        	code = "*130" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //BSNL India
	        else if(operatorName.contains("BSNL") || operatorName.contains("Bsnl") || operatorName.contains("bsnl")){
	        	code = "*123" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //Loop India
	        else if(operatorName.contains("Loop") || operatorName.contains("LOOP") || operatorName.contains("loop")){
	        	code = "*100" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //MTNL India
	        else if(operatorName.contains("Mtnl") || operatorName.contains("MTNL") || operatorName.contains("mtnl")){
	        	code = "*444" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //Aircel India
	        else if(operatorName.contains("Aircel") || operatorName.contains("AIRCEL") || operatorName.contains("aircel")){
	        	smsNumber = "121";
	            smsText = "BAL";
	            
	            sendText(smsNumber,smsText);
	        }
	        //Tata India
	        else if(operatorName.contains("Tata") || operatorName.contains("TATA") || operatorName.contains("tata")){
	        	code = "*111" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        //Uninor India
	        else if(operatorName.contains("Uninor") || operatorName.contains("uninor") || operatorName.contains("UNINOR")){
	        	code = "*222*2" + encodedHash;
	        	//contact network provider
	        	callUSSD(code);
	        }
	        else{
	        	//if network is not supported	
	        	diyUssd();
	        }
	    }
	    
	  
}
