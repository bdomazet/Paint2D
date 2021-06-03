package app;

import app.paint.layout.PaintWindow;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        PaintWindow window = PaintWindow.getInstance();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
