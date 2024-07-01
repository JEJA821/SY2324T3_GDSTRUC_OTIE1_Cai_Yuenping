public class CardNode {
    private Card card;
    private CardNode nextCard;

    public CardNode(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public CardNode getNextCard() {
        return nextCard;
    }

    public void setNextCard(CardNode nextCard) {
        this.nextCard = nextCard;
    }

    @Override
    public String toString() {
        return "CardNode{" + card + '}';
    }
}
