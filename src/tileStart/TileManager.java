package tileStart;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {

    GamePanel gp;
    Tile[] tiles;

    public TileManager(GamePanel gp){

        this.gp = gp;
        tiles = new Tile[10];
        getTileImage();
    }

    public void getTileImage(){

        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/gameTiles/steelFloorOne.png"));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/gameTiles/018.png"));

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/gameTiles/032.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gp.maxScreenCol && row < gp.maxScreenRow){

            g2.drawImage(tiles[0].image, x, y,gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol){

            }
        }
/*
 Commented out hard-coded map tiles
        g2.drawImage(tiles[0].image,0,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[0].image,48,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[0].image,96,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[0].image,144,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[0].image,192,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[0].image,240,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[2].image,288,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[2].image,336,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[2].image,384,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[2].image,432,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[1].image,480,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[1].image,528,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[1].image,576,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[2].image,0,48,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[2].image,48,48,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[2].image,0,96,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[1].image,96,96,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[1].image,144,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[1].image,192,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[1].image,240,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[1].image,288,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[1].image,336,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[1].image,384,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[1].image,432,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[1].image,480,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[1].image,528,0,gp.tileSize,gp.tileSize,null);
        g2.drawImage(tiles[1].image,576,0,gp.tileSize,gp.tileSize,null);
*/

    }
}
