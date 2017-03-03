/**
 * Created by LenovoT420 on 3/3/2017.
 */
public class BitBlock4 {
    private boolean bits[];
    final private int maxLength=4;
    public BitBlock4()
    {
        bits=new boolean[4];
    }
    public BitBlock4(boolean bits[],int start,int end)
    {
        int j=0;
        bits=new boolean[4];
        for(int i=start;i<=end;i++,j++)
        {
            this.bits[j]=bits[i];
        }
    }
    public BitBlock4 exor(BitBlock4 operand)
    {
        BitBlock4 result=new BitBlock4();
        for(int i=0;i<maxLength;i++)
        {
            result.bits[i]=this.bits[i]^operand.bits[i];
        }
        return result;
    }
}
