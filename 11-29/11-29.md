#1、显示hero

-声明变量
在class MainCanvas extends Canvas标签下定义、声明变量
```java
Image heroImg,currentImg;
```
-给变量赋值
在public MainCanvas里的try标签下给变量赋值
```java
currentImg=Image.createImage("/sayo10.png");
```

#2、实现hero转向

-声明变量
在class MainCanvas extends Canvas标签下定义、声明变量
```java
Image heroLeftImg,heroRightImg,heroUpImg,heroDownImg,currentImg;
```
-给变量赋值
在public void keyPressed(int keyCode)标签下给变量赋值
```java
if(action==LEFT){
			currentImg=heroLeftImg;
			repaint();
		}
```

#3、让hero可以移动

-声明变量
在class MainCanvas extends Canvas标签下定义、声明变量,并修改g.drawImage中的xy坐标为heroX,heroY
```java
int heroX,heroY;
```
-给变量赋值
在public MainCanvas里的try标签下给变量赋值
```java
	heroX=120;
	heroY=100;
```
-给变量重新赋值
在public void keyPressed(int keyCode)里的if(action==LEFT)标签里给heroX,heroY重新赋值
```java
heroX=heroX-1;
```

#4、让hero移动时可以切换动作

添加一个标志值来判断动作的切换

-声明变量
在class MainCanvas extends Canvas标签下定义、声明变量
```java
Image leftImg1,leftImg2,rightImg1,rightImg2,upImg1,upImg2,downImg1,downImg2;
int leftFlag,rightFlag,upFlag,downFlag;
```
-给变量赋值
在public MainCanvas里的try标签下给变量赋值
```java
heroDownImg=Image.createImage("/sayo10.png");
downImg1=Image.createImage("/sayo00.png");
downImg2=Image.createImage("/sayo20.png");
```
-增加标志值的判断
在public void keyPressed(int keyCode)里的if(action==LEFT)标签用if···else if 语句代替原本的currentImg=heroLeftImg;
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
#5、使用for循环和一维数组改造代码
-声明定义变量
在class MainCanvas extends Canvas标签下定义声明变量
```java
Image heroLeftImg[] =new Image[3];
```
-给变量赋值
在public MainCanvas里的try标签下给变量赋值
```java
for(int i=0;i<3;i++){
		heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
}
```
#6、使用二维数组改造代码
-声明定义变量
在class MainCanvas extends Canvas标签下定义声明变量
```java
Image heroImg[][]=new Image[4][3];
```
-给变量赋值
在public MainCanvas里的try标签下给变量赋值
```java
for(int i=0;i<4;i++){
	for(int j=0;j<3;j++){
		heroImg[i][j]=Image.createImage("/sayo0"+i+j+".png");
	}
}
```
#7、使用方法改造代码
-声明变量
改变Flag变量的定义声明
```java
int heroFlag;
```
-编写一个自定义方法
在class MainCanvas extends Canvas标签下写一个自定义方法
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
-调用方法
在public void keyPressed(int keyCode)标签里的if(action)语句中调用方法
```java
if(action==LEFT){
	changePictureandDirection(1);
	heroX=heroX-1;
	repaint();
}
```
#8、添加boss并使boss可以追击hero
-声明变量
声明bossImg、bossX、bossY的变量并赋值
-定义并声明一个多线程
```java
Thread thread;
```
-定义并声明一个返回随机数的函数
```java
Random rd=new Random();
```
-添加一个多线程
```java
thread=new Thread(this);//new Thread(this)的意思是当前类实例化为化为一个线程
thread.start();//启动该线程
```
-用if...else语句判断boss和hero的坐标并使boss追击hero
```java
public void run(){
		while(true){
			int rdNumber=rd.nextInt(10);//产生一个10以内的随机数

			try{
				Thread.sleep(500);//屏幕刷新率为500
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