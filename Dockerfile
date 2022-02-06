FROM centos:7

# RUN WITH local library

MAINTAINER cjz "1041886721@qq.com"

WORKDIR /usr/local/docker
 
ADD jdk-8u321-linux-x64.tar.gz /usr/local/docker
ADD apache-maven-3.8.4-bin.tar.gz /usr/local/docker
COPY version_hit-0.0.1-SNAPSHOT.jar /usr/local/docker
 
#5、配置环境变量，此处目录为tar.gz包解压后的名称，需提前解压知晓：
ENV JAVA_HOME=/usr/local/docker/jdk1.8.0_321
ENV MAVEN_HOME=/usr/local/docker/apache-maven-3.8.4
ENV CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
ENV PATH=$JAVA_HOME/bin:$PATH
ENV PATH=$MAVEN_HOME/bin:$PATH

CMD ["java","-jar","version_hit-0.0.1-SNAPSHOT.jar"]
# CMD ["java","-jar","target/version_hit-0.0.1-SNAPSHOT.jar"]
