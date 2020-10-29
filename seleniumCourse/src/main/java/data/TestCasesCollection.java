package data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestCasesCollection {

    private List<FormPageDTO> testCasesList = new ArrayList<>();

    public TestCasesCollection(){
        FormPageDTO testCasesDTO1 = new FormPageDTO("Jola", "Szostak-Marciniak", "QA Tester", "High School", "Female", 7, new Date());
        FormPageDTO testCasesDTO2 = new FormPageDTO("Konrad", "Marciniak", "Killer", "High School", "Male", 799, new Date());
        FormPageDTO testCasesDTO3 = new FormPageDTO("Kasia", "Kowalski", "Brak", "College", "Male", 3, new Date());
        FormPageDTO testCasesDTO4 = new FormPageDTO("Basia", "Nowak", "Driver", "Grad School", "Female", 1, new Date());
        FormPageDTO testCasesDTO5 = new FormPageDTO("Rysiu", "Nowak", "CEO", "High School", "Prefer not to say", 5, new Date());
        this.testCasesList.add(testCasesDTO1);
        this.testCasesList.add(testCasesDTO2);
        this.testCasesList.add(testCasesDTO3);
        this.testCasesList.add(testCasesDTO4);
        this.testCasesList.add(testCasesDTO5);
    }
    //TODO
    // 1. add one new constructor for csv/xls files
    // 2. add a second one for DB

    public void addTestCase(FormPageDTO testCase){
        testCasesList.add(testCase);
    }
    public List<FormPageDTO> getTestCasesList(){
        return testCasesList;
    }


}
