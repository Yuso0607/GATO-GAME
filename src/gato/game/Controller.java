/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gato.game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Gloriana
 */
public class Controller implements ActionListener{
    private Interface view;
    private Game game;
    private String title = "Gato Game ";

       
    public Controller(Interface view, Game model)
    {
        this.view = view;
        this.game = model;  
    }

    /////////////////////////////////////////////////////////////
    public void openView()
    {
        view.setTitle(this.title);
        view.setLocationRelativeTo(null);
        this.view.Celda1.addActionListener(this);
        this.view.Celda2.addActionListener(this);
        this.view.Celda3.addActionListener(this);
        this.view.Celda4.addActionListener(this);
        this.view.Celda5.addActionListener(this);
        this.view.Celda6.addActionListener(this);
        this.view.Celda7.addActionListener(this);
        this.view.Celda8.addActionListener(this);
        this.view.Celda9.addActionListener(this);
    }

    //////////////////////////////////////////////////////////
    public void actionPerformed(ActionEvent e) {
        Object boton = e.getSource();

        if(this.game.getWinPlayer()== 0)
        {
        if(boton == this.view.Celda1)
            this.view.Celda1.setText(this.game.setMove(1));
        else if(boton == this.view.Celda2)
            this.view.Celda2.setText(this.game.setMove(2));
        else if(boton == this.view.Celda3)
            this.view.Celda3.setText(this.game.setMove(3));
        else if(boton == this.view.Celda4)
            this.view.Celda4.setText(this.game.setMove(4));
        else if(boton == this.view.Celda5)
            this.view.Celda5.setText(this.game.setMove(5));
        else if(boton == this.view.Celda6)
            this.view.Celda6.setText(this.game.setMove(6));
        else if(boton == this.view.Celda7)
            this.view.Celda7.setText(this.game.setMove(7));
        else if(boton == this.view.Celda8)
            this.view.Celda8.setText(this.game.setMove(8));
        else if(boton == this.view.Celda9)
            this.view.Celda9.setText(this.game.setMove(9));
          if(this.game.getError())
              JOptionPane.showMessageDialog
                      (null, "The scauare is already marked \n You missed your turn");            

        this.view.setTitle(this.title + this.game.getPlayer());

        }
        
        if( this.game.getWinPlayer()== 1)
            message("X");
        else if(this.game.getWinPlayer()== 2)
            message("O");
        else if(this.game.getWinPlayer()== 3)
            message("It's a tie");
    }

   
    private void message(String s)
    {
           int selection = JOptionPane.showOptionDialog
                                       (null,"Winner: " + s + "\n ¿What do you want to do next?", "Game Over",
                           JOptionPane.YES_NO_CANCEL_OPTION,
                           JOptionPane.QUESTION_MESSAGE,
                           null,    
                           new Object[] {"Play again", "Exit"},
                           "Play again");

            if (selection != -1)
                if((selection+1)==1)
                {
                    this.game.replayGame();
                    this.view.setTitle(title);
                    this.view.Celda1.setText("");
                    this.view.Celda2.setText("");
                    this.view.Celda3.setText("");
                    this.view.Celda4.setText("");
                    this.view.Celda5.setText("");
                    this.view.Celda6.setText("");
                    this.view.Celda7.setText("");
                    this.view.Celda8.setText("");
                    this.view.Celda9.setText("");
                }
                else
                    System.exit(0);
    }
}
