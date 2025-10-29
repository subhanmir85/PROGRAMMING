public class Cornerplot extends Plot {
    //==== Constructor for rectangular corner plot====//
    public Cornerplot(String id, Plotshape shape, Plottype type, boolean avail, double width, double depth) {
        super(id, shape, type, avail, width, depth);
        this.price += (price*8)/100;
	
    }

    //==== Constructor for trapezoid corner plot====///
    public Cornerplot(String id, Plotshape shape, Plottype type, boolean avail, double front, double back, double depth) {
        super(id, shape, type, avail, front, back, depth);
        this.price += (price*8)/100;
    }

    //=== Constructor for L-shaped corner plot===//
    public Cornerplot(String id,  Plotshape shape,Plottype type, boolean avail, double w1, double w2, double d1, double d2) {
        super(id, type, shape, avail, w1, w2, d1, d2);
         this.price += (price*8)/100;
    }

public double calarea(Plotshape shape){
double area=0;
if(shape==Plotshape.RECTANGLE){
  area=( width)*depth;
area+=(area*2)/100;}
else if(shape==Plotshape.TRAPEZOID){
  area=(((front) + back) / 2) *depth;
area+=(area*2)/100;}

else if(shape==Plotshape.L_SHAPED){
 area=((w1) * d1) + ((w2) * d2);
area+=(area*2)/100;}
return area;

}

    @Override
    public String toString() {
        return super.toString() + " (Corner Plot)";
    }
}
