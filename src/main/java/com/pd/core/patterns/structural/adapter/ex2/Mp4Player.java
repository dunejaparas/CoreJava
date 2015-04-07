package com.pd.core.patterns.structural.adapter.ex2;

public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(final String fileName) {
	// do nothing
    }

    @Override
    public void playMp4(final String fileName) {
	System.out.println("Playing mp4 file. Name: " + fileName);
    }

}
