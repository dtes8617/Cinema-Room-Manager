class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        // write your code here
        if (array == null) {
            System.out.println("Exception!");
        } else {
            int lengthArray = array.length;

            if (index < 0 || index >= lengthArray) {
                System.out.println("Exception!");
            } else {
                System.out.println(array[index] * array[index]);
            }
        }

    }
}