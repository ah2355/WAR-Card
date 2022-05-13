import java.util.*;
public class Deck
  {
    private ArrayList<Card> deck;

    public Deck(String suit)
    { deck = new ArrayList<Card>();
     String rank;
      for(int i=0; i<12;i++)
        {
          if(i ==0)
       {
         rank = 2 + "";
         deck.add(new Card(suit, rank, 2));
       }
       else if(i ==1)
       {
         rank = 3 + "";
         deck.add(new Card(suit, rank, 3));
       }
       else if(i ==2)
       {
         rank = 4 + "";
         deck.add(new Card(suit, rank, 4));
       }
       else if(i ==3)
       {
         rank = 5 + "";
         deck.add(new Card(suit, rank, 5));
       }
       else if(i ==4)
       {
         rank = 6 + "";
         deck.add(new Card(suit, rank, 6));
       }
       else if(i==5)
       {
         rank = 7 + "";
         deck.add(new Card(suit, rank, 7));
       }
          else if(i==6)
          {
            rank = 8 +"";
            deck.add(new Card(suit,rank,8));
          }
          else if(i==7)
          {
            rank = 9 +"";
            deck.add(new Card(suit, rank, 9));
          }
          else if(i==8)
          {
            rank = 10 + "";
            deck.add(new Card(suit, rank,10));
          }
          else if(i==9)
          {
            rank = "Queen";
            deck.add(new Card(suit, rank, 12));
          }
          else if(i==10)
          {
            rank = "King";
            deck.add(new Card(suit, rank, 13));
          }
          else
          {
            rank = "Ace";
            deck.add(new Card(suit, rank, 14));
          }
          
        }
    }

    public int getSize()
    {
      return deck.size();
    }

    public void shuffle()
    {
      int index = (int)(Math.random()*deck.size()-1);
      Card[] arr = new Card[26];
      for(int i=0; i <deck.size();i++)
        {
          if(deck.get(i)!=null)
          {
            arr[0] = deck.get(i);
            deck.set(i,deck.get(index));
            deck.set(index,arr[0]);
            index = (int)  
            (Math.random()*deck.size()-1);
          }
        }
    }

    public Card flip()
    {
      for(int i=0; i<deck.size();i++)
        {
          if(deck.get(i)!= null)
          {
            return deck.remove(i);
          }
        }
      return deck.remove(0);
    }

    public void winCard(Card s)
    {
      deck.add(s);
    }

    public boolean isEmpty()
    {
      for(int i=0; i< deck.size();i++)
        {
          if(deck.get(i)!= null)
          {
            return false;
          }
        }
      return true;
    }

    public String toString()
    {
      String t=  "";
      for(int i=0; i<deck.size();i++)
        {
          t+= deck.get(i) + ", ";
        }
      return t;
    }
    
  }