import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.stream.*;

public class Game{
    private int[][] table;

    private int size;

    private int turn;

    private Checker c;

    private Sounds s;

    public Game(int a){
        table = new int[a][a];
        turn = 0;
        size = a;
        c = new Checker();
        s = new Sounds();

    }

    public void insertXO(int x, int y){

        if(table[x][y] == 0){
            if(turn == 0){
                table[x][y] = 1;
                turn = 1;
            } else if(turn == 1){
                table[x][y] = 2;

                turn = 0;
            }
            s.slap();
        }

    }

    public boolean checkFull(){
        boolean returner = true;
        for(int x = 0; x < table.length; x++){
            for(int y = 0; y < table[x].length; y++){
                if(table[x][y]!=0){
                    returner = true;
                } else{
                    returner = false;
                    break;
                }
            }

            if(returner == false){
                break;
            }

        }
        return returner;
    }
    public int getTurn(){
        return turn;
    }

    public void drawMe(Graphics g){
        int sx = 0;
        int sy = 0;

        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[i].length; j++){
                g.drawRect(sx,sy,50,50);

                if(table[i][j] == 0){

                } else if(table[i][j] == 1){
                    g.drawLine(sx,sy,sx+50,sy+50);
                    g.drawLine(sx,sy+50,sx+50,sy);
                } else if(table[i][j] == 2){
                    g.drawOval(sx,sy,50,50);
                } else if(table[i][j] == 3){
                    g.drawLine(sx,sy+50,sx+50,sy+50);
                    g.drawLine(sx+25,sy,sx+5,sy+50);
                    g.drawLine(sx+25,sy,sx,sy+50);
                }
                sx+=50;
            }
            sx = 0;
            sy+=50;
        }
    }

    public int checkWinner(){
        int winner = c.checkColumns(table);

        if(winner == 0){
            winner = c.checkRows(table);

            if(winner == 0){
                winner = c.checkDiagonals(table);
            }
        }

        return winner;
    }


    public void ai(){
        int rBig = 0;
        int cBig = 0;
        int bigNum = 0;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.println(calcPoints(i,j));
                if(calcPoints(i,j) >= bigNum){
                    bigNum = calcPoints(i,j);
                    rBig = i;
                    cBig = j;
                }
            }
        }

        insertXO(rBig,cBig);
    }

    public int calcPoints(int a, int b){
        int points = 0;

        //adds a point to empty squares

        if(table[a][b] == 0){
            points+=10;
            if(onlyOneRow(a,b,1)){
                points+=20;
            }

            if(onlyOneRow(a,b,2)){
                points+=40;
            }

            if(onlyOneColumn(a,b,1)){
                points+=20;
            }

            if(onlyOneColumn(a,b,2)){
                points+=40;
            }

            if(onlyOneRightDiagonal(a,b,1)){
                points+=10;
            }

            if(onlyOneRightDiagonal(a,b,2)){
                points+=20;
            }

            if(onlyOneLeftDiagonal(a,b,1)){
                points+=10;
            }

            if(onlyOneLeftDiagonal(a,b,2)){
                points+=20;
            }
        } else {
            points-=50;
        }

        

        return points;
    }

    public Boolean onlyOneRow(int a, int b, int num){
        Boolean isIt = true;

        for(int i = 0; i < size; i++){
            if(table[a][i] == 0){
                if(i == b){
                    isIt = true;
                } else {
                    isIt = false;
                    break;
                }
            } else if(table[a][i] == num){
                isIt = true;
            } else if(table[a][i] != num){
                isIt = false;
                break;
            }
        }

        return isIt;
    }

    public Boolean onlyOneColumn(int a, int b, int num){
        Boolean isIt = true;

        for(int i = 0; i < size; i++){
            if(table[i][b] == 0){
                if(i == a){
                    isIt = true;
                } else {
                    isIt = false;
                    break;
                }
            } else if(table[i][b] == num){
                isIt = true;
            } else if(table[i][b] != num){
                isIt = false;
                break;
            }
        }

        return isIt;
    }

    public Boolean onlyOneRightDiagonal(int a, int b, int num){
        Boolean isIt = true;

        if(a == b){
            for(int i = 0; i < size; i++){
                if(table[i][i] == 0){
                    if(i == a){
                        isIt = true;
                    } else if(table[i][i] == num){
                        isIt = true;
                    } else if(table[i][i] != num){
                        isIt = false;
                        break;
                    }
                }
            }
        } else{
            isIt = false;
        }
        

        return isIt;
    }

    public Boolean onlyOneLeftDiagonal(int a, int b, int num){
        Boolean isIt = true;

        if(a == ((size - 1) - b)){
            for(int i = 0; i < size; i++){
                if(table[i][size - 1 - i] == 0){
                    if(i == a){
                        isIt = true;
                    } else if(table[i][size - i - 1] == num){
                        isIt = true;
                    } else if(table[i][size - i - 1] != num){
                        isIt = false;
                        break;
                    }
                }
            }
        } else{
            isIt = false;
        }

        return isIt;
    }


}