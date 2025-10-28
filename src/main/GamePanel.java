package main;

import entity.Player;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import tileStart.TileManager;


public class GamePanel extends JPanel implements Runnable {
    // SCREEN SETTINGS
    final int originalTileSize = 16;  // 16x16 tile grid
    final int scale = 3; // this 16 x 3 (scale) will make the sprite 48x48 pixels

    public final int tileSize = originalTileSize * scale;  // will adjust to 48x48 due to 16x3
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; //  768 pixels ->  48pixels x 16pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 Pixels ->  36pixels x 16pixels

    BufferedImage titleImage;

    //FPS
    int FPS = 60;

    

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    Thread gameThread;
    Player player = new Player(this,keyH);


    public int gameState;
    public final int TITLE_SCREEN = 0;
    public final int PLAY_SCREEN = 1;
    public final int PAUSE_SCREEN = 2;
    

    public GamePanel() 
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.lightGray);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        gameState = TITLE_SCREEN;

         try {
        titleImage = ImageIO.read(getClass().getResourceAsStream("/screenAssets/titlescreen.jpg"));
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run()
    {
        double drawInterval = 1000000000/ FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) 
        {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if(delta >= 1) 
            {
                // 1 UPDATE: update information; char position
                update();
                // 2 DRAW: draw screen with the updated information
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) 
            {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() 
    {
        if(gameState == PLAY_SCREEN)
        {
            player.update();
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if(gameState == TITLE_SCREEN)
        {
            drawTitleScreen(g2);
        } else if (gameState == PLAY_SCREEN)
        {
            tileM.draw(g2);
            player.draw(g2);
        }else if (gameState == PAUSE_SCREEN) {
            drawPauseScreen(g2);
        }
        g2.dispose();
    }

    public void drawTitleScreen(Graphics2D g2)
    {

           // Draw background image
        if (titleImage != null) 
        {
            g2.drawImage(titleImage, 0, 0, screenWidth, screenHeight, null);
        } else 
        {
            // fallback color
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, screenWidth, screenHeight);
        }
            // Draw title text
        g2.setColor(Color.ORANGE);
        g2.setFont(new Font("Arial", Font.BOLD, 96));
        String gameTitle = "TIME LEAP";
        int x = getCenteredX(g2, gameTitle);
        int y = screenHeight / 2 - 50;
        g2.drawString(gameTitle, x, y);

        g2.setFont(new Font("Arial", Font.BOLD, 36));
        String startButton = "PRESS ENTER TO START";
        x = getCenteredX(g2, startButton);
        y += 100;
        g2.drawString(startButton, x, y);
    }

    private int getCenteredX(Graphics2D g2, String text)
    {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return screenWidth / 2 - length / 2;
    }

    public void drawPauseScreen(Graphics2D g2) 
    {
        g2.setColor(Color.black);
        g2.setFont(new Font("Arial", Font.BOLD, 96));
        String text = "GAME PAUSED";
        int x = getCenteredX(g2, text);
        int y = screenHeight / 2;
        g2.drawString(text, x, y);

        g2.setFont(new Font("Arial", Font.BOLD, 36));
        String resume = "Press ESC to Resume";
        x = getCenteredX(g2, resume);
        y += 50;
        g2.drawString(resume, x, y);
    }
}

