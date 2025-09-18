import java.util.*;

class Burger{
	public static int bp=500;
	public static int count=0;
	
	private String Oderid;
	private String Cusid;
	private String Cusname;
	private int Oderqnt;
	private int Odervalue;
	private int Status;
	
	public static final int PREPARING=0;
	public static final int DELIVERED=1;
	public static final int CANCELED=2;

	
	public Burger(){
	
	}
	
	public Burger(String Oderid,String Cusid,String Cusname,int Oderqnt,int Odervalue){
		this.Oderid=Oderid;
		this.Cusid=Cusid;
		this.Cusname=Cusname;
		this.Oderqnt=Oderqnt;
		this.Odervalue=Odervalue;
		this.Status=Status;
	}
	
	public String getOderid(){
		return Oderid;
	}
	public String getCusid(){
		return Cusid;
	}
	public String getCusname(){
		return Cusname;
	}
	public int getbrgQnt(){
		return Oderqnt;
	}
	public int getStatus(){
		return Status;
	}
	public void setCusid(){
		this.Cusid=Cusid;
	}
	public void setbrgQnt(int Oderqnt){
		this.Oderqnt=Oderqnt;
	}
	public void setStatus(int Status){
		this.Status=Status;
	}
	public void setOder(String Oderid,String Cusid,String Cusname,int Oderqnt){
		this.Oderid=Oderid;
		this.Cusid=Cusid;
		this.Cusname=Cusname;
		this.Oderqnt=Oderqnt;
		this.Odervalue=Oderqnt*bp;
		this.Status=Status;
	}
}

class iHungry2V{
		public static Burger[] brg=new Burger[Burger.count];
		public static int j=0;
		public static int call;

		public static void main(String args[]){
			
			
			L1:do{
				clearConsole();
				Scanner input=new Scanner(System.in);
				System.out.println("-------------------------------------------------------------");
				System.out.println("|                   iHungry Burger(v2.0)                    |");
				System.out.println("-------------------------------------------------------------");
				
				System.out.print("\n\n[1] Place Oder");
				System.out.println("\t\t[2] Search Best Customer");
				System.out.print("[3] Search Oder");
				System.out.println("\t\t[4] Search Customer");
				System.out.print("[5] View Oder");
				System.out.println("\t\t[6] Update Oder Details");
				System.out.println("[7] Exit");
				
				System.out.print("\nEnter Option To Continue > ");
				int op=input.nextInt();
				
				switch (op){
					case 1:
						placeOder();
					break;
					
					case 2:
						searchBestCustomer();
					break;
					
					case 3:
						searchOder();
					break;
					
					case 4:
						searchCustomer();
					break;
					
					case 5:
						viewOder();
					break;
					
					case 6:
						updateoderDetails();
					break;
					
					case 7:
						return;
				}
			}while(true);
		}
		
