package tileStart;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager
{

    GamePanel gp;
    Tile[] tiles;
    int mapTileNum[][];



    public TileManager(GamePanel gp)
    {

        this.gp = gp;
        tiles = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
        loadMap("M:\\JetBrains\\Java.projects\\2D_RPG\\2D_RPG\\res\\maps\\FLOOR_ONE.txt");

    }

    public void getTileImage()
    {

        try
        {
            tiles[0] = new Tile(); //steel floor tile
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/gameTiles/steelFloorOne.png"));

            tiles[1] = new Tile(); //LAVA tile
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/gameTiles/greenLAVA.png"));

            tiles[2] = new Tile(); //top spaceship wall tile
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/gameTiles/topWallOne.png"));

            tiles[3] = new Tile(); //left spaceship wall tile
            tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/gameTiles/topWallOne.png"));

            tiles[4] = new Tile(); //right spaceship wall tile
            tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/gameTiles/topWallOne.png"));

            tiles[5] = new Tile(); //right spaceship wall tile
            tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/gameTiles/topWallOne.png"));

            tiles[6] = new Tile(); //right spaceship wall tile
            tiles[6].image = ImageIO.read(getClass().getResourceAsStream("/gameTiles/topWallOne.png"));

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void loadMap(String fileInputStream)
    {
        try
        {
            InputStream is = new FileInputStream(fileInputStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int row = 0;
            while (row < gp.maxScreenRow)
            {
                String line = br.readLine();
                String numbers[] = line.split(" ");

                for (int col = 0; col < gp.maxScreenCol; col++) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                }
                row++;
            }
            br.close();
        }
        catch(Exception e)
        {
            e.printStackTrace(); // Always print or log your exceptions
        }
    }
    public void draw(Graphics2D g2) {

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            int tileNum = mapTileNum[col][row];
            g2.drawImage(tiles[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if (col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}

//        g2.drawImage(tiles[0].image,0,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[0].image,48,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[0].image,96,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[0].image,144,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[0].image,192,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[0].image,240,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[0].image,288,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[0].image,336,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[0].image,384,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[0].image,432,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[0].image,480,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[0].image,528,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[0].image,576,0,gp.tileSize,gp.tileSize,null);

//        g2.drawImage(tiles[1].image,96,96,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[1].image,144,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[1].image,192,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[1].image,240,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[1].image,288,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[1].image,336,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[1].image,384,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[1].image,432,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[1].image,480,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[1].image,528,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tiles[1].image,576,0,gp.tileSize,gp.tileSize,null);