public class StackEx {

    // C-6.19 and P-6.35
    public static double postfixArithmetic(String notation)
    {
        String[] notationArr = notation.split(" ");

        int sz = notationArr.length;

        ArrayStack<Double> container = new ArrayStack<>(sz);

        double m, n;

        for (String s : notationArr) {
            if (s.equals("+")) {
                m = container.pop();
                n = container.pop();
                container.push(n + m);
                
            } else if (s.equals("-")) {
                m = container.pop();
                n = container.pop();
                container.push(n - m);

            } else if (s.equals("*")) {
                m = container.pop();
                n = container.pop();
                container.push(n * m);

            } else if (s.equals("/")) {
                m = container.pop();
                n = container.pop();
                container.push(n / m);

            } else {
                container.push(Double.parseDouble(s));
            }
        }
        return container.pop();
    }
}
