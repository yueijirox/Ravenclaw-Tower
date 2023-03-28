import java.util.*;
class Lab8{
    public static void main(String[] args) {

        q0();

        q1_halfEachNumber();

        q2_forEachSingerName();

        q3_lambda_comparator();

        q4_method_reference_comparator();
    }
    static void q0(){
        HalfValueInterface bb = new HalfValueInterface() {
            public void printHalf(int p){
                System.out.println(p/2);
            }   
        };
        bb.printHalf(12);
    }
    public static void q1_halfEachNumber() {
        List<Integer> nums = Arrays.asList(100, 105);


        HalfValueInterface halfVal = /* q1.1 */ n -> System.out.println(n/2);
        for (int n : nums) {
            halfVal.printHalf(n);
        } 


        Consumer<Integer> consumer = n -> /* q1.2 */ System.out.println(n/2);
        for (int n : nums) {
            consumer.accept(n);
        }


        Consumer<Integer> halfMe = n -> System.out.println(n/2);
        nums./* q1.3 */ forEach(halfMe);


        nums.forEach(/* q1.4 */ n -> System.out.println(n/2));


        NumberProcessor np = new NumberProcessor();
        nums.forEach(/* q1.5 */ np::printHalf);
    }
    public static void q2_forEachSingerName() {
        List<Singer> singerList = Arrays.asList(
            new Singer("Aba","POP"),
            new Singer("Abi","POP"),
            new Singer("Abo","ROCK"),
            new Singer("Abe","ROCK")
        );



        singerList.stream().map(/* q2.1 */ x -> x.getName()).collect(Collectors.toList())
        .forEach(System.out::println);



        singerList.stream().map(/* q2.2 */ Singer::getName)
        .forEach(System.out::println);
    }
    public static void q3_lambda_comparator() {
        List<Singer> singerList = Arrays.asList(
            new Singer("Aba","POP"),
            new Singer("Abi","POP"),
            new Singer("Abo","ROCK"),
            new Singer("Abe","ROCK")
        );
        Comparator<Singer> byStyle1 = new Comparator<>() {
            @Override
            public int compare(Singer o1, Singer o2) {
                return o1.getStyle().compareTo(o2.getStyle());
            } 
        };
        Collections.sort(singerList, byStyle1);
        singerList.forEach(System.out::println);



        Comparator<Singer> byStyle2 = /* q3.1 */ (o1, o2) -> o1.getStyle().compareTo(o2.getStyle());
        Collections.sort(singerList, byStyle2);
        singerList.forEach(System.out::println);
    }
    public static void q4_method_reference_comparator() {
        List<Singer> singerList = Arrays.asList(
            new Singer("Aba","POP"),
            new Singer("Abi","ROCK"),
            new Singer("Abo","POP"),
            new Singer("Abe","ROCK")
        );


 
        Comparator<Singer> byName = /* q4.1 */ Comparator.comparing(Singer::getName);
        Collections.sort(singerList, byName);
        singerList.forEach(System.out::println);

        singerList.sort( /* q4.2 */ (o1,o2) -> o1.getStyle().compareTo(o2.getStyle()));
        singerList.forEach(System.out::println);
    }
}    