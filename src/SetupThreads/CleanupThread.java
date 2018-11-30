package SetupThreads;

import Model.ImageGeneration.Caching.ImageCache;

class CleanupThread extends Thread {

    @Override
    public void run() {
        ImageCache cache = ImageCache.getInstance();
    }
}
