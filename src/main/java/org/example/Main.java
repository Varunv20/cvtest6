package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.highgui.HighGui;

public class Main {

    public static void main(String[] args) {
        // Load OpenCV native library

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        opencvpipelines opencvpipeline = new opencvpipelines();
        VideoCapture capture = new VideoCapture(0);

        // Check if camera is opened successfully
        if (!capture.isOpened()) {
            System.out.println("Could not open video stream");
            return;
        }

        // Read frames from the video stream and convert them to Mat objects
        Mat frame = new Mat();
        while (capture.read(frame)) {
            frame = opencvpipeline.processFrame(frame);
            HighGui.imshow("Video Stream", frame);
            HighGui.waitKey(33);
        }

        // Release the VideoCapture object and close the window
        capture.release();
        HighGui.destroyAllWindows();
    }

}