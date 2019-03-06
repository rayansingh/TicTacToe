import java.util.Scanner;
import javax.swing.JFrame;
import java.io.*;

public class Runner {
    public static void main(String[] args) {
        int size;
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter a size");
        size = kb.nextInt();
        Screen sc = new Screen(size);
        //Screen2 sc2 = new Screen2(size);
        JFrame frame = new JFrame("Tic Tac Toe");
        //JFrame frame2 = new JFrame("Settings");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(sc);
        //frame2.add(sc2);
        frame.pack();
        //frame2.pack();
        frame.setVisible(true);
        //frame2.setVisible(true);
        Boolean done = false;

        //while(done != true){
        //    done = sc2.done();
        //}


    }
}
