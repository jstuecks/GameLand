//Basic Game Application
// Basic Object, Image, Movement
// Threaded


//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;


//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************


public class GameLand implements Runnable {


    //Variable Definition Section
    //Declare the variables used in the program
    //You can set their initial values too


    public Character Donkey;
    public Character Robber;
    public Character Bird;
    public Character SpiderMan;
    public Character Zookeeper;
    public Character animalControl;
    public Character healthBar;
    public Character blueHealthBar;


    public Image donkeyPic;
    public Image robberPic;
    public Image birdPic;
    public Image spiderPic;
    public Image zooKeeperPic;
    public Image animalControlPic;
    public Image healthBarPic;
    public Image blueHealthPic;




    public Image backgroundPic;
    public Image cityPic;
    public Image jailPic;
    public Image boomPic;
    public Image zooPic;
    public Image yumPic;
    public Image boxingPic;
    public Image mutantPic;
    public Image cagePic;
    public Image animalSignPic;
    public Image chickenPic;
    public Image refPic;


    public boolean BirdIsIntersectingDonkey;
    public boolean RobberIsCaught;
    public boolean DonkeyIsInZoo;
    public boolean BirdIsFightingSpider;
    public boolean AnimalControlHasCaughtSpiderman;
    public boolean BirdIsCookedChicken;


    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;


    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;


    public BufferStrategy bufferStrategy;




    // Main method definition
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        GameLand ex = new GameLand();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }




    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public GameLand() { // BasicGameApp constructor


        setUpGraphics();




        //variable and objects
        //create (construct) the objects needed for the game
        Donkey = new Character((int)(Math.random()*800), (int)(Math.random()*600), -1, 1);
        Robber = new Character((int)(Math.random()*800), (int)(Math.random()*600), 1, -1);
        Bird = new Character((int)(Math.random()*800), (int)(Math.random()*600), 1, 1);
        SpiderMan = new Character((int)(Math.random()*800), (int)(Math.random()*600), -2, -1);
        Zookeeper = new Character((int)(Math.random()*800), (int)(Math.random()*600), 2, 2);
        animalControl = new Character((int)(Math.random()*800), (int)(Math.random()*600), -1, -1);


        healthBar = new Character(300, 30,0,0);
        blueHealthBar = new Character(300,30,0,0);


        Donkey.printInfo();
        Robber.printInfo();
        Bird.printInfo();
        SpiderMan.printInfo();
        Zookeeper.printInfo();
        animalControl.printInfo();
        healthBar.printInfo();
        blueHealthBar.printInfo();


        //construct images
        cityPic = Toolkit.getDefaultToolkit().getImage("cityPic.png");
        backgroundPic = Toolkit.getDefaultToolkit().getImage("backgroundPic.jpg");
        jailPic = Toolkit.getDefaultToolkit().getImage("jailPic.png");
        healthBarPic = Toolkit.getDefaultToolkit().getImage("healthBarPic.png");
        boomPic = Toolkit.getDefaultToolkit().getImage("boomPic.png");
        zooPic = Toolkit.getDefaultToolkit().getImage("zooPic.png");
        yumPic = Toolkit.getDefaultToolkit().getImage("yumPic.png");
        boxingPic = Toolkit.getDefaultToolkit().getImage("boxingPic.png");
        mutantPic = Toolkit.getDefaultToolkit().getImage("mutantPic.png");
        blueHealthPic = Toolkit.getDefaultToolkit().getImage("blueHealthPic.png");
        cagePic = Toolkit.getDefaultToolkit().getImage("cagePic.png");
        animalSignPic = Toolkit.getDefaultToolkit().getImage("animalSignPic.png");
        chickenPic = Toolkit.getDefaultToolkit().getImage("chickenPic.png");
        refPic = Toolkit.getDefaultToolkit().getImage("refPic.png");


        donkeyPic = Toolkit.getDefaultToolkit().getImage("donkeyPic.png");
        robberPic = Toolkit.getDefaultToolkit().getImage("robberPic.png");
        birdPic = Toolkit.getDefaultToolkit().getImage("birdPic.png");
        spiderPic = Toolkit.getDefaultToolkit().getImage("spiderPic.png");
        zooKeeperPic = Toolkit.getDefaultToolkit().getImage("zooKeeperPic.png");
        animalControlPic = Toolkit.getDefaultToolkit().getImage("animalControlPic.png");












    } // end BasicGameApp constructor




