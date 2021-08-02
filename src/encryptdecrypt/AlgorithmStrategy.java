package encryptdecrypt;

public interface AlgorithmStrategy {
    String encryptOrDecrypt (boolean decrypt, int key, String input);
}
