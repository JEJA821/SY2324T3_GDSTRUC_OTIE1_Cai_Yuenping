public class CardStack {
    private CardNode top;

    public void push(Card card) {
        CardNode cardNode = new CardNode(card);
        cardNode.setNextCard(top);
        top = cardNode;
    }

    public Card pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        CardNode temp = top;
        top = top.getNextCard();
        temp.setNextCard(null);
        return temp.getCard();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        int count = 0;
        CardNode current = top;
        while (current != null) {
            count++;
            current = current.getNextCard();
        }
        return count;
    }

    public Card peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.getCard();
    }

    public void printStack() {
        CardNode current = top;
        System.out.print("top -> ");
        while (current != null) {
            System.out.print(current + " -> ");
            current = current.getNextCard();
        }
        System.out.println("null");
    }
}
