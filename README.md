# SCAU Java课程作业仓库

这是华南农业大学（SCAU）2025级面向对象编程课程的作业仓库，Tim2354编写（部分代码由GLM4.6协助完成，感谢智谱AI）

包含了课程中的实验、练习和课程设计项目。

## 许可证

本项目采用 [Unlicense](LICENSE) 协议，已完全释放到公共领域。这意味着您可以：
- 自由使用、修改、分发和商业使用
- 无需保留任何版权声明或许可证文本
- 无需署名原作者
- 完全没有任何限制

简单来说，您可以像对待自己写的代码一样对待这些代码。

## 项目结构

### 实验部分 (Experiment)
- **Experiment1**: Java基础编程练习
  - task2: 三角形面积计算程序（使用Point记录类和海伦公式）
  - task3: 十进制转十六进制转换器
  - task4: 科学计算器
  - task5: 柜子开关模拟器

- **Experiment2**: 面向对象编程基础
  - task1: 股票类实现（包含股票价格变化百分比计算）
  - task2: 风扇类实现
  - task3: 算术表达式求值器（支持基本四则运算）
  - task4: 秒表类实现

- **Experiment3**: 继承与多态
  - task1: 宠物类层次结构（Pet基类，Cat和Dog子类）
  - task2: 宠物类层次结构改进版
  - task3: 电器设备类层次结构（ElectricalDevice基类，Fan和Light子类）

- **Experiment4**: 高级面向对象特性
  - task1: 可着色图形系统（Colorable接口，Circle类实现）
  - task2: 学生信息管理系统（Student类实现）

- **Experiment5**: 数据结构与算法
  - task1: 数组工具类实现（ArrayUtil类，包含数组操作方法）

- **Experiment6**: 综合应用
  - task1: 最近和最远点查找系统（ClosestFarthestPoints类）

### 练习部分 (Practice)
- **Practice1**: Java基础语法练习
  - task2: 圆柱体积计算（使用Math.PI）
  - task3: 月份天数判断（考虑闰年）
  - task4: 字符串反转
  - task5: 考试成绩分析

- **Practice2**: 面向对象基础
  - task1: 矩形类实现
  - task2: 矩形类改进版
  - task3: 一元二次方程求解
  - task4: 圆形类实现

- **Practice3**: 面向对象进阶
  - task1: 正多边形类实现
  - task2: 银行账户管理系统
    - 包含储蓄账户（SavingAccount）和信用卡账户（CreditAccount）
    - 账户管理器（AccountManager）支持添加、删除、查询账户
    - 支持存款、取款操作和余额统计

- **Practice4**: 高级面向对象编程
  - task1: 图形面积计算系统
    - 支持矩形、圆形、梯形等图形
    - 使用抽象基类Shape和多态
    - 包含用户交互界面
  - task2: 产品库存管理系统
    - 包含产品查询、入库、出库、删除等功能
    - 使用ProductManager类管理库存操作

- **Practice5**: 泛型编程练习
  - task1: Location类实现
    - 泛型类，用于查找数组中的最大/最小值位置
    - 支持任意Comparable类型
    - 包含findMax和findMin静态方法

- **Practice6**: 综合练习
  - task1: 整数加法练习系统
    - IntegerAdditionRules类：定义练习规则（题目数量、数值范围）
    - Practice类：生成具体的加法题目
    - 支持随机数生成和用户交互答题

### 课程设计 (Course Design for DS)
- **Union-Find Set**: 并查集数据结构实现，用于图的连通分量分析
- 课程设计是给数据结构的，倒不是给Java课程的，但用Java写的，放在这里以示完整。


## 运行环境

- Java 17或更高版本
- 支持Java记录类(Record)特性
- IDE推荐：IntelliJ IDEA

## 作者信息

华南农业大学 Java课程作业 Tim2354自用仓库，不过公开也的确没问题

## 贡献与分享

本项目完全开源，欢迎：
- 学习参考
- 代码复用
- 提出改进建议
- Fork 并自定义

## 更新日志

### 最新更新
- 更新项目结构描述，添加Experiment3-6的完整内容
- 完善项目文档和README
- 完成Practice6整数加法练习系统

### 历史更新
- 完成所有实验和练习任务
- 添加并查集数据结构实现
- 优化代码结构和注释
