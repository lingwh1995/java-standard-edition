package structure.bridge.bridge_h;

public class Client {
    public static void main(String[] args) {
        // 使用Mac播放AVI
        VideoFomat aviFormat = new AVIFormat();
        SystemPlatform macPlatform = new MacPlatform();
        macPlatform.setVideoFomat( aviFormat );
        macPlatform.playVedio();

        // 使用windos 播放MPEG
        VideoFomat mpegFormat = new MPEGFormat();
        SystemPlatform windowsPlatform = new WindowsPlatform();
        windowsPlatform.setVideoFomat( mpegFormat );
        windowsPlatform.playVedio();
    }
}
