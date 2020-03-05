#!/bin/bash
###############################
# my-image/
# â assets
# â â entrypoint.sh
# â â install.sh
# â build.sh
# â Dockerfile
# â README.md
# â VERSION
###############################
##################################################################################################
# install.sh
# This is copied and run inside the container, installs packages, removes unnecessary files, etc.
# Without being 100% sure - I think such an approach reduces the number of layers avoiding
# multiple commands in a single RUN
##################################################################################################
TZ=America/Guatemala
/bin/echo $TZ | /usr/bin/tee /etc/timezone
/usr/sbin/dpkg-reconfigure --frontend noninteractive tzdata
/usr/bin/apt-get install -y wget
cd /usr/local/tomee
/bin/sed -i "30i openejb.deploymentId.format = {appId}/{ejbJarId}/{ejbName}" conf/system.properties
/usr/bin/wget http://172.20.1.178:8081/repository/resources/mysql-connector-java-5.1.37 -O lib/mysql-connector-java-5.1.37.jar
/usr/bin/wget http://172.20.1.178:8081/repository/resources/server.xml -O conf/server.xml
/usr/bin/wget https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-5.5.0-amd64.deb -O filebeat-5.5.0-amd64.deb
/usr/bin/dpkg -i filebeat-5.5.0-amd64.deb
/bin/rm filebeat-5.5.0-amd64.deb
/usr/sbin/update-rc.d filebeat defaults 95 10