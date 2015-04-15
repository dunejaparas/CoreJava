package com.pd.core.patterns.behavioral.template.example.game;

public class TemplatePatternDemo {
    public static void main(final String[] args) {

	Game game = new Cricket();
	game.play();
	System.out.println();
	game = new Football();
	game.play();
    }
}
