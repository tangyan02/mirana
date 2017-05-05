#!/usr/bin/env bash

javadoc -doclet EntityHandle -docletpath /Users/Agent/Projects/mirana/target/classes source/entity/*.java

javadoc -doclet EnumerationHandle -docletpath /Users/Agent/Projects/mirana/target/classes source/enumeration/*.java

javadoc -doclet InterfaceHandle -docletpath /Users/Agent/Projects/mirana/target/classes source/interfaces/*.java