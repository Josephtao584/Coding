package template;
/*
 *快速幂
 */
public class NumberPower {
    private int x;
    private NumberPower(int x){
        this.x = x;
    }
    public int fun(int data, int number){
        if(number == 1)
            return data;
        if(number % 2 == 0)
            return fun(data * data ,number / 2) ;
        else if(number % 2 == 1)
            return fun(data * data ,number / 2) * data;
        return 0;
    }

    public static void main(String[] args){
        int x = 8, number = 10;
        NumberPower P = new NumberPower(x);
        System.out.println("result: " + Math.pow(x,number));
        System.out.println("result: " + P.fun(x,number));
    }
}
