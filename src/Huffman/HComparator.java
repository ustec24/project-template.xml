package Huffman;

import java.util.Comparator;

public class HComparator implements Comparator<Node>
{
    public int compare(Node x, Node y)
    {
        return x.getElement() - y.getElement();
    }
}