		public static void placeOder(){
			Scanner input=new Scanner(System.in);
			
			String Oderid=genOderId();
			L1:do{
				clearConsole();
				System.out.println("-----------------------------------------------------");
				System.out.println("|                     PLACE ODER                    |");
				System.out.println("-----------------------------------------------------");
				System.out.print("ODER ID - "+Oderid);
				System.out.println("\n");
				System.out.println("================");
			Q1:do{
				System.out.print("Enter Customer ID(Phone No.: ");
				String Cusid=input.next();
				input.nextLine();
				if(!isValidCustomerId(Cusid)){
			L2:do{
					System.out.println("Invalid customer id...");
					System.out.print("Do you want to enter phone number again (Y/N) : ");
					char op=input.next().charAt(0);
					System.out.println(" ");
					if(op=='Y'|op=='y'){
						continue Q1;
					}else if(op=='N'|op=='n'){
						break L1;
					}else{
						System.out.println("Invalid option/ try again...");
						continue L2;
					}
				}while(true);
			}

				System.out.print("Customer Name: ");
				String Cusname=input.nextLine();
				R1:do{
					System.out.print("Enter Burger Quantity: ");
					int Oderqnt=input.nextInt();
					if (Oderqnt<=0){
						System.out.println("\nWrong Buger Quantity enter quantity again....\n");
						continue R1;
					}
				System.out.println("Total Value: "+(Oderqnt*Burger.bp));
				L2:do{
					System.out.print("\t\tAre you confirm oder(Y/N) -> ");
					char op=input.next().charAt(0);
					if (op=='Y'|op=='y'){
						System.out.println("\n\t\tYour oder is enter to the system successfully....");
						burgerExtend();
						brg[j] = new Burger();
						brg[j].setOder(Oderid,Cusid,Cusname,Oderqnt);

						++j;
						X1:do{
						System.out.print("\nDo you want enter another oder(Y/N) -> ");
							char op2=input.next().charAt(0);
							if (op2=='Y'|op2=='y'){
								Oderid=genOderId();
								continue L1;
							}else if (op2=='N'|op2=='n'){
								break L1;
							}else{
								System.out.println("Wrong input try again......");
								continue X1;
							}
						}while(true);
					}else if (op=='N'|op=='n'){
						System.out.println(" ");
						continue Q1;
					}else{
						System.out.println("Wrong input try again......");
						continue L2;
					}
						}while(true);
					}while(true);
				} while (true);
			} while (true);
		}
		
		public static String genOderId(){
			int newid=Burger.count+1;
			Burger.count++;
			String OderID;
			if (newid<10){
				OderID="B000"+newid;
			}else if (newid<100){
				OderID="B00"+newid;
			}else if (newid<1000){
				OderID="B0"+newid;
			}else{
				OderID="B"+newid;
			}
			return OderID;
		}
		
		public static void burgerExtend(){
			Burger[] tempBurgerar=new Burger[brg.length+1];
			for (int i=0; i<brg.length;i++){
				tempBurgerar[i]=brg[i];
			}
			brg=tempBurgerar;
		}
		
		public static boolean isValidCustomerId(String custId){
		if(custId.length()!=10){
			return false;
		}
		if(custId.charAt(0)!='0'){
			return false;
		}
		for(int i=1; i<custId.length(); i++){
			if(custId.charAt(i)<48 || custId.charAt(i)>57){
				return false;
			}
		}
		return true;
	}

		public static void searchBestCustomer(){
			L1:do{
				Scanner input=new Scanner(System.in);
				clearConsole();
				System.out.println("-----------------------------------------------------");
				System.out.println("|                    Best Customer                  |");
				System.out.println("-----------------------------------------------------\n");
				String[] custArray=new String[0];
				for (int i = 0; i < brg.length; i++){
					if(!search(custArray,brg[i].getCusid())){
						String[] tempCustArray=new String[custArray.length+1];
						for (int j = 0; j < custArray.length; j++){
							tempCustArray[j]=custArray[j];
						}
						custArray=tempCustArray;
						custArray[custArray.length-1]=brg[i].getCusid();
					}
				}
				String[] cusnameArray=new String[0];
				for (int i = 0; i < brg.length; i++){
					if(!search(custArray,brg[i].getCusname())){
						String[] tempCustnameArray=new String[cusnameArray.length+1];
						for (int j = 0; j <cusnameArray.length; j++){
							tempCustnameArray[j]=cusnameArray[j];
						}
						cusnameArray=tempCustnameArray;
						cusnameArray[cusnameArray.length-1]=brg[i].getCusname();
					}
				}
				
				int[] totalAmount=new int[custArray.length];
				
				for(int i=0; i<custArray.length; i++){
					int total=0;
					for(int j=0; j<brg.length; j++){
						if(brg[j].getCusid().equalsIgnoreCase(custArray[i])){
							total+=(brg[i].getbrgQnt()*Burger.bp);
						}
					}
					totalAmount[i]=total;
				}
				
				for (int i = 0; i <custArray.length-1 ; i++){
					for (int j = 0; j <custArray.length-1 ; j++){
						if(totalAmount[j]<totalAmount[j+1]){
							int tempTotal=totalAmount[j];
							totalAmount[j]=totalAmount[j+1];
							totalAmount[j+1]=tempTotal;
							
							String tempId=custArray[j];
							custArray[j]=custArray[j+1];
							custArray[j+1]=tempId; 
							
							String tempName=cusnameArray[j];
							cusnameArray[j]=cusnameArray[j+1];
							cusnameArray[j+1]=tempName; 
						}
					}
				}
				
				System.out.println("CustId\t\tName\t\tTotal Amount");
				System.out.println("============================================");
				for(int i=0; i<totalAmount.length; i++){
					System.out.println(custArray[i]+"\t"+cusnameArray[i]+"\t\t"+totalAmount[i]);
					System.out.println("--------------------------------------------");
				}
				L2:do{
						System.out.print("\n\nDo you want to main menu (Y/N) : ");
						char op=input.next().charAt(0);
						if(op=='N'|op=='n'){
							continue L1;
						}else if(op=='Y'|op=='y'){
							break L1;
						}else{
							System.out.println("Invalid option/ try again...");
							continue L2;
						}
					}while(true);
				}while(true);
			}
		public static boolean search(String[] ar, String custId){
			for (int i = 0; i < ar.length; i++){
				if(ar[i].equalsIgnoreCase(custId)){
					return true;
				}
			}
			return false;
		}
		
