import java.util.Scanner;

public class currencyconverter {

public static void main(String[] args) {
    currency();
}

public static void currency(){
    int choice;

    Scanner keyboard = new Scanner(System.in);

    System.out.println("What would you like to convert?");
    System.out.println("1. GBP to EURO?");
    System.out.println("2. EURO to GBP?");

    choice = keyboard.nextInt();

    if(choice == 1){
        float XEURO = (float) 0.792648;
        System.out.println("Enter GBP to be converted to EURO:");
        System.out.println("EURO: " + keyboard.nextFloat() * XEURO);
    } else if (choice == 2){
        float XGBP = (float) 0.64;
        System.out.println("Enter EURO to be converted to GBP:");
        System.out.println("GBP: " + keyboard.nextFloat() * XGBP);
    } else if (choice > 2 || choice < 1){
        System.out.println("Please pick either option 1 or 2.");
    }
}
}