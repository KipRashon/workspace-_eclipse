package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BouncingBabiesGame  extends JComponent implements ActionListener, KeyListener {

	private int width=800;
	private int height=600;
	private int babyX = 400;
	private double babyY = 300;
	private int groundHeight = 40;
	private int buildingWidth = 80;
    private double babyYSpeed=0;
    private int gravity=1;
    private int groundY=height-groundHeight;
    int fireManX = 400;
    private int fireManSpeed = 10;
    private String message="";
    int score=0;
    private String success="Score : "+score;
    private String speedMessage="Speed "+fireManSpeed;
    Image babyImage,ambulance,fireman1,fireman2,burningBuilding;

    public BouncingBabiesGame() throws IOException {
        babyImage = ImageIO.read(getClass().getResource("/resources/baby.png"));
        ambulance = ImageIO.read(getClass().getResource("/resources/ambulance.png"));
        fireman1 = ImageIO.read(getClass().getResource("/resources/fireman.png"));
        fireman2 = ImageIO.read(getClass().getResource("/resources/fireman2.png"));
        burningBuilding = ImageIO.read(getClass().getResource("/resources/burning-building.png"));
    }


    public static void main(String args[]) throws IOException {
		JFrame window = new JFrame("SAve the babies");
		BouncingBabiesGame game= new BouncingBabiesGame();
		window.add(game);
		//allows the game to resize to the size of the window
		window.pack();
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setBackground(new Color(23,178,90));
		Timer t= new Timer(39,game);
		t.start();
		window.addKeyListener(game);
	}
	
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(width,height);
	}

   @Override	
	protected void paintComponent(Graphics g)
	{
		//background
	   g.setColor(Color.BLACK);
	   g.fillRect(0, 0, width, height);

        drawTheMessage(g, speedMessage, 550,70,new Color(0x471DBB));

        //draw the message
        drawTheMessage(g, message, 50,70,new Color(187, 19, 32));

        //draw the success message
        drawTheMessage(g,success,400,300,new Color(46, 122, 56));


	   
	   //draw the building
	   g.setColor(new Color(212,81,58));
		g.drawImage(burningBuilding,0, 180,null);

	   //ambulance
		g.setColor(Color.white);
		g.drawImage(ambulance,680,480,null);

		//firemen
		g.setColor(new Color(26, 19, 65));


        g.drawImage(fireman1,fireManX,480,null);

		g.setColor(new Color(26, 19, 65));
		g.drawImage(fireman2,fireManX+150,480, null);

		//trampoline
		g.setColor(Color.white);
		g.fillRect(fireManX+15,height-groundHeight-35,150,10);


		//babies
		g.setColor(new Color(187, 149, 43));
		g.drawImage(babyImage,babyX, (int) babyY,null);

        //ground
        g.setColor(Color.white.darker());
        g.fillRect(0, height- groundHeight, width, groundHeight);
	}

    private void drawTheMessage(Graphics g, String message, int x,int y,Color color) {
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 34));
        g.setColor(color);
        g.drawString(message, x, y);
    }

    @Override
	public void actionPerformed(ActionEvent e) {
		babyX=babyX+5;
		babyY=babyY+babyYSpeed;
		babyYSpeed=babyYSpeed+gravity;

		if(babyY+25>=height-groundHeight-100)
        {
            //check if the trampoline if is under the trampoline
            if(babyX+25>= fireManX && fireManX+150>babyX) {
                babyYSpeed = -0.8 * babyYSpeed;
                message="";
                success="";
                speedMessage="";
            }
            else
            {
                //TODO: lose a life
                if(babyX<650) {
                    message = "Save the fuckin baby idiot";

                    score--;
                    success="Score: "+score;
                }
                else{
                    score++;
                    success="Score: "+score;

                }

                tossNewBaby();
            }
        }
		if(babyX>width)
        {
            tossNewBaby();
        }
		repaint();
	}

    private void tossNewBaby() {
        babyX = 50;
        babyY = 100;
        babyYSpeed = 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            if(fireManX>= buildingWidth+10) {

                fireManX = fireManX - fireManSpeed;
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
           if(fireManX <= 500 ) {
               fireManX = fireManX + fireManSpeed;
           }
        }
        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
            if(fireManSpeed<=50)fireManSpeed++;
            else fireManSpeed=10;

            speedMessage="Speed "+fireManSpeed;

        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            if(fireManSpeed>=10)fireManSpeed--;
            else fireManSpeed=50;

            speedMessage="Speed "+fireManSpeed;

        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
