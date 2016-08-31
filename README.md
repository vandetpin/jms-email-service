## JMS Email Service ##

### configuration ###
- go to config file
  hornetq-2.4.0.Final/config/stand-alone/non-clustered/hornetq-jms.xml 
  
- add below text to the follow the config file

   <queue name="emailQueue">
      <entry name="/queue/emailQueue"/>
   </queue>

http://hornetq.jboss.org/downloads.html

### start the jms service ###
$cd hornetq-2.4.0.Final/bin
$sh run.sh

### run your jms application service ###
mvn exec:java -Dexec.mainClass="com.findme.email.server.jms.JMSEmailReceiverApp"