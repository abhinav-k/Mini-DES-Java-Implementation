import java.security.SecureRandom;
import java.util.Scanner;

/**
 * Created by LenovoT420 on 3/9/2017.
 */
public class CTR {String algorithm="Counter Mode";
    Keygen key;
    int maxRounds=2;
    MiniDES des;
    int counter;
    public CTR()
    {
        key=new Keygen();
        key.generateKeyFromDate();
        des=new MiniDES(key,maxRounds);
        initializeCounter();


    }

    public void initializeCounter()
    {
        SecureRandom random = new SecureRandom();
        int randomCounter=(random.nextInt());
        randomCounter=randomCounter%(1<<12);
        this.counter=randomCounter;
    }

    public String toString()
    {
        return "Algorithm : "+algorithm+"\nMax Rounds : "+maxRounds+"\nKey Details:\n"+key+"\nRandom Counter Start Value: "+this.counter+"\n Counter in Binary Representation :"+new BitBlock12(this.counter);
    }

    public BitBlock12 [] encrypt(BitBlock12[] plainText)
    {
        BitBlock12 [] output=new BitBlock12[plainText.length];

        for(int i=0;i<plainText.length;i++)
        {

            BitBlock12 ctr=new BitBlock12((this.counter+i)%(1<<12));
            output[i]=plainText[i].exor(des.encrypt((ctr)));

        }
        return output;
    }

    public BitBlock12 [] decrypt(BitBlock12[] encText)
    {

        BitBlock12 [] output=new BitBlock12[encText.length];

        for(int i=0;i<encText.length;i++)
        {

            BitBlock12 ctr=new BitBlock12((this.counter+i)%(1<<12));
            output[i]=encText[i].exor(des.encrypt((ctr)));

        }
        return output;    }

}
