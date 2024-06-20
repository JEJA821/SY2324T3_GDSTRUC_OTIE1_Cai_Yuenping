import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player(1, "Antonio Claveria", 1);
        Player player2 = new Player(2, "Drake McKersie", 2);
        Player player3 = new Player(3, "Jeush King Nebres", 3);
        Player player4 = new Player(4, "Joey Lavina", 4);

        PlayerDoublyLinkedList playerLinkedList = new PlayerDoublyLinkedList();
        playerLinkedList.addToFront(player1);
        playerLinkedList.addToFront(player2);
        playerLinkedList.addToFront(player3);
        playerLinkedList.addToEnd(player4);

        playerLinkedList.printList();
        System.out.println("\nSize: " + playerLinkedList.size());

        playerLinkedList.removeFirst();
        playerLinkedList.printList();
        System.out.println("\nSize: " + playerLinkedList.size());

        System.out.println("\nList contains Antonio Claveria? " + playerLinkedList.contains(player1));
        System.out.println("Index of Joey Lavina: " + playerLinkedList.indexOf(player4));
    }
}

class PlayerNode {
    private Player player;
    private PlayerNode nextPlayer;
    private PlayerNode previousPlayer;

    public PlayerNode(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public PlayerNode getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(PlayerNode nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public PlayerNode getPreviousPlayer() {
        return previousPlayer;
    }

    public void setPreviousPlayer(PlayerNode previousPlayer) {
        this.previousPlayer = previousPlayer;
    }

    @Override
    public String toString() {
        return "PlayerNode{" + player + '}';
    }
}

class PlayerDoublyLinkedList {
    private PlayerNode head;
    private PlayerNode tail;
    private int size;

    public void addToFront(Player player) {
        PlayerNode playerNode = new PlayerNode(player);
        if (head == null) {
            head = tail = playerNode;
        } else {
            playerNode.setNextPlayer(head);
            head.setPreviousPlayer(playerNode);
            head = playerNode;
        }
        size++;
    }

    public void addToEnd(Player player) {
        PlayerNode playerNode = new PlayerNode(player);
        if (tail == null) {
            head = tail = playerNode;
        } else {
            tail.setNextPlayer(playerNode);
            playerNode.setPreviousPlayer(tail);
            tail = playerNode;
        }
        size++;
    }

    public Player removeFirst() {
        if (head == null) {
            return null;
        }
        Player removedPlayer = head.getPlayer();
        head = head.getNextPlayer();
        if (head != null) {
            head.setPreviousPlayer(null);
        } else {
            tail = null;
        }
        size--;
        return removedPlayer;
    }

    public boolean contains(Player player) {
        PlayerNode current = head;
        while (current != null) {
            if (current.getPlayer().equals(player)) {
                return true;
            }
            current = current.getNextPlayer();
        }
        return false;
    }

    public int indexOf(Player player) {
        PlayerNode current = head;
        int index = 0;
        while (current != null) {
            if (current.getPlayer().equals(player)) {
                return index;
            }
            current = current.getNextPlayer();
            index++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public void printList() {
        PlayerNode current = head;
        System.out.print("head -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <-> ");
            current = current.getNextPlayer();
        }
        System.out.println("null");
    }
}

class Player {
    private int id;
    private String name;
    private int level;

    public Player(int id, String name, int level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && level == player.level && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, level);
    }

    @Override
    public String toString() {
        return "Player{" + "[" + id + "] " + name + ", lvl " + level + '}';
    }
}
