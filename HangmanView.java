//Dylan Oldham Final Project NYU Java 11/27/17
//HangmanView


 public class HangmanView
   {
     
       
       public HangmanView()
    {
        System.out.println("Welcome to hangman!");
    }
    
    public String finalImage()
    {
        return printHangman(6);
    }
    public String printHangman(int numWrongPicks)
    { 
        String rValue = "";
        for (int i=0; i <= numWrongPicks; i++)
        {
            if (i == 1)
            {
               rValue +="|\n|\n|\n|\n|\n|\n"; 
            }
            else if (i == 2)
            {
                rValue +="__________________";
                rValue +="\n|\n|\n|\n|\n|\n|\n";
                
            }
            else if (i == 3)
            {
                rValue +="__________________";
                rValue +="\n|                |\n|\n|\n|\n|\n|\n";
            }
            else if (i == 4)
            {
                rValue +="__________________";
                rValue +="\n|                |\n|                O\n|                |\n|\n|\n|\n";
            }
            else if (i == 5)
            {
                rValue +="__________________";
                rValue +="\n|                |\n|                O\n|            "+
                          ">---|---<\n|\n|\n";
                
            }
            else if (i == 6)
            {
                rValue +="__________________";
                rValue += "\n|                |\n|                O\n|            "+
                          ">---|---<\n|                |\n|               / \\\n";
            }
            
        }
       return rValue;
     }
}
