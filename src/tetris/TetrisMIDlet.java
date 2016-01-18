/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Dj_System
 */

public class TetrisMIDlet extends MIDlet implements CommandListener {
    
    MiCanvas miCanvas;    
    Rejilla rejilla;
    Figura figura=null;
    Mueve mueve;
    
    private boolean midletPaused = false;

//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Command okCommand;
    private Form form;
    private StringItem stringItem;
    private ChoiceGroup choiceGroup;
    private Alert splashAlert;
    private Image image;
//</editor-fold>//GEN-END:|fields|0|

    /**
     * The HelloMIDlet constructor.
     */
    public TetrisMIDlet()
    {
        miCanvas = new MiCanvas(this);
        rejilla = new Rejilla(12,22);
        mueve = new Mueve(this, 2);
    }
    
    /**
     * Obtiene una referencia a la Rejilla del juego
     * @return una referencia a la Rejilla del juego
     */
    public Rejilla getRejilla()
    {
        return rejilla;
    }
    
    /**
     * Obtiene una referencia a la Figura que cae actualmente en el juego
     * @return una referencia a la Figura actual
     */
    public Figura getFigura()
    {
        return figura;
    }
    
    /**
     * Obtiene una nueva figura cuyo tipo es seleccionado de forma aleatoria
     */
    public void nuevaFigura()
    {
        figura = Figura.nuevaFigura();
    }
    
    /**
     * Deja VACIA todas las celdas de la Rejilla, la inicializa
     * de nuevo. Además genera una nueva Figura de tipo aleatorio
     */
    public void inicializaJuego()
    {
        rejilla.initRejilla();
        nuevaFigura();
    }
    
    /**
     * Obtiene una referencia al Canvas (panel donde se dibuja) del juego
     * @return una referencia al Canvas del juego
     */
    public MiCanvas getCanvas()
    {
        return miCanvas;
    }

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initializes the application. It is called only once when the MIDlet is
     * started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {
//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
}//GEN-BEGIN:|0-initialize|2|
//</editor-fold>//GEN-END:|0-initialize|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {
//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
switchDisplayable(getSplashAlert(), getForm());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
}//GEN-BEGIN:|3-startMIDlet|2|
//</editor-fold>//GEN-END:|3-startMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {
//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
}//GEN-BEGIN:|4-resumeMIDlet|2|
//</editor-fold>//GEN-END:|4-resumeMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code>
     * instance is taken from <code>getDisplay</code> method. This method is
     * used by all actions in the design for switching displayable.
     *
     * @param alert the Alert which is temporarily set to the display; if
     * <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {
//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
}//GEN-BEGIN:|5-switchDisplayable|2|
//</editor-fold>//GEN-END:|5-switchDisplayable|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a
     * particular displayable.
     *
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {
//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
if (displayable == form) {//GEN-BEGIN:|7-commandAction|1|19-preAction
            if (command == exitCommand) {//GEN-END:|7-commandAction|1|19-preAction
                // write pre-action user code here
exitMIDlet();//GEN-LINE:|7-commandAction|2|19-postAction
                // write post-action user code here
} else if (command == okCommand) {//GEN-LINE:|7-commandAction|3|28-preAction
                // write pre-action user code here
                if(choiceGroup.getSelectedIndex() == 0)
                {
                    System.out.println("Ha seleccionado Jugar");
                    javax.microedition.lcdui.Display.getDisplay(this).setCurrent(miCanvas);
                    inicializaJuego();
                    mueve.reanudar();
                } else if(choiceGroup.getSelectedIndex() == 1)
                {
                    System.out.println("Ha seleccionado Opciones");
                } else if(choiceGroup.getSelectedIndex() == 2)
                {
                    System.out.println("Ha seleccionado Ver records");
                }
//GEN-LINE:|7-commandAction|4|28-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|5|7-postCommandAction
        }//GEN-END:|7-commandAction|5|7-postCommandAction
        // write post-action user code here
}//GEN-BEGIN:|7-commandAction|6|
//</editor-fold>//GEN-END:|7-commandAction|6|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initialized instance of exitCommand component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {
//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
}//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
//</editor-fold>//GEN-END:|18-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initialized instance of form component.
     *
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {
//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
form = new Form("Welcome", new Item[]{getStringItem(), getChoiceGroup()});//GEN-BEGIN:|14-getter|1|14-postInit
            form.addCommand(getExitCommand());
            form.addCommand(getOkCommand());
            form.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
}//GEN-BEGIN:|14-getter|2|
        return form;
    }
