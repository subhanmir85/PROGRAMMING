public class Housingsociety{
	private char letter;
	private int counter=0;
	private int totalblocks;
	private String name;
	private Block_A b[];
Housingsociety(String n,int tb){
	this.totalblocks=tb;
	b=new Block_A[totalblocks];
	this.name=n;
	for(int i=0;i<2;i++){
		letter = (char) (65 + i);
		b[i]=new Block_A(String.format("%s %c","BLOCK",letter));
			counter++;	
		}
	}



public String toString(){
	StringBuilder str=new StringBuilder();
	str.append("\n"+name);
	for(int i=0;i<counter;i++){
		str.append(b[i].toString());
			}
return str.toString();
		
}
public void addblock(int newblocks){
		
	for(int i=0;i<newblocks;i++){
		if(b.length==counter){
Block_A bigger[]=new Block_A[b.length+1];

	for(int j=0;j<b.length;j++){
		bigger[j]=b[j];}
b=bigger;
	}

		letter = (char) (67+ i);
		b[counter]=new Block_A(String.format("%s %c","BLOCK",letter));
			counter++;
		}
}
public void shuffled(){
	for(int i=0;i<counter;i++){
		b[i].shuffle();
}
}



}