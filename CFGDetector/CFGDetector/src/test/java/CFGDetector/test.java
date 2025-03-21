package CFGDetector;

import chatGPT.queryGPT4o;
import util.Utils;

import java.io.File;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        String pathToTheDataset = ""; // Path to the dataset, like "data/"
        for (int i = 1; i <= 58; i++) {
            String type = "positive";
            String originalCode = Utils.readFromFile(new File(pathToTheDataset  + "/original/test" + i + ".java"));
            CFGNode original = CFGGenerator.generateCFG(originalCode);
            String nowCode = Utils.readFromFile(new File(pathToTheDataset + type + "/test" + i + ".java"));
            CFGNode now = CFGGenerator.generateCFG(originalCode);
            System.out.println(i + " " + type + ":" + CFGComparator.areCFGEqual(original, now));
            type = "negative";
            nowCode = Utils.readFromFile(new File(pathToTheDataset + type + "/test" + i + ".java"));
            now = CFGGenerator.generateCFG(originalCode);
            System.out.println(i + " " + type + ":" + CFGComparator.areCFGEqual(original, now));
        }
    }
}
