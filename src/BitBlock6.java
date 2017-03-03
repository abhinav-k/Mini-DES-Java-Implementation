/**
 * Created by LenovoT420 on 3/1/2017.
 */
public class BitBlock6 {
    boolean bits[];
    private final int bitBlockLen=6;
    final int SboxArray[][][]=new int[2][][];

    public BitBlock6()
    {
        bits=new boolean[6];
    }
    public BitBlock8 expandBlock()
    {
        boolean expandedBits[]=new boolean[8];
        expandedBits[0]=bits[0];
        expandedBits[1]=bits[1];
        expandedBits[2]=bits[3];
        expandedBits[3]=bits[2];
        expandedBits[4]=bits[3];
        expandedBits[5]=bits[2];
        expandedBits[6]=bits[5];
        expandedBits[7]=bits[5];
        BitBlock8 expandedBlock=new BitBlock8(expandedBits);
        return expandedBlock;
    }
    public BitBlock6 exor(BitBlock6 bitBlock)
    {
        BitBlock6 result= new BitBlock6();
        for(int i=0;i<bitBlockLen;i++)
        {
            result.bits[i]=this.bits[i]^bitBlock.bits[i];
        }
        return result;

    }
    public int convertToint(int start,int end)
    {
        int solution=0;
        int j=0;
        for(int i=start;i<=end;i++)
        {
            if(bits[i])
            {
                solution+=Math.pow(2,j);
            }
            j++;
        }
        return solution;
    }
    public BitBlock8 substitute()
    {
        boolean expandedBits[]=new boolean[8];
        BitBlock8 substitutedBlock=new BitBlock8(expandedBits);
        return substitutedBlock;
    }
}
