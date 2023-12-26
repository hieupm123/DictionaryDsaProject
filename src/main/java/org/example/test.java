package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class test {

    public static void main(String[] args) {
        try {
            File myObj = new File("out.txt");
//            FileWriter myWriter = new FileWriter("trieInsert.txt");
//            FileWriter myWriter = new FileWriter("bstInsert.txt");
//            FileWriter myWriter = new FileWriter("trieContain.txt");
            FileWriter myWriter = new FileWriter("hashmapInsert.txt");
            Scanner myReader = new Scanner(myObj);
            Integer a = Integer.parseInt(myReader.nextLine());
            System.out.println(a);
            for(int i = 0; i < a; ++i){
                int b = Integer.parseInt(myReader.nextLine());
//                Trie trie = new TrieUseArray();
                HashSet<String> trie = new HashSet<>();
                ArrayList<String> tmp = new ArrayList<>();
                long bstStartTime = System.nanoTime();
                for(int j = 0; j < b; ++j){
                    String c = myReader.nextLine();
                    tmp.add(c);
                    trie.add(c);
//                    System.out.println(c);
                }
//                long bstStartTime = System.nanoTime();
//                for(String c : tmp){
//                    trie.contains(c);
//                }
                long bstEndTime = System.nanoTime();
                long bstExecutionTime = bstEndTime - bstStartTime;

                myWriter.write(Integer.toString(b));
//                System.out.println(Integer.toString(b));
                myWriter.write("\n");
//                myWriter.write(Long.toString(ObjectMemoryUsage.getObjectSize(trie)));
//                System.out.println(Long.toString(bstExecutionTime));
                myWriter.write(Long.toString(bstExecutionTime));
                myWriter.write("\n");
            }
            myReader.close();
            myWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
