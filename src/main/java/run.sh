#!/usr/bin/env bash

classPath="/Users/Agent/Projects/mirana/target/classes"
entityPath="source/entity/*.java"
enumerationPath="source/enumeration/*.java"
interfacePath="source/interfaces/*.java"

javadoc -doclet EntityHandle -docletpath ${classPath} ${entityPath}

javadoc -doclet EnumerationHandle -docletpath ${classPath} ${enumerationPath}

javadoc -doclet InterfaceHandle -docletpath ${classPath} ${interfacePath}