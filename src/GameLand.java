//Basic Game Application
// Basic Object, Image, Movement
// Threaded


//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;


//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************


public class GameLand implements Runnable, KeyListener {


    //Variable Definition Section
    //Declare the variables used in the program
    //You can set their initial values too


    public Character Robber;
    public Character SpiderMan;
    public Character healthBar;


    public Image robberPic;
    public Image spiderPic;
    public Image healthBarPic;

    public Image bombPic;

    public Image webPic;

    public Image bankPic;

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
    public Image moneyBagsPic;

    public Image startScreenPic;
    public Image press1Pic;
    public Image press2Pic;

    public Image player1Pic;
    public Image player2Pic;

    public Image endlessRulesPic;
    public Image rules1Pic;
    public Image rules2Pic;
    public Image rules3Pic;
    public Image rules4Pic;
    public Image wasdPic;
    public Image toMovePic;


    public Image swallowedPic;
    public Image uhohPic;

    public Image onePic;
    public Image twoPic;
    public Image threePic;





    public Image endlessBackground;

    public int maxSpeed = 5;
    public int minSpeed = 0;
    public double ddx = .15;
    public double ddy = .15;

    public int score;

    public long timeStart;
    public long timeNow;
    public long timeElapsed;


    public boolean RobberIsCaught;

    public boolean startScreen = true;
    public boolean endlessRules;
    public boolean startEndless;
    public boolean lostEndless;
    public boolean gameOver;

    public boolean loseOnce = false;

    public boolean levelsRules;

    public Obstacle[] moneyBags;
    public Obstacle[] web;
    public Obstacle[] bomb;

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

        timeStart = System.currentTimeMillis();

        setUpGraphics();


        //variable and objects
        //create (construct) the objects needed for the game
        Robber = new Character(100, 300, 0, 0);
        SpiderMan = new Character(800, 300, 0, 0);

        web = new Obstacle[500];
        bomb = new Obstacle[500];


        healthBar = new Character(300, 30, 0, 0);

        //STEP 2 for Array
        moneyBags = new Obstacle[1000];

        //step 3 USE LOOP TO FILL
        for (int x = 0; x < moneyBags.length; x = x + 1) {
            int randX = (int) (150000 * Math.random() + 1500);
            int randY = (int) (550 * Math.random());
            int randDX = (int) (-5 * Math.random()) - 1;

            moneyBags[x] = new Obstacle(randX, randY, randDX, 0);
        }
        for (int x = 0; x < bomb.length; x = x + 1) {
            int randX = (int) (150000 * Math.random() + 1500);
            int randY = (int) (550 * Math.random());
            int randDX = (int) (-5 * Math.random()) - 1;

            bomb[x] = new Obstacle(randX, randY, randDX, 0);
        }

        for (int x = 0; x < web.length; x = x + 1) {
            int randX = (int) (150000 * Math.random() + 1500);
            int randY = (int) (550 * Math.random());
            int randDX = (int) (-5 * Math.random()) - 1;

            web[x] = new Obstacle(randX, randY, randDX, 0);
        }

        Robber.printInfo();
        SpiderMan.printInfo();
        healthBar.printInfo();


        //construct images
        cityPic = Toolkit.getDefaultToolkit().getImage("cityPic.png");
        backgroundPic = Toolkit.getDefaultToolkit().getImage("backgroundPic.jpg");
        jailPic = Toolkit.getDefaultToolkit().getImage("jailPic.png");
        healthBarPic = Toolkit.getDefaultToolkit().getImage("healthBarPic.png");
        boomPic = Toolkit.getDefaultToolkit().getImage("boomPic.png");
        boxingPic = Toolkit.getDefaultToolkit().getImage("boxingPic.png");
        mutantPic = Toolkit.getDefaultToolkit().getImage("mutantPic.png");
        cagePic = Toolkit.getDefaultToolkit().getImage("cagePic.png");
        animalSignPic = Toolkit.getDefaultToolkit().getImage("animalSignPic.png");
        chickenPic = Toolkit.getDefaultToolkit().getImage("chickenPic.png");
        refPic = Toolkit.getDefaultToolkit().getImage("refPic.png");

