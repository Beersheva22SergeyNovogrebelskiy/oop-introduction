package telran.memory;

public class MemoryOperations {
public static int getMaxAvaibleMemory() {
	int maxMemory = Integer.MAX_VALUE;
	byte ar[] = null;
	int minMemory = 0;
	int middle = (maxMemory + minMemory) /2;
	int count = 0;
	while(minMemory <= maxMemory) {
		try {
			ar = new byte[middle];
			minMemory = middle + 1;
			count++;
		} catch (Throwable e) {
			maxMemory = middle - 1;
			count++;
		}
		middle = (maxMemory + minMemory) / 2;
	}
	System.out.println(count);
	return middle;
}


}