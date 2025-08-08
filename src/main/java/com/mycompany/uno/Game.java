package com.mycompany.uno;

import java.util.*;

public class Game {
    private final Deck deck = new Deck();
    private final List<Player> players = new ArrayList<>();
    private Card topCard;
    private int currentPlayer = 0;
    private int direction = 1;
    private final Scanner scanner = new Scanner(System.in);

    public Game() {
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.drawCard(deck);
            }
        }
        topCard = deck.drawCard();
        while (topCard.getColor() == CardColor.WILD) {
            deck.shuffle();
            topCard = deck.drawCard();
        }
    }

    public void start() {
        System.out.println("UNO Game Started!");
        while (true) {
            Player player = players.get(currentPlayer);
            System.out.println("\nTop card: " + topCard);
            player.showHand();

            boolean played = false;
            for (int i = 0; i < player.getHand().size(); i++) {
                if (player.getHand().get(i).canBePlayedOn(topCard)) {
                    System.out.println(player.getName() + ", play card " + i + "? (yes/no)");
                    String input = scanner.nextLine().trim().toLowerCase();
                    if (input.equals("yes")) {
                        Card chosen = player.playCard(i);
                        topCard = chosen;
                        System.out.println(player.getName() + " played: " + chosen);
                        played = true;
                        break;
                    }
                }
            }

            if (!played) {
                System.out.println(player.getName() + " has no playable cards. Drawing...");
                player.drawCard(deck);
            }

            if (player.hasWon()) {
                System.out.println("\n" + player.getName() + " WINS!");
                break;
            }

            currentPlayer = (currentPlayer + direction + players.size()) % players.size();
        }
    }
}
