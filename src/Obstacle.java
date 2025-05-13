import java.awt.*;

public class Obstacle {

    public int dx;
    public int dy;

    public int xpos;
    public int ypos;


    public int width;
    public int height;

    public boolean isAlive;
    public Rectangle rec;

    public Obstacle(int pXpos, int pYpos, int pDx, int pDy) {
        xpos = pXpos;
        ypos = pYpos;
        dx = pDx;
        dy = pDy;
        width = (int)(Math.random()*100+30);
        height = width;
        isAlive = true;
        rec = new Rectangle(xpos, ypos, width/2, height/2);
    }

    public void bagCollected() {
        isAlive = false;
        dx = 0;
        dy = 0;
        ypos = 5000;
    }

    public void Wrap() {
        if (xpos < -2000 ) {
            xpos = 4000;
        }


        xpos = xpos + dx;
        ypos = ypos + dy;
        rec = new Rectangle(xpos, ypos, width, height);

    }
}