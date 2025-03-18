# Preventing Buggy Refactorings via Control Flow Analysis

  - [General Introduction](##General-Introduction)
  - [Contents of the Replication Package](##Contents-of-the-Replication-Package)
  - [Requirements](##Requirements)
  - [Replicate the Evaluation](##How-to-Replicate-the-Evaluation)

## General Introduction

This is the replication package for ICSE submission, containing both tool and data that are requested by the replication. It also provides detailed instructions to replicate the evaluation.

## Contents of the Replication Package

- /data: Benchmark Datasets
- /CFGDetector: The implementation of CFGDetector

## Requirements
- Java >= 17

## How to Replicate the Evaluation

   1. **Import project**

      `Go to *File* -> *open*`

      Browse to the `CFGDetector` directory

      `Click *OK* -> *Trust Project*`
  
   2. **Run the experiment**

       If you want to start the replication for ChatGPT-4o, run `test/java/chatGPT/queryGPT4oTest.java` 
       
       If you want to start the replication for ChatGPT-o1, run `test/java/chatGPT/queryGPTo1Test.java` 
       
       You need to modify several variables in the code:
       
       - `apiKey` to your ChatGPT API Key.
       - `pathToTheDataset` to the path where the dataset files are located.

       If you want to start the replication for CFGDetector, run `test/java/CFGDetector/test.java` 