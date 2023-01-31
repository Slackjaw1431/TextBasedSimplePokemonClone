package pokemon;

/*  @author Talha Memon */
public class MonsterTypes extends Monsters {

    public MonsterTypes(String Type, int HP, int Agility, int Attack, int Defense, String yell, String weak) {//big constructor
        this.type = Type;
        this.HP = HP;
        this.Agility = Agility;
        this.Attack = Attack;
        this.Defense = Defense;
        this.yell = yell;
        this.weak = weak;
        this.isDefending = false;
    }

    MonsterTypes(String Type) {//single specified constructor
        if (Type.equals("Water")) {
            type = "Water";
            HP = 200;
            Agility = 8;
            Attack = 30;
            Defense = 10;
            yell = "Splash!";
            weak = "Earth";
            isDefending = false;
        } else if (Type.equals("Air")) {
            type = "Air";
            HP = 110;
            Agility = 10;
            Attack = 25;
            Defense = 20;
            yell = "Woosh!";
            weak = "Fire";
            isDefending = false;

        } else if (Type.equals("Fire")) {
            this.type = "Fire";
            HP = 150;
            Agility = 6;
            Attack = 20;
            Defense = 15;
            yell = "Rar!";
            weak = "Water";
            isDefending = false;
        } else if (Type.equals("Earth")) {
            type = "Earth";
            HP = 180;
            Agility = 2;
            Attack = 30;
            Defense = 25;
            yell = "Grrrrr!";
            weak = "Air";
            isDefending = false;
        } else {
            System.out.println("Enter type of monster to create");
        }
    }
}
