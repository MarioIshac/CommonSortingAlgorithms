public class BubbleSort implements Sort {
    @Override
    public void sort(final int[] values) {
        for (int iterationIndex = 0; iterationIndex < values.length - 1; iterationIndex++) {
            for (int beforeValueIndex = 0; beforeValueIndex < values.length - iterationIndex - 1; beforeValueIndex++) {
                final int afterValueIndex = beforeValueIndex + 1;

                final int beforeValue = values[beforeValueIndex];
                final int afterValue = values[afterValueIndex];

                if (beforeValue > afterValue) {
                    values[afterValueIndex] = beforeValue;
                    values[beforeValueIndex] = afterValue;
                }
            }
        }
    }
}