		public static void searchOder(){
			Scanner input=new Scanner(System.in);
		L1:do{
			clearConsole();
			System.out.println("-----------------------------------------------------");
			System.out.println("|                    Search Oder                    |");
			System.out.println("-----------------------------------------------------");
			System.out.print("\nEnter oder ID - ");
			String oderID=input.next();
			int index=indexOf(oderID);
			if(index==-1){
				System.out.println();
				System.out.println("-- "+oderID+" -- is Invalid Oder ID...");
				System.out.println();
				L2:do{
					System.out.print("Do you want to search again(Y/N) : ");
					char op=input.next().charAt(0);
					if(op=='Y'|op=='y'){
						continue L1;
					}else if(op=='N'|op=='n'){
						break L1;
					}else{
						System.out.println("Wrong option/try again...");
						continue L2;
					}
				}while(true);
			}
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.println("OderID\t\tCustomerID\t\tName\t\tQuantity\tOrderValue\tOderStatus ");
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.print(oderID+"\t\t"+brg[call].getCusid()+"\t\t"+brg[call].getCusname()+"\t\t"+brg[call].getbrgQnt()+"\t\t"+brg[call].getbrgQnt()*Burger.bp+"\t\t"+brg[call].getStatus());
			if (brg[call].getStatus()==0){
				System.out.print(" (PREPARING)");
			}else if (brg[call].getStatus()==1){
				System.out.print(" (DELIVERED)");
			}else if (brg[call].getStatus()==2){
				System.out.print(" (CANCELED)");
			}
			System.out.println("\n---------------------------------------------------------------------------------------------------");
			System.out.println();
			L2:do{
				System.out.print("\tDo you want to search anothe oder(Y/N) : ");
					char op=input.next().charAt(0);
					if(op=='Y'|op=='y'){
						continue L1;
					}else if(op=='N'|op=='n'){
						break L1;
					}else{
						System.out.println("Wrong option/try again...");
						continue L2;
					}
				}while(true);
			}while(true);
		}
		
