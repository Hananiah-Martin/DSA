public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1,10,100};
        int[] arr2 = {1000};
        System.out.println(longestCommonPrefix(arr1, arr2));
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        int minLength = Math.min(arr1.length, arr2.length);
        int longestCommonPrefixLength = 0;

        for (int i = 0; i < minLength; i++) {
            int[] commonPrefix = longestCommonPrefix(arr1[i], arr2[i]);
            if (commonPrefix.length > longestCommonPrefixLength) {
                longestCommonPrefixLength = commonPrefix.length;
            }
        }

        return longestCommonPrefixLength;
    }

    public static int[] longestCommonPrefix(int num1, int num2) {
        int[] prefix = new int[10];
        int prefixLength = 0;

        while (num1 > 0 && num2 > 0) {
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;

            if (digit1 != digit2) {
                break;
            }

            prefix[prefixLength++] = digit1;
            num1 /= 10;
            num2 /= 10;
        }

        int[] commonPrefix = new int[prefixLength];
        System.arraycopy(prefix, 0, commonPrefix, 0, prefixLength);
        return commonPrefix;
    }
}