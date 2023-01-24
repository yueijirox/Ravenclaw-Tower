package packA;

import java.util.ArrayList;

class LabCoder {
    private String name;
    int experience;
    ArrayList<String> languages = new ArrayList<>();
    LabCoder(String n, int exp) {
        name = n;
        experience = exp;
    }
    LabCoder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int exp) {
        experience=exp;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(String... ls) {
        for (String l : ls)
            languages.add(l);
    }

    public String toString() {
        String str = String.format("%s(%d)",
            name, experience
        );
        for (String s : languages)
            str += " " + s;

        return str;
    }

    public ArrayList<String> findCommonLanguage(LabCoder lc) {
        ArrayList<String> common = new ArrayList<>();
        for (String thisLang : languages) {
            for (String otherLang : lc.getLanguages()) {
                if (thisLang.equals(otherLang))
                {
                    common.add(thisLang);
                }
            }
        }

        if (common.size() == 0)
            common.add("none");
        return common;
    }
}
