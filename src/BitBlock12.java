/**
 * Created by LenovoT420 on 3/4/2017.
 */
public class BitBlock12 {
    private final int bitBlockLen=6;
    BitBlock6 left;
    BitBlock6 right;

    public BitBlock12()
    {

        left=new BitBlock6();
        right=new BitBlock6();
    }
    public BitBlock12(char left,char right)
    {

        this.left=new BitBlock6(left);
        this.right=new BitBlock6(right);
    }

    public BitBlock12(int left,int right)
    {

        this.left=new BitBlock6(left);
        this.right=new BitBlock6(right);
    }


    public BitBlock12(BitBlock12 dup)
    {
        left=new BitBlock6(dup.left);
        right=new BitBlock6(dup.right);
    }
    public String toString()
    {
        return left+" "+right;
    }

    public BitBlock12 fiestalfunction(BitBlock8 key)
    {
        BitBlock8 expandedRight=right.expand();
        //System.out.println("Key : "+key);
        //System.out.println("Exp : "+expandedRight);
        BitBlock8 exorResult=expandedRight.exor(key);
        //System.out.println("KeyEXOR : "+exorResult);
        BitBlock6 result=exorResult.sBoxSubstitute();
        result=result.exor(left);
        return new BitBlock12(right,result);
    }
    public BitBlock12(BitBlock6 left,BitBlock6 right)
    {

        this.left=left;
        this.right=right;
    }
    public void reverseBlocks()
    {
        BitBlock6 temp=this.left;
        this.left=this.right;
        this.right=temp;
    }
    public BitBlock12 exor(BitBlock12 bitBlock)
    {
        BitBlock12 result= new BitBlock12();
        result.left=this.left.exor(bitBlock.left);
        result.right=this.right.exor(bitBlock.right);
        return result;

    }

}
