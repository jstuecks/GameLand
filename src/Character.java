import java.awt.*;

public class Character {
    //declare variables
    public int xpos;
    public int ypos;
    public int dx; //speed in the x direction
    public int dy; //speed in the y direction
    public int width;
    public int height;
    public Boolean isAlive;
    public Image pic;
    public Rectangle rec;
    //constructor

    public Character(int pXpos, int pYpos, int pDx, int pDy) {
        xpos = pXpos;
        ypos = pYpos;
        dx = pDx;
        dy = pDy;
        width = 100;
        height = 120;
        isAlive = true;


    }

    //additional methods, including print info
    public void bounceMove() {
        if (xpos > 1000 - width) {
            dx = (-1) * dx;

        }
        if (xpos < 0) {
            dx = (-1) * dx;

        }
        if (ypos > 700 - height) {
            dy = (-1) * dy;

        }
        if (ypos < 0) {
            dy = (-1) * dy;
        }
        xpos = xpos + dx;
        ypos = ypos + dy;
        rec = new Rectangle(xpos,ypos,width,height);
    }

    public void wrapMove() {
        if (xpos > 1000) {
            xpos = 0 - width;
        }
        if (xpos < 0 - width) {
            xpos = 1000;
        }
        if (ypos > 700) {
            ypos = 0 - height;
        }
        if (ypos < 0 - height) {
            ypos = 700;
        }
        xpos = xpos + dx;
        ypos = ypos + dy;
        rec = new Rectangle(xpos,ypos,width,height);
    }



    public void printInfo() {
        System.out.println("X Position: " + xpos);
        System.out.println("Y Position: " + ypos);
        System.out.println("X Speed: " + dx);
        System.out.println("Y Speed: " + dy);
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Alive?: " + isAlive);

    }
}