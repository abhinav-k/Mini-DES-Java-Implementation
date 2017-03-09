/**
 * Created by LenovoT420 on 3/2/2017.
 */
public class BitBlock8 {
   private BitBlock4 left;
   private BitBlock4 right;
   private final int bitBlockLen=8;
    final int SboxArray[][][]={{{5,2,1,6,3,4,7,0},{1,4,6,2,0,7,5,3}},{{4,0,6,5,7,1,3,2},{5,3,0,7,6,2,1,4}}};

    public BitBlock8()
    {
        left=new BitBlock4();
        right=new BitBlock4();
    }
    public BitBlock8(int value)
    {
        left=new BitBlock4(value/16);
        right=new BitBlock4(value%16);
    }
    public BitBlock8(BitBlock4 left,BitBlock4 right)
    {
        this.right=right;
        this.left=left;
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
    public BitBlock6 sBoxSubstitute()
    {
        BitBlock3 left=this.left.desSubstitutionBoxSubs(SboxArray[0]);
        BitBlock3 right=this.right.desSubstitutionBoxSubs(SboxArray[1]);
        return new BitBlock6(left,right);
    }
    public String toString()
    {
        return left+" "+right;
    }
}
