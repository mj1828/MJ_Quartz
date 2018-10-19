# 项目说明
> 本项目采用springboot、mybtais、spring-boot-starter-quartz搭建定时任务项目，前台页面还在开发中。

**特别说明**
> 本项目大部分代码copy https://github.com/cobraxiaoping/cobraboot.git

## 代码结构
```
├── java
│   └── com
│       └── mj
│           ├── MjQuartzApplication.java # 启动类
│           ├── ServletInitializer.java
│           ├── code # 代码项
│           │   ├── JobStatusCode.java # 任务状态
│           │   └── YesOrNoCode.java # 是否
│           ├── common
│           │   └── ResultUtil.java # 返回JsonObject
│           ├── controller
│           │   └── QuartzJobController.java
│           ├── entity
│           │   └── ScheduleJob.java
│           ├── mapper
│           │   └── ScheduleJobMapper.java
│           ├── service
│           │   ├── QuartzJobService.java
│           │   └── impl
│           │       └── QuartzJobServiceImpl.java
│           └── task
│               ├── BaseJob.java # 基础任务
│               ├── QuartzJobManager.java
│               ├── QuartzJobRunner.java
│               └── job
│                   └── CobraJob.java # 自定义任务，添加任务，放在这个包下，启动自动扫描
├── resources
│   ├── application.yml
│   ├── db
│   │   └── mj_quartz.sql # 备份数据库文件
│   ├── mybatis
│   │   ├── generatorConfig.xml
│   │   ├── mapper
│   │   │   └── ScheduleJobMapper.xml
│   │   └── mybatis-config.xml
│   ├── static
│   └── templates
└── webapp

```
## 项目后期计划
1. 完善项目
2. 使用vue搭建前台页面

## 补充
1. 项目还在开发中，没有整体测试，有问题联系 mj_java@163.com