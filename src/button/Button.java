package button;

import processing.core.*;

public class Button {
	
	PApplet app;

	float x, y, w, h, r, sw;
	int form;
	int sc, ac, pc, stroke;
	public boolean press;
	boolean isPressed;
	
	public Button(PApplet theParent) {
		app = theParent;
	}
	
	public void setGeometry(float x, float y, float w, float h) {
		form = 0;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public void setGeometry(float x, float y, float w, float h, float r) {
		form = 0;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.r = r;
	}
	
	public void setGeometry(float x, float y, float r) {
		form = 1;
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public void setDesign(int s, int a, int p, int stroke, float sw) {
		sc = s;
		ac = a;
		pc = p;
		this.stroke = stroke;
		this.sw = sw;
	}
	
	public boolean press() {
		boolean temp = false;
		if (press && !isPressed) {
			temp = true;
			isPressed = true;
		}
		return isPressed;
	}
	
	public void draw() {
		app.push();
		app.stroke(stroke);
		app.strokeWeight(sw);
		switch (form) {
		case 0:
			app.fill(sc);
			if (app.mouseX > x && app.mouseX < x+w && app.mouseY > y && app.mouseY < y+h) {
				app.fill(ac);
				if (app.mousePressed) press = true;
				else press = false;
			} else press = false;
			if (press) app.fill(pc);
			app.rect(x, y, w, h, r);
			break;
		case 1:
			app.fill(sc);
			if (PApplet.sqrt(PApplet.sq(app.mouseX - x) + PApplet.sq(app.mouseY - y)) < r) {
				app.fill(ac);
				if (app.mousePressed) press = true;
				else press = false;
			} else press = false;
			if (press) app.fill(pc);
			app.circle(x, y, r);
			break;
		}
		app.pop();
		if (!press) isPressed = false;
	}
}

