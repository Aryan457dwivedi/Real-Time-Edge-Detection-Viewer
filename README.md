📱 Real-Time Edge Detection Viewer
Android (Java/Kotlin) • OpenCV (C++) • OpenGL ES • TypeScript Web Viewer

A complete real-time image-processing pipeline combining Android camera, native OpenCV (C++), and OpenGL ES rendering.
Additionally, a lightweight TypeScript web viewer demonstrates exporting and visualizing processed frames on the web.

Built as part of the Software Engineering Intern (R&D) Assignment.

🚀 Features Implemented
📘 Android Application

📸 Camera feed capture using TextureView / SurfaceTexture

🔗 JNI bridge for sending frames to native C++ code

🧠 OpenCV-based processing (Canny edge detection / grayscale)

🎨 OpenGL ES 2.0 rendering for real-time output

🗂 Modular structure:

app/ — Android Java/Kotlin logic

app/src/main/cpp/ — Native C++ processing

gl/ — OpenGL renderer (if added)

🧠 Native C++ (NDK + OpenCV)

Location: app/src/main/cpp/

Includes:

Frame processing (grayscale, blur, canny)

Efficient native memory handling

JNI functions for communication with Java

Built using CMake (CMakeLists.txt)

🎨 OpenGL ES Rendering

Uses OpenGL ES 2.0

Renders:

Raw camera texture

OR processed OpenCV texture

Smooth rendering targeting 10–15 FPS

🌐 Web Viewer (TypeScript)

Folder: /web/

Features:

Displays static or base64-encoded processed frames

Simple, clean HTML+TS interface

Shows placeholder metadata (resolution, FPS)

Demonstrates TypeScript project structure & DOM updates

Run:

npm install
npm run dev

📂 Project Structure
/
├── app/
│   ├── src/main/
│   │   ├── java/...               # Android camera + JNI + UI
│   │   └── cpp/...                # OpenCV C++ processing (edgedetect.cpp)
│   └── build.gradle
│
├── web/
│   ├── index.html                 # Web viewer UI
│   ├── viewer.ts                  # Renders sample frame
│   ├── sample_frame.txt           # Base64 or test image
│   ├── package.json               # Dependencies
│   ├── tsconfig.json              # TS compiler config
│   └── README.md                  # Web-specific docs
│
├── CMakeLists.txt                 # Native build script
├── OPEN_CV_INSTRUCTIONS.txt       # OpenCV setup help
├── build.gradle                   # Root Gradle config
├── settings.gradle
└── README.md                      # (This file)

⚙️ Setup & Build Instructions
✅ 1. Android Prerequisites

Install:

Android Studio (latest)

Android SDK 33+

Android NDK (23+ recommended)

CMake & LLDB
(via Android Studio → SDK Tools)

🔧 2. Configure OpenCV Android SDK

Download from OpenCV.org

Extract to:

/path/to/OpenCV-android-sdk/


Edit CMakeLists.txt:

set(OpenCV_DIR /absolute/path/OpenCV-android-sdk/sdk/native/jni)
find_package(OpenCV REQUIRED)
include_directories(${OpenCV_INCLUDE_DIRS})
target_link_libraries(edgedetect ${OpenCV_LIBS})


(Also included inside OPEN_CV_INSTRUCTIONS.txt)

🏗 3. Build Native Library

Android Studio → Build → Make Project

This produces:

libedgedetect.so

📱 4. Run Android App

Connect physical device or emulator (with camera)

Click Run in Android Studio

🌐 5. Run Web Viewer
cd web
npm install
npm run build   # OR tsc
open index.html


Displays the processed frame from sample_frame.txt.

🧩 Architecture Overview
Processing Pipeline
Camera Feed → Java Camera Handler
              ↓
            JNI Layer
              ↓
       C++ OpenCV Processor
              ↓
     Processed Texture / Buffer
              ↓
       OpenGL ES Renderer
              ↓
         Android Display

Web Path (Parallel)
C++ Output → Exported Frame (PNG/Base64)
              ↓
          Web Viewer (TS)

⭐ Optional / Bonus Features (Planned / Partially Done)

🔄 Toggle: Raw camera feed / Edge-detected feed

⏱ FPS counter overlay

🎛 GLSL shader-based visual effects

🌐 Export frames to browser viewer

🧪 Testing

✔ Tested on physical Android device

✔ Verified OpenCV C++ processing

✔ Web viewer working with test frame

👤 Author

Aryan Dwivedi
