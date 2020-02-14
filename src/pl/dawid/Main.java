package pl.dawid;

import com.sun.security.jgss.GSSUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.Inet4Address;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filePath = new File("Popular_Baby_Names.csv").getAbsolutePath();
        List<Person> list = new ArrayList<>();
        try {
            list = CsvReader.readAllLinesFromFile(filePath);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        //print most popular female name
        Map<String, Integer> listOfFemaleNames = ProgramLogic.getMapOfNamesWithUsageCountDividedByGender(list, Gender.FEMALE);
        ProgramLogic.printPopularNames
                (ProgramLogic.findXNumbersOfMostPopularNames
                        (listOfFemaleNames, 1));

        Map<String, Integer> mapOfAllNames = ProgramLogic.getMapOfNamesAndUsagesWithoutGender(list);

        // print most popular names
//        ProgramLogic.printPopularNames
//                (ProgramLogic.findXNumbersOfMostPopularNames
//                        (mapOfAllNames, 10));
        //  print most popular letters
        ProgramLogic.printPopularNames
                (ProgramLogic.findXNumbersOfMostPopularNames
                        (ProgramLogic.findFirstLettersUsage(mapOfAllNames),3));
        System.out.println(ProgramLogic.findXTopNames(mapOfAllNames,3));

    }
}
