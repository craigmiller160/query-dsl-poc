# QueryDSL POC

This is a POC to figure out how to properly setup QueryDSL in both Java & Kotlin SpringBoot projects. The main challenge is that the default QueryDSL setup mechanism (maven-apt-plugin) is not invoked properly by IntelliJ upon compiling. The objective of this project is to figure out a setup in Java & Kotlin where QueryDSL code generation is properly executed both by the CLI Maven commands and by the default IntelliJ build process.

## Objectives

1. [x] Setup docker Postgres
2. [ ] Java POC
   1. [x] Scaffold Spring Boot Project
   2. [x] Setup basic JPA entities & SQL scripts
   3. [x] Add validation for Lombok code generation
   4. [ ] Integrate MapStruct and add validation for code generation
   5. [ ] Integrate QueryDSL and add validation for code generation
3. [ ] Kotlin POC
   1. [ ] Scaffold Spring Boot Project
   2. [ ] Setup basic JPA Entities. SQL scripts come from Java POC project
   3. [ ] Integrate MapStruct and add validation for code generation
   4. [ ] Integrate QueryDSL and add validation for code generation