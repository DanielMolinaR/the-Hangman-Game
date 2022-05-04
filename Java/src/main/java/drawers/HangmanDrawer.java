package drawers;

import java.util.Map;

public class HangmanDrawer implements Drawer{

    private Map<Integer, String> draws = Map.of(
            0, "   _____ \n" +
                        "  |     \n" +
                        "  |      \n" +
                        "  |      \n" +
                        "  |      \n" +
                        "  |      \n" +
                        "  |      \n" +
                        "__|__\n",
            1, "   _____ \n" +
                        "  |    | \n" +
                        "  |      \n" +
                        "  |      \n" +
                        "  |      \n" +
                        "  |      \n" +
                        "  |      \n" +
                        "__|__\n",
            2, "   _____ \n" +
                        "  |     | \n" +
                        "  |     |\n" +
                        "  |      \n" +
                        "  |      \n" +
                        "  |      \n" +
                        "  |      \n" +
                        "__|__\n",
            3, "   _____ \n" +
                        "  |     | \n" +
                        "  |     |\n" +
                        "  |     | \n" +
                        "  |      \n" +
                        "  |      \n" +
                        "  |      \n" +
                        "__|__\n",
            4, "   _____ \n" +
                        "  |     | \n" +
                        "  |     |\n" +
                        "  |     | \n" +
                        "  |     O \n" +
                        "  |      \n" +
                        "  |      \n" +
                        "__|__\n",
            5, "   _____ \n" +
                        "  |     | \n" +
                        "  |     |\n" +
                        "  |     | \n" +
                        "  |     O \n" +
                        "  |     | \n" +
                        "  |       \n" +
                        "__|__\n",
            6, "   _____ \n" +
                        "  |     | \n" +
                        "  |     |\n" +
                        "  |     | \n" +
                        "  |     O \n" +
                        "  |    /|\\ \n" +
                        "  |        \n" +
                        "__|__\n",
            7, "   _____ \n" +
                        "  |     | \n" +
                        "  |     |\n" +
                        "  |     | \n" +
                        "  |     O \n" +
                        "  |    /|\\ \n" +
                        "  |    / \\ \n" +
                        "__|__\n"
    );

    @Override
    public void draw(int step) {
        System.out.println(draws.get(step));
    }
}
