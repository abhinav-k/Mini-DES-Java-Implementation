/**
 * Created by LenovoT420 on 3/1/2017.
 */
public class BitBlock6 {
    private final int bitBlockLen=6;
    BitBlock3 left;
    BitBlock3 right;

    public BitBlock6()
    {

        left=new BitBlock3();
        right=new BitBlock3();
    }
    public BitBlock6(char a)
    {

        int key=parseChar(a);
        left=new BitBlock3(key/8);
        right=new BitBlock3(key%8);
    }
    public BitBlock6(BitBlock6 dup)
    {
        left=new BitBlock3(dup.left);
        right=new BitBlock3(dup.right);
    }
    public BitBlock6(BitBlock3 left,BitBlock3 right)
    {

        this.left=left;
        this.right=right;
    }

    public String toString()
    {
        return left+" "+right;
    }
    public BitBlock6(int key)
    {

        this.left=new BitBlock3(key/8);
        this.right=new BitBlock3(key%8);
    }

    public int parseChar(char a)
    {
        int key=-1;
        if(Character.isLetter(a))
        {
            key=((int)a)-64;
        }
        else if(Character.isDigit(a))
        {
            key=27+((int)a)-48;
        }
        else if(a==' ')
        {
            key=38;
        }
        else if(a=='.')
        {
            key=37;
        }
    return key;

    }
    public BitBlock8 expand()
    {
        return new BitBlock8(left.expandLeft(right),right.expandRight(left));
    }
    public BitBlock6 exor(BitBlock6 bitBlock)
    {
        BitBlock6 result= new BitBlock6();
        result.left=this.left.exor(bitBlock.left);
        result.right=this.right.exor(bitBlock.right);
        return result;

    }

}
