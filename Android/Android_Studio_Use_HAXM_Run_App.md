## 在 Android Studio 中使用模拟器运行App

- 下载 [Intel® Hardware Accelerated Execution Manager](https://software.intel.com/en-us/android/articles/intel-hardware-accelerated-execution-manager)
- 安装
- 查询是否安装成功。sc query intelhaxm
```
SERVICE_NAME: intelhaxm
        TYPE               : 1  KERNEL_DRIVER
        STATE              : 4  RUNNING
                                (STOPPABLE, NOT_PAUSABLE, IGNORES_SHUTDOWN)
        WIN32_EXIT_CODE    : 0  (0x0)
        SERVICE_EXIT_CODE  : 0  (0x0)
        CHECKPOINT         : 0x0
        WAIT_HINT          : 0x0
```
- 需要打开BIOS中的虚拟化技术。
- 在 Android Studio 下使用模拟器运行程序。
```
emulator.exe -avd Nexus_5_API_21 -netspeed full -netdelay none
Creating filesystem with parameters:
    Size: 69206016
    Block size: 4096
    Blocks per group: 32768
    Inodes per group: 4224
    Inode size: 256
    Journal blocks: 1024
    Label: 
    Blocks: 16896
    Block groups: 1
    Reserved block group size: 7
Created filesystem with 11/4224 inodes and 1302/16896 blocks
emulator: device fd:804
HAX is working and emulator runs in fast virt mode
emulator: warning: opening audio input failed
creating window 61 83 462 820
```
