
// Tc = 0(n)
//sc = 0(n)
import java.util.List;
import java.util.Stack;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev = 0;
        for (String log : logs) { // 0:start:0",
            String[] splitArr = log.split(":");
            int curr = Integer.parseInt(splitArr[2]);
            int task = Integer.parseInt(splitArr[0]);

            if (splitArr[1].equals("start")) {
                if (!st.isEmpty()) {
                    result[st.peek()] += curr - prev;
                }
                prev = curr;
                st.push(task);
            } else {
                result[st.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }

        }
        return result;

    }
}
