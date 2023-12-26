package org.example;

import java.util.Random;
import java.util.TreeMap;

public class BST {
    TreeMap<String,String> T = new TreeMap<>();

    public BST() {
    }

    public void insert(String en, String vi) {
        T.put(en,vi);
    }

    boolean contain(String en) {
        return T.containsKey(en);
    }

    String translate(String en) {
        return T.get(en);
    }

    void delete( String en) {
        T.remove(en);
    }

    public static void main(String[] args) {
        Random random = new Random();

        // Số ký tự trong ens
        int[] lengths = {5, 50, 500, 5000, 50000, 500000};

        for (int length : lengths) {
            String[] ens = new String[length];
            for (int i = 0; i < ens.length; i++) {
                ens[i] = generateRandomString(random, 10);
            }

            Trie trie = new TrieUseArray();
            BinarySearchTree bst = new BinarySearchTree();

            System.out.println("với số từ insert và search là " +  length);
            // insert
            long trieStartTime = System.nanoTime();
            for (String en : ens) {
                trie.insert(en, "null");
            }
            long trieEndTime = System.nanoTime();
            long trieExecutionTime = trieEndTime - trieStartTime;
            System.out.println("Thời gian thêm từ cây Trie: " + trieExecutionTime + " nanoseg");

            long bstStartTime = System.nanoTime();
            for (String en : ens) {
                bst.insert(en, "null");
            }
            long bstEndTime = System.nanoTime();
            long bstExecutionTime = bstEndTime - bstStartTime;
            System.out.println("Thời gian thêm từ BST: " + bstExecutionTime + " nanoseg");

            // search
            long trieSearchStartTime = System.nanoTime();
            for (String en : ens) {
                trie.contains(en);
            }
            long trieSearchEndTime = System.nanoTime();
            long trieSearchExecutionTime = trieSearchEndTime - trieSearchStartTime;
            System.out.println("Thời gian tìm từ cây Trie: " + trieSearchExecutionTime + " nanoseg");

            long bstSearchStartTime = System.nanoTime();
            for (String en : ens) {
                bst.contain(en);
            }
            long bstSearchEndTime = System.nanoTime();
            long bstSearchExecutionTime = bstSearchEndTime - bstSearchStartTime;
            System.out.println("Thời gian tìm từ BST: " + bstSearchExecutionTime + " nanoseg");

            System.out.println(); // In một dòng trống để phân tách giữa các lần chạy
        }
    }


    private static String generateRandomString(Random random, int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
