import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Developer dev1 = new Developer("Наташа", Arrays.asList("Java", "C++"));
        Developer dev2 = new Developer("Эрнест", Arrays.asList("Java", "Python"));
        Developer dev3 = new Developer("Элла", Arrays.asList("С#", "Python", "JavaScript"));

        Stream<Developer> developerStream = Stream.of(dev1, dev2, dev3);

        Set<String> list = developerStream
                .flatMap(d -> d.getLanguages().stream().map(l -> new AbstractMap.SimpleEntry<>(l, d)))
                .collect(Collectors.groupingBy(Map.Entry::getKey))
                .values().stream()
                .filter(entries -> entries.size() == 1)
                .map(simpleEntries -> simpleEntries.get(0).getValue().getName())
                .collect(Collectors.toSet());

        list.forEach(System.out::println);

//        List<Developer> developersWithUniqueLanguages = developerStream
//                .flatMap(developer -> developer.getLanguages().stream()
//                        .map(language -> new AbstractMap.SimpleEntry<>(language, developer)))
//                .collect(Collectors
//                        .toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue, (a, b) -> null))
//                .values().stream()
//                .filter(Objects::nonNull)
//                .distinct()
//                .collect(Collectors.toList());
//
//        developersWithUniqueLanguages.stream().map(Developer::getName).forEach(System.out::println);
    }
}

class Developer {
    private String name;
    private List<String> languages;

    public Developer(String developerName, List<String> developerLanguages) {
        this.languages = developerLanguages;
        this.name = developerName;
    }

    public String getName() {
        return name;
    }

    public List<String> getLanguages() {
        return languages;
    }
}
