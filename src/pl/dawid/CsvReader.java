package pl.dawid;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class CsvReader {

     //String filePath = new File("Popular_Baby_Names.csv").getAbsolutePath();
    static List<Person> readAllLinesFromFile(String fileName) throws FileNotFoundException {
        String filePath = new File(fileName).getAbsolutePath();
        List<Person> listOfPeople = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
             reader.readLine();
             String oneLine;
             while((oneLine = reader.readLine())!=null){
                 String [] lineWithPersonData = oneLine.split(",");
                 Gender gender = Gender.valueOf(lineWithPersonData[1]);
                 String name = lineWithPersonData[3].substring(0,1).toUpperCase()
                                +lineWithPersonData[3].substring(1).toLowerCase();
                 int count = Integer.parseInt(lineWithPersonData[4]);
                 Person person = new Person(name, gender, count);
                 listOfPeople.add(person);
             }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfPeople;
    }

}
