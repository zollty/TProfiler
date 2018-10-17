# TProfiler
TProfiler is a code profiling tool.  
author: [jlusdy](https://github.com/jlusdy) \<shutong.dy@taobao.com\>

## Note
TProfiler requires Java7™ VM.

## License
GPL2.0

## Contribution
We are actively looking for contributors, so if you have any ideas, bug
reports, or patches you would like to contribute please do not hesitate
to do that.

Contributors:

* [zollty](https://github.com/zollty) \<zollty@163.com\>
* [zhoulifu](https://github.com/zhoulifu) \<zlf369777684@gmail.com\>

Please refer to Wiki for more information:
https://github.com/alibaba/TProfiler/wiki

## usage

#### JVM agent配置：   
-javaagent:/home/admin/tprofiler/tprofiler-1.0.1.jar -Dprofile.properties=/home/admin/tprofiler/profile.properties   

#### 默认开始、结束时间配置如下：  
startProfTime=00:00:00  
endProfTime=23:59:59  

时间控制逻辑（参见TimeControlThread.java）:  
开始时间大，则wait  
开始时间小，则看结束时间，结束时间大，则立即开始，直到结束时间到时，结束。  
结束时间小，则等待下一次开始  


举例如下：  
now = 18:00  
start = 00:00  
stop = 23:59  

这时，由于已经超过开始时间，且小于结束时间，所以将会立即开始。  

手动停止：  
java -cp tprofiler-1.0.1.jar com.taobao.profile.client.TProfilerClient 192.168.11.249 50000 stop  
手动刷出方法数据：  
java -cp tprofiler-1.0.1.jar com.taobao.profile.client.TProfilerClient 192.168.11.249 50000 flushmethod  


#### 生成分析数据

生成方法和线程出现次数信息：  
java -cp tprofiler-1.0.1.jar com.taobao.profile.analysis.SamplerLogAnalysis /home/admin/tprofiler/tsampler.log /home/admin/tprofiler/method.log /home/admin/tprofiler/thread.log   
   
生成top method 和 object信息：   
java -cp tprofiler-1.0.1.jar com.taobao.profile.analysis.ProfilerLogAnalysis /home/admin/tprofiler/tprofiler.log /home/admin/tprofiler/tmethod.log /home/admin/tprofiler/topmethod.log /home/admin/tprofiler/topobject.log   

