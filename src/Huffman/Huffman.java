package Huffman;

import java.util.PriorityQueue;
import jdk.jshell.execution.JdiExecutionControl;
import java.util.HashMap;

public class Huffman {
    private static Node root;
    public static  String res="";
    public static void print(Node root, String s) {
        if (root.getLeft() == null && root.getRight() == null && Character.isLetter(root.getC())) {
            System.out.println(root.getC() + " | " + s);
            res+= s + "|";
            return;
        }
        print(root.getLeft(), s + "0");
        print(root.getRight(), s + "1");
    }

    public static String decode(String S_n)
    {

         String S= "";
        Node base= root;
         for (char c: S_n.toCharArray())
         {
             if( c == '0') {
                 S+=root.getRight().getElement();
             }
             else
             {
                 base=base.getLeft();
             }
         }
         StringBuilder output= new StringBuilder();
         while (!S.isEmpty())
         {
             if(S.charAt(0)=='1'){
                 base=base.getRight();
                 S=S.substring(1);
             }
             else {
                 base=base.getLeft();
                 S=S.substring(1);
             }
             if(base.getRight()==null && base.getRight()==null){
                 output.append(base.getC());
                 base =root;
             }
         }
        System.out.println(output.toString());
         return output.toString();
    }

    public static void calculateFreq(Integer [] freq, char [] charArray)
    {
        res= "";
        HashMap<Character, Integer> freq_char = new HashMap<>();
        for(char c:charArray)
        {
            if(freq_char.containsKey(c))
            {
                freq_char.replace(c,freq_char.get(c)+1);
            }
            else
            {
                freq_char.put(c,1);
            }
            for(int i =0; i<freq.length; i++)
            {
                freq[i]=freq_char.get(charArray[i]);
            }
        }
    }
    public static  String encode (String input){
        char [] charArray= input.toCharArray();
        int n = charArray.length;

        Integer [] charfreq = new Integer[charArray.length];
        calculateFreq(charfreq,charArray);
        for (int i=0; i< charArray.length;i++)
        {
            System.out.print(charArray[i]);
        }
        System.out.println();
        System.out.println("= = = = = = = = = =");
        System.out.println("FREQ:");
        System.out.print("|");
        for (int i = 0; i < charfreq.length; i++)
        {
            System.out.print(charfreq[i] + "|");
        }

        PriorityQueue<Node> queue = new PriorityQueue<Node>(n, new HComparator());

        for (int i = 0; i < n; i++) {
            Node node = new Node();

            node.setC(charArray[i]);
            node.setElement(charfreq[i]);

            node.setLeft(null);
            node.setRight(null);

            queue.add(node);
        }

        Node root = null;

        while (queue.size() > 1){

            Node x = queue.peek();
            queue.poll();
            Node y = queue.peek();
            queue.poll();
            Node nf = new Node();

            nf.setElement(x.getElement() + y.getElement());
            nf.setC('-');
            nf.setLeft(x);
            nf.setRight(y);
            root = nf;

            queue.add(nf);
        }
        System.out.println();
        System.out.println("= = = = = = = = = =");
        print(root, "");
        Huffman.root=root;
        return res;

    }
}

