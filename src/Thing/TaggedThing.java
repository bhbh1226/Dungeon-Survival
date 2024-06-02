package Thing;

import javax.swing.JLabel;

import Manager.FontManager;

public class TaggedThing extends Thing {
    private String tag;

    public TaggedThing(Sprite sprite) {
        super(sprite);

        setTag(null);
    }

    public TaggedThing(Sprite sprite, String tag) {
        super(sprite);

        setVerticalTextPosition(JLabel.BOTTOM);
        setVerticalAlignment(JLabel.CENTER);
        setHorizontalTextPosition(JLabel.CENTER);
        setHorizontalAlignment(JLabel.CENTER);

        setCurrentSprite(sprite);
        setTag(tag);
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public int getStartY() {
        if (tag == null) {
            return super.getStartY();
        } else {
            return super.getStartY() - getFontMetrics(getFont()).getHeight();
        }
    }

    @Override
    public void setCurrentSprite(Sprite sprite) {
        super.setCurrentSprite(sprite);

        if (tag != null) {
            setForeground(getBackground());
            setFont(FontManager.getInstance().getThaleahFatFont(16f));
            setText(tag);
            setSize(Math.max(sprite.getWidth(), getFontMetrics(getFont()).stringWidth(tag)), sprite.getHeight() + getFontMetrics(getFont()).getHeight());
        }
    }
}