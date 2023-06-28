FROM openjdk:17
WORKDIR /app
EXPOSE 443:443
EXPOSE 444:444
EXPOSE 445:445
EXPOSE 446:446
COPY ./matriculate/target/matriculate-0.0.1-SNAPSHOT.jar .
COPY ./student/target/student-0.0.1-SNAPSHOT.jar .
COPY ./subject/target/subject-0.0.1-SNAPSHOT.jar .
COPY ./user/target/user-0.0.1-SNAPSHOT.jar .
COPY ./launcher.sh .
CMD  chmod 777 './launcher.sh'; /bin/bash -c './launcher.sh'