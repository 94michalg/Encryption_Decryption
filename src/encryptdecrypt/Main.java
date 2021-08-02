package encryptdecrypt;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        // Setting all command arguments as map key-value pairs
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < args.length; i += 2) {
            map.put(args[i], args[i + 1]);
        }

        // Setting mode to encryption or decryption, depends on -mode command argument
        String mode = map.getOrDefault("-mode" , "enc");
        boolean decrypt = false; //true - decryption, false - encryption
        if (mode.equals("dec")) {
            decrypt = true;
        }

        // Input text read from file, or from -in command argument
        String inputText;
        if (!map.containsKey("-data") && !map.containsKey("-in")) {
            inputText = "";
        } else if (map.containsKey("-data") && map.containsKey("-in")) {
            inputText = map.getOrDefault("-data" , "");
        } else {
            inputText = Files.readString(Path.of(map.get("-in")));
        }

        // Key
        String keyString = map.getOrDefault("-key", "0");
        int key = Integer.parseInt(keyString);

        // Choosing algorithm
        Algorithm algo = new Algorithm();
        String algoChoice = map.getOrDefault("-alg", "shift");
        if (algoChoice.equals("unicode")) {
            algo.setStrategy(new UnicodeAlg());
        } else {
            algo.setStrategy(new ShiftingAlg());
        }

        // Generate output and saves it to file or prints it in console
        String result = algo.encryption(decrypt, key, inputText);
        if (!map.containsKey("-out")) {
                System.out.println(result);
        } else {
            File output = new File(map.get("-out"));
            try (PrintWriter writer = new PrintWriter(output)) {
                writer.write(result);
            } catch (IOException e) {
                System.out.println("Error" + e.getMessage());
            }
        }
    }
}
