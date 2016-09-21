import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inspector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inspector extends Alien
{
    Message msg, choiceMsg;
    Picker gumballPicker;
    /**
     * Act - do whatever the Inspector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
    }
    
    public void inspect(GumballMachine gumballMachine){
        String inspection = "";
        if(gumballMachine.coinType == 1){
            inspection = "Penny Rejected";
        }else if(gumballMachine.coinType == 2){
            inspection = "Fake Quarter";            
        }else if(gumballMachine.coinType == 3){
            inspection = "Quarter Accepted";            
        }
        World world = getWorld() ;
        GreenfootImage gi;
        gi = new GreenfootImage(120,25);
        gi.setColor( java.awt.Color.YELLOW ) ;
        gi.fill() ;
        gi.setColor( java.awt.Color.BLACK ) ;
        gi.drawString( inspection, 2, 15 );
        msg = new Message() ;
        msg.setImage(gi);
        world.addObject( msg, 533, 340) ;
        if(gumballMachine.coinType == 3){
            String choice = "";
            switch(Greenfoot.getRandomNumber(2)){
                case 0:
                    // Random Picker
                    gumballPicker = getWorld().getObjectsAt(643, 104, Picker.class).get(0);
                    choice = "Chose RandomPicker";
                break;
                case 1:
                    // Green Picker            
                    gumballPicker = getWorld().getObjectsAt(686, 454, Picker.class).get(0);
                    choice = "Chose greenPicker";                
                break;
            }
            gi = new GreenfootImage(140,25);
            gi.setColor( java.awt.Color.RED ) ;
            gi.fill() ;
            gi.setColor( java.awt.Color.BLACK ) ;
            gi.drawString( choice, 2, 15 );
            choiceMsg = new Message() ;
            choiceMsg.setImage(gi);
            world.addObject( choiceMsg, 660, 340) ;
            gumballPicker.pickGumball();
        }
        //removing coin from the machine
        gumballMachine.coinType = 0;
    }
    
    public void clearInspectorMessage(){
        World world = getWorld() ;
        if(msg != null){
            world.removeObject(msg);
        }
        if(choiceMsg != null){
            world.removeObject(choiceMsg);
        }
        if(gumballPicker != null){
            gumballPicker.clearPickerMessage();
        }
    }
}
