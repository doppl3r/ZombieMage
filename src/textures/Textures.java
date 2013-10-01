package textures;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Textures {
    public Image icon_hd;
    public Image title;
    public Image zombieLarge;
    public Image shader;
    public Image mage1;
    public Image mage2;
    public Image blood;
    public Image tile;

	
	public Textures(){
		addResources();
	}
	public void addResources(){
        icon_hd = new ImageIcon(this.getClass().getResource("/gui/icon_hd.png")).getImage();
		title = new ImageIcon(this.getClass().getResource("/gui/title.png")).getImage();
        zombieLarge = new ImageIcon(this.getClass().getResource("/gui/zombieLarge.png")).getImage();
        shader = new ImageIcon(this.getClass().getResource("/gui/shader.png")).getImage();
        mage1 = new ImageIcon(this.getClass().getResource("/graphics/mage1.png")).getImage();
        mage2 = new ImageIcon(this.getClass().getResource("/graphics/mage2.png")).getImage();
        blood = new ImageIcon(this.getClass().getResource("/graphics/blood.png")).getImage();
        tile = new ImageIcon(this.getClass().getResource("/graphics/tile.png")).getImage();
	}
}
