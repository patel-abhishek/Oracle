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
public class OrderItem {

           WoodItem item;
           float quantity;
           double totalTime;
           double totalPrice;
           float mf;
//Constructors           
        public OrderItem(){
            this.item=new WoodItem();
            this.quantity=0;
            this.totalPrice=0;
            this.totalTime=0;
            this.mf=1;
        }
        
        public OrderItem(WoodItem item, float quantity){
            this.item=item;
            this.quantity=quantity;
            this.mf=1;
            if(quantity>100 && quantity<=200){
                this.mf=2;
            }
            else if(quantity>200 && quantity<=300){
                this.mf=3;
            }
            else if(quantity>300 && quantity<=400){
                this.mf=4;
            }
            else if(quantity>400 && quantity<=500){
                this.mf=5;
            }
            else if(quantity>500 && quantity<=1000){
                this.mf=(float) 5.5;
            }
            this.totalTime = (float) (this.mf * this.item.getBaseDeliveryTime());
//               System.out.println("time:"+this.mf);
            this.totalPrice = (float) (item.price * quantity);
        } 
//  getters      
    public WoodItem getItem() {
        return item;
    }

    public float getQuantity() {
        return quantity;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
// Display
    public void printOrder(){
        System.out.println(item.getType()+"\t"+quantity+" bf"+ "\t$"+totalPrice);
    }
}
