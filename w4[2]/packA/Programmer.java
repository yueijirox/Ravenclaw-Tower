package packA;

import java.util.ArrayList;

public class Programmer extends Employee{
    private ArrayList<String> skills = new ArrayList<>();




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


    @Override
    public void sayHi(){
        System.out.println("hi from Programmer ");
    }





}