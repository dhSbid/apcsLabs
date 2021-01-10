package packaging.complex;

import java.awt.Dimension;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Node a = new Node("first node");
        Node b = new Node(a, "second node");
        Node c = new Node2d(b, "third node", 1f, 1f, 0f);

        print(a.toString());
        print(b.toString());
        print(c.toString());

        print("" + a.compareTo(b));
    }

    public static void print (String s) {
        System.out.println(s);
    }
}