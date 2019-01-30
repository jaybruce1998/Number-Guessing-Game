   import java.io.*;
   import java.util.*;
   public class numberGuessingGame
   {
      static Scanner input=new Scanner(System.in);
      static String typed;
      static int option, number, low, high, guess;
      public static void iGuess()
      {
         number=low-1;
         for(int i=(int)(Math.log(high-low)/Math.log(2))+1; option!=3&&i>0; i--)
         {
            guess=(low+high)/2;
            System.out.println("I have "+i+" guesses left.");
            System.out.println("Is your number less than, greater than or equal to "+guess+"?");
            option=0;
            while(option<1||option>3)
            {
               System.out.println("1) It's less than "+guess+".");
               System.out.println("2) It's greater than "+guess+".");
               System.out.println("3) You guessed my number.");
               typed=input.nextLine();
               if(!(typed.equals("1")||typed.equals("2")||typed.equals("3")||typed.equals("4")||typed.equals("5")))
                  option=0;
               else
                  option=Integer.parseInt(typed);
               if(option<1||option>3)
                  System.out.println(typed+" is not a valid answer.");
            }
            if(option==1)
               high=guess;
            if(option==2)
               low=guess;
         }
         if(option==3)
            System.out.println("I guessed your number!");
         else
            System.out.println("I ran out of guesses?! You must have cheated!");
         option=0;
      }
      public static void youGuess()
      {
         number=(int)(Math.random()*(high-low+1))+low;
         for(int i=(int)(Math.log(high-low)/Math.log(2))+1; guess!=number&&i>0; i--)
         {
            System.out.println("You have "+i+" guesses left.");
            System.out.println("Which number would you like to guess?");
            guess=input.nextInt();
            if(guess==number)
               System.out.println("You guessed my number!");
            if(guess<number)
               System.out.println("My number is greater than that.");
            if(guess>number)
               System.out.println("My number is lower than that.");
         }
         if(guess!=number)
            System.out.println("You ran out of guesses. My number was "+number+".");
         input.nextLine();
      }
      public static void main(String[] args)
      {
         while(option!=3)
         {
            option=0;
            while(option<1||option>3)
            {
               System.out.println("What would you like to do?");
               System.out.println("1) Guess my number.");
               System.out.println("2) Make me guess your number.");
               System.out.println("3) Exit.");
               typed=input.nextLine();
               if(!(typed.equals("1")||typed.equals("2")||typed.equals("3")||typed.equals("4")||typed.equals("5")))
                  option=0;
               else
                  option=Integer.parseInt(typed);
               if(option<1||option>3)
                  System.out.println(typed+" is not a valid option.");
            }
            if(option<3)
            {
               System.out.print("Alright, so ");
               if(option==1)
                  System.out.print("I'll");
               else
                  System.out.print("you'll");
               System.out.println(" think of a number between...");
               low=input.nextInt();
               high=low;
               while(high<=low)
               {
                  System.out.println("and...");
                  high=input.nextInt();
                  if(high<=low)
                     System.out.println(high+" is not greater than "+low+".");
                  if(high-low<2)
                  {
                     System.out.println("You can do better than that!");
                     high=low;
                  }
               }
               input.nextLine();
               if(option==1)
                  youGuess();
               else
                  iGuess();
            }
         }
      }
   }