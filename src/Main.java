import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
    System.out.println("enter your 13 digit barcode");
    long barCode = sc.nextLong();
    int barCodeLeng = String.valueOf(barCode).length();
    String barCodeString = Long.toString(barCode);
    while (barCodeLeng != 13){
        System.out.println("not 13 digits");
        barCode = sc.nextInt();
        barCodeLeng = String.valueOf(barCode).length();
        barCodeString = Long.toString(barCode);
    }
    int[] barCodeArray = new int[13];
        for (int i = 0; i < 13; i++) {
            barCodeArray[i] = barCodeString.charAt(i) - '0';
        }
        int checkDigit = barCodeArray[12];
        int stepOne = (barCodeArray[1]+barCodeArray[3]+barCodeArray[5]+barCodeArray[7]+barCodeArray[9]+barCodeArray[11]);
        int stepTwo = (barCodeArray[0]+barCodeArray[2]+barCodeArray[4]+barCodeArray[6]+barCodeArray[8]+barCodeArray[10]);
        int stepThree = stepOne*3;
        int stepFour = stepThree+stepTwo;
        int total = stepFour + checkDigit;
        if (total == stepFour+ barCodeArray[12]){
            System.out.println("data received correctly");
        }
        else{
            System.out.println("data received incorrectly, please retransmit");
        }

    }
}
