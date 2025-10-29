public class Shop{

private String id;
private double price;
private Plottype type;


Shop(Plottype t, String id){
this.id=id;
this.price=t.plotprice();
this.type=t;
}

@Override
public String toString(){
return String.format("%s\t\t  %s\t\t %.0f",id,type,price);
}
}