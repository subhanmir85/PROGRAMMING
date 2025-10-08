package sp25_bcs_106;
public class Seat{


	private String seatID;
	private Seattype type;
	private double price;
	private boolean isAvailable; 


	public Seat(String ID,Seattype t,Boolean isAvailable, double p){
         this.type=t;
         this.seatID=ID; 
         this.isAvailable=isAvailable;
         this.price=p;
     
    }


public String toString(){
return String.format("\t SEAT ID:%-5s \t SEAT TYPE:%-5s\t AVAILABILITY:%b \t PRICE:%.2f \n ",getseatID(),gettype(),getisAvailable(),getprice());


}
public String getseatID(){
          return this.seatID;
}

public Seattype gettype(){
          return this.type;
}

public double getprice(){
          return this.price;
}

public boolean getisAvailable(){
          return this.isAvailable;
}

public boolean bookSeat(){
     return this.isAvailable=false;
}

public boolean cancelBooking(){
    return  this.isAvailable=true;
     
}

public void setSeatType(Seattype type){
           this.type=type;
}

public void setPrice(double p){
	this.price=p;

}
}

