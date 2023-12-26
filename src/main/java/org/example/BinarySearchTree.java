package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class BinarySearchTree {
    public class Node {
        String en;
        String vi;
        Node left;
        Node right;

        public Node(String en, String vi) {
            this.en = en;
            this.vi = vi;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(String en, String vi) {
        root = insertRecursive(root, en, vi);
    }

    Node insertRecursive(Node root, String en, String vi) {
        if (root == null) {
            return new Node(en, vi);
        }
        if (en.compareTo(root.en) < 0) {
            root.left = insertRecursive(root.left, en, vi);
        } else if (en.compareTo(root.en) > 0) {
            root.right = insertRecursive(root.right, en, vi);
        }
        return root;
    }

    boolean contain(String en) {
        Node n = search(root,en);
        return n.en.compareTo(en) == 0;
    }

    Node search(Node root, String en) {
        if (root == null) {
            return null;
        }
        if (en.equals(root.en)) {
            return root;
        }
        if (en.compareTo(root.en) < 0) {
            return search(root.left, en);
        }
        return search(root.right, en);
    }
    String translate(String en) {
        Node n = search(root,en);
        return n.vi;
    }
    Node delete(Node root, String en) {
        if (root == null)
            return root;
        if (root.en.compareTo(en) > 0) {
            root.left = delete(root.left, en);
            return root;
        } else if (root.en.compareTo(en) < 0) {
            root.right = delete(root.right, en);
            return root;
        }
        if (root.left == null) {
            Node temp = root.right;
            return temp;
        } else if (root.right == null) {
            Node temp = root.left;
            return temp;
        } else {
            Node succParent = root;
            Node succ = root.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }
            if (succParent != root)
                succParent.left = succ.right;
            else
                succParent.right = succ.right;
            root.en = succ.en;
            return root;
        }
    }
    public static void main(String[] args) {
        Random random = new Random();

        // Số ký tự trong ens
//        int[] lengths = {5, 50, 500, 5000, 50000, 500000};

        ArrayList<Integer> lengths = new ArrayList<>();
        for(int i = 1; i <= 100000; i += 100){
            lengths.add(i);
        }
        try {
            FileWriter myWriter = new FileWriter("test.txt");
            myWriter.write(Integer.toString(lengths.size()));
            myWriter.write("\n");
            for (int length : lengths) {
                String[] ens = new String[length];
                myWriter.write(Integer.toString(length));
                myWriter.write("\n");
                for (int i = 0; i < ens.length; i++) {
                    ens[i] = generateRandomString(random, 10);
                    myWriter.write(ens[i]);
                    myWriter.write("\n");
                }
            }

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
//        for (int length : lengths) {
//            String[] ens = new String[length];
//            for (int i = 0; i < ens.length; i++) {
//                ens[i] = generateRandomString(random, 10);
//            }

//            BinarySearchTree bst = new BinarySearchTree();
//
//            long bstStartTime = System.nanoTime();
//            for (String en : ens) {
//                bst.insert(en, "null");
//            }
//            long bstEndTime = System.nanoTime();
//            long bstExecutionTime = bstEndTime - bstStartTime;
//            System.out.println("Thời gian thêm từ BST: " + bstExecutionTime + " nanoseg");


//            long bstSearchStartTime = System.nanoTime();
//            for (String en : ens) {
//                bst.contain(en);
//            }
//            long bstSearchEndTime = System.nanoTime();
//            long bstSearchExecutionTime = bstSearchEndTime - bstSearchStartTime;
//            System.out.println("Thời gian tìm từ BST: " + bstSearchExecutionTime + " nanoseg");

//            System.out.println(); // In một dòng trống để phân tách giữa các lần chạy
//        }
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
