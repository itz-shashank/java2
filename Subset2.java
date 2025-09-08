import java.util.*;

public class Subset2 {

    static void printAns(List<List<Integer>> ans) {
        System.out.println("The unique subsets are: ");
        for (List<Integer> subset : ans) {
            System.out.println(subset);
        }
    }

    public static void backtrack(int index, int[] nums, List<Integer> ds, List<List<Integer>> res) {
        res.add(new ArrayList<>(ds));

        for (int i = index; i < nums.length; i++) {
            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;

            ds.add(nums[i]);
            backtrack(i + 1, nums, ds, res);
            ds.remove(ds.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // ✅ sort once
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        List<List<Integer>> ans = subsetsWithDup(nums);
        printAns(ans);
    }
}
