## 简介

mirana是一个基于JavaDoc，根据代码注释生成md格式文档的软件。可以将接口，实体类，枚举类，能够通过注释，并配合简单的自定义标签，快速生成迭代开发过程中所需的文档。

## 环境要求

- Gradle
- Java >= 1.8

## 基本用法

1. 执行命令 gradle clean build
2. 在config.json文件中，将需要生成的java文件路径填写到entityPath，enumerationPath，interfacePath的数组中
3. 执行命令 gradle run
4. 在build/mdFiles目录中即可找到生成的md文件

## 选择性的生成方法

有的时候，我们需要在一个interface中，选择性的生成method，可以通过配置config.json来实现。在serviceList中填写接口名，methodWhiteList中填写方法名。此时将仅对methodWhiteList的方法进行文档生成。

## 辅助注释标签

- @remark 作用于实体的属性上，填写的内容会在实体md文件的备注栏中展示。

```java
public interface DogService {
    /**
     * 获取狗狗颜色
     *
     * @param dogId 狗狗Id
     * @remark 颜色有可能为空
     */
    Color getColor(int dogId);
}
```

## 方法名称重名

对于重载的方法目前暂不支持，请尽可能保证方法名与实体名称唯一。