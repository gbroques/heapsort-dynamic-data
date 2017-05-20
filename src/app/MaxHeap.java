package app;

public class MaxHeap {

	// Size of data
	private int size;
	private int numElements;
	private int[] heap;
	
	public MaxHeap(int initialSize) {
		this.size = this.numElements = 0;
		this.heap = new int[initialSize];
	}
	
	// Insert an element into the heap
	public void insert(int element) {
		size++;
		numElements++;
		if (size >= heap.length) {
			grow();
		}

		heap[size] = element;
		
		int current = size;
		while (heap[current] > heap[parent(current)] && parent(current) != 0) {
			swap(current, parent(current));
			current = parent(current);
		}
	}
	
    public void sort() {       
        buildMaxHeap();
        for (int i = numElements; i >= 2; i--) {
            swap(1, i);
            size--;
            maxHeapify(1);
        }
    }
    
	/**
	 * Displays the heap as a comma separated list,
	 * with new lines every 20 elements.
	 */
	public void print() {
		for (int i = 1, len = numElements + 1; i < len; i++) {
			if (i % 20 == 1) {
				System.out.print(System.getProperty("line.separator"));
			}
			System.out.printf("%-6d", heap[i]);
		}
		Main.printLineBreak();
	}
	
    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
    
	private void grow() {
		int[] newHeap = new int[size * 2];
		System.arraycopy(heap, 0, newHeap, 0, heap.length);
		heap = newHeap;
		System.out.print("Growing size from " + size + " to " + size * 2);
		Main.printLineBreak();
	}

	private int parent(int i) {
		return i / 2;
	}

	private int leftChild(int i) {
		return (2 * i);
	}

	private int rightChild(int i) {
		return (2 * i) + 1;
	}

    private void buildMaxHeap() {
        for (int i = numElements / 2; i >= 1; i--) {
            maxHeapify(i);
        }
    }
    
    private void maxHeapify(int i) { 
        int leftChild = leftChild(i);
        int rightChild = rightChild(i);
        int largest = i;
        if (leftChild <= size && heap[leftChild] > heap[i]) {
            largest = leftChild;
        }
        if (rightChild <= size && heap[rightChild] > heap[largest]) {    
            largest = rightChild;
        }
        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }    
}
