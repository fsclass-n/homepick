# 1. Build Stage
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# 빌드 효율을 위해 설정 파일과 Gradle Wrapper 먼저 복사
COPY gradlew build.gradle settings.gradle /app/
COPY gradle /app/gradle
COPY src /app/src

# 프로젝트에 고정된 Gradle Wrapper로 테스트 제외하고 jar 빌드
RUN chmod +x gradlew && ./gradlew clean bootJar -x test --no-daemon

# 2. Run Stage
FROM amazoncorretto:21-al2023-headless
WORKDIR /app

# 빌드된 jar 파일을 app.jar로 복사
COPY --from=build /app/build/libs/*.jar app.jar

# 타임존 설정 (한국 시간)
ENV TZ=Asia/Seoul
EXPOSE 8080

<<<<<<< HEAD
ENTRYPOINT ["java", "-jar", "app.jar"]
=======
ENTRYPOINT ["java", "-jar", "app.jar"]
>>>>>>> 7139bed0d4310330e1419e5290610a922d18f2d8
