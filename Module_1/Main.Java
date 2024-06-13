public class Main {
    public static void main(String[] args)
    {
        int[] array = new int[8];
        array[0] = 67;
        array[1] = 22;
        array[2] = 58;
        array[3] = 99;
        array[4] = 40;
        array[5] = 82;
        array[6] = 10;
        array[7] = 41;

        System.out.println("Before sort:");
        printArray(array);

        selectionSort(array);

        System.out.println("After sort:");
        printArray(array);
    }

    public static void printArray(int[] array)
    {
        System.out.print("array: ");
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + ", ");
        }
        System.out.println(" ");
    }

    public static void bubbleSort(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            System.out.println("pass " + i);
            for (int j = 0; j < array.length - 1 - i; j++)
            {
                if (array[j] < array[j + 1]) {
                    System.out.println(array[j] + " smaller than " + array[j + 1] + ", swapping");

                    int swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
                printArray(array);
            }
        }
    }

    public static void selectionSort(int[] array)
    {
        for(int i = array.length - 1; i > 0; i--)
        {
            System.out.println("pass " + (array.length - 1 - i));

            int smallestIndex = 0;

            for(int j = 1; j <= i; j++)
            {
                if(array[smallestIndex] > array[j])
                {
                    System.out.println(array[j] + " smaller than " + array[smallestIndex]);
                    smallestIndex = j;
                }
            }

            int swap = array[i];
            array[i] = array[smallestIndex];
            array[smallestIndex] = swap;
            printArray(array);
        }
    }
}
