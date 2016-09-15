import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RandomPicker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomPicker extends Picker
{
    Message msg;    
    /**
     * Act - do whatever the RandomPicker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    public void pickGumball(){
        String choice = "";
        switch(Greenfoot.getRandomNumber(3)){
            case 0:
                choice = "Picked Green";
            break;
            case 1:
                choice = "Picked Blue";
            break;
            case 2:
                choice = "Picked Red";
            break;
        }
        World world = getWorld() ;
        GreenfootImage gi;
        gi = new GreenfootImage(90,25);
        gi.setColor( java.awt.Color.YELLOW ) ;
        gi.fill() ;
        gi.setColor( java.awt.Color.BLACK ) ;
        gi.drawString( choice, 3, 15 );
        msg = new Message() ;
        msg.setImage(gi);
        world.addObject( msg, 661, 125) ;
    }
    
    public void clearPickerMessage(){
        World world = getWorld() ;
        if(msg != null){
            world.removeObject(msg);
        }
    }
}