        bankPic = Toolkit.getDefaultToolkit().getImage("bankPic.jpg");

        startScreenPic = Toolkit.getDefaultToolkit().getImage("startScreenPic.png");
        press1Pic = Toolkit.getDefaultToolkit().getImage("press1Pic.png");
        press2Pic = Toolkit.getDefaultToolkit().getImage("press2Pic.png");

        player1Pic = Toolkit.getDefaultToolkit().getImage("player1Pic.png");
        player2Pic = Toolkit.getDefaultToolkit().getImage("player2Pic.png");

        endlessRulesPic = Toolkit.getDefaultToolkit().getImage("endlessRulesPic.png");
        rules1Pic = Toolkit.getDefaultToolkit().getImage("rules1Pic.png");
        rules2Pic = Toolkit.getDefaultToolkit().getImage("rules2Pic.png");
        rules3Pic = Toolkit.getDefaultToolkit().getImage("rules3Pic.png");
        rules4Pic = Toolkit.getDefaultToolkit().getImage("rules4Pic.png");


        swallowedPic = Toolkit.getDefaultToolkit().getImage("swallowedPic.png");
        uhohPic = Toolkit.getDefaultToolkit().getImage("uhohPic.png");
        wasdPic = Toolkit.getDefaultToolkit().getImage("wasdPic.png");
        toMovePic = Toolkit.getDefaultToolkit().getImage("toMovePic.png");

        onePic = Toolkit.getDefaultToolkit().getImage("onePic.png");
        twoPic = Toolkit.getDefaultToolkit().getImage("twoPic.png");
        threePic = Toolkit.getDefaultToolkit().getImage("threePic.png");


        endlessBackground = Toolkit.getDefaultToolkit().getImage("endlessBackground.png");


        moneyBagsPic = Toolkit.getDefaultToolkit().getImage("moneyBagPic.png");
        robberPic = Toolkit.getDefaultToolkit().getImage("robberPic.png");
        spiderPic = Toolkit.getDefaultToolkit().getImage("spiderPic.png");
        webPic = Toolkit.getDefaultToolkit().getImage("webPic.png");
        bombPic = Toolkit.getDefaultToolkit().getImage("bombPic.png");


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
            acceleration();
            jailEscape();
            timer();
            pause(10); // sleep for 10 ms


        }


    }

    public void rulesEndless() {
        if (startScreen) {
            startScreen = false;
            endlessRules = true;
        }
    }

    public void levelEndless() {
        if (endlessRules == true) {
            endlessRules = false;
            startEndless = true;

            endless();
        }
    }

    public void endless() {
        score = 0;

    }

    public void lostEndless(){
        timeStart = System.currentTimeMillis();
        System.out.println(timeElapsed);
    }

    public void endScreen(){
        gameOver = true;

    }
