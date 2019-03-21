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

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class BaseWindow extends JFrame {

    public BaseWindow() {
        setTitle("Hunting Game");
        setSize(800, 650);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                showExitConfirmation();
            }

        });
        URL url = Window.class.getResource("icon.jpg");
        setIconImage(Toolkit.getDefaultToolkit().getImage(url));

    }

    private void showExitConfirmation() {
        int n = JOptionPane.showConfirmDialog(this, "Are you sure to exit?",
                "You are quiting", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            doUponExit();
        }
    }

    protected void doUponExit() {
        this.dispose();
    }

}
