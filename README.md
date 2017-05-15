## 简介

mirana是一个基于JavaDoc，根据代码注释生成md格式文档的软件。可以将接口，实体类，枚举类，能够通过注释，并配合简单的自定义标签，快速生成迭代开发过程中所需的文档。

## 基本用法

1. 将需要的接口，实体类，枚举类复制到source文件夹对应的目录中
2. 编译项目
3. 运行run.sh
4. 在target/mdFiles即可找到生成的md文件

## 根据路径生成

run.sh中的entityPath，enumerationPath，interfacePath三个变量代表实体类，枚举，接口的文件路径。替换该路径到您的项目路径的代码，可以无需复制文件，直接进行文档生成。

## 辅助注释标签

- @type 作用于实体的属性上。对于泛型的类型，javaDoc无法直接获取，可以通过该标签辅助文档生成。

```java
class Cats {
    /**
    * 猫的名称列表
    *
    * @type List<String>
    **/
    private List<String> names;
}
```

- @paramType 作用于接口的方法上，需要将参数名称与类型用":"隔开。对于泛型的类型，javaDoc无法直接获取，可以通过该标签辅助文档生成。

```java
interface AnimalService {
    /**
    * 回屋
    *
    * @paramType names:List<String>
    **/
    void goHome(List<String> names);
}
```

- @returnType 作用于接口的方法上。对于泛型的类型，javaDoc无法直接获取，可以通过该标签辅助文档生成。

```java
interface AnimalService {
    /**
    * 获取名称列表
    *
    * @returnType List<String>
    **/
    List<String> getNameList();
}
```

- @story 迭代版本，在story开关开启后。将只生成匹配的story的接口
