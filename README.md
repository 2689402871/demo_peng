# demo_peng 项目说明

## 项目简介
`demo_peng` 是一个基于 Spring Boot 的演示项目，主要包含字符串处理相关的功能，如删除连续重复字符、替换连续重复字符等操作，并提供了对应的测试用例。

## 技术栈
- Spring Boot 2.7.10
- Java 11
- Maven 3.9.11（通过 Maven Wrapper 管理）
- JUnit 5（单元测试）
- Lombok（简化代码）

## 项目结构
```
demo_peng/
├── .mvn/                      # Maven Wrapper 配置
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/demo_peng/
│   │   │       ├── DemoPengApplication.java  # 应用入口类
│   │   │       ├── handler/                  # 字符串处理抽象及实现
│   │   │       ├── service/                  # 服务接口及实现
│   │   │       └── untils/                   # 工具类（字符串处理工具）
│   │   └── resources/
│   │       └── application.properties        # 应用配置文件
│   └── test/                                 # 单元测试代码
├── .gitignore                                # Git 忽略文件配置
├── mvnw.cmd                                  # Windows 下的 Maven Wrapper 脚本
└── pom.xml                                   # Maven 项目配置
```

## 核心功能
1. **字符串工具类（StringUtil）**
   - 校验 是否仅包含小写字母（`isLowercaseLetterOnly`）
   - 获取小写字母的前一位字母（`getPreviousLetterFromLowercase`）

2. **字符串处理服务（StringServer）**
   - 删除连续3个及以上的重复字符（`removeConsecutive`）
   - 将连续3个及以上的重复字符替换为字母表中前一位字母（`replaceConsecutive`）

## 如何运行
### 前提条件
- JDK 11 或更高版本

### 编译和运行
1. 克隆项目到本地
2. 进入项目根目录
3. 使用 Maven Wrapper 编译项目：
   ```bash
   # Windows
   mvnw.cmd clean compile
   ```
4. 运行应用：
   ```bash
   # Windows
   mvnw.cmd spring-boot:run
   ```

### 运行测试
```bash
# Windows
mvnw.cmd test
```

## 测试说明
测试类位于 `src/test/java/com/example/demo_peng` 目录下，包含：
- `DemoPengApplicationTests`：应用上下文测试
- `StringServerImplTests`：字符串处理功能测试，涵盖各种输入场景

## 注意事项
- 输入字符串需为纯小写字母，否则则会被视为无效输入，不进行处理
- 连续3个及以上相同字符会被视为需要处理的连续字符
- 替换连续字符时，若字符为 'a'，则替换结果为空（因 'a' 没有前一位字母）
