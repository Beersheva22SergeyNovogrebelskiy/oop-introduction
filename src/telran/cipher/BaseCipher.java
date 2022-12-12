package telran.cipher;

public class BaseCipher {
	private String key;
	private int length;
	
	public BaseCipher(int length) {
		setKey(length);
	}

	public void setKey(int length) {
		String res = "";
		if(length < 2) {
			length = 2;
		} else if(length > 94) {
			length = 94;
		}
		this.length = length;
		int[] doubleCheck = new int[127];
		char[] key = new char[length];
		int count = 0;
		while(count < length) {
			int temp = (char) getRandomNumber();
			if(doubleCheck[temp] == 0) {
				key[count] = (char) temp;
				doubleCheck[temp] = 1;
				count++;
			}
		}
		for(char i: key) {
			res += i;
		}
		this.key = res;
	}
	
	public String getKey() {
		return key;
	}

	private int getRandomNumber() {
		int min = 33; 
		int max = 126;
		return (int)(min + Math.random() * (max - min + 1));
	}
	
	public String cipher(int number) {
		char arrKey[]=key.toCharArray();
		String res = "";
		while(number != 0) {
		res = arrKey[number % length] + res;
		number /= length;
		}
		return res;
	}
	
	public int decipher(String encryptedNumber) {
		int res = 0;
		char arrEncryptedNumber[] = encryptedNumber.toCharArray();
		int power = arrEncryptedNumber.length - 1;
		char arrKey[]=key.toCharArray();
		for(int i = 0; i < arrEncryptedNumber.length; i++) {
			for(int j = 0; j < arrKey.length; j++) {
				if(arrEncryptedNumber[i] == arrKey[j]) {
				res += j * ((int) Math.pow(length, power));
				power--;
				}
			}
		}
		return res;
	}

}
