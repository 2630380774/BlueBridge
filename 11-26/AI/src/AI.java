import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import java.util.*;

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
class MainCanvas extends Canvas implements Runnable
{
	int Flag;
	
	Thread thread;
	
	int heroX,heroY,bossX,bossY;
	
	Image heroImg[][]=new Image[4][3];
	Image currentImg,bossImg;

	Random rd=new Random();
	
	public MainCanvas(){
		try
		{
			for(int i=0;i<4;i++){
				for(int j=0;j<3;j++){
					heroImg[i][j]=Image.createImage("/sayo0"+i+j+".png");
				}
			}
			currentImg=heroImg[0][0];
			bossImg=Image.createImage("/zuzu000.png");
			
			heroX=120;
			heroY=100;
			
			bossX=0;
			bossY=0;
			
			Flag=1;

			thread=new Thread(this);
			thread.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

public void run(){
		while(true){
			int rdNumber=rd.nextInt(10);

			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if(rdNumber%3==0){
				if(bossX<heroX){
					bossX++;
				}
				else{
					bossX--;
				}

				if(bossY<heroY){
					bossY++;
				}else{
					bossY--;
				}
			}
			repaint();
		}
	}

	public void paint(Graphics g){
		g.setColor(255,97,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
		g.drawImage(bossImg,bossX,bossY,0);
		}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			changePicandDirection(1);
			heroX=heroX-1;
			repaint();
			}
		if(action==UP){
			changePicandDirection(2);
			heroY=heroY-1;
			repaint();
			} 
		if(action==RIGHT){
			changePicandDirection(3);
			heroX=heroX+1;
			repaint();
			} 
		if(action==DOWN){
			changePicandDirection(0);
			heroY=heroY+1;
			repaint();
			} 
		}
		void changePicandDirection(int direction){
			if(Flag==1){
				currentImg=heroImg[direction][1];
				Flag++;	
				}
			else if(Flag==2){
				currentImg=heroImg[direction][2];
				Flag--;
				}
		}
}