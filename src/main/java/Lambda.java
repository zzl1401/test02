import java.util.Arrays;
import java.util.List;

/**
 * zhongliang 2018/6/26.
 */
public class Lambda {
    /**
     * 桑桑桑松
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);
        //  String player = null;
        //players.forEach(player -> System.out.println(player + ";"));
        players.forEach(System.out::println);

    }



}
