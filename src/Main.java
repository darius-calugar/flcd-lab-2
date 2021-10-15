import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        var st = new SymbolTable();

        var tokens = List.of(
                "123",
                "5231",
                "514",
                "223131",
                "5",
                "1",
                "22",
                "\"This is a string\"",
                "\"This is another string\"",
                "Identifier",
                "Identifier123",
                "A",
                "B",
                "C"
        );

        var positions = tokens.stream()
                .map(st::put)
                .toList();

        for (int i = 0; i < tokens.size(); i++) {
            assert (Objects.equals(
                    st.get(positions.get(i)),
                    tokens.get(i)
            ));
            assert (Objects.equals(
                    positions.get(i),
                    st.lookup(tokens.get(i))
            ));
        }
        System.out.println("All tests passed");
    }
}
