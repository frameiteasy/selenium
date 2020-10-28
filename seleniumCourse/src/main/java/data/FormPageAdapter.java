package data;

import java.util.HashMap;
import java.util.Map;

public class FormPageAdapter {

    private Map<String, String> educationMap = new HashMap<String, String>();
    private Map<String, String> sexMap = new HashMap<String, String>();

    //konstruktor
    public FormPageAdapter(){
        this.educationMap.put("High School", "radio-button-1");
        this.educationMap.put("College", "radio-button-2");
        this.educationMap.put("Grad School", "radio-button-3");
        this.sexMap.put("Male", "checkbox-1");
        this.sexMap.put("Female", "checkbox-2");
        this.sexMap.put("Prefer not to say", "checkbox-3");
    }

    public String getEducation(String educationLevel){
        return this.educationMap.get(educationLevel);
    }

    public String getSex(String sexDeclared){
        return this.sexMap.get(sexDeclared);
    }

    public String getExperience(int experienceYears){
        if (experienceYears <= 1){
            return "option[value='1']";
        }
        else if(experienceYears <= 4){
            return "option[value='2']";
        }
        else if(experienceYears <= 9){
            return "option[value='3']";
        } else {
            return "option[value='4']";
        }
    }







}
