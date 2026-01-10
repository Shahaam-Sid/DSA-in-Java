public class Ruler {

    public static void drawRuler(int nInches, int majorLength) {
        drawLine(majorLength, 0);
        for (int j = 1; j < nInches; j++) {
            drawInterval(majorLength - 1);
            drawLine(majorLength, j);
        }
    }

    private static void drawInterval(int centralLength) {
        if (centralLength >= 1) {
            drawInterval(centralLength - 1);
            drawLine(centralLength);
            drawInterval(centralLength - 1);
        }
    }
    private static void drawLine(int tickLenght, int tickLabel) {
        for (int i = 0; i < tickLenght; i++) {
            System.out.print("-");
        }
        if (tickLabel >= 0) {
            System.out.print(" " + tickLabel);
        }
        System.out.println("\n");
    }
    private static void drawLine(int tickLenght) {
        drawLine(tickLenght, -1);
    }
}