//*******************************************************************************
//User Method Section
//
// put your code to do things here.


    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        //for the moment we will loop things forever.
        while (true) {
            moveThings();  //move all the game objects
            render();  // paint the graphics
            checkCollision();
            jailEscape();
            zooShenanigans();
            BoxingMatch();
            pause(10); // sleep for 10 ms


        }


    }


    public void moveThings() {
        Donkey.bounceMove();
        Bird.bounceMove();
        Robber.bounceMove();
        SpiderMan.bounceMove();
        Zookeeper.bounceMove();
        animalControl.bounceMove();


        //call the move() code for each object
    }
    public void checkCollision() {
        if (Bird.rec.intersects(Donkey.rec) && BirdIsIntersectingDonkey == false) {
            BirdIsIntersectingDonkey = true;
            System.out.println("Crash!");
            Donkey.dx = (-1) * Donkey.dx;
            Donkey.dy = (-1) * Donkey.dy;
            Bird.dx = (-1) * Bird.dx;
            Bird.dy = (-1) * Bird.dy;
        }
        if(Bird.rec.intersects(Donkey.rec)==false){
            BirdIsIntersectingDonkey = false;
        }


        //robber collision with jail cell wall
        if (Robber.rec.intersects(SpiderMan.rec) && RobberIsCaught == false) {
            Robber.dx=3;
            Robber.dy=3;
            healthBar.xpos=300;
            healthBar.width=400;
            healthBar.height=30;
            Bird.xpos=1000000;
            Zookeeper.xpos=2000000;
            animalControl.xpos=3000000;
            Donkey.xpos=4000000;
            SpiderMan.xpos=5000000;
            RobberIsCaught = true;
        }


        if (Donkey.rec.intersects(animalControl.rec) && DonkeyIsInZoo == false){
            Donkey.width=60;
            Donkey.height=80;
            Donkey.dx = Donkey.dx - 3;
            Donkey.dy = Donkey.dy - 5;
            Zookeeper.xpos=0;
            Zookeeper.ypos=300;
            Bird.xpos=10000000;
            animalControl.xpos=3000000;
            SpiderMan.xpos=5000000;
            Robber.xpos=6000000;
            DonkeyIsInZoo = true;
        }


        if (Bird.rec.intersects(SpiderMan.rec) && BirdIsFightingSpider == false) {
            Bird.dx = 3;
            Bird.dy = 3;
            SpiderMan.dx = 3;
            SpiderMan.dy = 3;

            healthBar.width=300;
            healthBar.height=30;

            blueHealthBar.width=300;
            blueHealthBar.height=30;

            BirdIsFightingSpider = true;
            Bird.xpos=200; Bird.ypos=200;
            SpiderMan.xpos=700; SpiderMan.ypos=400;
            animalControl.xpos=3000000;
            Robber.xpos=6000000;
            Donkey.xpos=5000000;
        }


        if (SpiderMan.rec.intersects(animalControl.rec) && AnimalControlHasCaughtSpiderman == false) {
            AnimalControlHasCaughtSpiderman = true; //see render for more interaction
            Robber.xpos=6000000;
            Donkey.xpos=5000000;
            Bird.xpos = 7000000;
            animalControl.xpos=200;
            SpiderMan.xpos=800;
        }


        if(Bird.rec.intersects(Robber.rec) && BirdIsCookedChicken == false){
            BirdIsCookedChicken = true; //see render for changes
        }
        if(Bird.rec.intersects(Robber.rec) == false && BirdIsCookedChicken == true){
            BirdIsCookedChicken = false; //see render for changes


        }


    }

    public void jailEscape() {
        if (RobberIsCaught == true && Robber.xpos > 900) {
            healthBar.width = healthBar.width - 40;
        }
        if (RobberIsCaught == true && Robber.xpos < 0) {
            healthBar.width = healthBar.width - 40;
        }
        if (RobberIsCaught == true && Robber.ypos > 580) {
            healthBar.width = healthBar.width - 40;
        }
        if (RobberIsCaught == true && Robber.ypos < 0) {
            healthBar.width = healthBar.width - 40;
        }
    }


    public void zooShenanigans(){
        if (Donkey.rec.intersects(Zookeeper.rec) && DonkeyIsInZoo == true) {
            Zookeeper.xpos = 10000000;
            Donkey.width = Donkey.width + 50;
            Donkey.height = Donkey.height + 50;
            Donkey.dx = Donkey.dx + 3;
            Donkey.dy = Donkey.dy + 5;


        }
        if(Donkey.xpos>800 && DonkeyIsInZoo==true && Zookeeper.xpos>10000){ // just so it waits a second before teleporting - even though there is still a chance it is instant
            DonkeyIsInZoo = false;
            Bird.xpos=500;
            animalControl.xpos=600;
            Donkey.xpos=200;
            SpiderMan.xpos=100;
            Robber.xpos=900;

            Donkey.dx = 1;
            Donkey.dy = 1;

        }
    }


    public void BoxingMatch() {
        if (Bird.rec.intersects(SpiderMan.rec)){
            healthBar.width = healthBar.width - 60;
            blueHealthBar.width = blueHealthBar.width - 40;

            Bird.dx = (-1) * Bird.dx;
            Bird.dy = (-1) * Bird.dy;
            SpiderMan.dx = (-1)* SpiderMan.dx;
            SpiderMan.dy = (-1)* SpiderMan.dy;
        }
    }




    //Paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);


        //draw the images
