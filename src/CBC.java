/**
 * Created by LenovoT420 on 3/4/2017.
 */
public class CBC {
    BitBlock12 [] plainText;
    Keygen key;
    int maxRounds=2;
    MiniDES des;
    public CBC()
    {

    }
    public CBC(String plainText)
    {
        if(plainText.length()%2!=0)
        {
            System.out.println("Invalid input... Exiting...");
            return;
        }
        this.plainText= new BitBlock12[plainText.length()/2];
        for(int i=0;i<plainText.length()/2;i++)
        {
            this.plainText[i]=new BitBlock12(plainText.charAt(2*i),plainText.charAt((2*i)+1));
        }
        key=new Keygen();
        key.generateKeyFromDate();
        des=new MiniDES(key,maxRounds);
        BitBlock12 [] output=new BitBlock12[plainText.length()/2];
        for(int i=0;i<plainText.length()/2;i++)
        {
            output[i]=des.encrypt(this.plainText[i]);
        }

    }
}
