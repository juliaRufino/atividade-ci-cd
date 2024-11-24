# Usar a imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Criar um diretório para a aplicação
WORKDIR /app

# Copiar o arquivo JAR gerado pelo Maven para o container
COPY target/atividade-relacionamento-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta 8080 (onde o Spring Boot roda por padrão)
EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-jar", "app.jar"]
