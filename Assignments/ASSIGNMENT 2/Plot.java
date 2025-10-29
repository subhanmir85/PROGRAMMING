public class Plot{

public String ID;
public Plottype type;
protected double price;
public boolean Availability;
protected double width,depth;
protected double front,back;
protected double w1,w2,d1,d2;
private double area;
private Plotshape shape;
//======FOR RECTANGLE====///
Plot(String id,Plotshape shape, Plottype type, boolean avail,double width,double depth){

this.ID=id;
this.type=type;
this.price=type.plotprice();
this.Availability=avail;
this.width=width;
this.depth=depth;
this.shape=shape;
this.area=calarea(shape);
}
//====FOR L SHAPED====///
Plot(String id, Plottype type,Plotshape shape,  boolean avail,double w1,double w2,double d1,double d2){

this.ID=id;
this.type=type;
this.price=price;
this.Availability=avail;
this.w1=w1;
this.w2=w2;
this.d1=d1;
this.d2=d2;
this.shape=shape;
this.area=calarea(shape);
}

//=====FOR TRAPEZOID===///
Plot(String id,Plotshape shape, Plottype type, boolean avail,double front , double back,double depth){

this.ID=id;
this.type=type;
this.price=type.plotprice();
this.Availability=avail;
this.shape=shape;
this.front=front;
this.back=back;
this.depth=depth;
this.area=calarea(shape);
}



@Override
public String toString(){
return String.format("%s\t %s\t %.0fPKR\t %s\t %.0f sq yd \t%s",ID,type,price,shape,area,CheckAvailability(Availability));
}



public boolean booking(){
return Availability=false;
}

public boolean cancel(){
return Availability=true;
}

 public String CheckAvailability(boolean a){
	if(a==false)
		 return "Booked";
        else
		return "Available";
}


public double calarea(Plotshape shape){
double area=0;
if(shape==Plotshape.RECTANGLE){
  area= width*depth;}

else if(shape==Plotshape.TRAPEZOID){
  area=((front + back) / 2) *depth;}

else if(shape==Plotshape.L_SHAPED){
 area=(w1 * d1) + (w2 * d2);}


return area;

}






}