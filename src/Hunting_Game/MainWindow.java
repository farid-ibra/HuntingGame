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

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class MainWindow extends BaseWindow {

    private List<Window> gameWindows = new ArrayList<>();

    public MainWindow() {

        JButton small = new JButton();
        small.setText("3 x 3");

        small.addActionListener(getActionListener(3));

        JButton medium = new JButton();
        medium.setText("5 x 5");

        medium.addActionListener(getActionListener(5));

        JButton large = new JButton();
        large.setText("7 x 7");

        large.addActionListener(getActionListener(7));

        getContentPane().setLayout(
                new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(small);
        getContentPane().add(medium);
        getContentPane().add(large);
    }

    private ActionListener getActionListener(final int size) {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Window window = new Window(size, MainWindow.this);
                window.setVisible(true);

                gameWindows.add(window);
            }

        };
    }

    public List<Window> getWindowList() {
        return gameWindows;
    }

    @Override
    protected void doUponExit() {
        System.exit(0);
    }

}
