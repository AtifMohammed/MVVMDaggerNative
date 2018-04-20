#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_zemosolabs_mindhive_daggermvvm_view_1models_SplashViewModel_getStringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
