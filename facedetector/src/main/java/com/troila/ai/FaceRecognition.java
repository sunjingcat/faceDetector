package com.troila.ai;

public class FaceRecognition {
    static {

        //System.loadLibrary("FD");
        //System.loadLibrary("FA");
        //System.loadLibrary("FR");
        //System.loadLibrary("opencv_java3");//导入生成的链接库文件
        //System.loadLibrary("TestAnOpenCV");
        //System.loadLibrary("seeta_facedet_lib");
        //System.loadLibrary("seeta_fa_lib");
        //System.loadLibrary("viplnet");
        //System.load("/data/local/tmp/libviplnet.so.4.5");//红米需要这样调用
        System.loadLibrary("SeetaFaceDetector2");
        System.loadLibrary("SeetaFaceLandmarker2");
        System.loadLibrary("SeetaFaceRecognizer2");
        System.loadLibrary("seetanet2");
        System.loadLibrary("fr_android");
    }

//public native int testHello(float  a,float b,byte[] arg1,byte[]arg2);
    // public native int init();
    //public native int[][] gray(char[] modelpath, byte[] buf, int w, int h);

    public native int extractModel(char[] srcPath, char[] dstPath);

    public native int initModel(char[] sModelPath,int minFace, int distCacheSize, double distThreshold);
    //新接口，输出一个15维向量。1-4元素为人脸框位置（左上坐标和右下坐标），5-14为5个关键点坐标，15为姿态判断结果（1是符合，0是不符合）
    public native int[] detectFace(byte[] _pstImageData, int iWidth, int iHeight);

    //最后的int数组传入上面的关键点坐标
    public native float[] getFaceFeature(byte[] _pstImageData, int iWidth, int iHeight, int[] _pstFAResult);

    public native float faceMatch(float[] feats1, float[] feats2);

    //public native  int initModelServer(char[] sModelPath);
    // 获取 n 维 4列  n =0 无效图片
    //public native int TROILA_FD_Process(byte[] _pstImageData,int iWidth,int iHeight,int iFaceNum, int[][] astFacePos);
    //public native int[][] faceDetection(byte[] _pstImageData, int iWidth, int iHeight);  //行数即为人脸数，列数为4，分别存放x，y，width，height

    // 获取人脸的特征点
    //public native int TROILA_FA_Process(byte[] _pstImageData,int iWidth,int iHeight,int[] _pstFaceRect,int[][] _pstFAResult);
    //public native int[][] faceAlignment(byte[] _pstImageData, int iWidth, int iHeight, int[] _pstFaceRect);  //68个点坐标，68行2列的数组

    //public native int[][] seetafaceAlignment(char[] sModelPath, byte[] _pstImageData, int iWidth, int iHeight, int[] _pstFaceRect);
    //  2 的话 继续拍照， 0 的话 调后续方法， 1的失败continue
    //public native int TROILA_FLD_Process(int[][] _pstFAResult,int fldResult,float EAR);
    //public native float[] faceLivingDetection(int[][] _pstTemFAResult, int temWidth, int temHeight, int[][] _pstFAResult); //0 成功 2的话 继续送  1 失败
    // 提取特征
    //public native int TROILA_FR_Process(byte[] _pstImageData,int iWidth, int iHeight,int[][] _pstFAResult,float[] feats);
    //public native float[] getFaceFeature(char[] sModelPath, byte[] _pstImageData, int iWidth, int iHeight, int[][] _pstFAResult);

    //public native float[] seetagetFaceFeature(char[] sModelPath, byte[] _pstImageData, int iWidth, int iHeight, int[][] _pstFAResult);

    //public native float faceMatch(float[] feats1, float[] feats2);

    //public native float[] Estmatorheadpose(int[][] _pstFAResult);

    //public native float[] detectDark(byte[] _pstImageData, int iWidth, int iHeight,int[][] _pstFAResult);

    //public native byte[] bilateralFilter(byte[] _pstImageData, int iWidth, int iHeight, float sigma, float ksize);

    public native int release();

//    public static void main(String[] args) {
//        System.loadLibrary("troila_fi_so");
//        TROILA_FI troila_fi = new TROILA_FI();
//        //jniDemo.testHello();
//        //jniDemo.TROILA_FI_Init();
//        //jniDemo.TROILA_FD_Process(byte[] _pstImageData,int iWidth, int iHeight, TROILA_FD_RESULT_S _pstFDResult);
//    }
}


