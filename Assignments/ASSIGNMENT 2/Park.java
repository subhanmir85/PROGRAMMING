public class Park{

private Plotshape shape;
private double length,width;

Park(Plotshape s,double w,double l){
this.shape=s;
this.width=w;
this.length=l;
}

public double calarea(){
return  width*length;
}

@Override

public String toString(){
return String.format("%s\t\t %.0f sq yd",shape,calarea());

}
}
