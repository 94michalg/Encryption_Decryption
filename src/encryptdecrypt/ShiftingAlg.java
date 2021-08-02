package encryptdecrypt;

public class ShiftingAlg implements AlgorithmStrategy {

    @Override
    public String encryptOrDecrypt(boolean decryption, int key, String input) {
        if (decryption) {
            key = -key;
        }
        char[] array = input.toCharArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = switchChar(array[i], key);
        }
        return String.valueOf(array);
    }

    private static char switchChar (char input, int key) {
        char result;
        if (input >= 'a' && input <= 'z') {
            result = (char) (input + key);
            if (result > 'z') {
                result -= 26;
            }
            if (result < 'a') {
                result += 26;
            }
        } else if (input >= 'A' && input <= 'Z') {
            result = (char) (input + key);
            if (result > 'Z') {
                result -= 26;
            }
            if (result < 'A') {
                result += 26;
            }
        } else {
            return input;
        }
        return result;
    }

}
