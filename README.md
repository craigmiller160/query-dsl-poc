# QueryDSL POC

This is a POC to figure out how to properly setup QueryDSL in both Java & Kotlin SpringBoot projects. The main challenge is that the default QueryDSL setup mechanism (maven-apt-plugin) is not invoked properly by IntelliJ upon compiling. The objective of this project is to figure out a setup in Java & Kotlin where QueryDSL code generation is properly executed both by the CLI Maven commands and by the default IntelliJ build process.

## Objectives

1. [x] Setup docker Postgres
2. [x] Java POC
   1. [x] Scaffold Spring Boot Project
   2. [x] Setup basic JPA entities & SQL scripts
   3. [x] Add validation for Lombok code generation
   4. [x] Integrate MapStruct and add validation for code generation
   5. [x] Integrate QueryDSL and add validation for code generation
3. [x] Kotlin POC
   1. [x] Scaffold Spring Boot Project
   2. [x] Setup basic JPA Entities. SQL scripts come from Java POC project
   3. [x] Integrate MapStruct and add validation for code generation
   4. [x] Integrate QueryDSL and add validation for code generation

## Important Information For Kotlin Build

IntelliJ's default builder cannot properly invoke Kapt for annotation processing in Kotlin. To make this work, IntelliJ must delegate all build tasks to Maven. To do this, open the settings menu and go to `Build, Execution, Deployment -> Build Tools -> Maven -> Runner`. Then do the following.

1. Check the box that says "Delete IDE build/run actions to Maven"
2. Make sure that "Skip Tests" is not checked.
3. Add the property `maven.test.skip.exec` with the value of `true`. This will ensure that tests compile, but are not executed as part of the build.
4. If Spotless is used, add the property `spotless.check.skip` with the value of `true` to ensure that spotless formatting errors do not block a build.

As an additional option, you can install the `Maven Helper` plugin, and then in its settings check "Use a terminal to run goals, with a custom mvn command" and make sure it is set to "mvnd". This just gives a nice little speed boost.