# javaagent
java agent example

```shell
gradle distZip
unzip myagent-1.0.0-SNAPSHOT.zip
cd myagent-1.0.0-SNAPSHOT/lib
java -javaagent:myagent-1.0.0-SNAPSHOT.jar -cp . -jar myagent-1.0.0-SNAPSHO
T.jar
```
