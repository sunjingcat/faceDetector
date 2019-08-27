package com.troila.ai;

public class FaceRecognition {
    static {
        System.loadLibrary("SeetaFaceDetector2");
        System.loadLibrary("SeetaFaceLandmarker2");
        System.loadLibrary("SeetaFaceRecognizer2");
        System.loadLibrary("seetanet2");

        System.loadLibrary("fr_android");
    }
	
    public native int initModel(char[] sModelPath,int minFace, int distCacheSize, double distThreshold);
    //新接口，输出一个15维向量。1-4元素为人脸框位置（左上坐标和右下坐标），5-14为5个关键点坐标，15为姿态判断结果（1是符合，0是不符合）
    public native int[] detectFace(byte[] _pstImageData, int iWidth, int iHeight);

    //最后的int数组传入上面的关键点坐标
    public native float[] getFaceFeature(byte[] _pstImageData, int iWidth, int iHeight, int[] _pstFAResult);

    public native float faceMatch(float[] feats1, float[] feats2);

    public native int release();

}


