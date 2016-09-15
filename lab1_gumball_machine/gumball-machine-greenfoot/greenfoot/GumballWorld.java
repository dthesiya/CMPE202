import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GumballWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballWorld extends World
{

    /**
     * Constructor for objects of class GumballWorld.
     * 
     */
    public GumballWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        GumballMachine gumballmachine = new GumballMachine();
        addObject(gumballmachine, 367, 237);
        GreenfootImage gi;
        gi = new GreenfootImage(120,20);
        gi.setColor( java.awt.Color.YELLOW) ;
        gi.fill() ;
        gi.setColor( java.awt.Color.BLACK ) ;
        gi.drawString( "Gumball Machine", 5, 15 );
        Message m = new Message() ;
        m.setImage(gi);
        addObject( m, 367, 430) ;
        
        
        addObject( new Penny(), 57, 71 ) ;
        addObject( new Quarter(), 68, 156 ) ;
        addObject( new FakeQuarter(), 66, 248 ) ;

        Inspector inspector = new Inspector();
        addObject(inspector, 533, 291);
        gi = new GreenfootImage(70,20);
        gi.setColor( java.awt.Color.YELLOW) ;
        gi.fill() ;
        gi.setColor( java.awt.Color.BLACK ) ;
        gi.drawString( "Inspector", 5, 15 );
        m = new Message() ;
        m.setImage(gi);
        addObject( m, 533, 380) ;
        
        
        RandomPicker randompicker = new RandomPicker();
        addObject(randompicker, 643, 104);
        randompicker.setLocation(655, 94);
        gi = new GreenfootImage(100,20);
        gi.setColor( java.awt.Color.GRAY) ;
        gi.fill() ;
        gi.setColor( java.awt.Color.BLACK ) ;
        gi.drawString( "Random Picker", 5, 15 );
        m = new Message() ;
        m.setImage(gi);
        addObject( m, 655, 185) ;
        
        GreenPicker greenpicker = new GreenPicker();
        addObject(greenpicker, 686, 454);
        greenpicker.setLocation(669, 456);
        gi = new GreenfootImage(90,20);
        gi.setColor( java.awt.Color.GREEN) ;
        gi.fill() ;
        gi.setColor( java.awt.Color.BLACK ) ;
        gi.drawString( "Green Picker", 5, 15 );
        m = new Message() ;
        m.setImage(gi);
        addObject( m, 669, 547) ;
    }
}
