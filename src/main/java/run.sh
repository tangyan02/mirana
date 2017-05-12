#!/usr/bin/env bash

classPath="../../../target/classes"
mdOutputPath="../../../target/mdFiles"

entityPath="
source/entity/*.java
"
enumerationPath="
source/enumeration/*.java
"

interfacePath="
source/interfaces/*.java
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