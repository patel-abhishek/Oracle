/**
 * 
 */
package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.OrderItem;
import model.WoodItem;

/**
 * @author Esteban
 * @author Abhishek
 */
public class HardwoodSeller {

    public static HashMap pTable;
    public static HashMap dTable;
    public static double maxDuration;
    ArrayList<OrderItem> oItem;
    Customer customer;
    double totalPrice;
	/**
	 * @param args
	 */
 
	public static void main(String[] args) {
                initializeHashMap(); 
                maxDuration=0;
//                customer = new Customer();
                HardwoodSeller hws=new HardwoodSeller();
            try {
                hws.readInputFile(args[0]);
            } catch (IOException ex) {
                Logger.getLogger(HardwoodSeller.class.getName()).log(Level.SEVERE, null, ex);
            }          
	}
	/*
        *Read from file and print bill for each customer 
        */
	public void readInputFile(String inputFilePath) throws IOException{
		FileInputStream fin = new FileInputStream(inputFilePath);
                BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                String buff;
                int isCust=0;            
//                Customer customer;
//                ArrayList<OrderItem> oItem=new ArrayList<OrderItem>();
                while((buff = br.readLine())!=null){
                    /*Parse and print the customer info*/
                    if(isCust==0){
                        customer=parseCustomer(buff);
                        System.out.println(customer.showCustomer());   
                    }
                    /*Parse the order, print it along wiht max duration*/
                    else{                        
                        oItem = parseOrder(buff);
                        maxDuration = deliveryTime();
                        printResults();
                    }
                    isCust=1-isCust;                 
                }
                fin.close();
        }
        /*
         *Parse String into customer info
         */
        public Customer parseCustomer(String buff){
            String[] pString = buff.split(";");
            Customer temp = new Customer(pString[0],pString[1],pString[2]);
            return temp;
        }
        /*
         *Parse String into order format
         */
        public ArrayList<OrderItem> parseOrder(String buff){
            String[] oString = buff.split(";");
            ArrayList<OrderItem> items=new ArrayList<OrderItem>();
            int i=0;
            for(i=0;i<oString.length;i++){
                String[] item=oString[i].split(":");
                double tempPrice = (double) pTable.get(item[0].toLowerCase());
                double tempDuration = (double) dTable.get(item[0].toLowerCase());                  
                WoodItem tempItem=new WoodItem(item[0],tempDuration,tempPrice);
                OrderItem tempOItem=new OrderItem(tempItem,Float.parseFloat(item[1]));
                items.add(tempOItem);
            }
            return items;
        }
           /*
            *Calculate delivery time while printing the items one by one
            */       
	public Double deliveryTime(){
		int i=0;
                totalPrice = 0.0;
                maxDuration=0.0;
                System.out.println("Item name \t Quanitity\t Price");
                for(i=0;i<oItem.size();i++){
                    oItem.get(i).printOrder();
//                       System.out.println("time:"+oItem.get(i).getTotalTime());
                    if(oItem.get(i).getTotalTime()>maxDuration){
                        maxDuration = oItem.get(i).getTotalTime();                     
                    }
                    totalPrice+=oItem.get(i).getTotalPrice();
                }                        
		return maxDuration;
	}
        /*
         *Print final result for each customer
         */
        public void printResults(){
            System.out.println("Total price of order is: $"+totalPrice);
            System.out.println("Total estimated time of order is: "+maxDuration+" hours");
            System.out.println("--------------------------------------------------------");
            System.out.println("");
        }
	/*
         *Inititalize hashmap containing base price and base delivery time
         */
        public static void initializeHashMap(){
            pTable=new HashMap();
                pTable.put("cherry",5.95);
                pTable.put("curly maple",6.00);
                pTable.put("genuine mahogany",9.60);
                pTable.put("wenge",22.35);
                pTable.put("white oak",6.70);
                pTable.put("sawdust",1.5);                        
                dTable=new HashMap();
                dTable.put("cherry",2.5);
                dTable.put("curly maple",1.5);
                dTable.put("genuine mahogany",3);
                dTable.put("wenge",5);
                dTable.put("white oak",2.3);
                dTable.put("sawdust",1);
        }
}
