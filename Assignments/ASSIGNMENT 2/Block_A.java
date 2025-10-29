import java.util.Random;
public class Block_A{
private String blockname;
private String[] stname;
public Plot[][] p1;
Park[] parks=new Park[2];
 Commercialmarket c=new  Commercialmarket();

 Block_A(String bn){
this.blockname=bn;
p1=new Plot[5][];
for(int i=0;i<parks.length;i++){
parks[i]=new Park(Plotshape.RECTANGLE,15,15);
}

for(int i=0;i<p1.length;i++){
	p1[i]=new Plot[10+i];
		for(int j=0;j<p1[i].length;j++){
			if(p1[i]==p1[0]){
				p1[i][j]=new Plot(String.format("%d-00%d",i+1,j+1),Plotshape.RECTANGLE,Plottype.RES_5_MARLA,true,20,12);
				if(p1[i][j]==p1[0][4]){
					p1[i][j]=new Plot(String.format("%d-00%d",i+1,j+1),Plotshape.RECTANGLE,Plottype.PARKING,true,20,12); }
					if (p1[i][j]==p1[0][3]){
						p1[i][j]=new Cornerplot(String.format("%d-00%d",i+1,j+1),Plotshape.RECTANGLE,Plottype.RES_5_MARLA,true,20,12);}
					}

			else if(p1[i]==p1[1]){
				p1[i][j]=new Plot(String.format("%d-00%d",i+1,j+1),Plotshape.RECTANGLE,Plottype.RES_10_MARLA,true,20,15);
					
					if(p1[i][j]==p1[1][4]){
					p1[i][j]=new Plot(String.format("%d-00%d",i+1,j+1),Plotshape.RECTANGLE,Plottype.PARKING,true,20,12); }
						if (p1[i][j]==p1[1][3]){
						p1[i][j]=new Cornerplot(String.format("%d-00%d",i+1,j+1),Plotshape.RECTANGLE,Plottype.RES_10_MARLA,true,20,15);}
								}

			else if(p1[i]==p1[2]){
				p1[i][j]=new Plot(String.format("%d-00%d",i+1,j+1),Plotshape.TRAPEZOID,Plottype.RES_1_KANAL,true,20,30,50);
					if(p1[i][j]==p1[2][4]){
					p1[i][j]=new Plot(String.format("%d-00%d",i+1,j+1),Plotshape.RECTANGLE,Plottype.PARKING,true,20,12);}
						if (p1[i][j]==p1[2][3]){
						p1[i][j]=new Cornerplot(String.format("%d-00%d",i+1,j+1),Plotshape.TRAPEZOID,Plottype.RES_1_KANAL,true,20,30,50);}
						}
			
			else if(p1[i]==p1[3]){
				p1[i][j]=new Plot(String.format("%d-00%d",i+1,j+1),Plotshape.RECTANGLE,Plottype.COMM_SHOP,true,20,26);
					if(p1[i][j]==p1[3][4]){
					p1[i][j]=new Plot(String.format("%d-00%d",i+1,j+1),Plotshape.RECTANGLE,Plottype.PARKING,true,20,12);}
						}
			
			else if(p1[i]==p1[4]){
				p1[i][j]=new Plot(String.format("%d-00%d",i+1,j+1),Plotshape.RECTANGLE,Plottype.COMM_OFFICE,true,20,50);
					if(p1[i][j]==p1[4][4]){
					p1[i][j]=new Plot(String.format("%d-00%d",i+1,j+1),Plotshape.RECTANGLE,Plottype.PARKING,true,20,12);}
						}


}
}
}

public void shuffle(){
Random random=new Random();
for(int i=0;i<p1.length;i++){
for(int j=0;j<p1[i].length;j++){
int ran=random.nextInt(p1[i].length);
Plot temp=p1[i][ran];
p1[i][ran]=p1[i][j];
p1[i][j]=temp;
p1[i][j].booking();
}
}
}
public  void checkavailability(String t ){

Plot listbook[][]=new Plot[5][];
Plot listavail[][]=new Plot[5][];
for(int i=0;i<p1.length;i++){
	listbook[i]=new Plot[p1[i].length];
	listavail[i]=new Plot[p1[i].length];
	for(int j=0;j<p1[i].length;j++){
		if(!p1[i][j].Availability&&p1[i][j].ID.equals(t)){
			listbook[i][j]=p1[i][j];
						}
			else
				listavail[i][j]=p1[i][j];
					}
			}
for(int i=0;i<listbook.length;i++){
		for(int j=0;j<listbook[i].length;j++){
			if(listbook[i][j]!=null){
			System.out.println(listbook[i][j]);}
			
						}	
			
				}
			
for(int i=0;i<listavail.length;i++){
		for(int j=0;j<listavail[i].length;j++){
if(listavail[i][j]!=null)
			System.out.println(listavail[i][j]);
}
}

}


	
@Override
public String toString(){
StringBuilder str=new StringBuilder();
str.append("\n");
str.append(blockname);
for(int i=0;i<p1.length;i++){
str.append("\nPLOT ID\t  TYPE\t\t PRICE\t\t SHAPE\t\t AREA\t\tAVAILABILITY");
	for(int j=0;j<p1[i].length;j++){
		str.append("\n"+p1[i][j].toString());
		str.append("\n");
}
}

str.append("\n\t\t\t//======AMENITIES======//");
for(int k=0;k<parks.length;k++){
str.append("\n\n\t\t\tPARK "+(k+1)+"\nSHAPE\t\t\t  AREA\n");
str.append(parks[k].toString()+"\n");
}

str.append("\n\n\t\t\tMARKET\n");
str.append(c.toString());


return str.toString();



}
}
