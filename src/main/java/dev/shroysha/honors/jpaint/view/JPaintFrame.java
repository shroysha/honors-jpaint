package dev.shroysha.honors.jpaint.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class JPaintFrame extends JFrame {

    private JPaintImagePanel imagePanel = new JPaintImagePanel();
    private JPaintToolPanel toolPanel = new JPaintToolPanel();


    public JPaintFrame() {
        super("JPaint");
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(dim.width, dim.height - 50);

        this.setJMenuBar(new MyMenuBar());

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        this.getContentPane().add(toolPanel, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        this.getContentPane().add(imagePanel, gbc);
    }

    private class MyMenuBar extends JMenuBar {
        final JFileChooser fileChooser;
        final JMenu fileMenu;
        final JMenuItem newPaint;
        final JMenuItem openPaint;
        final JMenuItem savePaint;
        final JMenuItem printPaint;
        final JMenuItem closeWindow;

        public MyMenuBar() {
            fileChooser = new JFileChooser("Choose Image");
            fileMenu = new JMenu("File");
            fileMenu.setMnemonic(KeyEvent.VK_F);
            newPaint = new JMenuItem("New", KeyEvent.VK_N);
            openPaint = new JMenuItem("Open", KeyEvent.VK_O);
            savePaint = new JMenuItem("Save", KeyEvent.VK_S);
            printPaint = new JMenuItem("Print", KeyEvent.VK_P);
            closeWindow = new JMenuItem("Close", KeyEvent.VK_X);

            newPaint.addActionListener(e -> {

            });
            openPaint.addActionListener(e -> {
                int returnVal = fileChooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION)
                    imagePanel.setImage();
            });
            savePaint.addActionListener(e -> {
                int returnVal = fileChooser.showSaveDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION)
                    returnVal = 0;
                //fileChooser.
            });
            printPaint.addActionListener(e -> {

            });

            fileMenu.add(newPaint);
            fileMenu.add(openPaint);
            fileMenu.add(savePaint);
            fileMenu.add(printPaint);
            fileMenu.add(closeWindow);
            this.add(fileMenu);
        }

    }

}
