package com;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.LinkedList;

public interface FilesAndLists {
    ObjectMapper mapper = new ObjectMapper();

    File map = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\CountedWordList.json");
    File mapKeys = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\keyList.json");
    File occurrence = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\occurrence.json");
    File alphabetical = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\alphabetical.json");
    File numerical = new File("C:\\JavaKotlinSandbox\\src\\main\\resources\\numerical.json");


}
