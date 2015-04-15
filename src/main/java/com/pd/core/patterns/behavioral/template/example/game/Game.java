package com.pd.core.patterns.behavioral.template.example.game;

public abstract class Game {
    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    // template method
    public final void play() {

	// initialize the game
	initialize();

	// start game
	startPlay();

	// end game
	endPlay();
    }
}