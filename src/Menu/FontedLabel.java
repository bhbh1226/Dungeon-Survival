package Menu;

import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.JLabel;

public class FontedLabel extends JLabel {
    public FontedLabel(String text, Font font) {
        this.setText(text);
        this.setFont(font);
    }

    public void setText(String text) {
        super.setText(text);
        this.resizeLabelToFitText();
    }

    public void setFont(Font font) {
        super.setFont(font);
        this.resizeLabelToFitText();
    }

    private void resizeLabelToFitText()
    {
        if (this.getText().isEmpty() || this.getFont() == null) {
            return;
        }

        FontMetrics metrics = this.getFontMetrics(this.getFont());
        int textWidth = metrics.stringWidth(this.getText());
        int textHeight = metrics.getHeight();
        this.setSize(textWidth, textHeight);
    }
}
