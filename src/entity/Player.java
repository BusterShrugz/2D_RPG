package entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

//---------------------------------------------------------------------------------------
public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
//---------------------------------------------------------------------------------------
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        defaultValues();
        getPlayerImage();
    }
//---------------------------------------------------------------------------------------
    public void defaultValues() {
        x = 100;
        y = 100;
        speed = 5;
        direction = "down";
    }
//---------------------------------------------------------------------------------------
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/move_High.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/upKnightTwo.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/move_Low.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/downKnightTwo.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/move_High_Left.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/move_Low_Left.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/move_High.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/move_Low.png"));

        }catch(IOException e){
            e.printStackTrace();
        }


    }
    //---------------------------------------------------------------------------------------
    public void update(){
    //---------------------------------------------------------------------------------------
       if(keyH.upPressed== true || keyH.downPressed== true ||
               keyH.leftPressed == true || keyH.rightPressed == true){

           if(keyH.upPressed == true){
               direction = "up";
               y -= speed;
           }
           else if(keyH.downPressed == true){
               direction = "down";
               y += speed;
           }
           else if(keyH.leftPressed == true){
               direction = "left";
               x -= speed;
           }
           else if(keyH.rightPressed == true){
               direction = "right";
               x += speed;
           }
//---------------------------------------------------------------------------------------
           spriteCounter++;
           if(spriteCounter > 14 ){
               if(spriteNum == 1){
                   spriteNum = 2;
               }
               else if(spriteNum == 2){
                   spriteNum = 1;
               }
               spriteCounter = 0;
           }
       }
    }
//---------------------------------------------------------------------------------------
    public void draw(Graphics2D g2){
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;
        switch(direction){
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up1;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down1;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }
}