		public static int indexOf(String name){
			for(int i=0; i<brg.length; i++){
				if(name.equalsIgnoreCase(brg[i].getOderid())){
					call=i;
					return i;
				}
			}
			return -1;
		}
		public static void searchCustomer(){
			Scanner input=new Scanner(System.in);
			L1:do{
				clearConsole();
				System.out.println("-----------------------------------------------------");
				System.out.println("|              Search Customer Details               |");
				System.out.println("-----------------------------------------------------");
				System.out.print("\nEnter Customer ID(Phone number) - ");
				String cuspNum=input.next();
				int index=indexOfcus(cuspNum);
				if(index==-1){
					System.out.println();
					System.out.println("\n\t-- "+cuspNum+" -- this Customer ID is not added yet...\n");
					System.out.println();
					L2:do{
						System.out.print("Do you want to search again(Y/N) : ");
						char op=input.next().charAt(0);
						if(op=='Y'|op=='y'){
							continue L1;
						}else if(op=='N'|op=='n'){
							break L1;
						}else{
							System.out.println("Wrong option/try again...");
							continue L2;
						}
					}while(true);
				}
				System.out.println("\n\nCustomer ID - "+brg[call].getCusid());
				System.out.println("Name        - "+brg[call].getCusname());
				System.out.println("\nCustomer Oder Details");
				System.out.println("=======================\n");
				System.out.println("--------------------------------------");
				System.out.println("Oder_ID    Oder_Quantity   Total_Value");
				System.out.println("--------------------------------------");
				for (int i = 0; i <brg.length; i++){
					if(cuspNum.equalsIgnoreCase(brg[i].getCusid())){
						System.out.println(brg[i].getOderid()+"\t\t"+brg[i].getbrgQnt()+"\t\t"+brg[i].getbrgQnt()*Burger.bp);
					}
				}
				System.out.println("--------------------------------------");
				L2:do{
				System.out.print("\n\tDo you want to search anothe Customer Details(Y/N) : ");
					char op=input.next().charAt(0);
					if(op=='Y'|op=='y'){
						continue L1;
					}else if(op=='N'|op=='n'){
						break L1;
					}else{
						System.out.println("Wrong option/try again...");
						continue L2;
					}
				}while(true);
			}while(true);
		}
		
		public static int indexOfcus(String cusID){
			for(int i=0; i<brg.length; i++){
				if(cusID.equalsIgnoreCase(brg[i].getCusid())){
					call=i;
					return i;
				}
			}
			return -1;
		}
		
		public static void viewOder(){
			Scanner input=new Scanner(System.in);
			L1:do{
			clearConsole();
			System.out.println("-----------------------------------------------------");
			System.out.println("|                     VIEW ORDER                     |");
			System.out.println("-----------------------------------------------------");
			System.out.println("\n[1] Delivered Oders");
			System.out.println("[2] Preparing Oders");
			System.out.println("[3] Canceled Oders");
			System.out.println("[4] main menu");
			System.out.print("Enter an option to continue -> ");
			int op=input.nextInt();
			switch (op){
				case 1:
				clearConsole();
					System.out.println("----------------------------------------------------------------");
					System.out.println("                        Delivered Oders                         ");
					System.out.println("----------------------------------------------------------------\n\n");
					System.out.println("----------------------------------------------------------------");
					System.out.println("OderID\t   CustomerID\t   Name\t       Quantity\t      OderValue");
					System.out.println("----------------------------------------------------------------");
					delevered();
				break;
				case 2:
				clearConsole();
					System.out.println("----------------------------------------------------------------");
					System.out.println("                        Preparing Oders                         ");
					System.out.println("----------------------------------------------------------------\n\n");
					System.out.println("----------------------------------------------------------------");
					System.out.println("OderID\t   CustomerID\t   Name\t       Quantity\t      OderValue");
					System.out.println("----------------------------------------------------------------");
					preparing();
				break;
				case 3:
				clearConsole();
					System.out.println("----------------------------------------------------------------");
					System.out.println("                         Canceled Oders                         ");
					System.out.println("----------------------------------------------------------------\n\n");
					System.out.println("----------------------------------------------------------------");
					System.out.println("OderID\t   CustomerID\t   Name\t       Quantity\t      OderValue");
					System.out.println("----------------------------------------------------------------");
					canceled();
				break;
				case 4:
					return;
			}
			L2:do{
				System.out.print("\n\tDo you want to view another oder status(Y/N) : ");
					char op2=input.next().charAt(0);
					if(op2=='Y'|op2=='y'){
						continue L1;
					}else if(op2=='N'|op2=='n'){
						break L1;
					}else{
						System.out.println("Wrong option/try again...");
						continue L2;
					}
				}while(true);
			}while(true);
		}
		
