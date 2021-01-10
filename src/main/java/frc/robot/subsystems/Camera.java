package frc.robot.subsystems;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.HttpCamera;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.VideoMode;

public class Camera {
    
    private CvSink cvSink;
    private MjpegServer cvMjpegServer;

    public Camera() {
        HttpCamera httpCamera = new HttpCamera("Camera", "http://10.99.99.176:8080");
        VideoMode videoMode = new VideoMode(VideoMode.PixelFormat.kGray, 1920, 1080, 25);
        httpCamera.setVideoMode(videoMode);
        cvSink = new CvSink("cvsource");
        cvSink.setSource(httpCamera);
        CvSource cvSource = new CvSource("cvsource", videoMode);
        cvMjpegServer = new MjpegServer("cvhttpserver", 8083);
        cvMjpegServer.setSource(cvSource);
    }

    public void close() {
        cvSink.close();
        cvMjpegServer.close();
    }
}
