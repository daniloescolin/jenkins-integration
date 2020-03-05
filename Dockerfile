FROM tomee:8-jre-1.7.4-plus

ARG folder=aws-desa
MAINTAINER Danilo Escolin <descolin@gyt.com.gt>

WORKDIR /usr/local/tomee
ADD resources/${folder}/tomee.xml conf/
ADD jenkins-integration-web/build/libs/jenkins-integration.war webapps
ADD resources/filebeat.yml /etc/filebeat
ADD assets/install.sh /tmp/install.sh
RUN /tmp/install.sh

ENV PATH /usr/local/tomee/bin:$PATH

CMD ["catalina.sh", "run"]