//        g.drawImage(backgroundPic,0,0,1000,700,null);


        if (RobberIsCaught == false && DonkeyIsInZoo == false && AnimalControlHasCaughtSpiderman == false && BirdIsFightingSpider == false) {
            g.drawImage(cityPic, 0, 0, 1000, 700, null);
        }


        if (RobberIsCaught == false && DonkeyIsInZoo == false && SpiderMan.xpos > 5000) { //any character works for using xpos, i just chose spiderman
            Bird.xpos = 900;
            animalControl.xpos = 200;
            Donkey.xpos = 300;
            SpiderMan.xpos = 100;
            Robber.xpos = 500;
            g.drawImage(cityPic, 0, 0, 1000, 700, null);
        }


        if (RobberIsCaught == true) {
            g.drawImage(jailPic, 0, 0, 1000, 700, null);
            g.drawImage(healthBarPic, healthBar.xpos, healthBar.ypos, healthBar.width, healthBar.height, null);
        }
        if (healthBar.width == 0 && RobberIsCaught == true) { // later add text to say "robber escaped"
            g.drawImage(boomPic, 0, 0, 1100, 600, null);
        }
        if (healthBar.width == -40 && RobberIsCaught == true) { //so that it waits a few seconds before returning to city
            RobberIsCaught = false;
            Robber.dx = 1;
            Robber.dy = 1;
            Robber.ypos = 500;
            Robber.xpos = 10;
            healthBar.width = 400;
        }
        if (DonkeyIsInZoo == true) {
            g.drawImage(zooPic, 0, 0, 1000, 700, null);
            g.drawImage(zooKeeperPic, Zookeeper.xpos, Zookeeper.ypos, Zookeeper.width, Zookeeper.height, null);
        }
        if (Zookeeper.xpos > 10000 && DonkeyIsInZoo == true) {
            g.drawImage(yumPic, 145, 200, 750, 320, null);
        }

        if (BirdIsFightingSpider == true) {
            g.drawImage(boxingPic, 0, 0, 1000, 700, null);


            g.drawImage(blueHealthPic, 100, 30, blueHealthBar.width, blueHealthBar.height, null);
            g.drawImage(healthBarPic, 600, 30, healthBar.width, healthBar.height, null);
        }
        if (healthBar.width == 0 && BirdIsFightingSpider == true) {
            g.drawImage(refPic, 300, 200, 300, 450, null);
        }
        if (healthBar.width == -60 && BirdIsFightingSpider == true) { //so that it waits a few seconds before returning to city
            BirdIsFightingSpider = false;
            Bird.dx = 2;
            Bird.dy = 2;
            SpiderMan.dy = 2;
            SpiderMan.dx = 2;


            Bird.width = 60;
            Bird.height = 80;

            SpiderMan.width = 60;
            SpiderMan.height = 80;

            healthBar.width = 300;
            blueHealthBar.width = 300;


            Bird.xpos = 100;
            animalControl.xpos = 200;
            Donkey.xpos = 300;
            SpiderMan.xpos = 400;
            Robber.xpos = 500;
        }


        if (AnimalControlHasCaughtSpiderman == true) {
            g.drawImage(cagePic, 0, 0, 1000, 700, null);
            g.drawImage(animalSignPic, 40, 400, 400, 300, null);
        }
        if (AnimalControlHasCaughtSpiderman == true && SpiderMan.ypos < 0) { //so that it waits a second
            g.drawImage(animalSignPic, 40, 400, 400, 300, null);
            animalControl.xpos = 1000000;
            AnimalControlHasCaughtSpiderman = false;
        }


        if (AnimalControlHasCaughtSpiderman == false && animalControl.xpos > 10000 && RobberIsCaught == false && DonkeyIsInZoo == false && BirdIsFightingSpider == false) { //any character works for using xpos, i just chose spiderman
            Bird.xpos = 100;
            animalControl.xpos = 200; animalControl.ypos = 400;
            Donkey.xpos = 300;
            SpiderMan.xpos = 400;
            Robber.xpos = 500;
            g.drawImage(cityPic, 0, 0, 1000, 700, null);
        }
        if (BirdIsCookedChicken == true) {
            g.drawImage(chickenPic, Bird.xpos, Bird.ypos, 200, 160, null);
        }
        if (BirdIsCookedChicken == false) {
            g.drawImage(birdPic, Bird.xpos, Bird.ypos, Bird.width, Bird.height, null);
        }
        if (healthBar.width > 0){
            g.drawImage(spiderPic, SpiderMan.xpos, SpiderMan.ypos, SpiderMan.width, SpiderMan.height, null);
    }
        g.drawImage(donkeyPic, Donkey.xpos, Donkey.ypos, Donkey.width, Donkey.height, null);
        g.drawImage(animalControlPic, animalControl.xpos, animalControl.ypos, animalControl.width, animalControl.height, null);
        g.drawImage(robberPic, Robber.xpos, Robber.ypos, Robber.width, Robber.height, null);


        bufferStrategy.show();


    }


    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time ) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }


    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.


        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout


        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);


        panel.add(canvas);  // adds the canvas to the panel.


        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!


        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }


}




