FROM openjdk:8

ADD target/paymentService.jar paymentService.jar
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "paymentService.jar"]