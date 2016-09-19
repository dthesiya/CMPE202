
color color1 = 255, color2 = 255, textColor1 = 0, textColor2 = 0;
int rect1X, rect1Y, rect2X, rect2Y, rectW = 140, rectH = 40;
boolean intoArea1=false, locked1 = false;
boolean intoArea2=false, locked2 = false;
GumballMachine gumballMachine;
void setup() 
{
  size(800, 800) ;
  background(255) ;
  smooth() ;
  strokeWeight(3);
  strokeCap(ROUND);
  
  // load font
  PFont font;
  font = loadFont("BookAntiqua-48.vlw");
  textFont(font, 32);

  color1 = color(255);
  color2 = color(255);

  rect1X = 80;
  rect1Y = 450;
  rect2X = 80;
  rect2Y = 500;
  gumballMachine = new GumballMachine(5);
}

void draw() {
  fill(0);
  textSize(32);
  text("The Gumball Machine", 250, 60);
  PImage image = loadImage("gumball.jpg");
  image(image, (width-image.width)/2, (height-image.height)/2);
  textSize(24);
  if (overRect(rect1X, rect1Y, rectW, rectH)) {
    intoArea1=true;
    if(mousePressed){
      textColor1 = color(255);
      color1 = color(0);
    }else{
      textColor1 = color(0);
      color1 = color(128); 
    }
  } else {
    intoArea1=false;
    color1 = color(255);
  }
  fill(color1);
  rect(rect1X, rect1Y, rectW, rectH, 7);
  fill(textColor1);
  text("Insert Coin", 90, 478);
  if (overRect(rect2X, rect2Y, rectW, rectH)) {
    intoArea2=true;
    if(mousePressed){
      textColor2 = color(255);
      color2 = color(0);
    }else{
      textColor2 = color(0);
      color2 = color(128); 
    }
  } else {
    intoArea2 = false;
    color2 = color(255);
  }
  fill(color2);
  rect(rect2X, rect2Y, rectW, rectH, 7);
  fill(textColor2);
  text("Turn Crank", 90, 528);
}

boolean overRect(int x, int y, int w, int h){
  if (mouseX >= x && mouseX <= x + w && 
      mouseY >= y && mouseY <= y + h) {
    return true;
  }else{
    return false; 
  }
}

void mouseClicked(){
    if(intoArea1){
        locked1 = true;
        fill(color1);
        rect(rect1X, rect1Y, rectW, rectH, 7);
        gumballMachine.insertQuarter();
        System.out.println(gumballMachine);
    }else if(intoArea2){
        locked2 = true;
        fill(color2);
        rect(rect2X, rect2Y, rectW, rectH, 7);
        gumballMachine.turnCrank();
        System.out.println("Gumball machine has "+gumballMachine.getCount()+" balls left inside");
        System.out.println(gumballMachine);
    }else{
       locked1 = locked2 = false; 
    }
}