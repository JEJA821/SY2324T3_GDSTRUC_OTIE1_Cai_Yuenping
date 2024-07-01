import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Queue<Player> playerQueue = new LinkedList<>();
        Random random = new Random();
        int gamesPlayed = 0;

        while (gamesPlayed < 10) {
            int playersToAdd = random.nextInt(7) + 1;
            System.out.println("Adding " + playersToAdd + " players to the queue.");
            for (int i = 0; i < playersToAdd; i++) {
                playerQueue.add(new Player("Player" + (playerQueue.size() + 1)));
            }
            System.out.println(playersToAdd + " players added to the queue. Current queue size: " + playerQueue.size());

            if (playerQueue.size() >= 5) {
                System.out.println("Starting a game with the following players:");
                for (int i = 0; i < 5; i++) {
                    Player player = playerQueue.poll();
                    System.out.println(player);
                }
                gamesPlayed++;
                System.out.println("Game " + gamesPlayed + " started. Current queue size: " + playerQueue.size());
            }

            System.out.println("Press Enter to continue to the next turn...");
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("10 games successfully played. Terminating the program.");
    }
}

class Player {
    private static int idCounter = 1;
    private int id;
    private String name;

    public Player(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
