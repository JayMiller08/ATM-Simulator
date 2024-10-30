import java.util.Scanner;
import java.util.Random;
public class ATMSimulator{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
	
		int iNewPin = 0, iTransactionCount = 0, iPinAttempts = 3, iOption, iBalance = rd.nextInt(10000)+1000, iDeposit, iWithdrawal, iTransactionRefNo, iOriginalPin; //integer variables for transactions
		char cOption; //char variable for Yes or No options
		
		//initial setup/output
		System.out.println("\n***************WELCOME TO TOMBO BANK***************");
		System.out.println();
		System.out.print("Create 4-digit PIN: ");
		final int PIN = sc.nextInt(); //set initial pin as constant
		
		System.out.println();
		iOriginalPin = PIN;
		do{

			iPinAttempts = 3; //user has a maximum of 3 attempts to enter correct pin
			
			System.out.println("Main Menu: \n 1. Check Balance \n 2. Deposit Money \n 3. Withdraw Money \n 4. Change PIN \n 5. Exit \n 6. Account Details");
				iOption = sc.nextInt(); 
				while(iOption < 1 && iOption > 5){
					System.out.println("Invalid Option, please select option 1 - 5."); //error message, if user enters inapproriate option
					}
					//ATM main menu
				switch(iOption){
					case 1: System.out.println("Balance: R"+iBalance);
							break;
						
					case 2: System.out.print("Enter amount to deposit: R");
						iDeposit = sc.nextInt();
						iBalance += iDeposit;
						System.out.println("You have deposited: R"+iDeposit+"\n Balance is now: R"+iBalance);
						
						iTransactionRefNo = rd.nextInt(99999)+10000;
						System.out.println("\nTransaction Reference Number: "+iTransactionRefNo);
						break;
					case 3: do{
						System.out.print("Enter amount to withdraw: R");
						iWithdrawal = sc.nextInt();
						if(iWithdrawal > iBalance || iWithdrawal > 5000){
							System.out.println("You have attempted to exceed your balance OR you have exceed your daily limit of R5000, please try again");
						}
							if(iWithdrawal % 10 != 0){
								System.out.println("\nWithdrawals must be a multiple of 10.");
								}
							
						}while(iWithdrawal > iBalance && iWithdrawal > 5000 && iWithdrawal % 10 != 0);
						
						if(iWithdrawal <= iBalance && iWithdrawal <= 5000 && iWithdrawal % 10 == 0){
							iBalance -= iWithdrawal;
							System.out.println("You have withdrawn: R"+iWithdrawal+"\n Balance is now: R"+iBalance);
							
							iTransactionRefNo = rd.nextInt(99999)+10000;
							System.out.println("\nTransaction Reference Number: "+iTransactionRefNo);
						}
						
						break;
					case 4: do{
						System.out.print("Enter previous 4-digit PIN for verification: ");
						iOriginalPin = sc.nextInt();
						if(iOriginalPin != PIN){
							System.out.println("You have entered an incorrect PIN, please try again.");
							System.out.println(iPinAttempts+" remaining attempts.");
							iPinAttempts--;
							}else{
								System.out.print("Enter new PIN: ");
								iNewPin = sc.nextInt();
								iOriginalPin = iNewPin;
							System.out.println("Your new PIN is :"+iNewPin);
							break;
							}
							
							
							if(iPinAttempts >= 3)
								System.out.println("You have reached maximum PIN attempts, please try again later.");
							
						}while(iPinAttempts <= 3 && iOriginalPin != iNewPin);
						break;
					case 5: System.out.println("\n==========Thank You for using TOMBO BANK.==========");
						break;
					case 6: System.out.println("Account Balance: R"+iBalance+"\nAccount Pin: "+iOriginalPin);
					break;
				}
				if(iOption != 5){
					iTransactionCount++;
					System.out.println("You have done a total of "+iTransactionCount+" transactions \nAnd your balance is: R"+iBalance);
					}
				
				do{
					
					System.out.print("\nWould you like to transact again? Y / N: ");
					cOption = Character.toUpperCase(sc.next().charAt(0));
					if(cOption != 'Y' && cOption != 'N')
						System.out.println("Invalid input, please enter: Y / N.");
				}while(cOption != 'Y' && cOption != 'N');
				
		}while(cOption == 'Y'); //repeat displaying main menu while option to continue is Y 
		
		if(iOption != 5){
			System.out.println("\n==========Thank You for using TOMBO BANK.==========");
		}
		

        sc.close(); //closing scanner object
	}
}
