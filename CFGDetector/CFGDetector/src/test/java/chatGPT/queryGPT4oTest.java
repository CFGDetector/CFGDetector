package chatGPT;


import util.Utils;
import java.io.File;
import java.io.IOException;

public class queryGPT4oTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        String apiKey = "sk-xxxxx"; // Your API key
        String apiUrl = "https://api.openai.com/";
        String pathToTheDataset = ""; // Path to the dataset, like "data/"
        for (int i = 1; i <= 58; i++) {
            String type = "positive";
            String prompt = "Suppose you are a skilled software engineer tasked with verifying the behavioral consistency of refactored code. \n" +
                    "Given an original method and its refactored version, carefully analyze whether the behavior of the original method remains unchanged after refactoring. Focus solely on behavior, not structure or readability improvements.\n" +
                    "Please determine and clearly state whether the original and refactored methods behave identically under all possible inputs.\n" +
                    "Do not generate a code summary, explanations, or suggest further refactoring. Your response must be exactly 'Yes' if identical or 'No' if not.\n" +
                    "Here we provide both the original codes and the refactored codes in markdown format.\n";
            String originalCode = Utils.readFromFile(new File(pathToTheDataset  + "/original/test" + i + ".java"));
            String nowCode = Utils.readFromFile(new File(pathToTheDataset + type + "/test" + i + ".java"));
            String res = queryGPT4o.query(apiKey, apiUrl, prompt + "Original code:\n```java\n" + originalCode + "\n```\nRefacted code:\n```java\n" + nowCode + "\n```\n");
            System.out.println(i + " " + type + ":" + res);
            type = "negative";
            nowCode = Utils.readFromFile(new File(pathToTheDataset + type + "/test" + i + ".java"));
            res = queryGPT4o.query(apiKey, apiUrl, prompt + "Original code:\n```java\n" + originalCode + "\n```\nRefacted code:\n```java\n" + nowCode + "\n```\n");
            System.out.println(i + " " + type + ":" + res);
        }
    }
}
