/**
 * Created by LenovoT420 on 3/3/2017.
 */
public class BitBlock3 {
    private boolean bits[];
    final private int maxLength=3;

    public BitBlock3()
    {
        bits=new boolean[maxLength];
    }
    public BitBlock3(boolean bits[],int start,int end)
    {
        int j=0;
        bits=new boolean[maxLength];
        for(int i=start;i<=end;i++,j++)
        {
            this.bits[j]=bits[i];
        }
    }
    public BitBlock3 exor(BitBlock3 operand)
    {
        BitBlock3 result=new BitBlock3();
        for(int i=0;i<maxLength;i++)
        {
            result.bits[i]=this.bits[i]^operand.bits[i];
        }
        return result;
    }
    public BitBlock3(int value)
    {

        bits=new boolean[maxLength];
        for(int i=maxLength-1;i>=0;i--)
        {
            bits[i]=!(value%(2)==0);
            value=value/2;
        }
    }
    public int getIntegerRepresentation()
    {
        int result=0;
        int j=0;
        for(int i=maxLength-1;i>=0;i--,j++)
        {
            if(this.bits[i])
            {
                result=result+(1<<j);
            }
        }
        return result;
    }

    public BitBlock4 expandLeft(BitBlock3 right)
    {
        boolean output[]=new boolean[4];
        output[0]=this.bits[0];
        output[1]=this.bits[1];
        output[2]=right.bits[0];
        output[3]=this.bits[2];
        return new BitBlock4(output,0,3);
    }
    public BitBlock4 expandRight(BitBlock3 left)
    {
        boolean output[]=new boolean[4];
        output[0]=this.bits[0];
        output[1]=left.bits[2];
        output[2]=this.bits[1];
        output[3]=this.bits[2];
        return new BitBlock4(output,0,3);
    }
}
