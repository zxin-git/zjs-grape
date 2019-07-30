package com.zxin.java.spring.sentinel;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

@RestController
public class SentinelResourceController{
	
	private static final Logger logger = LoggerFactory.getLogger(SentinelResourceController.class);
	
	@GetMapping(value = "/hello")
    @SentinelResource("hello")
    public String hello() {
        return "Hello Sentinel";
    }
	
	static {
		initFlowRules();
	}
	
	private static void initFlowRules(){
	    List<FlowRule> rules = new ArrayList<>();
	    FlowRule rule = new FlowRule();
	    rule.setResource("hello");
	    rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
	    // Set limit QPS to 20.
	    rule.setCount(1);
	    rules.add(rule);
	    FlowRuleManager.loadRules(rules);
	}
}