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
	int leftFlag,upFlag,rightFlag,downFlag;
	int x,y;
	Image heroImg[][]=new Image[4][3];
	Image currentImg;
	public MainCanvas(){
		try
		{
			for(int i=0;i<4;i++){
				for(int j=0;j<3;j++){
					heroImg[i][j]=Image.createImage("/sayo0"+i+j+".png");
				}
			}
			currentImg=heroImg[0][0];
			x=120;
			y=100;
			leftFlag=1;
			upFlag=1;
			rightFlag=1;
			downFlag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(255,97,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
		}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			if(leftFlag==1){
				currentImg=heroImg[1][1];
				leftFlag++;	
				}
			else if(leftFlag==2){
				currentImg=heroImg[1][2];
				leftFlag--;
				}
			x=x-1;
			repaint();
			}
		if(action==UP){
			if(upFlag==1){
				currentImg=heroImg[2][1];
				upFlag++;	
			}
			else if(upFlag==2){
				currentImg=heroImg[2][2];
				upFlag--;
			}
			y=y-1;
			repaint();
			} 
		if(action==RIGHT){
			if(rightFlag==1){
				currentImg=heroImg[3][1];
				rightFlag++;	
			}
			else if(rightFlag==2){
				currentImg=heroImg[3][2];
				rightFlag--;
			}
			x=x+1;
			repaint();
			} 
		if(action==DOWN){
			if(downFlag==1){
				currentImg=heroImg[0][1];
				downFlag++;	
			}
			else if(downFlag==2){
				currentImg=heroImg[0][2];
				downFlag--;
			}
			y=y+1;
			repaint();
			} 
		}
}