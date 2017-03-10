/**
 * Created by LenovoT420 on 3/4/2017.
 */
public class ECB {
    String algorithm="Electronic Code Book";
    Keygen key;
    int maxRounds=2;
    MiniDES des;

    public ECB()
    {
        key=new Keygen();
        key.generateKeyFromDate();
        des=new MiniDES(key,maxRounds);



    }
    public String toString()
    {
        return "Algorithm : "+algorithm+"\nMax Rounds : "+maxRounds+"\nKey Details:\n"+key;
    }
    public BitBlock12 [] encrypt(String plainTextString)
    {
        if(plainTextString.length()%2!=0)
        {
            System.out.println("Encryption String is not of proper format");
            return null;
        }
        BitBlock12 [] plainText= new BitBlock12[plainTextString.length()/2];
        for(int i=0;i<plainTextString.length()/2;i++)
        {
            plainText[i]=new BitBlock12(plainTextString.charAt(2*i),plainTextString.charAt((2*i)+1));
        }
        BitBlock12 [] output=new BitBlock12[plainTextString.length()/2];
        for(int i=0;i<plainText.length;i++)
        {
            output[i]=des.encrypt(plainText[i]);
        }
        return output;
    }

    public BitBlock12 [] encrypt(BitBlock12[] plainText)
    {
        BitBlock12 [] output=new BitBlock12[plainText.length];
        for(int i=0;i<plainText.length;i++)
        {
            output[i]=des.encrypt(plainText[i]);
        }
        return output;
    }

    public BitBlock12 [] decrypt(BitBlock12[] encText)
    {
        BitBlock12 [] output=new BitBlock12[encText.length];
        for(int i=0;i<encText.length;i++)
        {
            output[i]=des.decrypt(encText[i]);
        }
        return output;
    }

}
