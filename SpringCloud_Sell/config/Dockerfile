FROM registry.cn-beijing.aliyuncs.com/hadyang/oracle-java-8-alpine
#署名
MAINTAINER jason1512 2220953113@qq.com
#放到容器中 将jar文件重命名为app.jar
ADD target/*.jar app.jar
#声明端口8761
EXPOSE 8761
#运行
ENTRYPOINT ["java","-jar","/app.jar"]