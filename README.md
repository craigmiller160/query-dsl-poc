# QueryDSL POC

This is a POC to figure out how to properly setup QueryDSL in both Java & Kotlin SpringBoot projects. The main challenge is that the default QueryDSL setup mechanism (maven-apt-plugin) is not invoked properly by IntelliJ upon compiling. The objective of this project is to figure out a setup in Java & Kotlin where QueryDSL code generation is properly executed both by the CLI Maven commands and by the default IntelliJ build process.

## Objectives

1. [ ] Java
   1. [ ] Scaffold Spring Boot Project
   2. [ ] Setup basic JPA entities & SQL scripts
   3. [ ] Add validation for Lombok code generation
   4. [ ] Integrate MapStruct and add validation for code generation
   5. [ ] Integrate QueryDSL and add validation for code generation
2. [ ] Kotlin
   1. [ ] Scaffold Spring Boot Project
   2. [ ] Setup basic JPA Entities & SQL scripts
   3. [ ] Integrate MapStruct and add validation for code generation
   4. [ ] Integrate QueryDSL and add validation for code generation