		public static void preparing(){
			for (int i = 0; i <brg.length; i++){
				if(Burger.PREPARING==(brg[i].getStatus())){
					System.out.println(brg[i].getOderid()+"      "+brg[i].getCusid()+"     "+brg[i].getCusname()+"         "+brg[i].getbrgQnt()+"              "+brg[i].getbrgQnt()*Burger.bp);
					System.out.println("----------------------------------------------------------------");
				}
			}
		}
		public static void delevered(){
			for (int i = 0; i <brg.length; i++){
				if(Burger.DELIVERED==(brg[i].getStatus())){
					System.out.println(brg[i].getOderid()+"      "+brg[i].getCusid()+"     "+brg[i].getCusname()+"         "+brg[i].getbrgQnt()+"              "+brg[i].getbrgQnt()*Burger.bp);
					System.out.println("----------------------------------------------------------------");
				}
			}
		}
		public static void canceled(){
			for (int i = 0; i <brg.length; i++){
				if(Burger.CANCELED==(brg[i].getStatus())){
					System.out.println(brg[i].getOderid()+"      "+brg[i].getCusid()+"     "+brg[i].getCusname()+"         "+brg[i].getbrgQnt()+"              "+brg[i].getbrgQnt()*Burger.bp);
					System.out.println("---------------------------------------------------------------");
				}
			}
		}
		
		public static void updateoderDetails(){
			Scanner input=new Scanner(System.in);
			L1:do{
				clearConsole();
				System.out.println("-----------------------------------------------------");
				System.out.println("|                 Update Oder Details               |");
				System.out.println("-----------------------------------------------------");
				System.out.print("\nEnter oder ID - ");
				String id=input.next();
				for(int i=0; i<brg.length; i++){
					if(id.equalsIgnoreCase(brg[i].getOderid())){
						if(brg[i].getStatus()==Burger.PREPARING){
							System.out.println("\nOderID       - "+brg[i].getOderid());
							System.out.println("CustomerID   - "+brg[i].getCusid());
							System.out.println("Name         - "+brg[i].getCusname());
							System.out.println("Quantity     - "+brg[i].getbrgQnt());
							System.out.println("OderValue    - "+brg[i].getbrgQnt()*Burger.bp);
							System.out.print("OderStatus   - "+brg[i].getStatus());
							if (brg[i].getStatus()==0){
								System.out.print("(PREPARING)\n\n");
							}

						L2:do{
							System.out.println("\nWhat do you want to uppdate ?");
							System.out.println("\t(01) Quantity");
							System.out.println("\t(02) Status");
							System.out.println("\t(03) Exit to update menu(if you are used this options one time plz exit for new update!)");
							System.out.print("\nEnter your option -> ");
							int op2=input.nextInt();
							switch (op2){
								case 1:
									clearConsole();
									QuantityEdit(brg[i].getOderid(),brg[i].getCusid(),brg[i].getCusname(),brg[i].getbrgQnt());
								break;
								case 2:
									StatusEdit(brg[i].getOderid(),brg[i].getCusid(),brg[i].getCusname(),brg[i].getStatus());
								break;
								case 3:
								break L1;
							}
						}while(true);
						}else if (brg[i].getStatus()==Burger.DELIVERED){
							System.out.println("\nThis oder is already DELEVERED.....You can't update this oder...");
							L2:do{
								System.out.print("\nDo you want to update another oder (Y/N) -> ");
								char op2=input.next().charAt(0);
								if(op2=='Y'|op2=='y'){
									continue L1;
								}else if(op2=='N'|op2=='n'){
									break L1;
								}else{
									System.out.println("Wrong option/try again...");
									continue L2;
								}
							}while(true);
							}else if (brg[i].getStatus()==Burger.CANCELED){
							System.out.println("\nThis oder is already CANCELED.....You can't update this oder...");
							L2:do{
								System.out.print("\nDo you want to update another oder (Y/N) -> ");
								char op2=input.next().charAt(0);
								if(op2=='Y'|op2=='y'){
									continue L1;
								}else if(op2=='N'|op2=='n'){
									break L1;
								}else{
									System.out.println("Wrong option/try again...");
									continue L2;
								}
							}while(true);
						}
					}
				}
			}while(true);
		}
		
