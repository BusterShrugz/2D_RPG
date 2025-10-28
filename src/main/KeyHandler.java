package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    GamePanel gp;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
            // --- Title Screen Controls ---
          if(code == KeyEvent.VK_ENTER) 
          {
            if(gp.gameState == gp.TITLE_SCREEN) 
            {
                gp.gameState = gp.PLAY_SCREEN;
            }
        }
            // --- Gameplay Controls ---
        else if (gp.gameState == gp.PLAY_SCREEN) 
        {   
            if (code == KeyEvent.VK_W) {
                upPressed = true;
            }
            if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }
            if (code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.PAUSE_SCREEN;
            }
        }
             // --- Pause Controls ---
        else if (gp.gameState == gp.PAUSE_SCREEN) {
            if (code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.PLAY_SCREEN; // resume
            }
        }

    }


    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }

    }
}
