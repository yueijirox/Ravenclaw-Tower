package packA;
public class Programmer extends EmpTmp{
    public Programmer(String n,int exp , int sal){
        name = n;
        experience=exp;
        salary=sal;
    }
    
    public String toString() {
        return "Programmer [name=" + name + ", salary=" + salary + ", experience=" + experience + "]";
    }
    public String coding(){
        return "HI I PUAK DEK KAPK";
    }
    public void sayHi(String n){
        System.out.println("hi from "+n);
    }
}