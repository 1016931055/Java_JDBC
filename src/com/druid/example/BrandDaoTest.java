package com.druid.example;

import org.junit.Test;

import java.util.List;

public class BrandDaoTest {

    //查询所有
    @Test
    public void testfindAllBrand() throws Exception {

        BrandDao brandDao = new BrandDao();
        List<Brand> brandList = brandDao.findAllBrand();

        for (Brand brand : brandList) {
            System.out.println(brand);
        }
    }
    //添加

    //修改

    //删除
}
