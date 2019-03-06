import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.logging.*;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Screen extends JPanel implements MouseListener {

    private int size;

    private Game game;

    public Screen(int a){

        game = new Game(a);
        size = a;

        setFocusable(true);
        addMouseListener(this);
    }

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(size * 50, size * 50);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        game.drawMe(g);

    }

    public void mousePressed(MouseEvent e) {
        int x = 0;
        int y = 0;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(e.getX() > (i * 50) && e.getX() < ((i * 50) + 50) && e.getY() > (j * 50) && e.getY() < ((j * 50) + 50)){
                    x = j;
                    y = i;
                }
            }
        }

        if(game.getTurn() == 0){
            game.insertXO(x,y);
        } else if(game.getTurn() == 1){
            game.ai();
        }


        int winner = game.checkWinner();
        Boolean full = false;

        if(winner == 0){
            full = game.checkFull();
        } else {
            System.out.println("The winner is player " + winner);
        }

        if(full){
            System.out.println("Draw");
        }

        repaint();

    }

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {}



}
