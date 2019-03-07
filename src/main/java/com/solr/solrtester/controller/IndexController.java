package com.solr.solrtester.controller;

import com.solr.solrtester.model.SerchModel;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {


    @RequestMapping("/")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @RequestMapping("/serch")
    public ModelAndView serch(String keyword) throws IOException, SolrServerException {

        String url = "http://localhost:8080/solr/new_core";
        HttpSolrClient client = new HttpSolrClient.Builder(url).build();
        // 创建SolrQuery
        SolrQuery query = new SolrQuery();
        // 输入查询条件
        query.setQuery("username:"+keyword+"*");
        // 执行查询并返回结果
        QueryResponse response = client.query(query);
        // 获取匹配的所有结果
        SolrDocumentList list = response.getResults();
        // 匹配结果总数
        long count = list.getNumFound();
        List<SerchModel> smlist = SerchModel.build(list,count);


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");
        modelAndView.addObject("smlist",smlist);
        modelAndView.addObject("count",count);
        return modelAndView;
    }
}
