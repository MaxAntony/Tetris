/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import javax.microedition.lcdui.*;

/**
 * @author PaulMartin
 */
public class MiCanvas extends Canvas implements CommandListener {
    
    /**
     * Referencia al TetrisMidlet donde se incluye este MiCanvas
     */
    TetrisMIDlet tetrisMIDlet;
    private Command exitCommand;
    
    /**
     * Número de pixeles del ancho y alto de cada celda de
     * este tablero de juego
     */
    private int anchoCelda = -1;
    
    /**
     * constructor
     */   
    public MiCanvas(TetrisMIDlet t) {
        try {
            // Set up this canvas to listen to command events
            setCommandListener(this);
            // Add the Exit command
            exitCommand = new Command("Exit", Command.EXIT, 1);
            addCommand(exitCommand);
            tetrisMIDlet = t;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Dibuja los bordes del tablero de juego y las celdas ocupadas por trozos
     * de figura ya colocadas en el tablero
     * @param g el Graphics donde se dibujará
     */
    public void dibujaRejilla(Graphics g)
    {
        int i,j;
        Rejilla rejilla = tetrisMIDlet.getRejilla();
        int xoffset = (getWidth()-rejilla.getAnchura()*anchoCelda)/2;
        for(i=0;i<rejilla.getAnchura();i++)
        {
            for(j=0;j<rejilla.getAltura();j++)
            {
                if(rejilla.getTipoCelda(i,j) == Rejilla.BLOQUE)
                {
                    g.setColor(0,0,0);
                    g.drawRect(xoffset+i*anchoCelda,j*anchoCelda,anchoCelda,
                    anchoCelda);
                } else if(rejilla.getTipoCelda(i,j) == Rejilla.PIEZA)
                {
                    g.setColor(255,255,0);
                    g.fillRect(xoffset+i*anchoCelda,j*anchoCelda,anchoCelda,
                    anchoCelda);
                    g.setColor(255,0,0);
                    g.drawRect(xoffset+i*anchoCelda,j*anchoCelda,anchoCelda,
                    anchoCelda);
                }
            }
        }
    }
    
    /**
    * Dibuja la Figura fig en el Graphics g pasado como parámetro
    * (normalmente el asociado a este Canvas)
    * @param fig la Figura a dibujar
    * @param g el Graphics donde se dibujará
    */
    void dibujaFigura(Figura fig,Graphics g)
    {
        if (fig!=null)
        {
            Elemento elemento;
            Rejilla rejilla = tetrisMIDlet.getRejilla();
            int xoffset = (getWidth()-rejilla.getAnchura()*anchoCelda)/2+
            fig.getXOrigen()*anchoCelda;
            int yoffset = fig.getYOrigen()*anchoCelda;
            for(int i=0;i<fig.getNElements();i++)
            {
                elemento=fig.getElementAt(i);
                g.setColor(255,255,0);
                g.fillRect(xoffset+elemento.getColumna()*anchoCelda,
                yoffset+elemento.getFila()*anchoCelda,anchoCelda,
                anchoCelda);
                g.setColor(255,0,0);
                g.drawRect(xoffset+elemento.getColumna()*anchoCelda,
                yoffset+elemento.getFila()*anchoCelda,anchoCelda,
                anchoCelda);
            }
         }
    }

    /**
     * paint
     */
    public void paint(Graphics g)
    {
        //g.drawString("Sample Text",0,0,Graphics.TOP|Graphics.LEFT);
        if(anchoCelda==-1)
        {
            anchoCelda=Math.min(getWidth()/tetrisMIDlet.getRejilla().getAnchura(),
            (getHeight()-10)/tetrisMIDlet.getRejilla().getAltura());
        }
        g.setColor(255,255,255);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(0,0,0);
        g.translate(0,12);
        dibujaRejilla(g);
        dibujaFigura(tetrisMIDlet.getFigura(),g);
        g.translate(0,-12);
    }

    /**
     * Called when a key is pressed.
     */
    protected void keyPressed(int keyCode)
    {
        if (keyCode == getKeyCode(LEFT))
        {
            if(!tetrisMIDlet.getRejilla().seChoca(tetrisMIDlet.getFigura(), Figura.IZQUIERDA))
            {
                tetrisMIDlet.getFigura().mueve(Figura.IZQUIERDA);
                if(tetrisMIDlet.getCanvas()!=null)
                    tetrisMIDlet.getCanvas().repaint();
            }
        }else if (keyCode == getKeyCode(RIGHT))
        {
            if(!tetrisMIDlet.getRejilla().seChoca(tetrisMIDlet.getFigura(), Figura.DERECHA))
            {
                tetrisMIDlet.getFigura().mueve(Figura.DERECHA);
                if(tetrisMIDlet.getCanvas()!=null)
                    tetrisMIDlet.getCanvas().repaint();
            }
        }else if (keyCode == getKeyCode(UP))
        {
            tetrisMIDlet.getFigura().rotar(tetrisMIDlet.getRejilla());
            if(tetrisMIDlet.getCanvas()!=null)
                tetrisMIDlet.getCanvas().repaint();
        }else if (keyCode == getKeyCode(DOWN))
        {
            if(!tetrisMIDlet.getRejilla().seChoca(tetrisMIDlet.getFigura(), Figura.ABAJO))
            {
                tetrisMIDlet.getFigura().mueve(Figura.ABAJO);
                if(tetrisMIDlet.getCanvas()!=null)
                    tetrisMIDlet.getCanvas().repaint();
            }
        }
    }

    /**
     * Called when a key is released.
     */
    protected void keyReleased(int keyCode) {
    }

    /**
     * Called when a key is repeated (held down).
     */
    protected void keyRepeated(int keyCode) {
    }

    /**
     * Called when the pointer is dragged.
     */
    protected void pointerDragged(int x, int y) {
    }

    /**
     * Called when the pointer is pressed.
     */
    protected void pointerPressed(int x, int y) {
    }

    /**
     * Called when the pointer is released.
     */
    protected void pointerReleased(int x, int y) {
    }

    /**
     * Called when action should be handled
     */
    public void commandAction(Command command, Displayable displayable)
    {
        if (command == exitCommand)
        {
            javax.microedition.lcdui.Display.getDisplay(
            tetrisMIDlet).setCurrent(tetrisMIDlet.getForm());
        }
    }
    
}
