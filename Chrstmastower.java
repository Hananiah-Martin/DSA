import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Chrstmastower {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int L = scanner.nextInt();
        int[] blockHeights = new int[5];

        for (int i = 0; i < 5; i++) {
            blockHeights[i] = scanner.nextInt();
        }

        int[] result = constructTower(L, blockHeights);

        if (result == null) {
            System.out.println("Impossible");
        } else {
            for (int height : result) {
                System.out.print(height + " ");
            }
        }
    }

    private static int[] constructTower(int L, int[] blockHeights) {
        Map<Integer, Integer> blockCount = new HashMap<>();
        for (int height : blockHeights) {
            blockCount.put(height, blockCount.getOrDefault(height, 0) + 1);
        }

        Integer[] sortedBlocks = new Integer[blockCount.size()];
        blockCount.keySet().toArray(sortedBlocks);

        Arrays.sort(sortedBlocks, (a, b) -> {
            int freqComparison = Integer.compare(blockCount.get(b), blockCount.get(a));
            return (freqComparison != 0) ? freqComparison : Integer.compare(a, b);
        });

        int[] result = new int[L];
        int currentHeight = 0;
        int currentIndex = 0;

        for (int height : sortedBlocks) {
            int count = blockCount.get(height);
            while (currentHeight + height <= L && count > 0) {
                result[currentIndex++] = height;
                currentHeight += height;
                count--;
            }
        }

        return (currentHeight == L) ? Arrays.copyOf(result, currentIndex) : null;
    }
}
