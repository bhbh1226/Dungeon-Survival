package Thing;

public class AnimatedSprite extends Sprite {
    private SpriteSheet spriteSheet;
    private int frameCounter; // 프레임 카운터
    private int frameInterval; // 프레임 카운터 증가폭
    private int frameDelay; // 프레임 딜레이
    private int currentFrame; // 현재 프레임
    private int animationDirection; // 애니메이션 방향
    private int totalFrameCount; // 전체 프레임 수
    private boolean stopped; // 애니메이션 정지 여부

    public AnimatedSprite(String fileName, int width, int height, int frameInterval, int frameDelay) {
        super(fileName);

        this.spriteSheet = new SpriteSheet(fileName, width, height);
        this.frameCounter = 0;
        this.frameInterval = frameInterval;
        this.frameDelay = frameDelay;
        this.currentFrame = 0;
        this.animationDirection = 1;
        this.totalFrameCount = spriteSheet.getTotalFrameCount();
        this.stopped = false;

        this.setImage(spriteSheet.getSprite(currentFrame, 0));
    }

    public void stop() {
        stopped = true;
    }

    public void play() {
        stopped = false;
    }

    public void update() {
        if (!stopped) {
            frameCounter += frameInterval;

            if (frameCounter >= frameDelay) {
                frameCounter = 0;
                currentFrame += animationDirection;

                if (currentFrame > totalFrameCount - 1) {
                    currentFrame = 0;
                } else if (currentFrame < 0) {
                    currentFrame = totalFrameCount - 1;
                }

                this.setImage(spriteSheet.getSprite(currentFrame, 0));
            }
        }
    }

    public void setFrameInterval(int interval) {
        frameInterval = interval;
    }

    public void setFrameDelay(int delay) {
        frameDelay = delay;
    }

    public boolean isStopped() {
        return stopped;
    }
}
