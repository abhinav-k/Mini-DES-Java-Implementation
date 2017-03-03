/**
 * Created by LenovoT420 on 3/2/2017.
 */
public class BitBlock8 {
   private BitBlock4 left;
   private BitBlock4 right;
   private final int bitBlockLen=8;
    public BitBlock8()
    {
        left=new BitBlock4();
        right=new BitBlock4();
    }
    public BitBlock8 (boolean [] bits)
    {
        left=new BitBlock4(bits,0,3);
        right=new BitBlock4(bits,4,7);
    }
    public BitBlock8 exor(BitBlock8 bitBlock)
    {
        BitBlock8 result= new BitBlock8();
        result.left=this.left.exor(bitBlock.left);
        result.right=this.right.exor(bitBlock.right);
        return result;

    }
}
