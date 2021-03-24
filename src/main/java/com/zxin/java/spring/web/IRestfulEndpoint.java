package com.zxin.java.spring.web;


import com.zxin.java.spring.web.bean.PageRequest;
import com.zxin.java.spring.web.bean.PageResponse;
import com.zxin.java.spring.web.bean.ResultHelper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IRestfulEndpoint<Query, Request, Response> {

    @DeleteMapping("/{id}")
    ResultHelper<Void> deleteById(@PathVariable Long id);

    @GetMapping("/{id}")
    ResultHelper<Response> getById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResultHelper<Void> updateById(@PathVariable Long id, @RequestBody Request request);

    @PostMapping
    ResultHelper<Long> insert(@RequestBody Request request);

    @GetMapping("/page")
    ResultHelper<PageResponse<Response>> listByPage(Query query, PageRequest pageRequest);

    @GetMapping
    ResultHelper<List<Response>> list(Query query);
}