//        if(level1 && score>14){ // transition from level 1 to pause screen
//            level1=false;
//            startScreen2=true;
//        }
//        if (startScreen2){//transition from pause screen to level 2
//            startScreen2=false;
//            level2=true;
//            startLevel2();
//            // System.out.println("level 2 has started");
//        }
//        if(gameOver){ //restart the game transition from game over to level 1
//            gameOver=false;
//            level1=true;
//            startLevel1();
//        }


    public void moveThings() {
        Robber.keyMove();
        SpiderMan.keyMove();
        if (startEndless) {
            for (int x = 0; x < moneyBags.length; x = x + 1) {
                moneyBags[x].Wrap();
            }
            for (int x = 0; x < web.length; x = x + 1) {
                web[x].Wrap();
            }
            for (int x = 0; x < bomb.length; x = x + 1) {
                bomb[x].Wrap();
            }
        }
    }

    public void checkCollision() {
        for (int x = 0; x < moneyBags.length; x = x + 1) {
            if (Robber.rec.intersects(moneyBags[x].rec)) {
                moneyBags[x].bagCollected();
                score = score + moneyBags[x].height / 5;
            }
        }
        for (int x = 0; x < web.length; x = x + 1) {
            if (Robber.rec.intersects(web[x].rec)) {
                Robber.dx = 0;
                Robber.dy = 0;
            }
        }
        for (int x = 0; x < bomb.length; x = x + 1) {
            if (Robber.rec.intersects(bomb[x].rec)) {
                lostEndless = true;
            }

            if (lostEndless && loseOnce == false) {
                loseOnce = true;
                lostEndless();

            }

        }

    }

    public void acceleration() {
        if (Robber != null) {
            if (Robber.leftIsPressed) {
                if (Robber.dx > -maxSpeed) {
                    Robber.dx -= ddx;
                    System.out.println("hi" + Robber.dx);
                }
            } else if (Robber.rightIsPressed) {
                if (Robber.dx < maxSpeed) {
                    Robber.dx += ddx;
                }
            } else {
                Robber.dx *= .99;
            }
            if (Robber.upIsPressed) {
                if (Robber.dy > -maxSpeed) {
                    Robber.dy -= ddy;
                }
            } else if (Robber.downIsPressed) {
                if (Robber.dy < maxSpeed) {
                    Robber.dy += ddy;
                }
            } else {
                Robber.dy *= .99;
            }
        }
        if (SpiderMan != null) {
            if (SpiderMan.leftIsPressed) {
                if (SpiderMan.dx > -maxSpeed) {
                    SpiderMan.dx -= ddx;
                }
            } else if (SpiderMan.rightIsPressed) {
                if (SpiderMan.dx < maxSpeed) {
                    SpiderMan.dx += ddx;
                }
            } else {
                SpiderMan.dx *= .99;
            }
            if (SpiderMan.upIsPressed) {
                if (SpiderMan.dy > -maxSpeed) {
                    SpiderMan.dy -= ddy;
                }
            } else if (SpiderMan.downIsPressed) {
                if (SpiderMan.dy < maxSpeed) {
                    SpiderMan.dy += ddy;
                }
            } else {
                SpiderMan.dy *= .99;
            }
        }

        if (Robber.rec.intersects(SpiderMan.rec) && RobberIsCaught == false) {
            healthBar.xpos = 300;
            healthBar.width = 400;
            healthBar.height = 30;
            RobberIsCaught = true;
            SpiderMan.xpos = 800;

        }

    }

    public void jailEscape() {
        if (Robber.rec.intersects(SpiderMan.rec)) {
            healthBar.width = healthBar.width - 5;
        }
    }

    public void timer() {
        timeNow = System.currentTimeMillis();
        timeElapsed = (int) ((timeNow - timeStart) * .001);
    }





        //Paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);


        //draw the images
//        g.drawImage(backgroundPic,0,0,1000,700,null);
        if(startScreen==true) {
            g.drawImage(startScreenPic, 0, 0, 1000, 700, null);
            g.drawImage(press1Pic, 30, 60, 420, 100, null);
            g.drawImage(press2Pic, 550, 60, 420, 100, null);
            g.drawImage(player1Pic, 150, 140, 170, 75, null);
            g.drawImage(player2Pic, 670, 140, 170, 75, null);
        }
        if(endlessRules){
            g.drawImage(endlessRulesPic, 0, 0, 1000, 700, null);
            g.drawImage(rules1Pic, 60, -15, 900, 115, null);
            g.drawImage(rules2Pic, 65, 100, 340, 85, null);
            g.drawImage(rules3Pic, 600, 100, 340, 85, null);
            g.drawImage(rules4Pic, 65, 165, 340, 85, null);
            g.drawImage(toMovePic, 600, 300, 340, 85, null);
            g.drawImage(wasdPic, 640, 170, 250, 150, null);



        }
        if(startEndless){
            g.drawImage(endlessBackground, 0, 0, 1000, 700, null);
            g.setColor(Color.WHITE);
            Font moneyCollected = new Font( "Dialog", Font.BOLD, 20 );
            g.setFont(moneyCollected);
            g.drawString("Money Collected: "+ score +"$", 750, 35);
            for(int x=0;x<moneyBags.length; x=x+1){
                g.drawImage(moneyBagsPic, moneyBags[x].xpos,moneyBags[x].ypos,moneyBags[x].width,moneyBags[x].height,null);
            }
            for(int x=0;x<web.length; x=x+1){
                g.drawImage(webPic, web[x].xpos,web[x].ypos,web[x].width,web[x].height,null);
            }
            for(int x=0;x<bomb.length; x=x+1){
                g.drawImage(bombPic, bomb[x].xpos,bomb[x].ypos,bomb[x].width,bomb[x].height,null);
            }
            g.drawImage(robberPic, Robber.xpos, Robber.ypos, Robber.width, Robber.height, null);
        }

        if(lostEndless==true) {
            g.drawImage(uhohPic, 300, -15, 400, 200, null);
            g.drawImage(swallowedPic, 100, 510, 800, 200, null);
        }
            if (lostEndless && timeElapsed > 1 && timeElapsed <= 2) {
                g.drawImage(threePic, 300, 140, 400, 400, null);
            } else if (lostEndless && timeElapsed > 2 && timeElapsed <= 3) {
                g.drawImage(twoPic, 300, 140, 400, 400, null);
            } else if (lostEndless && timeElapsed > 3 && timeElapsed <= 4) {
                g.drawImage(onePic, 300, 140, 400, 400, null);
            } else if (lostEndless && timeElapsed > 4 && timeElapsed <=5) {
                g.drawImage(boomPic, 200, 0, 700, 700, null);
            } else if (lostEndless && timeElapsed > 5) {
                endScreen();
            }

