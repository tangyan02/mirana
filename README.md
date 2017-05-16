## 简介

mirana是一个基于JavaDoc，根据代码注释生成md格式文档的软件。可以将接口，实体类，枚举类，能够通过注释，并配合简单的自定义标签，快速生成迭代开发过程中所需的文档。

## 基本用法

1. 编译Maven项目
2. 在Config类中，将需要生成的java文件路径填写到entityPath，enumerationPath，interfacePath的数组中
3. 执行Main方法
4. 在target/mdFiles即可找到生成的md文件

## 选择性的生成方法



## 辅助注释标签

- @remark 作用于实体的属性上，填写的内容会在实体md文件的备注栏中展示。

```java
class Cats {
    /**
    * 猫的名称列表
    *
    * @remark 元素个数不会超过50
    **/
    private List<String> names;
}
```

## 方法名称重名

对于重载的方法目前暂不支持，请尽可能保证方法名与实体名称唯一。