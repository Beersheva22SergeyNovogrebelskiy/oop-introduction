package telran.cipher;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CipherTests {

	@Test
	void baseCipherTest() {
		BaseCipher baseCipher = new BaseCipher(67);
		int num = 4456543;
		String encryptedNumber = baseCipher.cipher(num);
		assertEquals(num, baseCipher.decipher(encryptedNumber));
		baseCipher.setKey(1234);
		num = 0;
		encryptedNumber = baseCipher.cipher(num);
		assertEquals(num, baseCipher.decipher(encryptedNumber));
		baseCipher.setKey(-8);
		num = 600;
		encryptedNumber = baseCipher.cipher(num);
		assertEquals(num, baseCipher.decipher(encryptedNumber));
	}

}
