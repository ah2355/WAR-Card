import java.util.*;

class Main {
private static Deck player;
private static Deck computer;
private static ArrayList<Card> limbo = new ArrayList<Card>();
  public static void main(String[] args) 
  {
    player = new Deck("Hearts");
    computer = new Deck("Clubs");
    player.shuffle();
    computer.shuffle();
    Scanner sc = new Scanner(System.in);
    System.out.println("Press Enter when ready for next card(type 'exit' to quit the game)");
    String input = sc.nextLine();
    boolean gameOver= false;
    while(!input.equals("exit")&&gameOver==false)
      {
        
       
       gameOver = play();
        input = sc.nextLine();
      }
    System.out.println("Player's deck: " + player);
    System.out.println("Computer's deck: " + computer);
    gameOver();
  }
 public static boolean play()
  {
    int y = 0;
    int j =0;
    System.out.println("Player played: ");
    Card p = player.flip();
    System.out.println(p);
    System.out.print("Computer played: ");
    Card c = computer.flip();
    System.out.println(c);
    if(p.getValue()<c.getValue())
    { 
      computer.winCard(c);
      computer.winCard(p);
      if(y==12)
      {
        computer.shuffle();
        y=0;
      }
      y++;
    }

     else if(p.getValue()>c.getValue())
    {
        player.winCard(c);
      player.winCard(p);
      if(j==12)
      {
        player.shuffle();
        j=0;
      }
      j++;
    }

    else
     {
      
       if(player.isEmpty()== true || computer.isEmpty()==true)
                {
                  return true;
                }
       while(p.getValue()==c.getValue())
         {
           System.out.println();
           System.out.println("WAR!!");
            for(int i=0; i<limbo.size();i++)
               {
                 limbo.remove(i);
                 i--;
               }
           limbo.add(p);
           limbo.add(c);
           for(int i=0;i<3;i++)
             {
               if(player.isEmpty()== true || computer.isEmpty()==true)
                {
                  return true;
                }
               
               limbo.add(player.flip());
               limbo.add(computer.flip());
             }

            if(player.isEmpty()== true || computer.isEmpty()==true)
                {
                  return true;
                }
           p = player.flip();
           c = computer.flip();
           System.out.println();
           System.out.println("Player played: ");
           System.out.println(p);
           System.out.println("Computer played: ");
           System.out.println(c);
           
           if(p.getValue()>c.getValue())
           {
             for(int i=0;i<limbo.size();i++)
               {
                 player.winCard(limbo.get(i));
               }
             
            if(player.isEmpty()== true || computer.isEmpty()==true)
                {
                  return true;
                }
             
               player.winCard(p);
               player.winCard(c);
             System.out.println("Player's deck: " + player);
    System.out.println("Computer's deck: " + computer);
             for(int i=0; i<limbo.size();i++)
               {
                 limbo.remove(i);
                 i--;
               }
           }
           else if(p.getValue()<c.getValue())
           {
               for(int i=0;i<limbo.size();i++)
               {
                 computer.winCard(limbo.get(i));
               }
             
            if(player.isEmpty()== true || computer.isEmpty()==true)
                {
                  return true;
                }
             
               computer.winCard(p);
               computer.winCard(c); 
             System.out.println("Player's deck: " + player);
    System.out.println("Computer's deck: " + computer);
             
             for(int i=0; i<limbo.size();i++)
               {
                 limbo.remove(i);
                 i--;
               }
           }
         }
     }   
  
     System.out.println("Player's deck: " + player);
    System.out.println("Computer's deck: " + computer);
    boolean x =false;
     if(player.isEmpty()== true || computer.isEmpty()==true)
    {
      x=true;
    }
    return x;
  }

  public static void gameOver()
  {
    //if the player deck is empty then it will print player lost else if the computer deck is empty it will print the player has won else the game is over
    if(player.isEmpty()==true)
    {
      System.out.println("Game Over! You lose!");
    }
    else if(computer.isEmpty()==true)
    {
      System.out.println("Game Over! You win!");
    }
    else
    {
      System.out.println("Game Over!");
    }

    

  }
}