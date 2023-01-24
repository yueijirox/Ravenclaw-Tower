package packA;

public class Lab1Driver {
    public static void main(String[] args){
        q1();
    }
        static void q1(){
        LabCoder santa = new LabCoder("Santa",8);
        santa.setName("Santa");
        santa.setExperience(3);
        String str = String.format("%s has been working for %d years."
                                            ,santa.getName(), santa.getExperience() );
        System.out.println(str);//santa has been workign for 3 years
        santa.experience=99;
        System.out.println(santa.experience);   
                       
    }
}