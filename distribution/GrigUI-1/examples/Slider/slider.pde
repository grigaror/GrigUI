import slider.*;

Slider sldr1, sldr2;

void setup() {
  size(800, 600);
  textSize(50);
  //Black text
  fill(0);
  
  //Classic constructor
  sldr1 = new Slider(this);
  sldr2 = new Slider(this);
  
  //Stick slider geometry - PosX, PosY, Length, Thickness, Circle diameter
  sldr1.setGeometry(50, 200, 300, 5, 20);
  
  //Rectangle slider geometry - PosX, PosY, Width, Height
  sldr2.setGeometry(400, 200, 300, 50);
  
  //Stick slider design - Stick color & Circle static color, Circle active color, Circle pressed color, Circle stroke color
  //Rectangle slider design - Background color, Fill static color, Fill active & pressed color, Stroke color
  sldr1.setDesign(0, 128, 192, 0, 0);
  sldr2.setDesign(0, #800000, #FF0000, #FFFFFF, 5);
  
  //Set the minimum and maximum value of slider
  sldr1.setRange(-0.5, 0.5);
  sldr2.setRange(-50, 50);
}

void draw() {
  background(255);
  
  //Draw the sliders
  sldr1.draw();
  sldr2.draw();
  
  //Slider also have press varaible, as button (But doesn't have press() function!)
  if (sldr1.press) text(sldr1.value, 50, 300);
  
  //Value is float varaible
  text(sldr2.value, 450, 300);
}