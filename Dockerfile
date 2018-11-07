FROM qaware/zulu-centos-payara-micro:8u181-5.183

ENTRYPOINT ["java", "-server", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-XX:MaxRAMFraction=3", "-XX:ThreadStackSize=256", "-XX:MaxMetaspaceSize=128m", "-XX:+UseG1GC", "-XX:ParallelGCThreads=2", "-XX:CICompilerCount=2", "-XX:+UseStringDeduplication", "-Dcom.sun.management.jmxremote=true", "-Djava.rmi.server.hostname=localhost", "-Dcom.sun.management.jmxremote.port=9090", "-Dcom.sun.management.jmxremote.rmi.port=9090", "-Dcom.sun.management.jmxremote.authenticate=false", "-Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.local.only=false", "-jar", "/opt/payara/payara-micro.jar"]
CMD ["--maxHttpThreads", "25", "--deploymentDir", "/opt/payara/deployments"]

COPY build/libs/config-service.war /opt/payara/deployments/