package slider;

import processing.core.*;

public class Slider {

	PApplet app;

	float x, y, w, h, r, sw;
	float min, max;
	int form;
	int sc, ac, pc, stroke;
	public boolean press;
	public float value;
	
	public Slider(PApplet theParent) {
		app = theParent;
	}
	
	public void setGeometry(float x, float y, float w, float h, float r) {
		form = 0;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.r = r;
	}
	
	public void setGeometry(float x, float y, float w, float h) {
		form = 1;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public void setDesign(int s, int a, int p, int stroke, float sw) {
		sc = s;
		ac = a;
		pc = p;
		this.stroke = stroke;
		this.sw = sw;
	}
	
	public void setRange(float min, float max) {
		this.min = min;
		this.max = max;
	}
	
	public void draw() {
		float position = PApplet.map(value, min, max, x, x+w);
		app.push();
		app.stroke(stroke);
		app.strokeWeight(sw);
		switch (form) {
		case 0:
			app.strokeWeight(h);
			app.line(x, y, x+w, y);
			app.strokeWeight(sw);
			app.fill(sc);
			if (PApplet.sqrt(PApplet.sq(app.mouseX - position) + PApplet.sq(app.mouseY - y)) < r) {
				app.fill(ac);
				if (press) value = PApplet.map(app.mouseX, x, x+w, min, max);
				if (value < min) value = min;
				if (value > max) value = max;
				if (app.mousePressed) press = true;
			} else press = false;
			if (press) app.fill(pc);
			app.circle(position, y, r);
			break;
		case 1:
			app.fill(sc);
			app.rect(x, y, w, h);
			app.fill(ac);
			if (app.mouseX > x && app.mouseX < x+w && app.mouseY > y && app.mouseY < y+h) {
				app.fill(pc);
				if (press) value = PApplet.map(app.mouseX, x, x+w, min, max);
				if (value < min) value = min;
				if (value > max) value = max;
				if (app.mousePressed) press = true;
				else press = false;
			} else press = false;
			app.rect(x, y, position - x, h);
			break;
		}
		app.pop();
	}
}

