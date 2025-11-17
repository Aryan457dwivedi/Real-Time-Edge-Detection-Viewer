# 📱 **Real-Time Edge Detection Viewer**
### **Android (Java/Kotlin) • OpenCV (C++) • OpenGL ES • TypeScript Web Viewer**

A complete real-time image processing pipeline combining **Android Camera**, **Native OpenCV C++**, and **OpenGL ES** rendering.  
Includes a minimal **TypeScript Web Viewer** for displaying processed frames.

_Project submitted as part of the **Software Engineering Intern (R&D) Assignment**._

---

## 🚀 **Features Implemented**

### 📘 **Android Application**
- Camera feed capture using **TextureView / SurfaceTexture**
- **JNI bridge** for sending frames to native C++
- **OpenCV processing**, including:
  - Grayscale  
  - Blur  
  - Canny edge detection
- **OpenGL ES 2.0 rendering** of processed frames
- Modular structure:
  - `app/` — Java/Kotlin logic  
  - `app/src/main/cpp/` — C++ native logic  
  - `gl/` — OpenGL renderer (optional)

---

### 🧠 **Native C++ (NDK + OpenCV)**
- Located at: `app/src/main/cpp/`
- Handles:
  - Frame conversion  
  - Image filtering  
  - Returning processed output to Java
- Built via **CMake** (`CMakeLists.txt`)

---

### 🎨 **OpenGL ES Rendering**
- Uses **OpenGL ES 2.0**
- Renders:
  - Raw camera frames  
  - Processed OpenCV textures
- Maintains **10–15 FPS** performance

---

### 🌐 **Web Viewer (TypeScript)**
Folder: `/web/`

Features:
- Loads **static/base64 processed images**
- Shows placeholder frame metadata
- Minimal, clear HTML+TS UI

Run:
```bash
npm install
npm run dev
```

---

## 📂 **Project Structure**

```
/
├── app/
│   ├── src/main/
│   │   ├── java/...               # Android camera + JNI + UI
│   │   └── cpp/...                # OpenCV C++ (edgedetect.cpp)
│   └── build.gradle
│
├── web/
│   ├── index.html                 # Web viewer UI
│   ├── viewer.ts                  # Renders sample frame
│   ├── sample_frame.txt           # Test image/base64
│   ├── package.json               # Dependencies
│   ├── tsconfig.json              # TS config
│   └── README.md                  # Web-specific docs
│
├── CMakeLists.txt                 # Native build rules
├── OPEN_CV_INSTRUCTIONS.txt       # OpenCV setup notes
├── build.gradle                   # Root Gradle
├── settings.gradle
└── README.md                      # (This file)
```

---

## ⚙️ **Setup & Build Instructions**

### ✅ **1. Android Requirements**
Install:
- Android Studio (latest)
- Android SDK 33+
- Android NDK 23+
- CMake & LLDB

---

### 🔧 **2. Configure OpenCV Android SDK**

Download OpenCV → Extract → Add path in `CMakeLists.txt`:

```cmake
set(OpenCV_DIR /absolute/path/OpenCV-android-sdk/sdk/native/jni)
find_package(OpenCV REQUIRED)
include_directories(${OpenCV_INCLUDE_DIRS})
target_link_libraries(edgedetect ${OpenCV_LIBS})
```

(Instructions also provided in `OPEN_CV_INSTRUCTIONS.txt`)

---

### 🏗 **3. Build Native Library**
Android Studio → **Build → Make Project**

Produces:
```
libedgedetect.so
```

---

### 📱 **4. Run Android App**
- Connect device/emulator  
- Click **Run**

---

### 🌐 **5. Run Web Viewer**

```bash
cd web
npm install
npm run build   # or: tsc
open index.html
```

Displays processed frame from `sample_frame.txt`.

---

## 🧩 **Architecture Overview**

### **Processing Pipeline**

```
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
```

### **Web Path**

```
C++ Frame Output → Exported as PNG/Base64 → TypeScript Web Viewer
```

---

## ⭐ **Optional / Bonus Features**
- 🔄 Toggle raw / processed feed
- ⏱ FPS overlay
- 🎛 GLSL shader effects
- 🌐 Live frame export to Web Viewer

---

## 🧪 **Testing**
- ✔ Tested on physical Android device  
- ✔ Verified native OpenCV + JNI pipeline  
- ✔ Web viewer works with sample frame  

---

## 👤 **Author**
**Aryan Dwivedi**
