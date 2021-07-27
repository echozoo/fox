# spring boot docker 镜像打包

## 镜像打包方式
### jib构建

### dockerfile构建
1. 创建docker file 

2. dockerFile 所在目录执行
* 构建镜像
docker build -t 镜像名称  执行目录
docker build -t athio/grpc-demo:1.0.1 .

* 推送到dockerhub
docker push athio/grpc-demo:1.0.0

* 启动服务
docker run -it -p 8001:8001 athio/grpc-1.0.1