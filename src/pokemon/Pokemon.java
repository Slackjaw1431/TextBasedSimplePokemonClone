package pokemon;

import java.util.Random;
import java.util.Scanner;

/*  @author Talha Memon */
public class Pokemon {

    public static void main(String[] args) {

        MonsterTypes fire = new MonsterTypes("Fire");
        MonsterTypes water = new MonsterTypes("Water");
        MonsterTypes earth = new MonsterTypes("Earth");
        MonsterTypes air = new MonsterTypes("Air");

        Monsters[] enemies = {air, fire, water, earth};

        System.out.println("Wild monsters roam the lands!");

        for (Monsters enemy : enemies) {
            System.out.print(enemy.type + " ");
        }
        System.out.println();

        Random rand = new Random();

        int x = rand.nextInt(enemies.length);

        System.out.println("A wild " + enemies[x].type + " monster appeared!\n");

        Scanner scan = new Scanner(System.in);
        char input = 'p';//placeholder because otherwise it doesnt compile

        char[] playerChoices = {'W', 'w', 'E', 'e', 'A', 'a', 'F', 'f'};
        boolean playerChoiceValid = false;

        while (!playerChoiceValid) {
            System.out.println("Select your monster: [F]ire, [A]ir, [W]ater, or [E]arth");
            input = scan.next().charAt(0);
            for (int i = 0; i < playerChoices.length; i++) {
                if (input == playerChoices[i]) {
                    playerChoiceValid = true;
                } else if (input != playerChoices[i]) {
                }
            }
        }

        PlayerMonsters player = new PlayerMonsters(input);

        int playerHP = player.HP;
        int enemyHP = enemies[x].HP;

        String firstMove = "";

        System.out.println("You selected the " + player.type + " monster\n");
        System.out.println("Player agility is " + player.Agility + " and Enemy agility is " + enemies[x].Agility);

        if (player.Agility >= enemies[x].Agility) {
            firstMove = "Player";
            System.out.println("The player has higher agility and moves first.\n");
            enemyHP -= move(player, enemies[x]);
        } else {
            firstMove = "Enemy";
            System.out.println("The enemy has higher agility and moves first.\n");
            playerHP -= move(enemies[x], player);
        }

        do {
            for (int i = 0; i < 10; i = i + 1 % 2) {
                if (firstMove.equals("Player")) {
                    if (i == 0) {
                        System.out.println("-----------------------------");
                        System.out.println("Player: " + playerHP + " Enemy: " + enemyHP);
                        System.out.println("-----------------------------");
                        playerHP -= move(enemies[x], player);
                    } else if (i == 1) {
                        System.out.println("-----------------------------");
                        System.out.println("Player: " + playerHP + " Enemy: " + enemyHP);
                        System.out.println("-----------------------------");
                        enemyHP -= move(player, enemies[x]);
                    }
                } else if (firstMove.equals("Enemy")) {
                    if (i == 0) {
                        System.out.println("-----------------------------");
                        System.out.println("Player: " + playerHP + " Enemy: " + enemyHP);
                        System.out.println("-----------------------------");
                        enemyHP -= move(player, enemies[x]);
                    } else if (i == 1) {
                        System.out.println("-----------------------------");
                        System.out.println("Player: " + playerHP + " Enemy: " + enemyHP);
                        System.out.println("-----------------------------");
                        playerHP -= move(enemies[x], player);
                    }
                }
            }
        } while (playerHP > 0 && enemyHP > 0);

        if (playerHP <= 0) {
            System.out.println("\nThe player has been defeated and the match has ended!");
        } else if (enemyHP <= 0) {
            System.out.println("\nThe enemy has been defeated and the match has ended!");
        }
    }

    public static int move(Monsters m, Monsters n) {
        {
            boolean player = m instanceof PlayerMonsters;
            boolean enemy = m instanceof MonsterTypes;
            Scanner scan = new Scanner(System.in);
            Random rand1 = new Random();
            int dam = 0;
            boolean correctInput = false;

            if (player) {
                while(!correctInput){
                System.out.println("Choose to [A]ttack or [D]efend");
                char input = scan.next().charAt(0);
                switch (input) {
                    case 'A':
                    case 'a':
                        correctInput = true;
                        System.out.println("Player chooses to Attack");
                        System.out.println("X");
                        dam += attack(m, n);//player,enemy/attacker,target
                        break;
                    case 'D':
                    case 'd':
                        correctInput = true;
                        System.out.println("Player chooses to Defend");
                        System.out.println("D");
                        defend(m);//player defends
                        break;
                    default:
                        System.out.println("Enter correct input: A or D");
                        input = scan.next().charAt(0);
                }
                }
            } else if (enemy) {
                String[] enemyMove = {"Attack", "Defend"};
                int y = rand1.nextInt(enemyMove.length);
                String move = enemyMove[y];
                System.out.println("Monster decides to " + enemyMove[y]);

                if (move == "Attack") {
                    System.out.println("X");
                    dam += attack(m, n);//enemy,player/attacker,target
                } else if (move == "Defend") {
                    System.out.println("D");
                    defend(m);//enemy defends
                }
            }
            return dam;
        }
    }

    public static int attack(Monsters attacker, Monsters target) {
        int damage = 0;
        boolean player = attacker instanceof PlayerMonsters;
        boolean enemy = attacker instanceof MonsterTypes;
        String attackerName = "";

        if (player) {
        attackerName = "Player";
        }
        else if (enemy) {
        attackerName = attacker.type + " monster";
        }

        if (target.isDefending) {
            damage += attacker.Attack - target.Defense;
            if (damage <= 0) { //negative damage should be nullified
                damage = 0;
            }
            System.out.println(attackerName + " attacks! " + attacker.yell);
            System.out.println(attackerName + " did " + damage + " damage");
            target.isDefending = false;
        } else if (!target.isDefending) {
            damage += attacker.Attack;
            System.out.println(attackerName + " attacks! " + attacker.yell);
            System.out.println(attackerName + " did " + damage + " damage");
            target.isDefending = false;
        }
        return damage;
    }

    public static void defend(Monsters m) {
        m.isDefending = true;
        //return m.isDefending;
    }
}
