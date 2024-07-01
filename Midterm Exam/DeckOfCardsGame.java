import java.util.Random;

public class DeckOfCardsGame {
    private static final int INITIAL_DECK_SIZE = 30;

    private CardStack playerDeck;
    private CardStack discardedPile;

    public DeckOfCardsGame() {
        playerDeck = new CardStack();
        discardedPile = new CardStack();

        // Initialize player deck with 30 cards (example names)
        for (int i = 0; i < INITIAL_DECK_SIZE; i++) {
            playerDeck.push(new Card("Card " + (i + 1)));
        }
    }

    public void playGame() {
        Random random = new Random();

        while (!playerDeck.isEmpty()) {
            // Simulate random commands
            int command = random.nextInt(3); // 0: Draw, 1: Discard, 2: Get from discarded pile

            switch (command) {
                case 0:
                    int drawCount = random.nextInt(5) + 1; // Draw 1 to 5 cards
                    drawCards(drawCount);
                    break;
                case 1:
                    int discardCount = random.nextInt(5) + 1; // Discard 1 to 5 cards
                    discardCards(discardCount);
                    break;
                case 2:
                    int getFromDiscardCount = random.nextInt(5) + 1; // Get 1 to 5 cards from discard pile
                    getCardsFromDiscard(getFromDiscardCount);
                    break;
            }

            // Display current game state
            displayGameState();
        }

        // End of game
        System.out.println("Player deck is empty. Game over!");
    }

    private void drawCards(int count) {
        System.out.println("Drawing " + count + " cards from player deck...");
        for (int i = 0; i < count; i++) {
            if (!playerDeck.isEmpty()) {
                Card drawnCard = playerDeck.pop();
                System.out.println("Drawn: " + drawnCard.getName());
            }
        }
    }

    private void discardCards(int count) {
        System.out.println("Discarding " + count + " cards...");
        for (int i = 0; i < count; i++) {
            if (!playerDeck.isEmpty()) {
                Card discardedCard = playerDeck.pop();
                discardedPile.push(discardedCard);
                System.out.println("Discarded: " + discardedCard.getName());
            }
        }
    }

    private void getCardsFromDiscard(int count) {
        System.out.println("Getting " + count + " cards from discarded pile...");
        for (int i = 0; i < count; i++) {
            if (!discardedPile.isEmpty()) {
                Card retrievedCard = discardedPile.pop();
                playerDeck.push(retrievedCard);
                System.out.println("Retrieved from discard: " + retrievedCard.getName());
            }
        }
    }

    private void displayGameState() {
        System.out.println("--- Current Game State ---");
        // Implement logic to display current cards in hand
        System.out.println("Remaining cards in deck: " + playerDeck.size());
        System.out.println("Cards in discarded pile: " + discardedPile.size());
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        DeckOfCardsGame game = new DeckOfCardsGame();
        game.playGame();
    }
}
