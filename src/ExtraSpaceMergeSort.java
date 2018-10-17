import java.util.Arrays;

public class ExtraSpaceMergeSort implements Sort {
    @Override
    public void sort(final int[] values) {
        if (values.length > 1) {
            final int middleIndex = values.length / 2;

            int[] leftValues = Arrays.copyOfRange(values, 0, middleIndex);
            int[] rightValues = Arrays.copyOfRange(values, middleIndex, values.length);

            sort(leftValues);
            sort(rightValues);

            merge(values, leftValues, rightValues);
        }
    }

    private void merge(final int[] values, final int[] leftValues, final int[] rightValues) {
        int leftIndex = 0;
        int rightIndex = 0;

        int valueIndex = 0;

        while (leftIndex < leftValues.length && rightIndex < rightValues.length) {
            final int leftValue = leftValues[leftIndex];
            final int rightValue = rightValues[rightIndex];

            if (leftValue < rightValue) {
                values[valueIndex] = leftValue;
                leftIndex++;
            }

            else {
                values[valueIndex] = rightValue;
                rightIndex++;
            }

            valueIndex++;
        }

        while (leftIndex < leftValues.length) {
            values[valueIndex++] = leftValues[leftIndex++];
        }

        while (rightIndex < rightValues.length) {
            values[valueIndex++] = rightValues[rightIndex++];
        }
    }
}
