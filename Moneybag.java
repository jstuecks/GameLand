import java.awt.*;

public class Moneybag {

    public int dx;
    public int dy;

    public int xpos;
    public int ypos;


    public int width;
    public int height;

    public boolean isAlive;
    public Rectangle rec;

    public Moneybag(int pXpos, int pYpos, int pDx, int pDy,pWidth,pHeight){
        xpos=pXpos;
        ypos=pYpos;
        dx=pDx;
        dy=pDy;
        width=pWidth;
        height=pHeight;
        isAlive=true;
        rec = new Rectangle(xpos, ypos, width,height);
    }
    public Moneybag(){
        xpos=100;
        ypos=200;
        dx=2;
        dy=3;
        width=60;
        height=80;
        isAlive=true;
    }

    public void bagCollected(){
        isAlive=false;
        dx=0;
        dy=0;
        ypos=5000;
    }

    public void bouncingMove(){
        //4 seperate if statements.
        if(xpos>(1100-width) ||xpos<-100){
            dx=-dx;
        }

        if(ypos>(800-height)){
            dy=-dy;
        }
        if(ypos<-100){
            dy=-dy;
        }

        //the two lines of code below actually update the position
        //this is what makes the object move.
        xpos=xpos+ dx;
        ypos= ypos+ dy;
        rec = new Rectangle(xpos, ypos, width,height);

    }
    public void wrappingMove(){
        //4 seperate if statements, one for each wall
        if(xpos>1000){
            xpos=0;
        }
        if(xpos<0) {
            xpos = 1000;
        }
        if(ypos>700){
            ypos=0;
        }
        if (ypos<0){
            ypos=1000;
        }
        //the two lines of code below actually update the position
        //this is what makes the object move.
        xpos=xpos+ dx;
        ypos= ypos+ dy;
        //this updates the rectangle location
        rec = new Rectangle(xpos, ypos, width,height);



}