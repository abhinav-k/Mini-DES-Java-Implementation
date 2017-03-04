/**
 * Created by LenovoT420 on 3/1/2017.
 */
public class BitBlock6 {
    private final int bitBlockLen=6;
    BitBlock3 left;
    BitBlock3 right;
    final int SboxArray[][][]={{{5,2,1,6,3,4,7,0},{1,4,6,2,0,7,5,3}},{{4,0,6,5,7,1,3,2},{5,3,0,7,6,2,1,4}}};

    public BitBlock6()
    {

        left=new BitBlock3();
        right=new BitBlock3();
    }

    public BitBlock6 exor(BitBlock6 bitBlock)
    {
        BitBlock6 result= new BitBlock6();
        result.left=this.left.exor(bitBlock.left);
        result.right=this.right.exor(bitBlock.right);
        return result;

    }
    
}
