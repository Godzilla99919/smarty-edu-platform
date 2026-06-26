package com.smartyedu;

import com.smartyedu.learning.LearningApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = LearningApplication.class)
public class bitMapTest {
    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * bitmap指定某位并设置值，但需要注意的是，返回值并不是操作成功或失败的标志，而是该位原值且为布尔值
     * 命令：setbit testBitMap 0 1
     */
    @Test
    public void test(){
        Boolean testBitMap = redisTemplate.opsForValue().setBit("testBitMap", 1, true);
        System.out.println("原始值：" + testBitMap);
        if(testBitMap){
            System.out.println("已经签到过了");
        }
    }

    /**
     * 测试前1-3天内的签到，但是bitmap返回的值是十进制的数，同时需要转化为无符号数
     * 命令：bitfield testBitMap get u3 0
     * 如果需要返回负数，需要使用get i3命令
     */
    @Test
    public void test1(){
        //BitFieldSubCommands.create()的参数可以多个，所以返回的也是一个数组，由于我们参数只有一个，所以list只取第一个
        List<Long> list = redisTemplate.opsForValue().bitField(
                "testBitMap",
                //unsigned则为无符号数
                BitFieldSubCommands.create().get(BitFieldSubCommands.BitFieldType.unsigned(3)).valueAt(0)
        );
        System.out.println(list.get(0));
    }

    /**
     * 测试bitMap返回的Long转List数组
     */
    @Test
    public void test2(){
        List<Long> list = redisTemplate.opsForValue().bitField(
                "testBitMap",
                //unsigned则为无符号数
                BitFieldSubCommands.create().get(BitFieldSubCommands.BitFieldType.unsigned(3)).valueAt(0)
        );
        Long aLong = list.get(0);
        String s = Long.toBinaryString(aLong);
        ArrayList<Integer> arr = new ArrayList<>(31);
        for (char c : s.toCharArray()) {
            arr.add(c == '1'?1:0);
        }
        System.out.println(arr);
    }
//
//    @Test
//    public void test3(){
//        // 假设 redisTemplate 是通过 Spring RedisTemplate 配置的
//        String key = "user:sign_ins:2024:07";
//        int len = 8; // 假设每个 Long 使用了前面的 8 位来存储签到情况
//
//// 获取本月从第一天开始，到今天为止的所有签到记录
//        List<Long> result = redisTemplate.opsForValue().bitField(key,
//                BitFieldSubCommands.create().get(BitFieldSubCommands.BitFieldType.unsigned(len)).valueAt(0));
//
//// 输出每个 Long 的签到情况（示例中只显示前面的 8 位）
//        for (int i = 0; i < result.size(); i++) {
//            Long bits = result.get(i);
//            System.out.println("第 " + (i + 1) + " 天的签到情况：" + Long.toBinaryString(bits));
//        }
//
//    }
}
