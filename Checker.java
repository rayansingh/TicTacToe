public class Checker{
    public int checkColumns(int[][] table){
        int num1 = 0;
        int winner = 0;
        Boolean same = true;
        for(int i = 0; i < table.length; i++){
            num1 = table[0][i];
            for(int j = 0; j < table.length; j++){
                if(table[j][i] == num1){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }

            if(same){
                winner = num1;
                break;
            }
        }

        return winner;
    }

    public int checkRows(int[][] table){
        int num1 = 0;
        int winner = 0;
        Boolean same = true;

        for(int i = 0; i < table.length; i++){
            num1 = table[i][0];
            for(int j = 0; j < table.length; j++){
                if(table[i][j] == num1 && num1 != 0){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }

            if(same){
                winner = num1;
                break;
            }
        }

        return winner;
    }

    public int checkDiagonals(int[][] table){
        int num1 = 0;
        int winner = 0;
        Boolean same = true;

        int num2 = table.length - 1;

        num1 = table[0][table.length - 1];

        for(int i = 0; i < table.length; i++){
            if(table[i][table.length - 1 - i] == num1){
                same = true;
            } else {
                same = false;
                break;
            }
        }

        if(same){
            winner = num1;
        }

        if(winner == 0){
            num1 = table[0][0];
            for(int i = 0; i < table.length; i++){
                if(table[i][i] == num1){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }

            if(same){
                winner = num1;
            }
        }

        return winner;
    }
}
