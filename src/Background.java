import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    private BufferedImage background;

    public Background(){
        background = renderBackground(Window.tt.tile, 10, 8, 64);
    }
    public void draw(Graphics2D g){
        g.drawImage(background,0,0,null);
        g.drawImage(Window.tt.shader,0,0,null);
    }
    public BufferedImage renderBackground(Image image, int cols ,int rows, int tileSize){
        BufferedImage bufferedImage = new BufferedImage(cols*tileSize, rows*tileSize,  BufferedImage.TYPE_INT_ARGB);
        Graphics g = bufferedImage.createGraphics();

        for (int col = 0; col < cols; col++){
            for (int row = 0; row < rows; row++){
                g.drawImage(image, col*tileSize, row*tileSize, tileSize, tileSize, null);
            }
        }
        g.dispose();
        return bufferedImage;
    }
}
