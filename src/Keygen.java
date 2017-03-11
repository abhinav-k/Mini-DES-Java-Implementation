import java.util.Scanner;

/**
 * Created by LenovoT420 on 3/8/2017.
 */
public class Keygen {

    boolean keybool[]=new boolean[9];
    public Keygen()
    {}

    public String keyinString()
    {
        String ret="";
        for(int i=0;i<9;i++)
        {
            if(keybool[i])
                ret+="1";
            else
                ret+="0";
        }
        return ret;
    }
    public void printKey()
    {
        System.out.println(keyinString()) ;

    }
    public String toString()
    {
        String s=  "Binary representation - "+keyinString();

        return s;

    }
    public int getKey(int round)
    {

        int max=8;
        round--;
        int start=0;
        round=round%8;
        int key=0,value=(1<<7);
        for(int i=0;i<8;i++)
        {
            if(start+round>max)
            {
                start=-round;

            }
            if(keybool[start+round])
            {
                key=key+(value);

            }
            start++;
            value=value>>1;


        }
        return key;


    }
    public void generateKeyFromDate()
    {
        Scanner io=new Scanner(System.in);
        System.out.print("Enter date in format yyyy.mm.dd : ");
        String dateString=io.nextLine();
        String [] date=dateString.split("[.]");
        if(date.length!=3)
        {
            System.out.println("Invalid format");
            System.exit(1);
        }
        int mm=0,dd=0,yyyy=0;
        try
        {
            yyyy=Integer.parseInt(date[0]);
            mm=Integer.parseInt(date[1]);
            dd=Integer.parseInt(date[2]);
        }
        catch (Exception e)
        {
            System.out.println("Invalid format");
            System.exit(1);

        }
        generateKeyBool(getKeyFromDate(yyyy,mm,dd));
    }
    public   void generateKeyBool(int key)
    {
        for(int i=8;i>=0;i--)
        {
            keybool[i]=false;
            keybool[i]=!(key%(2)==0);
            key=key/2;
        }
    }
    private int getKeyFromDate(int y,int m,int d)
    {
        int days[][]={{31,29,31,30,31,30,31,31,30,31,30,31},{31,28,31,30,31,30,31,31,30,31,30,31}};
        int day=0;
        if(y%4==0)
        {
            for(int i=0;i<m-1;i++)
            {
                day=day+days[0][i];
            }
            day=day+d;
        }
        if(y%4!=0)
        {
            for(int i=0;i<m-1;i++)
            {
                day=day+days[1][i];
            }
            day=day+d;
        }
        return day;
    }
}
