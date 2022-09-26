import button.*;

Button btn1, btn2;

boolean invert;

void setup() {
  size(800, 600);
  
  //Classic constructor
  btn1 = new Button(this);
  btn2 = new Button(this);
  
  //Rectangle geometry - posX, posY, width, height;
  //Or posX, posY, width, height, rounding
  btn1.setGeometry(100, 100, 50, 80, 10);
  
  //Circle geometry - posX, posY, diameter
  btn2.setGeometry(500, 100, 50);
  
  //Static color, Touching color, Pressing color, Stroke Color, Stroke weight
  btn1.setDesign(0, 128, 192, 0, 3);
  btn2.setDesign(#800000, #FF0000, #FF8000, 128, 5);
}

void draw() {
  background(255);
  
  //Draw the buttons
  btn1.draw();
  btn2.draw();
  
  //press varaible - always is true, when the button is pressed.
  if (btn1.press()) invert = !invert;
  fill(0);
  if (invert) fill(#0000FF);
  circle(125, 300, 30);
    
  //press function - is true at one frame, when the button is pressed.
  fill(0);
  if (btn2.press) fill(#0000FF);
  circle(500, 300, 30);
}