//</editor-fold>//GEN-END:|14-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|16-getter|0|16-preInit
    /**
     * Returns an initialized instance of stringItem component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {
//GEN-END:|16-getter|0|16-preInit
            // write pre-init user code here
stringItem = new StringItem("Hello", "Bienvenido al juego del Tetris");//GEN-LINE:|16-getter|1|16-postInit
            // write post-init user code here
}//GEN-BEGIN:|16-getter|2|
        return stringItem;
    }
//</editor-fold>//GEN-END:|16-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: splashAlert ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initialized instance of splashAlert component.
     *
     * @return the initialized component instance
     */
    public Alert getSplashAlert() {
        if (splashAlert == null) {
//GEN-END:|22-getter|0|22-preInit
 // write pre-init user code here
splashAlert = new Alert("Java Tetris", "Bienvenido al juego del Tetris", null, null);//GEN-BEGIN:|22-getter|1|22-postInit
            splashAlert.setTimeout(2000);//GEN-END:|22-getter|1|22-postInit
 // write post-init user code here
}//GEN-BEGIN:|22-getter|2|
        return splashAlert;
    }
//</editor-fold>//GEN-END:|22-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|27-getter|0|27-preInit
    /**
     * Returns an initialized instance of okCommand component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {
//GEN-END:|27-getter|0|27-preInit
 // write pre-init user code here
okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|27-getter|1|27-postInit
 // write post-init user code here
}//GEN-BEGIN:|27-getter|2|
        return okCommand;
    }
//</editor-fold>//GEN-END:|27-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: choiceGroup ">//GEN-BEGIN:|23-getter|0|23-preInit
    /**
     * Returns an initialized instance of choiceGroup component.
     *
     * @return the initialized component instance
     */
    public ChoiceGroup getChoiceGroup() {
        if (choiceGroup == null) {
//GEN-END:|23-getter|0|23-preInit
 // write pre-init user code here
choiceGroup = new ChoiceGroup("Men\u00FA", Choice.EXCLUSIVE);//GEN-BEGIN:|23-getter|1|23-postInit
            choiceGroup.append("Jugar", null);
            choiceGroup.append("Opciones", null);
            choiceGroup.append("Ver records", null);
            choiceGroup.setSelectedFlags(new boolean[]{false, false, false});//GEN-END:|23-getter|1|23-postInit
 // write post-init user code here
}//GEN-BEGIN:|23-getter|2|
        return choiceGroup;
    }
//</editor-fold>//GEN-END:|23-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image ">//GEN-BEGIN:|30-getter|0|30-preInit
    /**
     * Returns an initialized instance of image component.
     *
     * @return the initialized component instance
     */
    public Image getImage() {
        if (image == null) {//GEN-END:|30-getter|0|30-preInit
 // write pre-init user code here
try {//GEN-BEGIN:|30-getter|1|30-@java.io.IOException
                image = Image.createImage("/tetris/piezatetris.png");
            } catch (java.io.IOException e) {//GEN-END:|30-getter|1|30-@java.io.IOException
    e.printStackTrace();}//GEN-LINE:|30-getter|2|30-postInit
 // write post-init user code here
}//GEN-BEGIN:|30-getter|3|
        return image;
    }
//</editor-fold>//GEN-END:|30-getter|3|

    /**
     * Returns a display instance.
     *
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started. Checks whether the MIDlet have been
     * already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

    /**
     * @param form the form to set
     */
    public void setForm(Form form) {
        this.form = form;
    }
    
}
