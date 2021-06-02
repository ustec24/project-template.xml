package Huffman;

public class Node {
    private int element;
    private char c;
    private Node left;
    private Node right;

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
