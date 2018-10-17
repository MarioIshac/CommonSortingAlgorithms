import java.util.Arrays;

public class CountSort implements Sort {
    @Override
    public void sort(final int[] values) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for (final int value : values) {
            if (value < minValue) {
                minValue = value;
            }

            if (value > maxValue) {
                maxValue = value;
            }
        }

        sort(values, minValue, maxValue);
    }

    public void sort(int[] values, int minValue, int maxValue) {
        final int[] valueCounts = new int[maxValue - minValue + 1];

        for (final int value : values) {
            final int valueRelativeToMin = value - minValue;

            valueCounts[valueRelativeToMin]++;
        }

        for (int valueOccurencesIndex = 1; valueOccurencesIndex < valueCounts.length; valueOccurencesIndex++) {
            final int previousValueCountIndex = valueOccurencesIndex - 1;
            final int previousValueCount = valueCounts[previousValueCountIndex];

            valueCounts[valueOccurencesIndex] += previousValueCount;
        }

        final int[] sortedValues = new int[values.length];

        for (int valueIndex = sortedValues.length - 1; valueIndex >= 0; valueIndex--) {
            final int value = values[valueIndex];
            final int relativeValueToMin = value - minValue;
            final int valueCount = valueCounts[relativeValueToMin];

            sortedValues[valueCount - 1] = value;
        }

        System.arraycopy(sortedValues, 0, values, 0, sortedValues.length);
    }
}
