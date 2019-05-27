#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true

docker build -t registry.cn-beijing.aliyuncs.com/springcloud-jason/product .

docker push registry.cn-beijing.aliyuncs.com/springcloud-jason/product