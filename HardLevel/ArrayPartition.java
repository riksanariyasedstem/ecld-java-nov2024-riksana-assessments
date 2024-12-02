public class ArrayPartition {
    public static void main(String[] args) {
        int[] arr = {2, 8, 1, 4};  
        System.out.println(canPartition(arr));
    }

    public static boolean canPartition(int[] arr) {
        int totalProduct = 1;
        int zeroCount = 0;
        
        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
                continue;
            }
            totalProduct *= num;
        }
        
        for (int num : arr) {
            if (num == 0) {
                if (zeroCount == 1) {
                    return true;  
                }
            } else if (totalProduct / num == num) {
                return true;
            }
        }
        
        return false;
    }
}
