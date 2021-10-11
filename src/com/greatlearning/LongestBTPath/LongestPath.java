package com.greatlearning.LongestBTPath;
import java.util.ArrayList;

public class LongestPath {

    static class Node{
        int data;
        Node right ,left;

        public Node(int data) {
            this.data=data;
            right =left=null;
        }
    }

    public static void main(String[] args) {

        //Hardcoded Tree Values
		Node root = new Node( 100 );
        root.left = new Node( 20 );
        root.right = new Node( 130 );
        root.left.left = new Node( 10 );
        root.left.right = new Node( 50 );
        root.right.left = new Node( 110 );
        root.right.right = new Node( 140 );
        root.left.left.left = new Node(5);


        ArrayList<Node> longestPath = getLongestPath( root );

        //Print Longest path
        for(int i=longestPath.size()-1;i>=0;i--) {
            String appendS = i==0 ?"":"->";
            System.out.print(longestPath.get(i).data+appendS);
        }
        System.out.println();
        System.out.println("Longest path size is : " + longestPath.size() );

    }

    private static ArrayList<Node> getLongestPath(Node root) {

        if(root == null) {
            return new ArrayList<>();
        }
        ArrayList<Node> left = getLongestPath(root.left);
        ArrayList<Node> right = getLongestPath(root.right);

        if(left.size() > right.size()) {
            left.add(root);
            return left;
        }else {
            right.add(root);
            return right;
        }
    }
}