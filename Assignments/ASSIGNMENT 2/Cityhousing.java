public class Cityhousing{
	private String name;
	private int newblock;
	private Housingsociety society[]=new Housingsociety[2];
	Cityhousing(String n,int nb){
	newblock=nb;
	this.name=n;
	for(int i=0;i<society.length;i++){
		society[i]=new Housingsociety(String.format("%s-%s","LDA",i+1),10);
		society[i].addblock(newblock);
				}
	}


public String toString(){
	StringBuilder str=new StringBuilder();
	str.append("\n"+name);
	for(int i=0;i<society.length;i++){
		str.append(society[i].toString());
		}
	return str.toString();
	}
public void display(){
	for(int i=0;i<society.length;i++){
		society[i].shuffled();
}
}
}