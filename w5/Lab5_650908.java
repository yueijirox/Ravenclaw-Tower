import java.util.Arrays;

public class Lab5_650908 {
    static int[] data= {28,58,8,77,48,39};
    static ArrayProcessor q1NumberOfEvenElement;//4
    static ArrayProcessor q2IndexOfLargestEvenValue;//1
    static ArrayProcessor myMedian; // 2th element of sorted array


    public static void main(String[] args) {
        q1();       //4
        q2();       //1
        oneline();  //48

    }
    static void q1(){
        q1NumberOfEvenElement = (data) ->{
            int sum=0;
            for(int a : data )
                if(a%2==0)
                    sum+=1;
            return sum;
        };
        System.out.println(q1NumberOfEvenElement.calculate(data));



    }



    static void q2(){
        q2IndexOfLargestEvenValue = (data)->{

            int tmp=data[0];
            int idx=0;
            for(int i=0;i<data.length;i++)
                if(data[i]>=tmp && data[i]%2 == 0){
                    tmp=data[i];
                    idx=i;
                }
            return idx;
        };
        System.out.println(q2IndexOfLargestEvenValue.calculate(data));

    }

    static void oneline(){
        int [] tmp = Arrays.copyOf(data, data.length);
        Arrays.sort(tmp);
        ArrayProcessor myMedian = (data) -> data[data.length/2];
        System.out.println(myMedian.calculate(tmp));//48


    }
}
