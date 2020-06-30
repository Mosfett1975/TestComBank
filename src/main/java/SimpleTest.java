import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.Map.Entry.comparingByValue;

public class SimpleTest {

    //Вывести всех лиц чей возрас меньше 30 лет с сортировкой во возрастанию
    //ФИО --> Возраст
    public static void main(String[] args) {

        parseData(fakeData()).entrySet().stream().sorted(comparingByValue()).filter(age -> age.getValue() < 30)
                .map(map -> map.getKey().getFamilyName() + " " + map.getKey().getName() + " "
                        + map.getKey().getMiddleName() + " --> " + map.getValue()).forEach(System.out::println);

    }

    //Возвращает мапу Person --> Integer (возраст) после парсинга fakeData()
    public static Map<Person, Integer> parseData(String data) {

        Map<Person, Integer> map = new HashMap<>();
        int age;
        int i = 0;

        String[] arrSplit = data.split("\n");
        Pattern pattern = Pattern.compile("([а-яА-Я]+)\\s+([а-яА-Я]+)\\s+([а-яА-Я]+),+\\s+(\\d{1,})");

        for (i = 0; i < arrSplit.length; i++) {
            Person person = new Person();
            Matcher matcher = pattern.matcher(arrSplit[i]);
            if (matcher.find()) {
                person.familyName = matcher.group(1);
                person.name = matcher.group(2);
                person.middleName = matcher.group(3);
                age = Integer.parseInt(matcher.group(4));
                map.put(person, age);
            }
        }
        return map;
    }

    //Тестовые данные (могут содержать пустые строки)
    public static String fakeData() {
        return "Тетерин Глеб Ярославович, 14\n" +
                "Блинов Велор Ярославович, 21\n" +
                "Щербаков Гарри Протасьевич, 33\n" +
                "Носов Альфред Фролович, 65\n" +
                "Селиверстов Лавр Геласьевич, 9\n" +
                "Агафонов Корней Геннадиевич, 24\n" +
                "Сазонов Иосиф Павлович, 34\n" +
                "Данилов Осип Федотович, 12\n" +
                "Савин Вальтер Юлианович, 45\n" +
                "Филиппов Кассиан Артемович, 64\n" +
                "\n" +
                "\n";
    }

    public static class Person {
        private String familyName;
        private String name;
        private String middleName;

        public Person() {
            this.familyName = familyName;
            this.name = name;
            this.middleName = middleName;
        }

        public String getFamilyName() {
            return familyName;
        }

        public String getName() {
            return name;
        }

        public String getMiddleName() {
            return middleName;
        }


    }
}
