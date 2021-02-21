FROM centos:7

# Tomcat
ENV TOMCAT_HOME /opt/tomcat
ARG TOMCAT_VERSION=9.0.39

RUN cd /opt && wget http://archive.apache.org/dist/tomcat/tomcat-9/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz && \
    tar --directory /opt -xzf apache-tomcat-${TOMCAT_VERSION}.tar.gz && \
    mv /opt/apache-tomcat-${TOMCAT_VERSION}/* ${TOMCAT_HOME} && \
    ls -l /opt && ls -l /opt/tomcat/ && \
    sed -i "s*shared.loader=*shared.loader=/opt/config*g" ${TOMCAT_HOME}/conf/catalina.properties && \
    rm apache-tomcat-${TOMCAT_VERSION}.tar.gz

# ELK
ENV FILEBEAT_ENV dev
ENV FILEBEAT_REGION na
ENV LOGSTASH_HOST "logstash:5044"

ENV APPLICATION_COMPONENT "learn-elk"
ENV APPLICATION_COMPONENT_INSTANCE "learn-elk-instance"

ARG FILEBEAT_VERSION=7.11.1
RUN printf "\nInstalling Filebeat..." && \
	curl -L -O https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-${FILEBEAT_VERSION}-linux-x86_64.tar.gz && \
    tar xzvf filebeat-${FILEBEAT_VERSION}-linux-x86_64.tar.gz && \
    rm filebeat-${FILEBEAT_VERSION}-linux-x86_64.tar.gz && \
    mkdir -p usr/share/filebeat && \
    cp -rf filebeat-${FILEBEAT_VERSION}-linux-x86_64/* /usr/share/filebeat && \
    rm -rf filebeat-${FILEBEAT_VERSION}-linux-x86_64/
COPY filebeat.yml /usr/share/filebeat/filebeat.yml

CMD nohup ${TOMCAT_HOME}/filebeat/filebeat -e -c ${TOMCAT_HOME}/filebeat/filebeat.yml & bin/catalina.sh run