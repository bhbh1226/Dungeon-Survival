package Manager;

import java.util.concurrent.CopyOnWriteArrayList;

import Thing.AnimatedSprite;
import Thing.Thing;

public class AnimationManager {
    private static AnimationManager instance = null;
    private static final int DEFAULT_FPS = 60;
    
    private CopyOnWriteArrayList<Thing> things = new CopyOnWriteArrayList<Thing>();
    private boolean isRunning = false;
    private Thread animationThread = null;

    private AnimationManager() {
        if (animationThread == null) {
            animationThread = new Thread(() -> {
                while (isRunning) {
                    try {
                        Thread.sleep(1000 / DEFAULT_FPS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // doneList에는 update()가 호출된 AnimatedSprite 객체들이 저장된다. 중복 호출을 방지하기 위해 사용한다.
                    CopyOnWriteArrayList<AnimatedSprite> doneList = new CopyOnWriteArrayList<AnimatedSprite>();

                    for (Thing thing : things) {
                        AnimatedSprite animatedSprite = ((AnimatedSprite) thing.getCurrentSprite());
                        
                        // animatedSprite가 doneList에 없으면 update()를 호출하고 doneList에 추가한다.
                        if (!doneList.contains(animatedSprite)) {
                            animatedSprite.update();
                            doneList.add(animatedSprite);
                        } 
                        thing.repaint();
                    }
                }
            });
        
            start();
            animationThread.start();
        }
    }

    public static AnimationManager getInstance() {
        if (instance == null) {
            instance = new AnimationManager();
        }

        return instance;
    }

    public void addThing(Thing thing) {
        if (!things.contains(thing)) {
            things.add(thing);
        }
    }

    public void removeThing(Thing thing) {
        if (!things.contains(thing)) {
            things.remove(thing);
        }
    }

    public void start() {
        isRunning = true;
    }

    public void stop() {
        isRunning = false;
    }
}
