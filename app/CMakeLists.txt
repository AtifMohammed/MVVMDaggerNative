cmake_minimum_required(VERSION 3.4.1)

add_library( native-lib.lib
             MODULE
             src/main/cpp/native-lib.cpp )

find_library( log-lib
              log )

target_link_libraries( native-lib.lib ${log-lib} )