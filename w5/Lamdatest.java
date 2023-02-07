import java.util.List;

public class Lamdatest {
    public static void main(String[] args) {
        q1();
        System.out.println("================================");
        q2();
        System.out.println("================================");
        q3();
        System.out.println("================================");
        q4();
        System.out.println("================================");
        //q5();
    }

    static void q1(){
        Funcinterface1 instance;
        instance = () -> (int)(Math.random() * 1000);
        System.out.println("q1: "+instance.method1());
    }

    static void q2(){
        Funcinterface2 instance;
        instance = (a,b)->a>b?a:b;
        System.out.println("q2 : "+instance.method2(5, 7));

    }

    static void q3(){
        Funcinterface3 instance = (list)->{
            int sum=0;
            for(int i : list)
                if(i%2==0)
                    sum+=i;
                return sum;
        };
        System.out.println("q3: "+
                        instance.method3(List.of(2,5,7,4)));
    }

    static void q4(){
        Funcinterface4<String> instance1;
        instance1 = (str) -> {
            String rev = "";
            for (int i = str.length() - 1; i >= 0; i--)
                rev += str.charAt(i);
            return rev;
        };
        System.out.println("q4a : " + instance1.method4("abcd"));
        Funcinterface4<Integer> instance2;
        instance2 = (factorial) -> {
            int result = 1;
            for (int i = 2; i <= factorial; i++)
                result *= i;
            return result;
        };
        System.out.println("q4b : " + instance2.method4(5));

        /*static void q5() {
            double circleArea = callInterface5((radius/* , blank ) -> Math.PI * 2.0 * radius);
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println("q5 : " + df.format(circleArea));
            }
            static private double callInterface5(FuncInterface5 instance) {
            return instance.method5(3/* ,0 );
            }
            */


    }


}