#FROM amd64/buildpack-deps:buster-curl as installer
#
#ARG SENTINEL_VERSION=1.8.7
#
#RUN set -x \
#    && curl -SL --output /home/sentinel-dashboard.jar https://github.com/alibaba/Sentinel/releases/download/${SENTINEL_VERSION}/sentinel-dashboard-${SENTINEL_VERSION}.jar
#
#FROM openjdk:8-jre-slim
#
## copy sentinel jar
#COPY --from=installer ["/home/sentinel-dashboard.jar", "/home/sentinel-dashboard.jar"]
#
#ENV JAVA_OPTS '-Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080'
#
#RUN chmod -R +x /home/sentinel-dashboard.jar
#
#EXPOSE 8080
#
#CMD java ${JAVA_OPTS} -jar /home/sentinel-dashboard.jar
FROM openjdk:8-jre-slim
ENV POTR 8718
ENV APIPORT 8719
ENV HOST 'localhost'
ENV NACOS_SERVER 'localhost:8848'
ENV NACOS_USER_NAME 'nacos'
ENV NACOS_PASSWORD 'nacos'
ENV NACOS_NAMESPACE ''
ENV NACOS_GROUPID 'SENTINEL_GROUP'

EXPOSE ${POTR}
EXPOSE ${APIPORT}
COPY target/sentinel-dashboard.jar /home/sentinel-dashboard.jar
RUN chmod -R +x /home/sentinel-dashboard.jar
ENV JAVA_OPTS '-Dserver.port=${POTR} -Dcsp.sentinel.dashboard.server=${HOST}:${POTR} -Dproject.name=sentinel-dashboard -Dcsp.sentinel.api.port=${APIPORT}'
CMD java ${JAVA_OPTS} -jar /home/sentinel-dashboard.jar