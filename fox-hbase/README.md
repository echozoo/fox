# HBASE
## HBASE简介
Hbase是一个高可靠性、高性能、面向列、可伸缩、实时读写的分布式数据库。依托Hadoop-HDFS作为其文件存储系统，利用MapReduce来处理海量数据，用Zookeeper作为其分布式协同服务，主要用来存储非结构化和半结构化的松散数据（列存 NoSQL 数据库）

### Hbase有什么特性
* 强读写一致，但是不是“最终一致性”的数据存储，这使得它非常适合高速的计算聚合
* 自动分片，通过Region分散在集群中，当行数增长的时候，Region也会自动的切分和再分配
* 自动的故障转移
* Hadoop/HDFS集成，和HDFS开箱即用，不用太麻烦的衔接
* 丰富的“简洁，高效”API，Thrift/REST API，Java API
* 块缓存，布隆过滤器，可以高效的列查询优化
* 操作管理，Hbase提供了内置的web界面来操作，还可以监控JMX指标

### HBASE使用场景


## HBASE架构体系
物理上，Hbase 是由三种类型的 server 组成的的主从式（master-slave）架构：

Region Server 负责处理数据的读写请求，客户端请求数据时直接和 Region Server 交互。
HBase Master 负责 Region 的分配，DDL（创建，删除 table）等操作。
Zookeeper，作为 HDFS 的一部分，负责维护集群状态。
当然底层的存储都是基于 Hadoop HDFS 的：

Hadoop DataNode 负责存储 Region Server 所管理的数据。所有的 HBase 数据都存储在 HDFS 文件中。Region Server 和 HDFS DataNode 往往是分布在一起的，这样 Region Server 就能够实现数据本地化（data locality，即将数据放在离需要者尽可能近的地方）。HBase 的数据在写的时候是本地的，但是当 region 被迁移的时候，数据就可能不再满足本地性了，直到完成 compaction，才能又恢复到本地。
Hadoop NameNode 维护了所有 HDFS 物理 data block 的元信息。
![image-20210803222543735](https://raw.githubusercontent.com/echozoo/peacock/main/img/image-20210803222543735.png)

### HBase Master
 HMaster，负责 Region 的分配，DDL（创建，删除表）等操作：

统筹协调所有 region server：

启动时分配 regions，在故障恢复和负载均衡时重分配 regions
监控集群中所有 Region Server 实例（从 Zookeeper 获取通知信息）
管理员功能：

提供创建，删除和更新 HBase Table 的接口

### Regions
HBase 表（Table）根据 rowkey 的范围被水平拆分成若干个 region。每个 region 都包含了这个region 的 start key 和 end key 之间的所有行（row）。Regions 被分配给集群中的某些节点来管理，即 Region Server，由它们来负责处理数据的读写请求。每个 Region Server 大约可以管理 1000 个 regions。

### Zookeeper
HBase 使用 Zookeeper 做分布式管理服务，来维护集群中所有服务的状态。Zookeeper 维护了哪些 servers 是健康可用的，并且在 server 故障时做出通知。Zookeeper 使用一致性协议来保证分布式状态的一致性。注意这需要三台或者五台机器来做一致性协议。


## windows使用配置
* java连接报错java.io.FileNotFoundException: HADOOP_HOME and hadoop.home.dir are unset.

解决办法:
1. 访问https://github.com/steveloughran/winutils，下载对应版本的windows hadoop模拟工具
2. 本地创建hadoop文件夹，将对应版本的bin目录拷贝到hadoop文件夹下
3. HADOOP_HOME环境变量配置`D:\dujf\software\hadoop\bin`

*不需要下载安装win版hadoop*

* 报错java.net.unknownhostexception: docker-hbase

解决办法:

host 文件配置别名访问
127.0.0.1 docker-hbase


