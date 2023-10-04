package ru.szherbekov.gamecentr;


public class Main {

    public static void main(String[] args) {

        Player player = new Player(20, 30, 40, 4, 9, 50);
        Monster monster = new Monster(10, 50, 30, 4, 10);
        battle(player, monster);
    }

    private static void battle(Player player, Monster monster) {
        int countMonsterAttack = 0;
        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            if (monster.getHealth() != 0 && player.getHealth() != 0) {
                player.isSuccessAttack(monster);
                System.out.println("Игрок атакует монстра, здоровье монстра теперь - " + monster.getHealth());
            }
            if (player.getHealth() != 0 && monster.getHealth() != 0) {
                monster.isSuccessAttack(player);
                countMonsterAttack++;
                System.out.println("Монстр атакует игрока, здоровье игрока теперь - " + player.getHealth());
            }
            if (countMonsterAttack <= 4) {
                player.heal();
                System.out.println("Игрок восстановил здоровье, здоровье игрока теперь - " + player.getHealth());
            }
        }
        if (player.getHealth() == 0) {
            System.out.println("Монстр победил!");

        } else {
            System.out.println("Игрок победил!");
        }
    }
}
