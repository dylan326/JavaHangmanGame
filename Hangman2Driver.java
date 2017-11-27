//Dylan Oldham Final Project NYU Java 11/27/17
//Hangman2Driver


 import java.util.Scanner;
 import java.io.*;

public class Hangman2Driver
{
  
  
  public static void main(String[] args) throws Exception
    {   
        //declaring variables needed
        String userString;
        char userGuess;
        
        
        //creating all the objects needed from controller
        HangmanController game = new HangmanController();
        HangmanView images = new HangmanView();
        Scanner keyboard = new Scanner(System.in);
        PrintWriter outFile = new PrintWriter("hangmanWords.txt");
        
        
        //prompt player 1 to  pick a word for player 2
        System.out.println("Player 1 enter a word and dont show player 2!");
        userString = keyboard.nextLine();
        
        //print what the user entered to the hangmanWords text file
        outFile.println(userString.toLowerCase());
        outFile.close();
        
        //creating objects to read the file
        File myFile = new File("hangmanWords.txt");
        Scanner inFile = new Scanner(myFile);
        
        //string var that contains the line we need from the hangmanWords text
        String p1Word = inFile.nextLine();
        
        // Close the file so information is avalible.
        inFile.close();
        
        //set the word for player 2
        game.setHiddenWord(p1Word);
        
        
       do
        {  
            //if number of wrong picks is > 0 an image from the view is called
            System.out.println(images.printHangman(game.getNumWrongPicks()));
            
            //gets current status of the word
            System.out.println(game.getWordStatus());
            
            //the guessing starts
            System.out.println("Guess a letter player 2: ");
            
            //it's char so need to concat two functions to get the char
            userGuess = keyboard.next().charAt(0);
            char lowEr = Character.toLowerCase(userGuess);
            
            //excute the makeGuess function with user char as  paramater
            game.makeGuess(lowEr);
            System.out.println(game.getCorrectGuesses());
            
       
        }while ( !game.isGameOver());
        
        //if else to determinie if there was a will
        if(game.isWon())
        {   
            System.out.println("You're a winner!!");
        }
        else 
        {
            System.out.println(images.finalImage());
            System.out.println("You lost, Sorry!!");
        }
    
    
    
    }
}
