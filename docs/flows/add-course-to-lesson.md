# 添加课程到课表 - 业务流程

## 需求
用户购买课程后，交易服务会通过MQ通知学习服务，学习服务将课程加入用户课表中

## 流程图

```mermaid
flowchart TD
    A([开始]) --> B[监听MQ消息]
    B --> C[1. 基于CourseClient<br/>查询课程有效期]
    C --> D[2. 循环遍历<br/>封装LearningLesson]
    D --> E[2.1 计算并填入过期时间]
    E --> F[2.2 填入userId和courseId]
    F --> G[3. 批量保存LearningLesson]
    G --> H([结束])
```

## 入参

| 参数名 | 类型 | 说明 |
|--------|------|------|
| orderId | Long | 订单id |
| userId | Long | 用户id |
| courseIds | List\<Long\> | 订单包含的课程id |
| finishTime | LocalDateTime | 支付完成时间 |

## 代码映射

```
MQ消息监听 → LessonChangeListener.onOrderMessage()
查询课程有效期 → CourseClient.getCoursesInfo()
封装LearningLesson → 循环courseIds, 设置过期时间, userId
批量保存 → learningLessonMapper.insertBatch()
```
