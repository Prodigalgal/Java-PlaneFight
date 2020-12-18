package listener;

import config.Constant;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlListener implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        //¼àÌýÒÆ¶¯
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> Constant.UP = true;
            case KeyEvent.VK_DOWN -> Constant.DOWN = true;
            case KeyEvent.VK_LEFT -> Constant.LEFT = true;
            case KeyEvent.VK_RIGHT -> Constant.RIGHT = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //¼àÌýÒÆ¶¯
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> Constant.UP = false;
            case KeyEvent.VK_DOWN -> Constant.DOWN = false;
            case KeyEvent.VK_LEFT -> Constant.LEFT = false;
            case KeyEvent.VK_RIGHT -> Constant.RIGHT = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
