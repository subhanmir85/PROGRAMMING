public class PlotDemo{

public static void main(String args[]){

Plot p1=new Plot(String.format("%d-00%d",3,1),Plotshape.TRAPEZOID,Plottype.RES_10_MARLA,true,20,20,8);

System.out.println(p1);
p1.booking();

System.out.println(p1);

}
}