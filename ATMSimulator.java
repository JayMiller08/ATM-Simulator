import java.util.Scanner;
import java.util.Random;
public class ATMSimulator{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
	
		int iNewPin, iTransactionCount = 0, iPinAttempts = 3, iOption, iPin, iBalance = rd.nextInt(10000)+1000, iDeposit, iWithdrawal, iTransactionRefNo, iPinCheck;
		char cOption;
		
		System.out.println("***************WELCOME TO TOMBO BANK***************");
		System.out.println();
		System.out.print("Create 4-digit PIN: ");
		iPin = sc.nextInt();
		
		System.out.println();
		
		do{
			iPinAttempts = 3;
			iPinCheck = iPin;
			System.out.println("Main Menu: \n 1. Check Balance \n 2. Deposit Money \n 3. Withdraw Money \n 4. Change PIN \n 5. Exit");
				iOption = sc.nextInt();
				while(iOption < 1 && iOption > 5){
					System.out.println("Invalid Option, please select option 1 - 5.");
					}
				switch(iOption){
					case 1: System.out.println("Balance: R"+iBalance);
						break;
					case 2: System.out.print("Enter amount to deposit: ");
						iDeposit = sc.nextInt();
						iBalance += iDeposit;
						System.out.println("You have deposited: R"+iDeposit+"\n Balance is now: R"+iBalance);
						
						iTransactionRefNo = rd.nextInt(99999)+10000;
						System.out.println("\nTransaction Reference Number: "+iTransactionRefNo);
						break;
					case 3: do{
						System.out.print("Enter amount to withdraw: ");
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
						iPin = sc.nextInt();
						if(iPin != iPinCheck){
							System.out.println("You have entered an incorrect PIN, please try again.");
							System.out.println(iPinAttempts+" remaining attempts.");
							iPinAttempts--;
							}else{
								System.out.print("Enter new PIN: ");
								iNewPin = sc.nextInt();
							System.out.println("Your new PIN is :"+iNewPin);
							break;
							}
							
							
							if(iPinAttempts >= 3)
								System.out.println("You have reached maximum PIN attempts, please try again later.");
							
						}while(iPinAttempts <= 3 && iPin != iPinCheck);
						break;
					case 5: System.out.println("\n==========Thank You for using TOMBO BANK.==========");
						break;
				}
				iTransactionCount++;
				System.out.println("You have done a total of "+iTransactionCount+" transactions \nAnd your balance is: R"+iBalance);
				do{
					
					System.out.print("\nWould you like to transact again? Y / N: ");
					cOption = Character.toUpperCase(sc.next().charAt(0));
					if(cOption != 'Y' && cOption != 'N')
						System.out.println("Invalid input, please enter: Y / N.");
				}while(cOption != 'Y' && cOption != 'N');
				

				
		}while(cOption == 'Y');
		System.out.println("\n==========Thank You for using TOMBO BANK.==========");

        sc.close();
	}
}