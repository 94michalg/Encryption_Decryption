package encryptdecrypt;

public class Algorithm {

    private AlgorithmStrategy strategy;

    public void setStrategy(AlgorithmStrategy strategy) {
        this.strategy = strategy;
    }

    public String encryption(boolean decryption, int key, String input) {
        return this.strategy.encryptOrDecrypt(decryption, key, input);
    }
}
