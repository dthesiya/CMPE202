import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GumballMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballMachine extends Actor
{
    Message hasCoin, crankTurned;
    int coinType;
    Inspector inspector;

    public GumballMachine()
    {
        GreenfootImage image = getImage() ;
        image.scale( 350, 400 ) ;
    }

    public void act() 
    {
        // Add your action code here.
        int mouseX, mouseY ;
        inspector = (Inspector)getWorld().getObjectsAt(533, 291, Inspector.class).get(0);
        World world = getWorld() ;
        if(Greenfoot.mousePressed(this)) {
            if(hasCoin != null){
                world.removeObject(hasCoin);
            }
            turnCrank();
        }

        Actor coin = getOneObjectAtOffset(0, 50, Coin.class ) ;
        if ( coin != null )
        {
            if(crankTurned != null){
                world.removeObject(crankTurned);
            }
            insertCoin(coin);
        }
    }
    
    public void insertCoin(Actor coin){
        World world = getWorld();
        inspector.clearInspectorMessage();
        if(coinType > 0){
            if(hasCoin != null){
                world.removeObject(hasCoin);
            }
            GreenfootImage gi;
            gi = new GreenfootImage(100,25);
            gi.setColor( java.awt.Color.YELLOW ) ;
            gi.fill() ;
            gi.setColor( java.awt.Color.BLACK ) ;
            gi.drawString( "Inserted Already!", 0, 15 );
            hasCoin = new Message() ;
            hasCoin.setImage(gi);
            world.addObject( hasCoin, 367, 267) ;
        }else{
            if(coin instanceof Penny){
                coinType = 1;
            }else if(coin instanceof FakeQuarter){
                coinType = 2;
            }else if(coin instanceof Quarter){
                coinType = 3;
            }
            world.removeObject(coin) ;
            GreenfootImage gi;
            gi = new GreenfootImage(100,25);
            gi.setColor( java.awt.Color.YELLOW ) ;
            gi.fill() ;
            gi.setColor( java.awt.Color.BLACK ) ;
            gi.drawString( "Have Coin!", 5, 15 );
            hasCoin = new Message() ;
            hasCoin.setImage(gi);
            world.addObject( hasCoin, 367, 267) ;
        }
        
    }
    
    public void turnCrank(){
        World world = getWorld();
        if(coinType > 0){
            GreenfootImage gi;
            gi = new GreenfootImage(100,25);
            gi.setColor( java.awt.Color.YELLOW ) ;
            gi.fill() ;
            gi.setColor( java.awt.Color.BLACK ) ;
            gi.drawString( "Crank Turned!", 5, 15 );
            crankTurned = new Message() ;
            crankTurned.setImage(gi);
            world.addObject( crankTurned, 367, 327 ) ;
            inspector.inspect(this);
        }else{
            if(crankTurned != null){
                world.removeObject(crankTurned);
            }
            GreenfootImage gi;
            gi = new GreenfootImage(100,25);
            gi.setColor( java.awt.Color.YELLOW ) ;
            gi.fill() ;
            gi.setColor( java.awt.Color.BLACK ) ;
            gi.drawString( "Insert Coin!", 5, 15 );
            crankTurned = new Message() ;
            crankTurned.setImage(gi);
            world.addObject( crankTurned, 367, 327 ) ;
        }
    }
}
