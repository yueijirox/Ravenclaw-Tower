package packA;

import java.util.ArrayList;
public class Lab3Driver {
    static LabCoder keng;
    static LabCoder somsri;
    public static void main(String[] args) {
        q2();
        q3();
    }

    static void q2() {
        somsri = new LabCoder("Somsri", 5);
        somsri.setLanguages("javascript", "dart");
    }

    static void q3() {
        keng = new LabCoder("Keng", 2);
        keng.setLanguages("java", "solidity", "c");

        LabCoder ber3 = new LabCoder("ber3");
        ber3.setLanguages("c", "java", "typescript");

        System.out.println(ber3);
        System.out.println();


        ArrayList<String> commonLanguages = ber3.findCommonLanguage(somsri);
        System.out.println(commonLanguages);
        System.out.println(keng.findCommonLanguage(ber3));
    }
}
