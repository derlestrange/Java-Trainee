import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SwapHashMap {
    public static void main(String[] args) {

        Map<String, Integer> sources = new HashMap<>();
        sources.put("Maxim", 1);

        Map<Integer, String> sourcesSwapped = sources
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

        sources.forEach((key, value) -> System.out.println("key: " + key + ", value: " + value + "\n"));
        sourcesSwapped.forEach((key, value) -> System.out.println("key: " + key + ", value: " + value));

    }
}
