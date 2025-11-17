#include <jni.h>
#include <android/log.h>
#include <vector>
#include <cstring>
using namespace std;

#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, "EdgeDetect", __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, "EdgeDetect", __VA_ARGS__)

// #include <opencv2/imgproc.hpp>
// #include <opencv2/core.hpp>

extern "C" {

JNIEXPORT void JNICALL
Java_com_example_edgedetect_MainActivity_nativeInit(JNIEnv *env, jobject thiz, jint width, jint height) {
    LOGI("nativeInit: %d x %d", width, height);
}

JNIEXPORT void JNICALL
Java_com_example_edgedetect_MainActivity_nativeProcessFrame(JNIEnv *env, jobject thiz, jbyteArray input, jint len, jint width, jint height) {
    jsize l = env->GetArrayLength(input);
    LOGI("nativeProcessFrame length=%d expected=%d", l, len);
    jbyte *bytes = env->GetByteArrayElements(input, 0);
    // Process with OpenCV here (YUV->Mat -> Canny)
    env->ReleaseByteArrayElements(input, bytes, 0);
}

JNIEXPORT void JNICALL
Java_com_example_edgedetect_MainActivity_nativeToggleMode(JNIEnv *env, jobject thiz, jint mode) {
    LOGI("nativeToggleMode: %d", mode);
}

}
