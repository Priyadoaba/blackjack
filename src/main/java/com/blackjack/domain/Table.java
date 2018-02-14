package com.blackjack.domain;

import com.blackjack.util.ResultFormat;

import java.util.Optional;

import static java.util.Optional.of;

public class Table {

    private static final int INITIAL_CARD_ITERATION_COUNT = 2;

    private static final int MINIMUM_PLAYERS_TOTAL_VALUE_TO_STOP_PICKING_CARDS = 17;

    private final Deck deck;
    private final Dealer dealer;
    private final Player player;

    /**
     * Initialize table
     *
     * @param deck   deck of cards required to initialize the table
     * @param player player required to initialize the table
     * @throws IllegalArgumentException if no deck or no player is provided
     */
    private Table(Deck deck, Player player) {
        if (deck == null) {
            throw new IllegalArgumentException("Table must be initialized with deck, please provide one");
        }

        if (player == null) {
            throw new IllegalArgumentException("Table must be initialized with player, please provide one");
        }

        this.deck = deck;
        this.dealer = new Dealer();
        this.player = player;
    }


    /**
     * Initialize table
     *
     * @param deck   deck of cards required to initialize the table
     * @param player player required to initialize the table
     * @return table with deck of cards, player and dealer
     * @throws IllegalArgumentException if no deck or no player is provided
     */
    public static Table initializeTable(Deck deck, Player player) {
        return new Table(deck, player);
    }

    /**
     * Method to start playing the game
     *
     * @return winner of the game
     */
    public Participant play() {
        distributeCards();

        return checkWinnerAfterCardsDistribution()
                .orElseGet(this::playFurther);
    }

    private Participant playFurther() {
        drawIfApplicable(MINIMUM_PLAYERS_TOTAL_VALUE_TO_STOP_PICKING_CARDS, player);

        return checkWinnerAfterPlayerFinishedPickingCards()
                .orElseGet(this::winnerAfterDealerFinishedPickingCards);
    }

    private Participant winnerAfterDealerFinishedPickingCards() {
        drawIfApplicable(player.getTotalValue() + 1, dealer);

        if (dealer.getTotalValue() < 22 && dealer.getTotalValue() > player.getTotalValue()) {
            return dealer;
        } else {
            return player;
        }
    }

    /**
     * validate the game conditions after Player's cards withdrawal
     *
     * @return Optional<Participant> if there is a winner after player finished picking cards
     */
    private Optional<Participant> checkWinnerAfterPlayerFinishedPickingCards() {
        if (player.getTotalValue() == 21) {
            return Optional.of(player);
        } else if (player.getTotalValue() > 21) {
            return Optional.of(dealer);
        }
        return Optional.empty();
    }

    /**
     * validate the game conditions after initial iteration
     *
     * @return Optional<Participant>
     */
    private Optional<Participant> checkWinnerAfterCardsDistribution() {
        if (player.getTotalValue() == 21) {
            return of(player);
        } else if (dealer.getTotalValue() == 21) {
            return of(dealer);
        } else if (player.getTotalValue() == 22) {
            return of(dealer);
        } else if (dealer.getTotalValue() == 22) {
            return of(player);
        }
        return Optional.empty();
    }

    private void distributeCards() {
        for (int i = 0; i < INITIAL_CARD_ITERATION_COUNT; i++) {
            player.pickCard(this.deck.drawCard());
            dealer.pickCard(this.deck.drawCard());
        }
    }

    /**
     * Participant draws the card if his card's total scores has not yet reached to the Minimum limit.
     *
     * @param minimumTotal lower limit of participant's total score which should be validated to draw card
     * @param participant  Participant to draw the card
     */
    private void drawIfApplicable(int minimumTotal, Participant participant) {
        while (participant.getTotalValue() < minimumTotal) {
            participant.pickCard(this.deck.drawCard());
        }
    }

    /**
     * Display all cards of Player and Dealer
     *
     * @return String
     */
    public String displayParticipantsCards() {
        return ResultFormat.printResult(player) + "\n" + ResultFormat.printResult(dealer);
    }
}


