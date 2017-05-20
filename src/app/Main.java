package app;

public class Main {

	// The maximum size of heap
	public static final int MAX_SIZE = 2000;
	
	// The size of random data generated at one time
	public static final int SIZE = 100;

	public Main() {
		
	}

	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap(SIZE);
		for (int i = 0; i < 20; i++) {
			simulateDynamicData(maxHeap);
		}
		System.out.println("Sorting heap");
		maxHeap.sort();
		maxHeap.print();
	}
	
	public static void simulateDynamicData(MaxHeap maxHeap) {
		int[] data = generateRandomData(SIZE, 1, MAX_SIZE);
		displayData(data);
		for(int element : data) {
			maxHeap.insert(element);
		}
	}
	
	/**
	 * Generates an array of random numbers from
	 * a lower bound to an upper bound inclusive.
	 * 
	 * @param size Size of array
	 * @param lower Lower Bound
	 * @param upper Upper Bound
	 * @return Array of randomly generated numbers
	 */
	public static int[] generateRandomData(int size, int lower, int upper) {
		int[] data = new int[size];
		for (int i = 0; i < size; i++) {
			data[i] = lower + (int) (Math.random() * (upper - lower + 1));
		}
		return data;
	}
	
	/**
	 * Displays a comma separated list of data,
	 * with new lines every 20 elements.
	 * @param data
	 */
	public static void displayData(int[] data) {
		for (int i = 0, len = data.length; i < len; i++) {
			if (i % 20 == 0 && i != 0) {
				System.out.print(System.getProperty("line.separator"));
			}
			System.out.printf("%-6d", data[i]);
		}
		printLineBreak();
	}
	
	public static void printLineBreak() {
		System.out.println(System.getProperty("line.separator"));
	}
}
