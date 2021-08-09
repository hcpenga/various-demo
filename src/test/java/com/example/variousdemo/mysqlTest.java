package com.example.variousdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.variousdemo.entity.Testone;
import com.example.variousdemo.service.TestoneService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * @className: mysqlTest
 * @description:
 * @created: 2021/08/09 17:41
 */
@SpringJUnitConfig
@SpringBootTest
public class mysqlTest {
    @Autowired
    private TestoneService testoneService;

    @Test
    public void save(){
        Testone testone = new Testone();
        testone.setId(88);
        testone.setDeptId(99);
        testone.setName("Jack");
        testone.setSalary(new Float("22"));
        testoneService.save(testone);
    }

    @Test
    public void getOne(){
        Testone testone = testoneService.getById(1);
        System.out.println(testone.getName());
    }

    @Test
    public void getList(){
        QueryWrapper<Testone> queryWrapper = new QueryWrapper<Testone>();
        queryWrapper.lambda().eq(Testone::getDeptId,"123");
        List<Testone> list= testoneService.list(queryWrapper);
//        if(list != null && list.size() > 0){
//            for(int i = 0 ; i < list.size() ; i++){
//                Testone testOne = list.get(i);
//                System.out.println(testOne.getName());
//            }
//        }
        list.forEach(System.out::println);
    }

    @Test
    public void conditionSearch(){
        //条件查询
//       Testone testone = testoneService.getOne(new QueryWrapper<Testone>()
//               .lambda().eq(Testone::getName,"Mark").eq(Testone::getId,"1").last("limit 1"));
//       if(testone != null){
//           System.out.println(testone.getName());
//       }
        //分页查询
        int pageNum = 1;
        int pageSize = 1;
        IPage<Testone> testoneIPage = testoneService.page(new Page<>(pageNum,pageSize),new QueryWrapper<Testone>().lambda().eq(Testone::getDeptId,"123"));
        List<Testone> testoneList = testoneIPage.getRecords();
        testoneList.forEach(System.out::println);
        //总页数
        long allPageNum = testoneIPage.getPages();
        System.out.println(allPageNum);
    }

    @Test
    public void update(){
        Testone testone = testoneService.getById(1);
        testone.setName("test");
        testoneService.updateById(testone);
    }
}
