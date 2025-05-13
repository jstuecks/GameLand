import java.awt.*;

public class Character {
    //declare variables
    public int xpos;
    public int ypos;

    public double dx; //speed in the x direction
    public double dy;//speed in the y direction

    public double ddx;
    public double ddy;

    public boolean leftIsPressed;
    public boolean rightIsPressed;
    public boolean upIsPressed;
    public boolean downIsPressed;



    public int width;
    public int height;
    public Boolean isAlive;
    public Rectangle rec;
    //constructor

    public Character(int pXpos, int pYpos, double pDx, double pDy) {
        xpos = pXpos;
        ypos = pYpos;
        dx = pDx;
        dy = pDy;
        width = 100;
        height = 100;
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

        xpos = (int)(xpos + dx);
        ypos = (int)(ypos + dy);
        rec = new Rectangle(xpos,ypos,width,height);
    }

    public void wrapMove() {
        if (xpos < -2000) {
            xpos = (int) (Math.random() * 15000 + 2000);
        }

        xpos = (int)(xpos + dx);
        ypos = (int)(ypos + dy);

            rec = new Rectangle(xpos, ypos, width, height);
        }

    public void keyMove(){

        xpos = (int)(xpos + dx);
        ypos = (int)(ypos + dy);
        rec = new Rectangle(xpos,ypos,width,height);

        dx = dx + ddx;
        dy = dy + ddy;
    }

    public void shootWeb(){
        xpos = (int)(xpos + dx);
        ypos = (int)(ypos + dy);
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