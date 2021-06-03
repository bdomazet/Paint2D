package app.paint.layout;

import app.paint.event.ExitListener;
import app.paint.event.OpenListener;
import app.paint.event.SaveListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class PaintWindow extends JFrame {

    private static PaintWindow INSTANCE = null;

    private final JRadioButton circleRadioButton = new JRadioButton("Krug");
    private final JRadioButton squareRadioButton = new JRadioButton("Kvadrat");

    private final JRadioButton blueRadioButton = new JRadioButton("Plava");
    private final JRadioButton redRadioButton = new JRadioButton("Crvena");


    private PaintWindow() {
        setTitle("Paint 2D");
        setSize(500, 300);

        add(getPaintSettingPanel(), BorderLayout.NORTH);
        add(new PaintPanel(), BorderLayout.CENTER);

        /**
         * Dodajemo menije
         */
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Fajl");
        fileMenu.setMnemonic('F');
        //Save
        JMenuItem saveMenuItem = new JMenuItem("Snimi");
        saveMenuItem.setMnemonic('S');
        saveMenuItem.addActionListener(new SaveListener());
        fileMenu.add(createMenuItem("Snimi", 'S', new SaveListener()));
        fileMenu.add(createMenuItem("Otvori",'O', new OpenListener()));
        fileMenu.add(createMenuItem("Izlaz", 'I', new ExitListener()));
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

    }

    private JMenuItem createMenuItem(String label, int mnemonic, ActionListener listener){
        JMenuItem menuItem = new JMenuItem(label);
        menuItem.setMnemonic(mnemonic);
        menuItem.addActionListener(listener);
        return menuItem;
    }

    private JPanel getPaintSettingPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JPanel shapePanel = new JPanel();
        shapePanel.add(circleRadioButton);
        circleRadioButton.setSelected(true);
        shapePanel.add(squareRadioButton);
        TitledBorder shapeTitledBorder = new TitledBorder("Oblik");
        shapePanel.setBorder(shapeTitledBorder);
        ButtonGroup shapeButtonGroup = new ButtonGroup();
        shapeButtonGroup.add(circleRadioButton);
        shapeButtonGroup.add(squareRadioButton);

        JPanel colorPanel = new JPanel();
        colorPanel.add(blueRadioButton);
        blueRadioButton.setSelected(true);
        colorPanel.add(redRadioButton);
        TitledBorder colorTitledBorder = new TitledBorder("Boja");
        colorPanel.setBorder(colorTitledBorder);
        ButtonGroup colorButtonGroup = new ButtonGroup();
        colorButtonGroup.add(blueRadioButton);
        colorButtonGroup.add(redRadioButton);

        panel.add(shapePanel);
        panel.add(colorPanel);
        return panel;

    }

    public Color getSelectedColor() {
        return redRadioButton.isSelected() ? Color.RED : Color.BLUE;
    }

    public boolean isCircleSelected() {
        return circleRadioButton.isSelected();
    }

    public static PaintWindow getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PaintWindow();
        }
        return INSTANCE;
    }
}
