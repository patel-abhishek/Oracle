/**
 * 
 */
package controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;

/**
 * @author Esteban
 *
 */
public class HardwoodSeller {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
                System.out.println(args[0]);
                HardwoodSeller hws=new HardwoodSeller();
            try {
                hws.readInputFile(args[0]);
            } catch (IOException ex) {
                Logger.getLogger(HardwoodSeller.class.getName()).log(Level.SEVERE, null, ex);
            }          
	}
	
	public void readInputFile(String inputFilePath) throws IOException{
		FileInputStream fin = new FileInputStream(inputFilePath);
                BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                String buff;
                int isCust=0;
                Customer customer;
                while((buff = br.readLine())!=null){
                    if(isCust==0){
                        customer=parseCustomer(buff);
                        System.out.println(customer.showCustomer());   
                    }
                    else{
                        parseOrder(buff);
                    }
//                    System.out.println(buff);
                    isCust=1-isCust;
                }
                fin.close();
	}
	
        public Customer parseCustomer(String buff){
            String[] pString = buff.split(";");
            Customer temp = new Customer(pString[0],pString[1],pString[2]);
            return temp;
        }
        
        public void parseOrder(String buff){
//            System.out.println(buff);
        }
                
	public Double deliveryTime(){
		Double deliveryETA = 0.0;
		return deliveryETA;
	}
	
}
