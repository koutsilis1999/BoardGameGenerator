package org.example.games;

import static java.lang.Math.abs;

public class Game21 extends Game {
  /*  private int limit = 21;
    private List<Player> pausedPlayers = new ArrayList<>();
    private List<Player> executedPlayers = new ArrayList<>();

    public Game21(Board board, int numOfPlayers) {
        this.board=board;
       this.playerList = new PlayerList(numOfPlayers,board.getFirstSquare());
    }

    public void startGame() {
        Player player = playerList.getCurrentPlayer();
        Status status = Status.PLAY;
        SuccessCondition successCondition = new SuccessCondition21();
        Dice dice = new Dice(1, 6);
        Scanner scanner = new Scanner(System.in);
        String input;
        int diceThrow;

        do {
            System.out.println(player.getName() + " is currently playing , press enter to throw dice!");
            input = scanner.nextLine();
            diceThrow = dice.rollDice();
            System.out.println(player.getName() + " rolled " + diceThrow);
            board.movePlayer(this, diceThrow);
            System.out.println(player.getName() + " has " + player.getPower() + " Power !");
            if (player.getPower() > limit) {
                System.out.println("Oops you lost \n");
                executedPlayers.add(this.playerList.removePlayer());
                status = successCondition.getSuccessCondition(this);

            } else {
                System.out.println("Do you want to continue playing ?");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("no")) {
                    pausedPlayers.add(this.playerList.removePlayer());
                }
                status = successCondition.getSuccessCondition(this);
            }
            if (status == Status.PLAY)
                player = playerList.getNextPlayer();
        } while (status != Status.FINISH);
        finishGame();

    }

    public void finishGame() {
        if (pausedPlayers != null) {
            winner = pausedPlayers.get(0);
            int min = abs(winner.getPower() - limit);
            for (Player player1 : pausedPlayers) {
                if (abs(player1.getPower() - limit) < min) {
                    min = abs(player1.getPower() - limit);
                    winner = player1;
                }
            }
            System.out.println("Congrats " + winner.getName() + " you won!!!");
            System.out.println("=============================================");
        }
        for (Player player1 : pausedPlayers) {
            System.out.println(player1.getName() + " points " + player1.getPower());

        }
        System.out.println("\nExecuted Players");
        System.out.println("=============================================");
        for (Player player1 : executedPlayers) {
            System.out.println(player1.getName() + " points " + player1.getPower());
        }

    }
*/
}
