import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SortMain {
    private static final List<Supplier<Sort>> SORTERS = List.of(
        CountSort::new,
        ExtraSpaceMergeSort::new,
        BubbleSort::new
    );

    public static void main(String[] args) {
        for (Supplier<Sort> sorterSupplier : SORTERS) {
            Sort sorter = sorterSupplier.get();

            int[] values = {1, 2, 3, 6, 5, 4, 1001, 1000, 10000};
            sorter.sort(values);

            System.out.println(Arrays.toString(values));
        }
    }
}
