import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ElevenElementException {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            list.add(i);
            if (list.size() > 10) {
                throw new ElevenElementException("overflow");
            }
        }

        list.forEach(System.out::println);
    }
}
