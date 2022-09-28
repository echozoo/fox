package com.echozoo.fox.service;

import com.echozoo.fox.convert.FooMapper;
import com.echozoo.fox.dao.FooRepository;
import com.echozoo.fox.model.FooDTO;
import com.echozoo.fox.model.FooPO;
import com.echozoo.fox.model.FooVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author dujf
 * @version 1.0
 * @date 2022/9/28 11:18
 */
@Service
public class FooService {

    @Resource
    private FooRepository fooRepository;
    @Resource
    private FooMapper mapper;

    public List<FooVO> list() {
        final List<FooDTO> dtoList = fooRepository.list();
        return dtoList.stream().map(mapper::toVo).collect(Collectors.toList());
    }

    public FooVO detail() {
        return mapper.toVo(fooRepository.detail());
    }
}
