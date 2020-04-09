package com.example.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.entity.ProductAttributeValue;
import com.example.demo.mapper.ProductAttributeValueMapper;
import com.example.demo.service.IProductAttributeValueService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 存储产品参数信息的表 服务实现类
 * </p>
 *
 * @author Zhang@Jowim.com
 * @since 2020-03-21
 */
@Service
public class ProductAttributeValueServiceImpl extends ServiceImpl<ProductAttributeValueMapper, ProductAttributeValue> implements IProductAttributeValueService {

}
