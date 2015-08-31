/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Abhishek
 */
public class Customer {

    String name;
    String address;
    String date;
//Constructors
    public Customer(){
        this.name = "foo";
        this.address = "bar";
        this.date = "1/1/1";
    }
  
    public Customer(String name, String address, String Date){
        this.name=name;
        this.address= address;
        this.date = Date;
    }
//  Get info
    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
//Print customer info
    public String showCustomer(){
        return "Customer: "+this.name+"\n"+"Address: "+this.address+"\n"+"Date: "
                +this.date+"\n";
    }
}
