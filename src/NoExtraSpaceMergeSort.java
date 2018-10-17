public class NoExtraSpaceMergeSort implements Sort {
    @Override
    public void sort(final int[] values) {
        final int middleIndex = values.length / 2;

        sort(values, 0, middleIndex, values.length - 1);
    }

    private void sort(final int[] values, final int leftStartValueIndex, final int middleValueIndex, final int rightEndValueIndex) {
        if (rightEndValueIndex - leftStartValueIndex > 1) {
            final int leftMiddleValueIndex = (leftStartValueIndex + middleValueIndex) / 2;
            final int rightMiddleValueIndex = (middleValueIndex + rightEndValueIndex) / 2;

            sort(values, leftStartValueIndex, leftMiddleValueIndex, middleValueIndex);
            sort(values, middleValueIndex, rightMiddleValueIndex, rightEndValueIndex);

            merge(values, leftStartValueIndex, middleValueIndex, rightEndValueIndex);
        }
    }

    private void merge(final int[] values, final int leftStartValueIndex, final int middleValueIndex, final int rightEndValueIndex) {
        final int leftEndValueIndex = middleValueIndex - 1;

        for (int rightValueIndex = rightEndValueIndex - 1; rightValueIndex >= middleValueIndex; rightValueIndex--) {
            int leftValueIndex = leftEndValueIndex - 1;
            final int leftEndValue = values[leftEndValueIndex];

            while (leftValueIndex >= leftStartValueIndex && values[leftValueIndex] > values[rightValueIndex]) {
                values[leftValueIndex + 1] = values[leftValueIndex];
                leftValueIndex--;
            }

            if (leftValueIndex != leftEndValueIndex - 1 || leftEndValue > values[rightValueIndex]) {
                values[leftValueIndex + 1] = values[rightValueIndex];
                values[rightValueIndex] = leftEndValue;
            }
        }
    }
}
