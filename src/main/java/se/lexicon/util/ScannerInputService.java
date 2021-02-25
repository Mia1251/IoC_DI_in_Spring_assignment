package se.lexicon.util;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class ScannerInputService implements UserInputService{

    public Scanner scanner;

    @Autowired
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        String input = scanner.nextLine();
        return input;
    }

    @Override
    public int getInt() {
        int numbers = scanner.nextInt();
        return numbers;
    }
}
