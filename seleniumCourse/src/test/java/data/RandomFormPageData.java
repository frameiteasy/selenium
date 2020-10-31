package data;

import java.util.Random;

public class RandomFormPageData {

    private static final int MAX_EXPERIENCE = 15;

    private String[] firstNames = {"Jola", "Konrad", "Kasia", "Piotr", "Krzysztof"};
    private String[] lastNames = {"Szostak-Marciniak", "Szostak", "Marciniak", "Nowak", "Kowalski", "Batman", "Joker", "Bąk"};
    private String[] jobs = {"QA Tester", "Killer", "Brak", "Driver", "CEO", "Fireman", "Policeman", "Actor"};
    private String[] education = {"High School", "College", "Grad School"};
    private String[] sex = {"Male", "Female", "Prefer not to say"};

    public String getFirstName(){
        int randomInt = getRandomInt(firstNames.length);
        return firstNames[randomInt];
    }

    public String getLastName(){
        int randomInt = getRandomInt(lastNames.length);
        return lastNames[randomInt];
    }

    public String getJob(){
        int randomInt = getRandomInt(jobs.length);
        return jobs[randomInt];
    }

    public String getEducation(){
        int randomInt = getRandomInt(education.length);
        return education[randomInt];
    }

    public String getSex(){
        return sex[getRandomInt(sex.length)];
    }

    public int getExperience(){
        return getRandomInt(MAX_EXPERIENCE);
    }

    private int getRandomInt(int bound){
        Random random = new Random();
        return random.nextInt(bound);
    }
}
