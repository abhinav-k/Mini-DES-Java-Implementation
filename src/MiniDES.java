/**
 * Created by LenovoT420 on 3/8/2017.
 */
public class MiniDES {
    Keygen key;
    int rounds;
    public MiniDES(Keygen key,int rounds)
    {
        this.key=key;
        this.rounds=rounds;
    }
    public BitBlock12 encrypt(BitBlock12 planeText)
    {
        BitBlock12 block=new BitBlock12(planeText);
        for(int i=0;i<rounds;i++)
        {
            block=block.fiestalfunction(new BitBlock8(key.getKey(i+1)));
        }
        block.reverseBlocks();
        return block;
    }

    public BitBlock12 decrypt(BitBlock12 encText)
    {
        BitBlock12 block=new BitBlock12(encText);
        for(int i=rounds;i!=0;i--)
        {
            block=block.fiestalfunction(new BitBlock8(key.getKey(i)));
        }
        block.reverseBlocks();
        return block;
    }

}
