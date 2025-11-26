# -----------------------------------------------------
# ETAPA 1 — Build da aplicação usando Maven Wrapper
# -----------------------------------------------------
FROM eclipse-temurin:17-jdk AS build

WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN chmod -R 777 ./mvnw

RUN ./mvnw install -DskipTests

RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# -----------------------------------------------------
# ETAPA 2 — Imagem final para rodar no Render
# -----------------------------------------------------
FROM eclipse-temurin:17-jdk

VOLUME /tmp

ARG DEPENDENCY=/workspace/app/target/dependency

COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# 🚀 Classe principal da sua API FITNESS
ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.generation.fitness.FitnessApplication"]
