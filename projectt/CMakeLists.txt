cmake_minimum_required(VERSION 3.10)
project(edgedetect)

set(CMAKE_CXX_STANDARD 17)

# To use OpenCV, set OpenCV_DIR to the OpenCV Android SDK path and uncomment find_package
# find_package(OpenCV REQUIRED)
# include_directories(${OpenCV_INCLUDE_DIRS})

add_library(edgedetect SHARED
    app/src/main/cpp/edgedetect.cpp
)

find_library(log-lib log)
target_link_libraries(edgedetect ${log-lib})
