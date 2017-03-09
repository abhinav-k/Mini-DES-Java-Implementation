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
            block.fiestalfunction(new BitBlock8(key.getKey(i+1)));
        }
        return null;
    }

}
