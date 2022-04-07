package waterBillingSys;

class HelloWorld {
    public static void main(String[] args) {
    String months[] ={"Jan", "Feb", "March", "April","May","Jun","July","Aug","Sep","Oct","Nov","Dec"};
    String years[] = {"2022","2023"};
         for (int i=0; i<12;i++){
        	 for (int j =0;j<2;j++) {
        		 if (months[i]=="Jan" && years[j] == "2022") {
        			 continue;
        		 }
        		 else {
        			 System.out.println(months[i]+years[j]);
        		 }
        		 
        	 }
        }
    }
}
