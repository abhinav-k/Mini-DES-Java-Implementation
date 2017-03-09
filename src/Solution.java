import java.util.Scanner;

/**
 * Created by LenovoT420 on 3/8/2017.
 */
public class Solution {
    public void solve()
    {
        Scanner io=new Scanner(System.in);
        String pattern= ("[A-Z][A-Z][A-Z][A-Z][A-Z][A-Z][A-Z][A-Z][A-Z][A-Z] [0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9].");

        System.out.println("Select an option:");
        System.out.println("1 - CBC");
        String option=io.nextLine();
        System.out.println("Enter Plain text:");
        String plainText=io.nextLine();
        if(plainText.length()==22 &&plainText.matches(pattern))
        {
            System.out.println("match successful");
        }
        switch (Integer.parseInt(option))
        {
            case 1:
                new CBC(plainText);
                break;
            default:
                System.out.println("Invalid option. Exiting...");
        }

    }
}
