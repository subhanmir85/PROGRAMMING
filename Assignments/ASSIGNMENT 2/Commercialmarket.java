public class Commercialmarket{

private Shop[] shops=new Shop[12];

Commercialmarket(){

for(int i=0;i<shops.length;i++){
	shops[i]=new Shop(Plottype.COMM_SHOP,String.format("%s",i+1));
}

}

public String toString(){
StringBuilder str=new StringBuilder();
			str.append("ID\t\tTYPE\t\tPRICE\n");
		for(int i=0;i<shops.length;i++){
		str.append(shops[i].toString()+"\n");
}
return str.toString();
}
}