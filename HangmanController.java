//Dylan Oldham Final Project NYU Java 11/27/17
//HangmanController

 public class HangmanController
{
    private int nWrongPick = 0;
    private String uString;
    private boolean bWin = false;
    private boolean bLose = false;
    private char[] guesses = new char[26];
    private int howLong = 0;
 
    public HangmanController()
    {
        //empty constructior
    }
    //setter for the word that player 2 is guessing
    public void setHiddenWord(String newHiddenWord)
    {
        uString = newHiddenWord;
    }
    
    public boolean isWon()
    {
        return bWin;
    }
    
    public boolean isGameOver()
    {
        return bWin || bLose;
    }
    
    public boolean containsGuessChar(char newGuess)
    { 
          for (int i=0; i < howLong; i++)
          {
              if(guesses[i] == newGuess)
              {
                  return true;
              }
          }
    
        return false;
    }

    
    public String getWordStatus()
    { 
        String rValue = "";
        for(int i = 0; i < uString.length(); i++)
        {
            if(!containsGuessChar(uString.charAt(i)))
            {
                rValue+="_ ";
                
            }
            else
            {
                rValue += uString.charAt(i);
                
            }
            
        }
        return rValue;
    }
    
    
    
    public void makeGuess(char newUserGuess)
    {
        //search the word uString
        //if newUserGuess == any char in uString word trigger fill in blank correc guess
        //else if incorrect(ex: first guess) count number of wrong picks
        //the view will call the getter for obtaining the correct image
        //append to the char array in both cases
        //after making guess check if it's a win or loss
        
        
        if (uString.indexOf(newUserGuess) >= 0)

        {  boolean allReadyGuessed = false;

           for(int i=0; i < howLong; i++)
               {
                 if(guesses[i] == newUserGuess)
                  {
                     allReadyGuessed = true;
                   } 
                }

            if(allReadyGuessed == false)
             {guesses[howLong++] = newUserGuess;
            
           bWin = checkForWin();
            }
            
        }
        else
        { 
       
        
            nWrongPick++;
            if(nWrongPick > 5)
            {
                bLose = true;
            }
        }
    }
    
    public boolean checkForWin()
    { 
        int countCheck = 0;
        for(int i= 0; i < uString.length(); i++)
        {
            for(int j= 0; j < howLong; j++)
            {
                if(uString.charAt(i) == guesses[j])
                {
                    countCheck++;
                }
            }
        }
       return countCheck == uString.length();
    }
    
    public int getNumWrongPicks()
    {
        return nWrongPick;
    }
    public String getCorrectGuesses()
    {
        String rValue = "";
        for (int i = 0; i <= howLong; i++)
        {
            rValue += guesses[i];
        }
        return rValue;
    }
}

