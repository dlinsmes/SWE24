import java.util.Scanner;
public class HeyLookFreeCodeThanksMrLin {

    public static void main(String [] args) {

        //letters
        String input = "BLAH";
        input = input.toLowerCase();
        System.out.println(input);

        char firstLet = input.charAt(0);

        char letter = 'a';
        int num = (int)(letter);
        System.out.println(num);
        num += 2;
        letter = (char)(num);
        System.out.println(letter);

        //use 'a' as an offset to find how many
        // letters away another letter is


        int [] ships = {1, 5, 2, 23};
    }

    static Scanner s = new Scanner(System.in);

    public static int getNum() {

        try {
            String input = s.nextLine();
            int n = Integer.parseInt(input);
            return n;
        }
        catch (Exception e) {
            System.out.println("you dumdum");
            return -1;
        }

    }

}
