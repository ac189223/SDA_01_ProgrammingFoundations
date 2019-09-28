package PF03.BlueJ._13_MusicPlayer;

import javazoom.jl.decoder.JavaLayerException;

public class MusicPlayer
{
    private MusicFilePlayer player;
    private String filename;

    public MusicPlayer() {
        player = null;
        filename = "";
    }

    public void startPlaying(final String filename) {
        try {
            setupPlayer(filename);
            playFrom(0);
        } catch (JavaLayerException ex) {
            reportProblem();
        }
    }

    public void stop() { killPlayer(); }

    public void pause() {
        if (player != null)
            try {
                player.pause();
            } catch (JavaLayerException e) {
                reportProblem();
                killPlayer();
            }
    }

    public void resume() {
        if (player != null) {
            Thread playerThread = new Thread() {
                public void run()
                {
                    try {
                        player.resume();
                    } catch (JavaLayerException e) {
                        reportProblem();
                        killPlayer();
                    }
                }
            };
            playerThread.setPriority(Thread.MIN_PRIORITY);
            playerThread.start();
        }
    }

    public void seekTo(int position) { if (player != null && position >= 0 && position < player.getLength()) { } }

    public int getLength() {
        if (player != null)
            return player.getLength();
        else
            return 0;
    }

    private void setupPlayer(String filename) {
        try {
            if (player != null)
                killPlayer();
            this.filename = filename;
            player = new MusicFilePlayer(filename);
        } catch(JavaLayerException e) {
            System.out.println("Problem setting up player");
            e.printStackTrace();
            reportProblem();
            killPlayer();
        }
    }

    private void playFrom(final int start) throws JavaLayerException {
        Thread playerThread = new Thread() {
            public void run() {
                try {
                    player.playFrom(start);
                }
                catch (JavaLayerException e) {
                    reportProblem();
                    killPlayer();
                }
            }
        };
        playerThread.setPriority(Thread.MIN_PRIORITY);
        playerThread.start();
    }

    private void killPlayer() {
        synchronized(this) {
            if (player != null) {
                player.stop();
                player = null;
                filename = "";
            }
        }
    }

    private void reportProblem() { System.out.println("There was a problem playing: " + filename); }
}
