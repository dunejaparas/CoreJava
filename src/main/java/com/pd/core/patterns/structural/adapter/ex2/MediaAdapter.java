package com.pd.core.patterns.structural.adapter.ex2;

public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(final String audioType) {

	if (audioType.equalsIgnoreCase("vlc")) {
	    advancedMusicPlayer = new VlcPlayer();

	} else if (audioType.equalsIgnoreCase("mp4")) {
	    advancedMusicPlayer = new Mp4Player();
	}
    }

    @Override
    public void play(final String audioType, final String fileName) {

	if (audioType.equalsIgnoreCase("vlc")) {
	    advancedMusicPlayer.playVlc(fileName);
	} else if (audioType.equalsIgnoreCase("mp4")) {
	    advancedMusicPlayer.playMp4(fileName);
	}
    }

}
