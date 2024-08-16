FROM ubuntu:latest
LABEL authors="Принцесуха"

ENTRYPOINT ["my-topic", "--server", "kafka:9092", "--topic", "my-topic", "--bootstrap-server", "kafka:9092"]