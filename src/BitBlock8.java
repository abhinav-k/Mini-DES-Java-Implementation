/**
 * Created by LenovoT420 on 3/2/2017.
 */
public class BitBlock8 {
   private boolean bits[];
   private final int bitBlockLen=8;
    public BitBlock8()
    {
        bits=new boolean[8];
    }
    public BitBlock8 (boolean [] bits)
    {
        this.bits=bits;
    }
    public BitBlock8 exor(BitBlock8 bitBlock)
    {
        BitBlock8 result= new BitBlock8();
        for(int i=0;i<8;i++)
        {
            result.bits[i]=this.bits[i]^bitBlock.bits[i];
        }
        return result;

    }
}
