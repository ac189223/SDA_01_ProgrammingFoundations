package PF03.BlueJ._13_MusicPlayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.BitstreamException;
import javazoom.jl.decoder.Decoder;
import javazoom.jl.decoder.Header;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.decoder.SampleBuffer;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.FactoryRegistry;

public class MusicFilePlayer
{
    private Bitstream bitstream;
    private Decoder decoder;
    private AudioDevice audio;
    private boolean playing = false;
    private String filename;
    private int frameCount;
    private int frameNumber;
    private int resumePosition;

    public MusicFilePlayer(String filename) throws JavaLayerException
    {
        this.filename = filename;
        openAudio();
        frameCount = getFrameCount(filename);
        openBitstream(filename);
        frameNumber = 0;
        resumePosition = -1;
    }

    public void play() throws JavaLayerException { playFrames(0, frameCount); }

    public boolean play(int frames) throws JavaLayerException { return playFrames(frameNumber, frameNumber + frames); }

    public boolean play(int start, int end) throws JavaLayerException { return playFrames(start, start + end); }

    public boolean playFrom(int start) throws JavaLayerException { return playFrames(start, frameCount); }

    public int getLength() { return frameCount; }

    public int getPosition() { return frameNumber; }

    public void setPosition(int position) throws JavaLayerException {
        pause();
        resumePosition = position;
    }

    public void pause() throws JavaLayerException {
        synchronized(this) {
            playing = false;
            resumePosition = frameNumber;
        }
    }

    public void resume() throws JavaLayerException {
        if (!playing) {
            int start;
            if (resumePosition >= 0)
                start = resumePosition;
            else
                start = frameNumber;
            resumePosition = -1;
            playFrames(start, frameCount);
        }
    }

    public int getFrameNumber() { return frameNumber; }

    private boolean playFrames(int start, int end) throws JavaLayerException {
        resumePosition = -1;
        if (end > frameCount)
            end = frameCount;
        synchronized(this) {
            moveTo(start);
            playing = true;
        }
        boolean ok = true;
        while (frameNumber < end && playing && ok) {
            ok = decodeFrame();
            if(ok)
                frameNumber++;
        }
        synchronized(this) {
            playing = false;
            AudioDevice out = audio;
            if (out != null)
                out.flush();
        }
        return ok;
    }

    private void moveTo(int position) throws JavaLayerException {
        if (position < frameNumber) {
            synchronized(this) {
                if (bitstream != null)
                    try { bitstream.close(); } catch (BitstreamException ex) { }
                if (audio != null)
                    audio.close();
                openAudio();
                openBitstream(filename);
                frameNumber = 0;
            }
        }
        while(frameNumber < position) {
            skipFrame();
            frameNumber++;
        }
    }

    public void close() {
        synchronized(this) {
            if (audio != null) {
                AudioDevice out = audio;
                audio = null;
                out.close();
                try { bitstream.close(); } catch (BitstreamException ex) { }
                bitstream = null;
                decoder = null;
            }
        }
    }

    protected boolean decodeFrame() throws JavaLayerException {
        try
        {
            synchronized (this) {
                if (audio == null)
                    return false;
                Header h = readFrame();
                if (h == null)
                    return false;
                SampleBuffer output = (SampleBuffer) decoder.decodeFrame(h, bitstream);
                if (audio != null)
                    audio.write(output.getBuffer(), 0, output.getBufferLength());
            }
            bitstream.closeFrame();
        }
        catch (RuntimeException ex) {
            ex.printStackTrace();
            throw new JavaLayerException("Exception decoding audio frame", ex);
        }
        return true;
    }

    protected boolean skipFrame() throws JavaLayerException {
        Header h = readFrame();
        if (h == null)
            return false;
        frameNumber++;
        bitstream.closeFrame();
        return true;
    }

    public void stop() { close(); }

    protected int getFrameCount(String filename) throws JavaLayerException {
        openBitstream(filename);
        int count = 0;
        while (skipFrame())
            count++;
        bitstream.close();
        return count;
    }

    protected Header readFrame() throws JavaLayerException {
        if (audio != null)
            return bitstream.readFrame();
        else
            return null;
    }

    protected void openAudio() throws JavaLayerException {
        audio = FactoryRegistry.systemRegistry().createAudioDevice();
        decoder = new Decoder();
        audio.open(decoder);
    }

    protected void openBitstream(String filename) throws JavaLayerException {
        try {
            bitstream = new Bitstream(new BufferedInputStream(new FileInputStream(filename)));
        }
        catch(java.io.IOException ex) {
            throw new JavaLayerException(ex.getMessage(), ex);
        }
    }
}



