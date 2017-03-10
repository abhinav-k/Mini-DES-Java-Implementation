import java.util.Scanner;

/**
 * Created by LenovoT420 on 3/9/2017.
 */
public class CBC {
    String algorithm="Cipher Block Chaining";
    Keygen key;
    int maxRounds=2;
    MiniDES des;
    BitBlock12 initializationVector;
    String initializationVectorString;
    public CBC()
    {
        key=new Keygen();
        key.generateKeyFromDate();
        des=new MiniDES(key,maxRounds);
        Scanner io=new Scanner(System.in);
        System.out.println("Enter Initialization Vector. (Please enter only two letters or digits and hit enter) :");
        String iv=io.nextLine();
        setInitializationVector(iv);


    }
    public void setInitializationVector(String iv)
    {
        iv=iv.toUpperCase();
        if(iv.length()!=2)
        {
            System.out.println("Initialization Vector should be of size 2. You entered Initialization Vector of Size "+ iv.length());
            System.exit(0);
        }
        else
        {
            char a=iv.charAt(0);
            char b=iv.charAt(1);
            if(!((Character.isDigit(a)||Character.isLetter(a))||a=='.'||a==' ') || !((Character.isDigit(b)||Character.isLetter(b))||b=='.'||b==' '))
            {
                System.out.println("Only enter letter,digit, <space> or <dot> for Initialization Vector. You entered \""+a+"\",\""+b+"\".");
                System.exit(0);
            }
        }
        this.initializationVectorString=iv;
        this.initializationVector=new BitBlock12(iv.charAt(0),iv.charAt(1));
    }
    public String toString()
    {
        return "Algorithm : "+algorithm+"\nMax Rounds : "+maxRounds+"\nKey Details:\n"+key+"\nInitialization Vector : "+this.initializationVector+"\n Initialization Vector in Binary Representation :"+this.initializationVector;
    }

    public BitBlock12 [] encrypt(BitBlock12[] plainText)
    {
        BitBlock12 [] output=new BitBlock12[plainText.length];
        BitBlock12 iv=this.initializationVector;
        for(int i=0;i<plainText.length;i++)
        {

            output[i]=des.encrypt(plainText[i].exor(iv));
            iv=output[i];
        }
        return output;
    }

    public BitBlock12 [] decrypt(BitBlock12[] encText)
    {
        BitBlock12 iv=this.initializationVector;

        BitBlock12 [] output=new BitBlock12[encText.length];
        for(int i=0;i<encText.length;i++)
        {
            output[i]=des.decrypt(encText[i]).exor(iv);
            iv=encText[i];
        }
        return output;
    }

}
