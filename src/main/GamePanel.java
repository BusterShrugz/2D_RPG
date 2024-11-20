package main;

import entity.Player;
import tileStart.TileManager;

import javax.swing.JPanel;
import java.awt.*;


//---------------------------------------------------------------------------------------
public class GamePanel extends JPanel implements Runnable {
//---------------------------------------------------------------------------------------

    // SCREEN SETTINGS
    final int originalTileSize = 16;  // 16x16 tile grid
    final int scale = 3; // this 16 x 3 (scale) will make the sprite 48x48 pixels

    public final int tileSize = originalTileSize * scale;  // will adjust to 48x48 due to 16x3
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; //  768 pixels ->  48pixels x 16pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 Pixels ->  48pixels x 12pixels

    //FPS
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this,keyH);



    //---------------------------------------------------------------------------------------
    public GamePanel() {
    //---------------------------------------------------------------------------------------
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.lightGray);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    //---------------------------------------------------------------------------------------
    public void startGameThread(){
    //---------------------------------------------------------------------------------------
        gameThread = new Thread(this);
        gameThread.start();
    }
    //---------------------------------------------------------------------------------------
    @Override
    public void run(){
    //---------------------------------------------------------------------------------------
        double drawInterval = 1000000000/ FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if(delta >= 1) {
                // 1 UPDATE: update information; char position
                update();
                // 2 DRAW: draw screen with the updated information
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
          }
    }
    //---------------------------------------------------------------------------------------
    public void update() {
    //---------------------------------------------------------------------------------------
        player.update();
    }
    //---------------------------------------------------------------------------------------
    public void paintComponent(Graphics g){
    //---------------------------------------------------------------------------------------
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        tileM.draw(g2);
        player.draw(g2);
        g2.dispose();

    }
}


//    public void run() {
//
//        double drawInterval = 1000000000/FPS; //0.01666 seconds
//        double nextDrawTime = System.nanoTime() + drawInterval;
//
//

//
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime/1000000;
//
//                if(remainingTime < 0){
//                    remainingTime = 0;
//                }
//                Thread.sleep((long) remainingTime);
//
//                nextDrawTime += drawInterval;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }