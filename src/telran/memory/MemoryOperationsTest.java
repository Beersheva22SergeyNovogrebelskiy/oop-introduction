package telran.memory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MemoryOperationsTest {
private static final long MGB = 1024 * 1024;
byte ar[];

	@Test
	void maxMemoryTest() {
		int maxMemory = MemoryOperations.getMaxAvaibleMemory();
		ar = new byte[maxMemory];
		boolean flException = false;
		try {
			ar = new byte[maxMemory + 1];
			
		}catch(Throwable e) {
			flException = true;
		}
		assertTrue(flException);
	}

}