// Farid Ibrahimli
//
// DQWMYW
//
// PSE_Second_Assignment
//
// 2018/12/03 16:38:23
//
// This solution was submitted and prepared by Farid Ibrahimli, DQWMYW for the
// PSE_Second_Assignment assignment of the Practical software engineering I. course.
//
// I declare that this solution is my own work.
//
// I have not copied or used third party solutions.
//
// I have not passed my solution to my classmates, neither  made it public.
//
// Students’ regulation of Eötvös Loránd University (ELTE Regulations
// Vol. II. 74/C. § ) states that as long as a student presents another
// student’s work - or at least the significant part of it - as his/her own
// performance, it will count as a disciplinary fault. The most serious
// consequence of a disciplinary fault can be dismissal of the student from
// the University.
package Hunting_Game;

public class Model {

    private int size;

    private Player actualPlayer;

    private Player temp;

    public Player[][] table;

    public Model(int size) {
        this.size = size;
        actualPlayer = Player.X;

        table = new Player[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                table[i][j] = Player.NOBODY;
            }
        }

        table[0][0] = Player.X;
        table[0][size - 1] = Player.X;
        table[size - 1][0] = Player.X;
        table[size - 1][size - 1] = Player.X;
        table[(size / 2)][(size / 2)] = Player.O;
    }

    int counter1;
    int k, g;

    public Player step(int row, int column) {
        //table[row][column] = actualPlayer;
         
        if (actualPlayer == Player.X) {
            actualPlayer = Player.O;

        } else if (actualPlayer == Player.O) {
            actualPlayer = Player.X;

        }

        return table[row][column];
    }

    public Player statusChanger(int row, int column) {

        table[row][column] = Player.NOBODY;

        return table[row][column];
    }

    public Player statusChangerForNobody(int row, int column) {

        if (getActualPlayer() == Player.X) {
            return Player.O;
        } else {
            return Player.X;
        }

    }

    public Player findWinner(int cnt) {

        if (cnt < 4 * size) {
            //corners****************************************************************************************
            if (table[0][0] == Player.O && table[0][1] == Player.X && table[1][0] == Player.X && table[1][1] == Player.X) {
                return Player.X;
            }

            if (table[size - 1][0] == Player.O && table[size - 2][0] == Player.X && table[size - 1][1] == Player.X && table[size - 2][1] == Player.X) {
                return Player.X;
            }

            if (table[0][size - 1] == Player.O && table[0][size - 2] == Player.X && table[1][size - 1] == Player.X && table[1][size - 2] == Player.X) {
                return Player.X;
            }

            if (table[size - 1][size - 1] == Player.O && table[size - 1][size - 2] == Player.X && table[size - 2][size - 1] == Player.X && table[size - 2][size - 2] == Player.X) {
                return Player.X;
            }
            //******************************************************************************************************

            for (int i = 1; i < size - 1; i++) {
                if (table[i][0] == Player.O && table[i][1] == Player.X && table[i - 1][0] == Player.X && table[i + 1][0] == Player.X) {
                    return Player.X;
                }
            }

            for (int i = 1; i < size - 1; i++) {
                if (table[i][size - 1] == Player.O && table[i - 1][size - 1] == Player.X && table[i + 1][size - 1] == Player.X && table[i][size - 2] == Player.X) {
                    return Player.X;
                }
            }

            for (int i = 1; i < size - 1; i++) {
                if (table[0][i] == Player.O && table[1][i] == Player.X && table[0][i + 1] == Player.X && table[0][i - 1] == Player.X) {
                    return Player.X;
                }
            }

            for (int i = 1; i < size - 1; i++) {
                if (table[size - 1][i] == Player.O && table[size - 2][i] == Player.X && table[size - 1][i + 1] == Player.X && table[size - 1][i - 1] == Player.X) {
                    return Player.X;
                }
            }

            for (int i = 1; i < size - 1; i++) {
                for (int j = 1; j < size - 1; j++) {
                    if (table[i][j] == Player.O && table[i][j + 1] == Player.X && table[i][j - 1] == Player.X && table[i + 1][j] == Player.X && table[i - 1][j] == Player.X) {
                        return Player.X;
                    }
                }

            }
        }

        if (cnt >= 4 * size) {
            return Player.O;
        }

        return Player.NOBODY;
    }

    public Player getActualPlayer() {
        return actualPlayer;
    }

}
