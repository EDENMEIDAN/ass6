package gameScreens;

import biuoop.DrawSurface;

public interface doOneFrame {
    void doOneFrame(DrawSurface d);

    boolean shouldStop();

}