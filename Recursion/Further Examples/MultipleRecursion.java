import java.util.HashSet;
import java.util.Set;

public class MultipleRecursion {
    public static void  puzzleSolve(int k, String S, Set<Character> U) {

        Set<Character> UCopy = new HashSet<>(U);
        String temp;

        for (char e : UCopy) {

            temp = S;
            S = S + e;
            U.remove(e);
            if (k == 1) {
                System.out.println(S);
            } else {
                puzzleSolve(k - 1, S, U);
            }
            S = temp;
            U.add(e);
        } 
    }
}