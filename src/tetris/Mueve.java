package tetris;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * Esta clase implementa una hebra que hace que se mueva continuamente hacia abajo la Figura actual.
 * La hebra se encarga también de ir refrescando la pantalla
 * dónde se dibuja todo. Además controla si la Figura
 * choca contra un muro o contra las piezas ya colocadas. 
 */
public class Mueve implements Runnable{
    private int delay;
    private boolean continuar=true;
    private boolean suspendFlag=true;
    private TetrisMIDlet tetrisMidlet;
    
    
    /**
     * Constructor de la clase, que inicializa la referencia utilizadas por
     * la hebra al TetrisMidlet, establece el retardo en milisegundos
     * entre movimiento y movimiento de la Figura actual, y comienza a ejecutar
     * la hebra. 
     */
    Mueve(TetrisMIDlet tetris,int nivel){
        tetrisMidlet = tetris;
        delay=actualizaRetardo(nivel);
        Thread t=new Thread(this);
        t.start();
    }
    
    /**
     * Código que constituye las sentencias de la hebra. En este caso, se encarga
     * de hacer que se mueva continuamente hacia abajo la figura actual
     * La hebra se encarga también de ir refrescando la pantalla donde se dibuja todo. 
     * Además controla si la figura ha llegado a la parte de abajo para detenerla.
     */
    public void run(){
        try{
            while(continuar){
                synchronized(this){
                    while(suspendFlag){
                        wait();
                    }
                }
                Thread.sleep(delay);
                if(!tetrisMidlet.getRejilla().seChoca(tetrisMidlet.getFigura(),Figura.ABAJO)){
                    tetrisMidlet.getFigura().mueve(Figura.ABAJO);
                    if(tetrisMidlet.getCanvas()!=null)
                        tetrisMidlet.getCanvas().repaint();
                }
                else{
                    boolean valor=tetrisMidlet.getRejilla().copiaFiguraEnRejilla(tetrisMidlet.getFigura());
                    tetrisMidlet.getRejilla().eliminarFilasLlenas();
                    if(tetrisMidlet.getCanvas()!=null)
                        tetrisMidlet.getCanvas().repaint();
                    if(!valor)
                        tetrisMidlet.nuevaFigura();
                    else{
                        System.out.println("He llegado al final");
                        continuar=false;
                    }
                }
            }// end while(continuar)
        } catch(InterruptedException e){
            System.out.println("Hilo MueveSerpiente interrumpido");
        }
    }
    
    /**
     * Detiene momentaneamente la ejecución de la hebra, haciendo que la Figura actual
     * quede parada.
     */
    synchronized public void suspender(){
        tetrisMidlet.getCanvas().repaint();
        suspendFlag=true;
    }
    
    /**
     * Reanuda el movimiento de la hebra. La Figura actual vuelve  a moverse.
     */
    public synchronized void reanudar(){
        tetrisMidlet.getCanvas().repaint();
        suspendFlag = false;
        notify();
    }
    
    /**
     * Termina la ejecución de la hebra.
     */
    public void parar(){
        continuar=false;
    }
    
    /**
     * Nos dice si la hebra está o no parada.
     * @return true si la hebra de movimiento está parada, false en otro caso
     */
    synchronized public boolean getParado(){
        return suspendFlag;
    }
    
    /**
     * La siguiente función actualiza el retardo que espera la hebra
     * para mover la Figura actual. El nivel más lento será
     * el 0 (retardo 700) y el más rápido el 10 (retardo 50)
     */
    private int actualizaRetardo(int nivel) {
        if (nivel>10) nivel=10;
        else if (nivel<0) nivel=0;
        return ( 400-(nivel*35) );
    }
}
