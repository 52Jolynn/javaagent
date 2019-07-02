# javaagent example

```shell
gradle distZip
unzip myagent-1.0.0-SNAPSHOT.zip
cd myagent-1.0.0-SNAPSHOT/lib
java -javaagent:myagent-1.0.0-SNAPSHOT.jar -cp . -jar myagent-1.0.0-SNAPSHO
T.jar
```

[动手写一个javaagent](https://www.jianshu.com/p/1ca23d884e7f)
[Instrumentation 新功能](https://www.ibm.com/developerworks/cn/java/j-lo-jse61/index.html)
