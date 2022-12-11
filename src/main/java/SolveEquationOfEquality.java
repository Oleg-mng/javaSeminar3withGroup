import java.util.ArrayList;
import java.util.List;

class SolveEquationOfEquality {
    static List<Integer> questionSignInteger;
    static char[] equationCharArray;

    public static void main(String[] args) {
        String equation = "2? + ?5 = 69".replace(" ", "");
        questionSignInteger = new ArrayList<>();
        equationCharArray = equation.toCharArray();

        for (int i = 0; i < equationCharArray.length; i++) {
            if (equationCharArray[i] == '?') {
                questionSignInteger.add(i);
            }
            else if (equationCharArray[i] == '+') {
                equationCharArray[i] = '=';
                }
            }
           generateCombination(new ArrayList<>(), questionSignInteger.size());
        }

        public static void generateCombination(List<Integer> combination, int k) {
            if (combination.size() == k) {
                check(combination);
                return;
            }
            for (int i = 0; i <= 9; i++) {
                combination.add(i);
                generateCombination(combination, k);
                combination.remove(combination.size() - 1);
            }
        }
        public static void check(List<Integer> combination) {
            for (int i = 0; i <= combination.size(); i++) {
                char x = Character.forDigit(combination.get(i), 10);
                equationCharArray[questionSignInteger.get(i)] = x;
            }
            String[] arr = String.valueOf(equationCharArray).split("=");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            if (a + b == c) {
                System.out.println("Равенство %d + %d = %d верно\n");
            }
        }
}


