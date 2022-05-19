import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class NotepadWindow extends JFrame implements ActionListener {
    Font font;
    Notepad notepad;
    JTextPane textPane;
    JMenuBar menuBar;

    JMenu mFile, openStyle, fileMenu, newMenu, Batcolor, font_Size;
    JMenuItem miNew, miOpen, miSave;
    JMenuItem fontTimes, fontArial, fontVerdana; // Fonts
    JMenuItem textRegular, textItalic, textBold, textBoldItalic;  // Style fonts
    JMenuItem black_btn, red_btn, green_btn, blue_btn; // color
    JMenuItem S_12, S_14, S_16, S_25, S_50; // size

    SimpleAttributeSet attributeSet = new SimpleAttributeSet();

    public NotepadWindow(String title, int width, int height) {
        notepad = new Notepad();

        setTitle(title);
        setSize(width, height);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        textPane = new JTextPane();

        mFile = new JMenu("Файл");
        miNew = new JMenuItem("Новый");
        miOpen = new JMenuItem("Открыть");
        miSave = new JMenuItem("Сахранить");

        miNew.addActionListener(this);
        miOpen.addActionListener(this);
        miSave.addActionListener(this);

        mFile.add(miNew);
        mFile.add(miSave);
        mFile.add(miOpen);

        menuBar.add(mFile);

        setJMenuBar(menuBar);
        add(textPane, BorderLayout.CENTER);
        setVisible(true);

        fileMenu = new JMenu("Меню");
        newMenu = new JMenu("Шрифт");
        Batcolor = new JMenu("Цвет");
        font_Size = new JMenu("Размер");

        fontTimes = new JMenuItem("Times New Roman");
        fontArial = new JMenuItem("Arial");
        fontVerdana = new JMenuItem("Verdana");

        openStyle = new JMenu("Стиль");
        textRegular = new JMenuItem("Простой");
        textItalic = new JMenuItem("Курсив");
        textBold = new JMenuItem("Жирный");
        textBoldItalic = new JMenuItem("Жирный курсив");

        black_btn = new JMenuItem("Чёрный");
        red_btn = new JMenuItem("Красный");
        green_btn = new JMenuItem("Зелёный");
        blue_btn = new JMenuItem("Синий");

        S_12 = new JMenuItem("12");
        S_14 = new JMenuItem("14");
        S_16 = new JMenuItem("16");
        S_25 = new JMenuItem("25");
        S_50 = new JMenuItem("50");
        

        // font
        menuBar.add(fileMenu);
        newMenu.addActionListener(this);
        fontTimes.addActionListener(this);
        fontArial.addActionListener(this);
        fontVerdana.addActionListener(this);
        StyleConstants.setFontFamily(attributeSet, "Times New Roman");
        StyleConstants.setFontSize(attributeSet, 25);
        textPane.setCharacterAttributes(attributeSet, true);
        
        // Style
        openStyle.addActionListener(this);
        textRegular.addActionListener(this);
        textItalic.addActionListener(this);
        textBold.addActionListener(this);
        textBoldItalic.addActionListener(this);
        // Button color
        Batcolor.addActionListener(this);
        black_btn.addActionListener(this);
        red_btn.addActionListener(this);
        green_btn.addActionListener(this);
        blue_btn.addActionListener(this);
        // Size
        S_12.addActionListener(this);
        S_14.addActionListener(this);
        S_16.addActionListener(this);
        S_25.addActionListener(this);
        S_50.addActionListener(this);

        // font
        openStyle.add(textRegular);
        menuBar.add(fileMenu);
        fileMenu.add(newMenu);
        newMenu.add(fontTimes);
        newMenu.add(fontArial);
        newMenu.add(fontVerdana);
        fileMenu.add(openStyle);
        // Style
        openStyle.add(textRegular);
        openStyle.add(textItalic);
        openStyle.add(textBold);
        openStyle.add(textBoldItalic);
        // Color
        Batcolor.add(black_btn);
        Batcolor.add(red_btn);
        Batcolor.add(green_btn);
        Batcolor.add(blue_btn);
        fileMenu.add(Batcolor);
        // Size
        font_Size.add(S_12);
        font_Size.add(S_14);
        font_Size.add(S_16);
        font_Size.add(S_25);
        font_Size.add(S_50);
        fileMenu.add(font_Size);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(miNew))
            notepad.newFile();

        if (e.getSource().equals(miOpen))
            textPane.setText(notepad.openFile().toString());

        if (e.getSource().equals(miSave))
            notepad.saveFile(textPane.getText().getBytes());

        if (e.getSource().equals(black_btn) || e.getSource().equals(red_btn) || e.getSource().equals(green_btn)
                || e.getSource().equals(blue_btn)) {
            changeFontColor(e);
        } else if (e.getSource().equals(textRegular) || e.getSource().equals(textItalic)
                || e.getSource().equals(textBold) || e.getSource().equals(textBoldItalic)) {
            changeFontStyle(e);
        } else if (e.getSource().equals(fontTimes) || e.getSource().equals(fontArial)
                || e.getSource().equals(fontVerdana)) {
            changeFontFamily(e);
        } else if (e.getSource().equals(S_12) || e.getSource().equals(S_14) || e.getSource().equals(S_16)
                || e.getSource().equals(S_25) || e.getSource().equals(S_50)) {
            changeFontSize(e);
        }
        textPane.setCharacterAttributes(attributeSet, true);
    }

    public void changeFontSize(ActionEvent e) {
        if (e.getSource().equals(S_12)) {
            StyleConstants.setFontSize(attributeSet, 12);
        } else if (e.getSource().equals(S_14)) {
            StyleConstants.setFontSize(attributeSet, 14);
        } else if (e.getSource().equals(S_16)) {
            StyleConstants.setFontSize(attributeSet, 16);
        } else if (e.getSource().equals(S_25)) {
            StyleConstants.setFontSize(attributeSet, 25);
        } else if (e.getSource().equals(S_50)) {
            StyleConstants.setFontSize(attributeSet, 50);
        }
    }

    public void changeFontColor(ActionEvent e) {
        if (e.getSource().equals(black_btn)) {
            StyleConstants.setForeground(attributeSet, Color.black);
        } else if (e.getSource().equals(red_btn)) {
            StyleConstants.setForeground(attributeSet, Color.red);
        } else if (e.getSource().equals(green_btn)) {
            StyleConstants.setForeground(attributeSet, Color.green);
        } else if (e.getSource().equals(blue_btn)) {
            StyleConstants.setForeground(attributeSet, Color.blue);
        }
    }

    public void changeFontStyle(ActionEvent e) {
        if (e.getSource().equals(textRegular)) {
            StyleConstants.setBold(attributeSet, false);
            StyleConstants.setItalic(attributeSet, false);
        } else if (e.getSource().equals(textItalic)) {
            StyleConstants.setItalic(attributeSet, true);
        } else if (e.getSource().equals(textBold)) {
            StyleConstants.setBold(attributeSet, true);
        } else if (e.getSource().equals(textBoldItalic)) {
            StyleConstants.setItalic(attributeSet, true);
            StyleConstants.setBold(attributeSet, true);
        }
    }

    public void changeFontFamily(ActionEvent e) {
        if (e.getSource().equals(fontTimes)) {
            StyleConstants.setFontFamily(attributeSet, "Times New Roman");
        } else if (e.getSource().equals(fontArial)) {
            StyleConstants.setFontFamily(attributeSet, "Arial");
        } else if (e.getSource().equals(fontVerdana)) {
            StyleConstants.setFontFamily(attributeSet, "Verdana");
        }
    }
}