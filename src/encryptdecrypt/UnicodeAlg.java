package encryptdecrypt;

public class UnicodeAlg implements AlgorithmStrategy {

    @Override
    public String encryptOrDecrypt(boolean decryption, int key, String input) {
        if (decryption) {
            key = -key;
        }
        char[] array = input.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int letterAsciiCode = (int) array[i] + key;
            array[i] = (char) letterAsciiCode;
        }
        return String.valueOf(array);
    }
}
