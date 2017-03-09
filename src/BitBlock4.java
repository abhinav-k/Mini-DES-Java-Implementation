/**
 * Created by LenovoT420 on 3/3/2017.
 */
public class BitBlock4 {
    private boolean bits[];
    final private int maxLength=4;

    public BitBlock4()
    {
        bits=new boolean[maxLength];
    }
    public BitBlock4(boolean bits[],int start,int end)
    {
        int j=0;
        this.bits=new boolean[maxLength];
        for(int i=start;i<=end;i++,j++)
        {
            this.bits[j]=bits[i];
        }
    }
    public BitBlock4(int value)
    {

        bits=new boolean[maxLength];
        for(int i=maxLength-1;i>=0;i--)
        {
            bits[i]=!(value%(2)==0);
            value=value/2;
        }
    }
    public String toString()
    {
        String ret="";
        for(int i=0;i<maxLength;i++)
        {
            if(bits[i])
                ret+="1";
            else
                ret+="0";
        }
        return ret;
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
    public BitBlock3 desSubstitutionBoxSubs(int substituitionBox[][])
    {
        int intValue=this.getIntegerRepresentation();
        int substituteValue= substituitionBox[intValue/(1<<(maxLength-1))][intValue%(1<<(maxLength-1))];
        BitBlock3 result=new BitBlock3(substituteValue);
        return result;
    }
}
