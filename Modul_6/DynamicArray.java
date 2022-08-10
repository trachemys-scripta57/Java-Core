package Modul_6;

import java.util.Arrays;

class Main {
    public static class DynamicArray<T> {
        private Object[] arr;
        private int minAmount = 16;
        private int size;

        public DynamicArray() {
            this.arr = new Object[minAmount];
        }

        public void add(T el) {
            if (size < minAmount) {
                arr[size++] = el;
            } else {
                minAmount = minAmount * 2;
                arr = Arrays.copyOf(arr, minAmount);
                arr[size++] = el;
            }
        }

        public void remove(int index) {
            int n = size - index - 1;
            if (minAmount > 0) {
                System.arraycopy(arr, (index + 1), arr, index, n);
            }
            arr[--size] = null;
        }

        public T get(int index) throws ArrayIndexOutOfBoundsException {
            if (index >= size || index < 0) {
                throw new ArrayIndexOutOfBoundsException("");
            }
            return (T) arr[index];
        }
    }
}
/* https://www.youtube.com/watch?v=lbvF7PwGyvY&list=PLAma_mKffTOTtGQEbqurDRoPwDEKzzZQA&index=4 */