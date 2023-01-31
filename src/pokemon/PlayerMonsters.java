package pokemon;
/*  @author Talha Memon */

import java.util.Scanner;

public class PlayerMonsters extends Monsters{

    Scanner scan = new Scanner(System.in);

     PlayerMonsters (char Type) {
         switch (Type) {
             case 'W', 'w' -> {
                 type = "Water";
                 HP = 60;
                 Agility = 4;
                 Attack = 45;
                 Defense = 10;
                 yell = "Splash!";
                 weak = "Earth";
                 isDefending = false;
             }
             case 'A', 'a' -> {
                 type = "Air";
                 HP = 70;
                 Agility = 6;
                 Attack = 55;
                 Defense = 20;
                 yell = "Woosh!";
                 weak = "Fire";
                 isDefending = false;
             }
             case 'F', 'f' -> {
                 this.type = "Fire";
                 HP = 80;
                 Agility = 6;
                 Attack = 40;
                 Defense = 15;
                 yell = "Rar!";
                 weak = "Water";
                 isDefending = false;
             }
             case 'E', 'e' -> {
                 type = "Earth";
                 HP = 95;
                 Agility = 2;
                 Attack = 50;
                 Defense = 25;
                 yell = "Grrrrr!";
                 weak = "Air";
                 isDefending = false;
             }
             default -> {
                 System.out.println("Enter type of monster to create");
                 Type = scan.next().charAt(0);
             }
         }
    }

}
