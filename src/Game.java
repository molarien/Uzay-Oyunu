import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.CopyOnWriteArrayList;


class Fire {

    private int x;
    private int y;

    public Fire(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}


public class Game extends JPanel implements KeyListener, ActionListener {

    Timer timer = new Timer(10, this);

    private int elapsed_time = 0;
    private int spent_fire = 0;

    private Image image;

    private CopyOnWriteArrayList<Fire> fires = new CopyOnWriteArrayList<>();

    private int fireDirY = 5;

    private int ballX = 0;
    private int ballDirX = 4;

    private int ufoX = 0;
    private int ufoDirX = 20;


    public boolean control() {

        for (Fire fire : fires) {

            if (new Rectangle(fire.getX(), fire.getY(), 10, 20).intersects(new Rectangle(ballX, 0, 20, 20))) {
                return true;
            }

        }
        return false;
    }


    public Game() {

        image = new ImageIcon(getClass().getResource("/ufo.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);

        setBackground(Color.BLACK);

        timer.start();


    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.RED);
        g.fillOval(ballX, 0, 20, 20);
        g.drawImage(image, ufoX, 490, 120, 60, this);
        g.setColor(Color.blue);

        for (Fire fire : fires) {

            g.fillRect(fire.getX(), fire.getY(), 10, 20);
        }

        if (control()) {
            timer.stop();
            String message = "Winner!!!\n" +
                    "Spent Fire: " + spent_fire +
                    "\nElapsed Time: " + elapsed_time / 1000.0 + " second";

            JOptionPane.showMessageDialog(this, message);
            System.exit(0);

        }

    }

    @Override
    public void repaint() {
        super.repaint();


    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {

        int c = e.getKeyCode();

        if (c == KeyEvent.VK_LEFT) {
            if (!(ufoX <= 0)) {
                ufoX -= ufoDirX;
            } else {
                ufoX = 0;
            }
        }
        else if (c == KeyEvent.VK_RIGHT) {

            if (!(ufoX >= 660)) {
                ufoX += ufoDirX;
            } else {
                ufoX = 660;
            }
        }
        else if (c == KeyEvent.VK_CONTROL) {

            fires.add(new Fire(ufoX + 55, 485));

            spent_fire++;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        elapsed_time += 5;


        for (Fire fire : fires) {
            fire.setY(fire.getY() - fireDirY);


            if (fire.getY() < 0) {
                fires.remove(fire);
            }
        }


        ballX += ballDirX;
        if (ballX >= 750 || ballX <= 0) {
            ballDirX *= -1;
        }

        repaint();


    }


}
