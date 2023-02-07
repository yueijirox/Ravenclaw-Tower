public class Main {
    public static void main(String[] args){

        Printable lamdaPrintable = () -> System.out.println("MEOW");
        printThing(lamdaPrintable);
    }
    
    static void printThing(Printable thing){
        thing.print();
    }
}
