

cmake_minimum_required(VERSION 3.4.1)


#指定一个变量 添加的时候使用变量值(my_c_path)

file(GLOB my_c_path src/main/cpp/bzip2/*.c)

add_library( BisPatch
             SHARED
             ${my_c_path}
             src/main/cpp/bspatch.c )



find_library( log-lib
              log )



target_link_libraries(BisPatch
                       ${log-lib} )





