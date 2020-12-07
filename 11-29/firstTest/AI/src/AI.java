import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image heroImg[][]=new Image[4][3];
	
	Image currentImg;
	
	int heroX,heroY;
	int heroFlag;

	public MainCanvas(){
		
		try{

			for(int i=0;i<4;i++){
				for(int j=0;j<3;j++){
						heroImg[i][j]=Image.createImage("/sayo0"+i+j+".png");
				}
			}

			currentImg=heroImg[0][0];

			heroX=120;
			heroY=100;

			heroFlag=1;
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			changePictureandDirection(1);
			heroX=heroX-1;
			repaint();
		}
		if(action==UP){
			changePictureandDirection(2);
			heroY=heroY-1;
			repaint();
		}
		if(action==RIGHT){
			changePictureandDirection(3);
			heroX=heroX+1;
			repaint();
		}
		if(action==DOWN){
			changePictureandDirection(0);
			heroY=heroY+1;
			repaint();
		}
	}
	void changePictureandDirection(int direction){
		if(heroFlag==1){
			currentImg=heroImg[direction][1];
			heroFlag++;
		}
		else if(heroFlag==2){
			currentImg=heroImg[direction][2];
			heroFlag--;
		}
	}
}