//        if (RobberIsCaught == false) {
//            g.drawImage(bankPic, 0, 0, 1000, 700, null);
//        }

        if (RobberIsCaught == true) {
            g.drawImage(jailPic, 0, 0, 1000, 700, null);
            g.drawImage(healthBarPic, healthBar.xpos, healthBar.ypos, healthBar.width, healthBar.height, null);
        }
        if (healthBar.width == 0 && RobberIsCaught == true) { // later add text to say "robber escaped"
            g.drawImage(boomPic, 0, 0, 1100, 600, null);
        }
        if (healthBar.width == -5 && RobberIsCaught == true) { //so that it waits a few seconds before returning to city
            RobberIsCaught = false;
            Robber.ypos = 500;
            Robber.xpos = 10;
            healthBar.width = 400;
            SpiderMan.xpos = 500;
            SpiderMan.ypos = 500;

        }


        if (healthBar.width > 0){
            g.drawImage(spiderPic, SpiderMan.xpos, SpiderMan.ypos, SpiderMan.width, SpiderMan.height, null);
    }



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

canvas.addKeyListener(this);
        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();
        int keyCode = e.getKeyCode();
        System.out.println("Key Pressed: " +key+ " , Key Code: " + keyCode);

        if(keyCode==68){
            Robber.rightIsPressed=true;
        }
        if (keyCode==65){
            Robber.leftIsPressed=true;
        }
        if(keyCode==87){
            Robber.upIsPressed=true;
        }
        if(keyCode==83){
            Robber.downIsPressed=true;
        }

        //now spiderman
        if(keyCode == 37) { //keycode for a
            SpiderMan.leftIsPressed=true;
        }
        if(keyCode == 38) { //keycode for w
            SpiderMan.upIsPressed=true;
        }
        if(keyCode == 39) { //keycode for s
            SpiderMan.rightIsPressed=true;
        }
        if(keyCode == 40) { //keycode for d
            SpiderMan.downIsPressed=true;

        }



    }

    @Override
    public void keyReleased(KeyEvent e) {
        char key = e.getKeyChar();
        int keyCode = e.getKeyCode();

        if(endlessRules && keyCode == 32){
            levelEndless();
        }
        if(keyCode==49) {
            rulesEndless();
        }
        if(keyCode==50) {
//            rulesLevels();
        }
        if(keyCode==68){// d is 68 // right movement
            Robber.rightIsPressed=false;
        }
        if (keyCode==65){
            Robber.leftIsPressed=false;
        }
        if(keyCode==87){
            Robber.upIsPressed=false;
        }
        if(keyCode==83){
            Robber.downIsPressed=false;

        }
//for spiderman
        if(keyCode == 37) {
            SpiderMan.leftIsPressed=false;
        }
        if(keyCode == 38) {
            SpiderMan.upIsPressed=false;
        }
        if(keyCode == 39) {
            SpiderMan.rightIsPressed=false;
        }
        if(keyCode == 40) {
            SpiderMan.downIsPressed=false;
        }

    }
}