		public static void QuantityEdit(String id,String cusid,String cusname,int quant){
			Scanner input=new Scanner(System.in);
			L1:do{
				System.out.print("Quantity Update\n===============\n");
				System.out.println("OderID        -"+id);
				System.out.println("CustomerID    -"+cusid);
				System.out.println("Name          -"+cusname);
				System.out.println("Quantity      -"+quant);
				System.out.print("\nEnter your quntity update value - ");
				int newVal=input.nextInt();
				System.out.println("\n\tUpdate oder quntity success fully.....");
				System.out.println("\nnew oder quntity   - "+newVal);
				System.out.println("new oder value     - "+(newVal*Burger.bp));
				
				for(int i=0; i<brg.length; i++){
					if(quant==(brg[i].getbrgQnt())){
						brg[i].setbrgQnt(newVal);
					}
				}
				L2:do{
					System.out.print("\nDo you want to update another oder(Y/N) -> ");
					char op2=input.next().charAt(0);
					if(op2=='Y'|op2=='y'){
						break L1;
					}else if(op2=='N'|op2=='n'){
						break L1;
					}else{
						System.out.println("Wrong option/try again...");
						continue L2;
					}
				}while(true);
			}while(true);
		}
		
		public static void StatusEdit(String id,String cusid,String cusname,int stat){
			Scanner input=new Scanner(System.in);
			L1:do{
				clearConsole();
				System.out.print("Status Update\n===============\n");
				System.out.println("OderID        -"+id);
				System.out.println("CustomerID    -"+cusid);
				System.out.println("Name          -"+cusname);
				System.out.println("Status        -"+stat);
				System.out.print("\n\t(0)PREPARING");
				System.out.print("\n\t(1)DELIVERED");
				System.out.print("\n\t(2)CANCELED\n");
				System.out.print("\nEnter new oder stetus - ");
				int newStat=input.nextInt();
				String st="";
				if (newStat==0){
						st="PREPARING";
					}else if(newStat==1){
						st="DELIVERED";
					}else if(newStat==2){
						st="CANCELED";
					}
				for (int i = 0; i <brg.length; i++){
					if (newStat==0){
						brg[i].setStatus(Burger.PREPARING);
					}else if(newStat==1){
						brg[i].setStatus(Burger.DELIVERED);
					}else if(newStat==2){
						brg[i].setStatus(Burger.CANCELED);
					}
				}
				System.out.println("\n\tUpdate oder STATUS success fully.....");
				System.out.print("\nNew oder status - "+st);
				
				for(int i=0; i<brg.length; i++){
					if(stat==(brg[i].getStatus())){
						brg[i].setStatus(newStat);
					}
				}
				L2:do{
					System.out.print("\nDo you want to update another oder(Y/N) -> ");
					char op2=input.next().charAt(0);
					if(op2=='Y'|op2=='y'){
						break L1;
					}else if(op2=='N'|op2=='n'){
						break L1;
					}else{
						System.out.println("Wrong option/try again...");
						continue L2;
					}
				}while(true);
			}while(true);
		}
		
		public static void clearConsole(){
		try{
			final String os=System.getProperty("os.name");
			if(os.contains("Windows")){
				new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			}else{
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		}catch(final Exception e){
			e.printStackTrace();
		}
	}
}





















