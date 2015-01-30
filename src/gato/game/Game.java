/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gato.game;

/**
 *
 * @author Gloriana
 */
public class Game {
    
    private String board[][] ={{"","",""},
                               {"","",""},
                               {"","",""}
                              };
    private String signX = "X";
    private String signO = "O";
    private int player = 1;
    private boolean error = false;
    private byte winPlayer = 0;
    
    
    ////////////////////////////////////////
    public boolean getError()
    {
        return error;
    }
    
    ////////////////////////////////////////
    public void setError(boolean pBoolean)
    {
        error = pBoolean;
    }

    ////////////////////////////////////////
    public String getPlayer()
    {
        return (player==1)? "Turn: X":"Turn: O";
    }
    
    /////////////////////////////////////////
    public void setPlayer(int pNum)
    {
        player = pNum;
    }

    ////////////////////////////////////////
    public byte getWinPlayer()
    {
        return winPlayer;
    }
    
   
    ////////////////////////////////////////
    public void replayGame()
    {
        for (int row = 0 ; row < board.length ; row++)
            for (int col = 0 ; col < board.length ; col++)
                board[row][col]="";
        setError(false);
        this.winPlayer = 0;
        setPlayer(1); 

    }
    ////////////////////////////////////////////////////////
    public String setMove(int pPosition)
    {
        String out="";
        if(player==1)
        {
            out = markPosition(pPosition , this.signX);
            //
            player = 2;
            if ( win(this.board, this.signX) )
                this.winPlayer=1;
            else if (checkTie())
                this.winPlayer=3;
        }
        else
        {
            out =  markPosition(pPosition , this.signO);
            player = 1;
            if (win(this.board, this.signO))
                this.winPlayer=2;
            else if (checkTie())
                this.winPlayer=3;
        }     
        return out;
    }
    
    
    //////////////////////////////////////////////////////////
    private String markPosition(int pPosition, String value)
    {        
       String sign=""; 
       switch (pPosition)
       {
           case 1:sign = subMark(0,0,value); break;
           case 2:sign = subMark(0,1,value); break;
           case 3:sign = subMark(0,2,value); break;
           case 4:sign = subMark(1,0,value); break;
           case 5:sign = subMark(1,1,value); break;
           case 6:sign = subMark(1,2,value); break;
           case 7:sign = subMark(2,0,value); break;
           case 8:sign = subMark(2,1,value); break;
           case 9:sign = subMark(2,2,value); break;
       }
       return sign;
    }

    ////////////////////////////////////////////////////////////
    private String subMark(int pX, int pY, String value)
    {
        String sign="";
        setError(false);
        if(this.board[pX][pY].equals("")) //
        {
            this.board[pX][pY] = value;
            sign = value;
        }        
        else//
        {
            sign = this.board[pX][pY];
            setError(true);//
        }
        return sign;
             
    }

    

    //
    public boolean win(String matrix[][], String sign)
    {
        //filas
        for (int i = 0 ; i < matrix.length ; i++)
        {
            byte count=0;
            for (int j = 0 ; j < matrix.length ; j++)
                count+=(matrix[i][j].equals(sign) )?1:0;
            if(count == 3)
                 return true;
        }
        //columnas
        for (int j = 0 ; j < matrix.length ; j++)
        {
            byte count=0;
            for (int i = 0 ; i < matrix.length ; i++)
                count+=(matrix[i][j].equals(sign))?1:0;
            if(count == 3)
                 return true;
        }
        //diagonales
        if(matrix[0][0].equals(sign) && matrix[1][1].equals(sign) && matrix[2][2].equals(sign))
            return true;

        if(matrix[0][2].equals(sign) && matrix[1][1].equals(sign) && matrix[2][0].equals(sign))
            return true;

        return false;
    }
    
    ///////////////////////////////////////////////////////////////
    private boolean checkTie()
    {
        for (int row = 0 ; row < board.length ; row++)
           for (int col = 0 ; col < board.length ; col++)
                if(board[row][col].equals(""))
                    return false;
        return true;
    }

}


     
     
