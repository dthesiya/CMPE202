import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenPicker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenPicker extends Picker
{
    Message msg;
    /**
     * Act - do whatever the GreenPicker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    public void pickGumball(){
        World world = getWorld() ;
        GreenfootImage gi;
        gi = new GreenfootImage(90,25);
        gi.setColor( java.awt.Color.YELLOW ) ;
        gi.fill() ;
        gi.setColor( java.awt.Color.BLACK ) ;
        gi.drawString( "Picked Green", 2, 15 );
        msg = new Message() ;
        msg.setImage(gi);
        world.addObject( msg, 676, 485) ;
    }
    
    public void clearPickerMessage(){
        World world = getWorld() ;
        if(msg != null){
            world.removeObject(msg);
        }
    }
}
