#!/usr/bin/env bash

classPath="../../../target/classes"
mdOutputPath="../../../target/mdFiles"

entityPath="
/Users/Agent/Projects/napos-openapi/buttonwood-api-descriptor/src/main/java/me/ele/napos/buttonwood/api/descriptor/struct/application/Application.java
/Users/Agent/Projects/napos-openapi/buttonwood-api-descriptor/src/main/java/me/ele/napos/buttonwood/api/descriptor/struct/application/UpdateApplication.java
/Users/Agent/Projects/napos-openapi/buttonwood-service-descriptor/src/main/java/me/ele/napos/buttonwood/service/descriptor/struct/application/Config.java
/Users/Agent/Projects/napos-openapi/buttonwood-service-descriptor/src/main/java/me/ele/napos/buttonwood/service/descriptor/struct/application/EnumConfig.java
/Users/Agent/Projects/napos-openapi/buttonwood-api-descriptor/src/main/java/me/ele/napos/buttonwood/api/descriptor/struct/facilitator/FacilitatorResult.java
/Users/Agent/Projects/napos-openapi/buttonwood-api-descriptor/src/main/java/me/ele/napos/buttonwood/api/descriptor/struct/facilitator/Facilitator.java
/Users/Agent/Projects/napos-openapi/buttonwood-api-descriptor/src/main/java/me/ele/napos/buttonwood/api/descriptor/struct/facilitator/ApplicationMelodyView.java
"
enumerationPath="
/Users/Agent/Projects/napos-openapi/buttonwood-service-descriptor/src/main/java/me/ele/napos/buttonwood/service/descriptor/struct/application/AppGroundingState.java
/Users/Agent/Projects/napos-openapi/buttonwood-service-descriptor/src/main/java/me/ele/napos/buttonwood/service/descriptor/struct/application/AppLabel.java
/Users/Agent/Projects/napos-openapi/buttonwood-service-descriptor/src/main/java/me/ele/napos/buttonwood/service/descriptor/struct/application/AppType.java
/Users/Agent/Projects/napos-openapi/buttonwood-service-descriptor/src/main/java/me/ele/napos/buttonwood/service/descriptor/struct/application/PlatformType.java
/Users/Agent/Projects/napos-openapi/buttonwood-service-descriptor/src/main/java/me/ele/napos/buttonwood/service/descriptor/struct/application/AppState.java

"

interfacePath="
/Users/Agent/Projects/napos-openapi/buttonwood-api-descriptor/src/main/java/me/ele/napos/buttonwood/api/descriptor/service/ApplicationApIService.java
/Users/Agent/Projects/napos-openapi/buttonwood-api-descriptor/src/main/java/me/ele/napos/buttonwood/api/descriptor/service/FacilitatorApiService.java
"

rm -rf ${mdOutputPath}

for path in ${entityPath}
do
    javadoc -doclet EntityHandle -docletpath ${classPath} ${path}
done

for path in ${enumerationPath}
do
    javadoc -doclet EnumerationHandle -docletpath ${classPath} ${path}
done

for path in ${interfacePath}
do
    javadoc -doclet InterfaceHandle -docletpath ${classPath} ${path}
done