

### 文档说明：

在【data_platform】文件夹中，包含项目源代码，相关数据源，以及代码运行所需要的sql语句等。

### 项目版本信息：

- MySQL 8.0 

- JDK 11

- POWER BI DESKTOP

### 流程图：

![时序图设计](assets/时序图设计.svg)

### 数据库基本表：

![](C:\Users\admin\Desktop\统计与机器学习\数据中台\assets\2021-12-11-00-29-18-image.png)

### postman接口列表：

- 系统管理
  
    - `POST` 用户登录
  
    - `GET`  退出登录

- 获取数据源
  
    - `GET` 爬取数据
  
    - `GET` 获取爬虫记录
  
    - `POST`入库
  
    - `GET` 获取入库记录

- 贴源数据层
  
    - `GET` 元数据列表
  
    - `GET` 查看源数据
  
    - `POST`清洗数据
  
    - `GET` 操作记录
  
    - `POST`导入数据仓库  

- 数据仓库
  
    - `GET` 查看仓库中文件列表
  
    - `POST`打标签

### 接口详情：

1，爬取数据: http://localhost:8080/api/spider                                                        

```json
{
    "url": "tageted_url_path_for_spider",
    "filePath": "the_storage_path_of_the_file",//relative path to the root directory
    "fileName": "the_storage_name_of_the_file"
}
```

2.获取数据源记录: http://localhost:8080/api/spider/records

```json
 "records": [
        {
            "id": 16,
            "url": "https://spec.org/cgi-bin/osgresults?conf=cpu2017",
            "fileName": "cpu2017.csv",
            "filePath": "C:\\HWA\\data-platform\\rawSource\\cpu2017.csv",
            "status": "SUCCEED",
            "createTime": "2021-12-07 16:14:13",
            "updateTime": "2021-12-07 16:14:13"
        },
        {
            "id": 17,
            "url": "https://spec.org/cgi-bin/osgresults?conf=sfsd",
            "fileName": "cpu2018.csv",
            "filePath": "rawSource/",
            "status": "FAILED",
            "createTime": "2021-12-07 16:14:38",
            "updateTime": "2021-12-07 16:14:38"
        }
    ]
```

3.入库: http://localhost:8080/api/storage

```json
{
    "rawSource":{
        "id":1
    },
    "tableName": "cpu2017_results1",
    "dataBase":"data_platform"
}
```

4.入库记录: http://localhost:8080/api/storage/records

```json
"records": [
      {
         "id": 1,
         "rawSoure": {
             "id": 18,
             "rawSourcePath": "C:\\HWA\\data-platform\\RawSource\\CPU2017_Results.csv"
          },
         "tableName": "cpu2017_results",
         "dataBase": "data_platform",
         "createTime": "2021-12-08 16:24:52",
         "updateTime": "2021-12-08 16:24:52"
    }
```

4.贴源数据层元数据详情: http://localhost:8080/api/metadata

```json
"records": [
        {
            "id": 1,
            "rawSource": {
                "id": 18,
                "rawSourcePath": "C:\\HWA\\data-platform\\RawSource\\CPU2017_Results.csv"
            },
            "tableName": "cpu2017_results",
            "dataBase": "data_platform",
            "column": 35,
            "row": 973,
            "createTime": "2021-12-08 16:02:58",
            "updateTime": "2021-12-08 16:02:58"
        }
    ]
```

5.查看源数据: http://localhost:8080/api/raw/data

![](C:\Users\admin\Desktop\统计与机器学习\数据中台\assets\2021-12-08-16-49-50-image.png)

6.清洗数据: http://localhost:8080/api/raw/data

```sql
{
    "metaData":{
        "metaDataId":1
    },
    "operation":"DELETE",
    "sql":"delete from log_raw_data;"
}
```

7.操作记录: http://localhost:8080/api/meta/data/{id}/operation

```json
{
    "records": [
        {
            "id": 5,
            "metaData": {
                "metaDataId": 1,
                "dataBase": "data_platform",
                "tableName": "cpu2017_results"
            },
            "operation": "SELECT",
            "sql": "select * from cpu2017_results where Peak_Result='9.09' limit 1;",
            "processTime": "2021-12-09 15:13:32"
        }
    ]
}
```

8.导入数据仓库: http://localhost:8080/api/repository/import

```json
{
    "tableName": "cpu2017_results",
    "dataBase":"data_platform",
    "targetName":"test1.csv",
    "targetPath":"C:\\\\HWA\\\\data-platform\\\\rawSource\\\\"
}
```

9.查看统一数仓: http://localhost:8080/api/repository/records

```json
"records": [
        {
            "id": 1,
            "tableName": "cpu2017_results",
            "dataBase": "data_platform",
            "targetName": "cpu2017_results",
            "targetPath": "C:\\\\HWA\\\\data-platform\\\\rawSource\\\\",
            "createTime": "2021-12-10 17:39:31",
            "updateTime": "2021-12-10 17:39:31"
        }
 ]
```

### 数据资产化与服务化

经过清洗后。得到以下处理后的数据源：

![](C:\Users\admin\Desktop\统计与机器学习\数据中台\assets\2021-12-11-01-25-06-image.png)

查询服务：

![](C:\Users\admin\Desktop\统计与机器学习\数据中台\assets\2021-12-11-01-54-26-image.png)

数据报表：

- 分析JVM计数在不同公司和操作系统的差异

<img src="file:///C:/Users/admin/Desktop/统计与机器学习/数据中台/assets/2021-12-11-01-51-27-image.png" title="" alt="" width="812">

![](C:\Users\admin\Desktop\统计与机器学习\数据中台\assets\2021-12-11-01-51-43-image.png)
