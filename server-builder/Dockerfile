FROM jboss/base-jdk:11

MAINTAINER JavaEEPRO <j2eengineer@gmail.com>

ENV WILDFLY_VERSION 15.0.1.Final
ENV WILDFLY_SHA1 23d6a5889b76702fc518600fc5b2d80d6b3b7bb1
ENV JBOSS_HOME /opt/jboss/wildfly

RUN cd $HOME \
&& curl -O https://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz \
&& sha1sum wildfly-$WILDFLY_VERSION.tar.gz | grep $WILDFLY_SHA1 \
&& tar xf wildfly-$WILDFLY_VERSION.tar.gz \
&& mv $HOME/wildfly-$WILDFLY_VERSION $JBOSS_HOME \
&& rm wildfly-$WILDFLY_VERSION.tar.gz

#ENV LAUNCH_JBOSS_IN_BACKGROUND true

COPY ./ear/target/tickets.ear /opt/jboss/wildfly/standalone/deployments/
#ADD  /opt/jboss/wildfly/standalone/deployments/

# Expose the ports (only outer host machine ports)
EXPOSE 3000

# Set the default command to run on boot
# This will boot WildFly in the standalone mode and bind to all interface
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]