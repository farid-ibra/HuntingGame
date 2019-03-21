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

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Window extends BaseWindow {

    private final int size;
    private final Model model;
    private final JLabel label;
    private final MainWindow mainWindow;

    private JButton[][] table;

    public Window(int size, MainWindow mainWindow) {
        this.size = size;
        this.mainWindow = mainWindow;
        mainWindow.getWindowList().add(this);
        model = new Model(size);
        table = new JButton[size][size];
        JPanel top = new JPanel();

        label = new JLabel();
        updateLabelText();

        JButton newGameButton = new JButton();
        newGameButton.setText("New game");
        newGameButton.addActionListener(e -> newGame());

        top.add(label);
        top.add(newGameButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(size, size));

        for (int i = 0; i < size; ++i) {

            for (int j = 0; j < size; ++j) {

                addButton(mainPanel, i, j);
            }
        }

        table[0][0].setText("X");
        table[0][size - 1].setText("X");
        table[size - 1][0].setText("X");
        table[size - 1][size - 1].setText("X");
        table[(size / 2)][(size / 2)].setText("O");

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(top, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

    int k;
    int g;
    int counter = 0;
    int cnt = 0;

    private void addButton(JPanel panel, final int i, final int j) {
        final JButton button = new JButton();

        table[i][j] = button;

        button.addActionListener(e -> {

            if (model.table[i][j].name() == "X" && model.table[i][j].name() == model.getActualPlayer().name() ) { //tam deyil
                k = i;
                g = j;
                button.setText("");
                counter = 1;

            }

            if (model.table[i][j].name() == "O" && model.table[i][j].name() == model.getActualPlayer().name()) {
                k = i;
                g = j;
                button.setText("");
                counter = 1;

            }

            if (model.table[i][j].name() == "NOBODY" && counter == 1) {
                Player newValue = model.step(k, g);
                button.setText(newValue.name());
                model.table[i][j] = model.statusChangerForNobody(k, g);

                table[k][g].setName("NOBODY");
                model.table[k][g] = model.statusChanger(k, g);

                counter = 0;
                cnt++;
            }
            updateLabelText();

            Player winner = model.findWinner(cnt);
            if (winner != Player.NOBODY) {
                showGameOverMessage(winner);
            }

        });

        panel.add(button);
    }

    private void showGameOverMessage(Player winner) {
        JOptionPane.showMessageDialog(this,
                "Game is over. Winner: " + winner.name());
        newGame();
    }

    public void newGame() {
        Window newWindow = new Window(size, mainWindow);
        newWindow.setVisible(true);

        this.dispose();
        mainWindow.getWindowList().remove(this);
    }

    private void updateLabelText() {
        label.setText("Current player: "
                + model.getActualPlayer().name()
                + " Moves: " + cnt);
    }

    @Override
    protected void doUponExit() {
        super.doUponExit();
        mainWindow.getWindowList().remove(this);
    }

}
