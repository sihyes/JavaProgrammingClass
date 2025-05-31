package view;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import javax.swing.JTextArea;

public class TextAreaOutputStream extends OutputStream {
    private JTextArea textArea;

    public TextAreaOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) {
        textArea.append(String.valueOf((char) b));
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
    
    @Override
    public void write(byte[] b, int off, int len) {
        String text = new String(b, off, len, StandardCharsets.UTF_8);
        textArea.append(text);
     // 자동 스크롤
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

}

