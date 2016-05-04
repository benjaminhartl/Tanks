import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/** PlayMenu is a class that allows users to name their tanks, and select a tank color
    @author Benjamin Hartl
    @author Nick Abrahan
    @author Colin Biafore
    @author Bryce Bowers
    @version 1.0
*/

public class PlayMenu{
    JFrame jf;
    
    GameScreen newGame;

    public JPanel jpTop;
    public JPanel jpBottom;

    public JPanel jpPlayer1;
	public JPanel jpPlayer2;

    public JPanel configButtonPanel;
    public drawTank tank1;
    public drawTank tank2;
    private JTextField p1Name;
    private JTextField p2Name;
    private JButton confirmBtn;
    private JButton backToMain;

    /** Constructor
	creates the menu to name a player and set tank color
    */

    public PlayMenu() {
	
	jf = new JFrame( "Forge your Characters!" );
	jf.setSize( 700, 600 );
	jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    	
	jpTop = new JPanel();
	jpTop.setLayout( new GridLayout( 2, 2, 5, 5 ) );
	jf.add( jpTop );

	jpBottom = new JPanel();
	jf.add( jpBottom, BorderLayout.SOUTH );

	jpPlayer1 = new JPanel();
	jpPlayer1.setLayout( new GridLayout( 3, 1 ) );
	jpPlayer1.add( new JLabel( "Player 1" ) );
	p1Name = new JTextField( "" );
	jpPlayer1.add( p1Name );
	
	jpPlayer2 = new JPanel();
	jpPlayer2.setLayout( new GridLayout( 3, 1 ) );
	jpPlayer2.add( new JLabel( "Player 2" ) );
	p2Name = new JTextField( "" );
	jpPlayer2.add( p2Name );

	jpTop.add( jpPlayer1 );
	jpTop.add( jpPlayer2 );

	tank1 = new drawTank();
	jpTop.add( tank1 );

	tank2 = new drawTank();
	jpTop.add( tank2 );

	addToConfigButtonPanel();

	setToVisible();
    }

    /**
       Creates a panel with text fields and buttons to take user to next and previous menu
    */
    
    private void addToConfigButtonPanel() {
			
	confirmBtn = new JButton( "Confirm!" );
	confirmBtn.addActionListener( new StartGameListener() );

	backToMain = new JButton( "Back To Main Menu" );
	backToMain.addActionListener( new BackToMainListener() );
	
	configButtonPanel = new JPanel();
	configButtonPanel.add( backToMain );
	configButtonPanel.add( confirmBtn );
       	
    jpBottom.add( configButtonPanel, BorderLayout.SOUTH );
    }    
    
    class StartGameListener implements ActionListener{
	public void actionPerformed( ActionEvent ae ){
	    try{
	      	enviroMenu envMenu = new enviroMenu( p1Name.getText(), 
						    tank1.getTheColor(),
						    p2Name.getText(),
						    tank2.getTheColor() );
			jf.dispose();
	    }catch( IOException ioe ){
		ioe.printStackTrace();
	    }
	}
    }
    
    class BackToMainListener implements ActionListener{
	public void actionPerformed( ActionEvent e ){
	    jf.setVisible( false );
	}
    }

    /**
       makes the play menu visible on the screen
    */

    public void setToVisible()
    {
	jf.setVisible( true );
    }
    
}
