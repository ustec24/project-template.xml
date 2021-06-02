

import Huffman.Huffman;


import javax.swing.*;
import java.awt.*;
public class Window extends JFrame {
    private JButton button1;
    private JTextField text1;
    private JTextField text2;
    private  JButton code_decode;
    private boolean code=true;

    public Window()
    {
        setUpMainFrame();
        setUpComponents();
        setVisible(true);
    }
    private void setUpMainFrame(){
        this.setSize(new Dimension(720,340));
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Kodowanie Huffmana Koder/Dekoder");
        this.setBackground(Color.ORANGE);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void setUpComponents()
    {
        //Button 1
        button1 = new JButton("KODUJ");
        button1.setSize(140,45);
        button1.setLocation(getWidth()/2- button1.getWidth()-5,230);
        button1.addActionListener(e -> {
        //algorytm kodowania
        if (code)
        {
            text2.setText(Huffman.encode(text1.getText()));
        } else {
            text1.setText(Huffman.decode(text2.getText()));
        }
    });
        add(button1);

        //button2
        code_decode= new JButton("KODUJ/DEKODUJ");
        code_decode.setSize(140,45);
        code_decode.setLocation(getWidth()/2+5,230);
        code_decode.addActionListener( e -> {
            if(code)
            {
                text1.setEnabled(false);
                text2.setEnabled(true);
                button1.setText("DEKODUJ");
                code=false;
            }else{
                text1.setEnabled(false);
                text2.setEnabled(true);
                button1.setText("KODUJ");
                code=true;
            }
        });
        add(code_decode);
        //TEXT1
        text1 = new JTextField("Encode");
        text1.setSize(320, 38);
        text1.setLocation(getWidth()/2- text1.getWidth()/2, 90);
        text1.setFont(new Font(Font.SERIF, Font.PLAIN, 21));
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        add(text1);


        //TEXT2
        text2 = new JTextField("Decode");
        text2.setSize(320, 38);
        text2.setLocation(getWidth()/2- text2.getWidth()/2, 150);
        text2.setFont(new Font(Font.SERIF, Font.PLAIN, 21));
        text2.setHorizontalAlignment(SwingConstants.CENTER);
        text2.setEnabled(false);
        add(text2);

    }
}






