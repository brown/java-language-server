#!/usr/bin/env bash
protoc -I=. --java_out=src/main/java src/main/protobuf/build.proto
protoc -I=. --java_out=src/main/java src/main/protobuf/analysis.proto
protoc -I=. --java_out=src/main/java src/main/protobuf/analysis_v2.proto
