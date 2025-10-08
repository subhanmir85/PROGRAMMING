package sp25_bcs_106;
public class Screen{

private double price_premium=750;
private int num_of_rows;
private Seat[][] seats;
private double price_recliner=1250;
private String screenName;
private double price_vip=1000;
private double price_regular=750;

Screen(String name){
			screenName=name;
			seats=new Seat[5][];
			for(int i=0;i<seats.length;i++){
				seats[i]=new Seat[5+i];
				for(int j=0;j<seats[i].length;j++){
					seats[i][j]=new Seat(String.format("R%d-%03d",i+1,j+1),seattype(i,j),true,priceFor(seattype(i,j)));
			}
}	
}

	public String toString(){
      		StringBuilder str=new StringBuilder();
		str.append(screenName);
		for(int i=0;i<seats.length;i++)
			for(int j=0;j<seats[i].length;j++)
				str.append("\n"+seats[i][j].toString());	
		return str.toString();
}

//===== SEAT TYPE===//
public Seattype seattype(int r,int s){
	for(int i=0;i<seats.length;i++){
            for(int j=0;j<seats[i].length;j++){
               if(r<=1){
                  return Seattype.REGULAR;
}
               if(r==2){
                  return Seattype.PREMIUM;
}
               if(r==3){
                  return Seattype.VIP;
}
               if(r==4){
                  return Seattype.RECLINER;
}

}
}
                  return null;
}

//====	PRICE =====///

public double priceFor(Seattype s){                          
       if(s==Seattype.REGULAR)
            return price_regular;
      else if(s==Seattype.PREMIUM)
            return price_premium;
      else if(s==Seattype.VIP)
            return price_vip;
      else if(s==Seattype.RECLINER)
            return price_recliner;
      else 
            return 0;
}




//======CANCEL======////

public boolean cancel(int r,int s){
r--;
s--;
		if(!seats[r][s].getisAvailable()){
			seats[r][s].cancelBooking();
				return true;
		}
		else{ 
		      return false;
}
}
//======= SCREEN NAME=====//
public String getScreenName(){
return screenName;
}

//======AVAILABLE SEAT COUNT====///
public int getAvailableSeatCount(){
int available=0;
for(int i=0;i<seats.length;i++){
	for(int j=0;j<seats[i].length;j++){
		if(seats[i][j].getisAvailable()){
			available++;
}
}
}

return available;
}

///======ROW TYPE=====//
public void setRowType(int r,Seattype t, double p){
r--;
                               for(int i=0;i<seats[r].length;i++){
                    seats[r][i].setSeatType(t);
                    seats[r][i].setPrice(p);
}
}
//======= GET SEAT====///
public Seat getseat(int r,int s){
r--;
s--;
	return seats[r][s];
}
//=== BOOKED====////
public boolean booked(int r,int s){
	r--;
	s--;
	if(seats[r][s].getisAvailable()){
		seats[r][s].bookSeat();

		return false;
}
	else{
		return true;
}
}

///=====TOTAL SEAT ===//
int gettotalseatcount(){
	int totalseats=0;
for(int i=0;i<seats.length;i++){
for(int j=0;j<seats[i].length;j++){
	totalseats++;
}
}
return totalseats;
}

//====AVAILABLE SEAT TYPE===///
int getavailableseattype(Seattype t){

 int availableSeat=0;
            for(int i=0;i<seats.length;i++){
            for(int j=0;j<seats[i].length;j++){
                  if(seats[i][j].getisAvailable() && seats[i][j].gettype()==t){
                     availableSeat++;
}
}
}
              return availableSeat;
}

//=====GET FIRST AVAILABLE====//
public Seat getFirstAvailableSeat(Seattype s){              
                   for(int i=0;i<seats.length;i++){
            for(int j=0;j<seats[i].length;j++){
                 if(seats[i][j].getisAvailable()&& seats[i][j].gettype()==s){
                     return seats[i][j];
}
}
}        
                 return null;
}

/// ======GET ROW count====//
public int getRowcount(){
	 int count=0;
         for(int j=0;j<seats.length;j++){
         count++;
}
      return count;
}



//===== ROW LENGTH====///
public int getRowLength(int r){                       
r--;
      int count=0;
         for(int j=0;j<seats[r].length;j++){
         count++;
}
      return count;
}



//==== 	LIST AVAILABLE ===//
public Seat[] getListAvailableSeat(Seattype s) {
    int count = 0;
    for (int i=0;i<seats.length;i++) {
        for (int j=0;j<seats[i].length;j++) {
            if (seats[i][j].getisAvailable() && seats[i][j].gettype() == s) {
                count++;
    }
    }
    }
    Seat[] list = new Seat[count];
    int index = 0;
    for (int i=0;i<seats.length;i++) {
        for (int j=0;j<seats[i].length;j++) {
            if (seats[i][j].getisAvailable() && seats[i][j].gettype() == s) {
                list[index]=seats[i][j];
                index++;
    }
    }
    }

    return list;
}
///====DISPLAY===///
 public void displaylayout(){
             for(int i=0;i<seats.length;i++){
            for(int j=0;j<seats[i].length;j++){
                System.out.print("[ "+seats[i][j].getseatID() +seats[i][j].getisAvailable()+"]");
}
              System.out.println();
}
              System.out.println("Total : "+gettotalseatcount()+", Available : "+getAvailableSeatCount());
}



}





		









