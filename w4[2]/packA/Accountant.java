package packA;
public class Accountant extends Employee{
    private static String companyName="berk barn jamkad";
    private int experience;
    private String specialty;



    public Accountant(String name,int superExp,int experience,int sal,String talent){
        this.experience=experience;
        specialty=talent;
    }

    public void setSpecialty(String newSpecialty){
        specialty=newSpecialty;
    }

    public String getSpecialty(){
        return specialty;
    }

    public void setAccountExperience(int exp){
        experience=exp;
    }

    public int getAccountExperience(){
        return experience;
    }

    public String tellProfit(){
        return companyName+"'s profit is "+(int) (Math.random()*1000) +" My salary is "+salary; 
    }

    public String toString() {
        return "Accountant[experience=" + experience + ", specialty=" + specialty
                + "]";
    }
    
    public void sayHi(){
        System.out.println("Say hello from Accountant");
    }

    public static String tellMyRole(){
        return "I am an accountant at " + companyName;
    } 
    
}