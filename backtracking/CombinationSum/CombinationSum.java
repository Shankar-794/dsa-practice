import java.util.*;

public class CombinationSum {

    static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    static void backtrack(int[] candidates, int target, int index,
                          List<Integer> current,
                          List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0)
            return;

        for (int i = index; i < candidates.length; i++) {

            // choose
            current.add(candidates[i]);

            // explore (reuse allowed → pass i)
            backtrack(candidates, target - candidates[i], i, current, result);

            // un-choose
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = combinationSum(candidates, target);

        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }
}
