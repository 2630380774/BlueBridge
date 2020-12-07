#1����ʾhero

-��������
��class MainCanvas extends Canvas��ǩ�¶��塢��������
```java
Image heroImg,currentImg;
```
-��������ֵ
��public MainCanvas���try��ǩ�¸�������ֵ
```java
currentImg=Image.createImage("/sayo10.png");
```

#2��ʵ��heroת��

-��������
��class MainCanvas extends Canvas��ǩ�¶��塢��������
```java
Image heroLeftImg,heroRightImg,heroUpImg,heroDownImg,currentImg;
```
-��������ֵ
��public void keyPressed(int keyCode)��ǩ�¸�������ֵ
```java
if(action==LEFT){
			currentImg=heroLeftImg;
			repaint();
		}
```

#3����hero�����ƶ�

-��������
��class MainCanvas extends Canvas��ǩ�¶��塢��������,���޸�g.drawImage�е�xy����ΪheroX,heroY
```java
int heroX,heroY;
```
-��������ֵ
��public MainCanvas���try��ǩ�¸�������ֵ
```java
	heroX=120;
	heroY=100;
```
-���������¸�ֵ
��public void keyPressed(int keyCode)���if(action==LEFT)��ǩ���heroX,heroY���¸�ֵ
```java
heroX=heroX-1;
```

#4����hero�ƶ�ʱ�����л�����

���һ����־ֵ���ж϶������л�

-��������
��class MainCanvas extends Canvas��ǩ�¶��塢��������
```java
Image leftImg1,leftImg2,rightImg1,rightImg2,upImg1,upImg2,downImg1,downImg2;
int leftFlag,rightFlag,upFlag,downFlag;
```
-��������ֵ
��public MainCanvas���try��ǩ�¸�������ֵ
```java
heroDownImg=Image.createImage("/sayo10.png");
downImg1=Image.createImage("/sayo00.png");
downImg2=Image.createImage("/sayo20.png");
```
-���ӱ�־ֵ���ж�
��public void keyPressed(int keyCode)���if(action==LEFT)��ǩ��if������else if ������ԭ����currentImg=heroLeftImg;
```java
if(leftFlag==1){
	currentImg=leftImg1;
	leftFlag++;
}
else if(leftFlag==2){
	currentImg=leftImg2;
	leftFlag--;
}
```
#5��ʹ��forѭ����һά����������
-�����������
��class MainCanvas extends Canvas��ǩ�¶�����������
```java
Image heroLeftImg[] =new Image[3];
```
-��������ֵ
��public MainCanvas���try��ǩ�¸�������ֵ
```java
for(int i=0;i<3;i++){
		heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
}
```
#6��ʹ�ö�ά����������
-�����������
��class MainCanvas extends Canvas��ǩ�¶�����������
```java
Image heroImg[][]=new Image[4][3];
```
-��������ֵ
��public MainCanvas���try��ǩ�¸�������ֵ
```java
for(int i=0;i<4;i++){
	for(int j=0;j<3;j++){
		heroImg[i][j]=Image.createImage("/sayo0"+i+j+".png");
	}
}
```
#7��ʹ�÷����������
-��������
�ı�Flag�����Ķ�������
```java
int heroFlag;
```
-��дһ���Զ��巽��
��class MainCanvas extends Canvas��ǩ��дһ���Զ��巽��
```java
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
```
-���÷���
��public void keyPressed(int keyCode)��ǩ���if(action)����е��÷���
```java
if(action==LEFT){
	changePictureandDirection(1);
	heroX=heroX-1;
	repaint();
}
```
#8�����boss��ʹboss����׷��hero
-��������
����bossImg��bossX��bossY�ı�������ֵ
-���岢����һ�����߳�
```java
Thread thread;
```
-���岢����һ������������ĺ���
```java
Random rd=new Random();
```
-���һ�����߳�
```java
thread=new Thread(this);//new Thread(this)����˼�ǵ�ǰ��ʵ����Ϊ��Ϊһ���߳�
thread.start();//�������߳�
```
-��if...else����ж�boss��hero�����겢ʹboss׷��hero
```java
public void run(){
		while(true){
			int rdNumber=rd.nextInt(10);//����һ��10���ڵ������

			try{
				Thread.sleep(500);//��Ļˢ����Ϊ500
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
				}
				else{
					bossY--;
				}
			}
			repaint();
		}
	}
```