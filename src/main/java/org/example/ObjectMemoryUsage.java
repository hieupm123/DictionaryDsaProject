package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.util.ClassUtils;
import org.openjdk.jol.vm.VM;

import java.util.HashSet;
import java.util.Scanner;


public class ObjectMemoryUsage {

    public static void main(String[] args) {
        try {
            File myObj = new File("out.txt");
            FileWriter myWriter = new FileWriter("hashmapMemo.txt");
//            FileWriter myWriter = new FileWriter("trieMemo.txt");
//            FileWriter myWriter = new FileWriter("bstMemo.txt");
            Scanner myReader = new Scanner(myObj);
            Integer a = Integer.parseInt(myReader.nextLine());
            System.out.println(a);
            long prev = 0;
            for(int i = 0; i < a; ++i){
                int b = Integer.parseInt(myReader.nextLine());
                HashSet<String> trie = new HashSet<>();
//                BST trie = new BST();
//                Trie trie = new TrieUseHashMap();
                for(int j = 0; j < b; ++j){
                    String c = myReader.nextLine();
                    trie.add(c);
//                    trie.insert(c, "null");
                }

                myWriter.write(Integer.toString(b));
                myWriter.write("\n");
//                myWriter.write(Long.toString(ObjectSizeCalculator.getObjectSize(trie)));
                myWriter.write(Long.toString(GraphLayout.parseInstance(trie).totalSize() - prev));
                prev = GraphLayout.parseInstance(trie).totalSize();
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
