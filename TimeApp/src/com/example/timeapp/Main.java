package com.example.timeapp;

import com.example.timeapp.spi.TimeProvider;
import java.awt.BorderLayout;
import java.awt.Image;
import java.util.ServiceLoader;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public final class Main extends JFrame {

    public static void main(String[] args) {
        final Main frame = new Main();
        ServiceLoader<TimeProvider> serviceLoader = ServiceLoader.load(TimeProvider.class);
        serviceLoader.forEach(t -> {
            final JButton button = new JButton();
            button.setText(t.getClass().getSimpleName());
            final Image icon = t.icon();
            if (icon != null) {
                button.setIcon(new ImageIcon(icon));
            }
            button.addActionListener(e -> {
                frame.outputLabel.setText(String.format("Current time: %s%n", t.now()));
            });
            frame.modulesPanel.add(button);
        });
        frame.pack();
        frame.setVisible(true);
    }

    private final JPanel modulesPanel;
    private final JLabel outputLabel;

    public Main() {
        super("Jigsaw Example");

        modulesPanel = new JPanel();
        modulesPanel.setLayout(new BoxLayout(modulesPanel, BoxLayout.LINE_AXIS));
        add(modulesPanel, BorderLayout.NORTH);

        outputLabel = new JLabel("output");
        outputLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(outputLabel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
