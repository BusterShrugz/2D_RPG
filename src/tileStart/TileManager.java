package tileStart;

import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import main.GamePanel;

public class TileManager {

    GamePanel gp;
    Tile[] tiles;
    int mapTileNum[][];

    public TileManager(GamePanel gp) {

        this.gp = gp;
        tiles = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
        loadMap("maps/spawnZoneCSVs/FLOOR_ONE.txt");

    }

    public void getTileImage() {

        try {
            tiles[0] = new Tile(); // steel floor tile
            tiles[0].image = ImageIO
                    .read(getClass().getClassLoader().getResourceAsStream("gameTiles/steelFloorOne.png"));

            tiles[1] = new Tile(); // LAVA tile
            tiles[1].image = ImageIO
                    .read(getClass().getClassLoader().getResourceAsStream("gameTiles/001.png"));

            tiles[2] = new Tile(); // top spaceship wall tile
            tiles[2].image = ImageIO
                    .read(getClass().getClassLoader().getResourceAsStream("gameTiles/032.png"));

            // tiles[3] = new Tile(); //left spaceship wall tile
            // tiles[3].image =
            // ImageIO.read(getClass().getResourceAsStream("/gameTiles/topWallOne.png"));

            // tiles[4] = new Tile(); //right spaceship wall tile
            // tiles[4].image =
            // ImageIO.read(getClass().getResourceAsStream("/gameTiles/topWallOne.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String mapFileName) {
        try {
            // Load map file from classpath instead of using absolute path
            InputStream is = getClass().getClassLoader().getResourceAsStream("maps/spawnZoneCSVs/FLOOR_ONE.txt");
            if (is == null) {
                System.out.println("Map file not found: " + "maps/spawnZoneCSVs/FLOOR_ONE.txt");
                return;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int row = 0;
            while (row < gp.maxScreenRow) {
                String line = br.readLine();
                if (line == null)
                    break;

                String[] numbers = line.split(" ");

                for (int col = 0; col < gp.maxScreenCol; col++) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                }
                row++;
            }
            br.close();
            System.out.println("✅ Map loaded: " + mapFileName);
        } catch (Exception e) {
            e.printStackTrace();
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