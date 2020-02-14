package pl.dawid;

import java.util.*;
import java.util.stream.Stream;

public class ProgramLogic {
    public static Map<String, Integer> getMapOfNamesWithUsageCountDividedByGender(List<Person> listOfPeople, Gender gender) {
        Map<String, Integer> listOfPeopleByGenderMap = new HashMap<>();
        for (Person p : listOfPeople) {
            if (p.getGender().equals(gender)) {
                listOfPeopleByGenderMap.merge(p.getName(), p.getCount(), Integer::sum);
            }
        }
        return listOfPeopleByGenderMap;
    }

    public static Map<String, Integer> getMapOfNamesAndUsagesWithoutGender(List<Person> listOfPeople){
        Map<String,Integer> mapOfNamesAndUsages = new HashMap<>();
        for (Person p : listOfPeople){
            mapOfNamesAndUsages.merge(p.getName(), p.getCount(), Integer::sum);
        }
        return mapOfNamesAndUsages;
    }
    public static List<Person> findXNumbersOfMostPopularNames(Map<String,Integer> mapOfNames, int howManyNames){
        List<Person> listOfPopularNames = new ArrayList<>();
        for(int i = 0;i<howManyNames; i++){
            int maxValueInMap = (Collections.max(mapOfNames.values()));
            Iterator<Map.Entry<String, Integer>> iterator = mapOfNames.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String, Integer> entry = iterator.next();
                if(entry.getValue()==maxValueInMap){
                    Person person = new Person(entry.getKey(), entry.getValue());
                    listOfPopularNames.add(person);
                    iterator.remove();
                }
            }
        }
        return listOfPopularNames;
    }
    public static void printPopularNames(List<Person> listOfPeople){
        System.out.println("This is "+listOfPeople.size()+" most popular names/letters");
        for(Person p:listOfPeople){
            System.out.println(p.getName()+" : "+p.getCount());
        }
    }
    public static Map<String, Integer> findFirstLettersUsage(Map<String, Integer> mapOfNames){
        Map<String, Integer> lettersWithUsage = new HashMap<>();
        for (Map.Entry<String, Integer> entry : mapOfNames.entrySet()){
            String letter = entry.getKey().substring(0,1);
            lettersWithUsage.merge(letter, entry.getValue(), Integer::sum);
        }
        return lettersWithUsage;
    }
    public static Stream<Map.Entry<String, Integer>> findXTopNames(Map<String, Integer> map, int howMany){
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(howMany);
    }
}
