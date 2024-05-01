## Versions
- CLI SDKMAN!
- Coursier 2.1.9
- JDK java 21.0.3 2024-04-16 LTS(21.0.3-oracle) ```sdk current java``` or ```sdk list java```
- sbt 1.9.8 ```sbt --version```
- scala 3.3.1
- play framework 3.0.2
- Docker Baseimage [eclipse-temurin:21.0.3_9-jre-jammy](https://github.com/adoptium/containers/blob/057e5aa7581e96b8a2334290e750b329d62abfdf/21/jdk/ubuntu/jammy/Dockerfile)

[Scala compatibility table](https://docs.scala-lang.org/overviews/jdk-compatibility/overview.html)

## Deploy
```
$ sbt Docker/publishLocal
$ docker run -it -p 9000:9000 scala-miniapp:1.0-SNAPSHOT

$ cd target/docker/stage/Dockerfile
$ gcloud builds submit --tag gcr.io/scala-miniapp/gcloud-one-scala
$ gcloud run deploy --image gcr.io/scala-miniapp/gcloud-one-scala --platform managed --allow-unauthenticated --port 9000
```