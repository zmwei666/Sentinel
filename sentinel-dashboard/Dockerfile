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
#FROM openjdk:8-jre-slim
FROM meddream/jdk17
ARG SENTINEL_VERSION=1.8.7
ENV PORT 8718
ENV APIPORT 8719
ENV HOST '127.0.0.1'
#ENV NACOS_SERVER '127.0.0.1:8848'
#ENV SENTINEL_USERNAME sentinel
#ENV SENTINEL_PASSWORD sentinel
#ENV NACOS_USERNAME 'nacos'
#ENV NACOS_PASSWORD 'nacos'
#ENV NACOS_NAMESPACE ''
#ENV NACOS_GROUPID 'SENTINEL_GROUP'

EXPOSE ${PORT}
EXPOSE ${APIPORT}
COPY target/sentinel-dashboard.jar /home/sentinel-dashboard.jar
COPY src/main/resources/application.properties /home/application.properties
WORKDIR /home/
RUN chmod -R +x /home/sentinel-dashboard.jar
ENV JAVA_OPTS '-Dserver.port=${PORT} -Dcsp.sentinel.dashboard.server=${HOST}:${PORT} -Dproject.name=sentinel-dashboard -Dcsp.sentinel.api.port=${APIPORT}'
CMD java ${JAVA_OPTS} -jar /home/sentinel-dashboard.jar