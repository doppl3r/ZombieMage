import audio.AudioHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements KeyListener, Runnable{
	private static final long serialVersionUID = 1L;
    private boolean paused; //pause option
    private int panelState; //displays menus individually
    private Font font;
    public MainMenu menu1;
    public Game game;
    public GUI gui;
	private Timer t;
	
	public Panel(){
        font = new Font ("Arial", Font.BOLD, 18);
        menu1 = new MainMenu();
        game = new Game();
        gui = new GUI();
        //start music
        //AudioHandler.THEME.play();

        AudioHandler.THEME.clip.loop(-1);

		//set listeners and thread
		addKeyListener(this);
		setFocusable(true);
		run();
	}
	public void run(){
		t = new Timer(1000/60, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				update();
				repaint();
			}
		});
		t.start();
	}
	public void paintComponent(Graphics tempG){
        //convert to Graphics2D
        Graphics2D g = (Graphics2D)tempG;
        super.paintComponent(g);
		setBackground(Color.BLACK);
        g.setFont(font);
        //draw components
        if (!paused){
            switch(panelState){
                case(0): menu1.draw(g); break;
                case(1): game.draw(g); break;
            }
        }
        gui.draw(g);
	}
	public void update(){
		//update the components
        if (!paused){
            switch(panelState){
                case(0): menu1.update(); break;
                case(1): game.update(); break;
            }
        }
        gui.update();
	}
	//key bindings
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
        switch(panelState){
            case(0): break;
            case(1): //game keybindings
                if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) { game.keyUpPressed(); }
                if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) { game.keyRightPressed(); }
                if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) { game.keyDownPressed(); }
                if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) { game.keyLeftPressed(); }
                if (key == KeyEvent.VK_ESCAPE){ paused = !paused; }
           break;
        }
	}
	public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch(panelState){
            case(0): if (key != 0) menu1.loadGame(); break;
            case(1): //game keybindings
                if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) { game.keyUpReleased(); }
                if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) { game.keyRightReleased(); }
                if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) { game.keyDownReleased(); }
                if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) { game.keyLeftReleased(); }
            break;
        }
    }
	public void keyTyped(KeyEvent arg0) { }
    public void setPanelState(int i){ panelState = i; }
    public int getPanelState(){ return panelState; }
    public void setPause(boolean paused){ this.paused=paused; }
    public boolean isPaused(){ return paused; }
}
