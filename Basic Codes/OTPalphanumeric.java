import java.util.Random;
import java.util.Scanner;

public class OTPalphanumeric {
  public static void main(String[] args) {
    char alpha[] = new char[4];
    // create an array contains alphabets
    char bets[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    int num = 0;
    int  in,v;
    Random r = new Random();
//for alphabets:
      for (int k = 0; k < 4; k++)
      { //bound upto 26 because array bets[] contains elements upto index 25
        v=r.nextInt(26);
        alpha[k]=bets[v];
      }
// for numbers:
      for (int i = 0; i < 4; i++) {
        //bound upto 9999 because all 4 digit numbers exist between 0 to 9999
        in = r.nextInt(9999);
        //if random no. is >1000
        if (in >= 1000) {
          num = in;
        }
        // for else - for loop executes again
      }
      System.out.print("Alpha Numeric OTP:");
      for (int i = 0; i < 4; i++)
        System.out.print(alpha[i]);
      System.out.print(num);

    }
  }
