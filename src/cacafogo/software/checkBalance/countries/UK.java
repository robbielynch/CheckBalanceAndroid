package cacafogo.software.checkBalance.countries;

import android.os.Bundle;

public class UK extends Country {
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
	        //setContentView(R.layout.main);

	    	checkNetworks();
	    }

	    
	    
	    public void checkNetworks(){
	    	//vodafone uk
            if(operatorName.contains("odafone")){
            	code = "*" + encodedHash + "1345" + encodedHash;
            	callUSSD(code);
            }
            //orange uk
            else if(operatorName.contains("range")){
            	code = "453";
            	callUSSD(code);
            }
            //o2 uk
            else if(operatorName.contains("2")){
            	code = "*" + encodedHash + "10" + encodedHash;
            	callUSSD(code);
            }
            //three uk
            else if(operatorName.contains("hree") || operatorName.contains("3")){
            	code = "444";
            	callUSSD(code);
            }
            //giffgaff uk
            else if(operatorName.contains("iffgaff") || operatorName.contains("Giff") || operatorName.contains("GIFF")
            		|| operatorName.contains("giff") || operatorName.contains("Gaff") || operatorName.contains("gaff")
            		|| operatorName.contains("GAFF")){
            	code = "*" + "100" + encodedHash;
            	callUSSD(code);
            }
            //tesco mobile uk
            else if(operatorName.contains("esco")){
            	code = "*" + encodedHash + "10" + encodedHash;
            	callUSSD(code);
            }
            //asda mobile uk
            else if(operatorName.contains("sda")){
            	code = "*" + encodedHash + "1345" + encodedHash;
            	callUSSD(code);
            }
            //virgin mobile uk
            else if(operatorName.contains("irgin")){
            	smsNumber = "789789";
                smsText = "BALANCE";
                
                sendText(smsNumber,smsText);
            }
            //tmobile
            else if(operatorName.contains("T") && operatorName.contains("obile")){
            	smsNumber = "150";
                smsText = "BA";
                
                sendText(smsNumber,smsText);
            }
            else{
            	//if network is not found
            	diyUssd();
            }
	    }
	  
}
