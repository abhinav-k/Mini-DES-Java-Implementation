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
        System.out.println("1 - ECB");
        System.out.println("2 - CBC");
        String option=io.nextLine();
        System.out.println("Enter Plain text:");
        String plainText=io.nextLine();
        if(plainText.length()!=22 || !plainText.matches(pattern))
        {
            System.out.println("Given text does not matches the <Last Name> <Std Id>. Format\n try again." );
            System.exit(1);
        }
        switch (Integer.parseInt(option))
        {
            case 1: {
                ECB ecb = new ECB();
                System.out.println(ecb);
                BitBlock12[] blocks = convertToBlocks(plainText);
                System.out.print("Intital plainText - ");
                printTextinBinary(blocks);
                BitBlock12[] encryptedText = ecb.encrypt(blocks);
                System.out.print("Encrypted text - ");
                printTextinBinary(encryptedText);
                System.out.print("Decrypted text - ");
                BitBlock12[] planeTextBlock = ecb.decrypt(encryptedText);
                printTextinBinary(planeTextBlock);
                break;
            }
            case 2:
            {
                CBC cbc = new CBC();
                System.out.println(cbc);
                BitBlock12[] blocks = convertToBlocks(plainText);
                System.out.print("Intital plainText - ");
                printTextinBinary(blocks);
                BitBlock12[] encryptedText = cbc.encrypt(blocks);
                System.out.print("Encrypted text - ");
                printTextinBinary(encryptedText);
                System.out.print("Decrypted text - ");
                BitBlock12[] planeTextBlock = cbc.decrypt(encryptedText);
                printTextinBinary(planeTextBlock);
                break;
            }
            default:
                System.out.println("Invalid option. Exiting...");
        }

    }
    public BitBlock12[] convertToBlocks(String plainTextString)
    {
        if(plainTextString.length()%2!=0)
        {
            System.out.println("Invalid input... Exiting...");
            System.exit(0);
            return null;
        }
        BitBlock12 [] plainText= new BitBlock12[plainTextString.length()/2];
        for(int i=0;i<plainTextString.length()/2;i++)
        {
            plainText[i]=new BitBlock12(plainTextString.charAt(2*i),plainTextString.charAt((2*i)+1));
        }
        return plainText;
    }
    public void printTextinBinary(BitBlock12 [] block)
    {
        for(int i=0;i<block.length-1;i++)
        {
            System.out.print(block[i]+"   -----   ");
        }
        if(block.length!=0)
        {
            System.out.print(block[block.length-1]);
        }
        System.out.println();
    }
}
