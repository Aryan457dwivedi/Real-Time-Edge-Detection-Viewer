📱 Real-Time Edge Detection Viewer
Android (Java) + OpenCV (C++) + OpenGL ES + Web Viewer (TypeScript)

This project implements a real-time image processing pipeline using the phone camera, native OpenCV (C++), and OpenGL ES rendering.
It also includes a minimal TypeScript-based web viewer to demonstrate bridging native processing results to the web.

This project was built as part of the Software Engineering Intern (R&D) Assignment.

🚀 Features Implemented
✅ Android Application

Camera feed capture using TextureView / SurfaceTexture

JNI bridge for sending frames to native C++ code

OpenCV-based processing (Canny edge detection / grayscale)

Real-time rendering on screen via OpenGL ES 2.0

Modular structure:

app/ → Android Java/Kotlin components

app/src/main/cpp/ → Native C++ logic

gl/ → OpenGL renderer (if implemented separately)

🧠 Native C++ (NDK + OpenCV)

Structure in app/src/main/cpp/

JNI bridge for:

Accepting frames from Java

Processing with OpenCV (convert, blur, canny)

Returning processed frames or passing to GL texture

Built using CMake (CMakeLists.txt)

🎨 OpenGL ES Rendering

Uses OpenGL ES 2.0 pipeline

Draws camera texture or processed texture

Smooth rendering targeting 10–15 FPS

🌐 Web Viewer (TypeScript)

Located in /web/ directory.

Displays a static or base64-encoded processed image

Shows basic frame metadata (resolution, FPS placeholder)

Demonstrates TypeScript build setup & DOM updates
