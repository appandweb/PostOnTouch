package com.appandweb.postontouch;

import com.example.postontouch.R;


import android.os.Bundle;
import android.app.Activity;
import android.graphics.PointF;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView cuadrado;
	private int modificarX = 100;
	private int modificarY = 100;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		cuadrado = (ImageView) findViewById(R.id.imageView1);
		
		cuadrado.setOnTouchListener(handlerMover);
	}
	
	View.OnTouchListener handlerMover = new View.OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			PointF DownPT = new PointF(); 
		    PointF StartPT = new PointF();
			int eid = event.getAction();
		    switch (eid)
		    {
		        case MotionEvent.ACTION_MOVE :
		        	// Obtenemos la posicion actual del elemento
		            StartPT = new PointF( v.getX(), v.getY() );
		            // Calculamos el desplazamiento
		            PointF mv = new PointF( event.getX() - DownPT.x, event.getY() - DownPT.y);
		            
		            // Asignamos al elemento la posicion actual menos un valor que se define para
		            // que el elemento quede centrado con respecto a nuestro dedo.
		            v.setX((StartPT.x+mv.x) - modificarX);
		            v.setY((StartPT.y+mv.y) - modificarY);
		            
		            
		            break;
		        case MotionEvent.ACTION_DOWN:
		        	// Guardamos la posici??n inicial
		            DownPT.x = event.getX();
		            DownPT.y = event.getY();

		            break;
		        case MotionEvent.ACTION_UP :
	        		// En esta parte se podran guardar en una base de datos
		        	// la nueva posicion para que ese elemento se muestre en dicha posicion
		        	// la proxima vez que abramos la aplicacion.
		        	// hariamos algo asi:
		        	//      cuadrado.setPosX(v.getX());
		        	//		cuadrado.setPosY(v.getY());
		            break;
		        default :
		            break;
		    }
		    return true;
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
