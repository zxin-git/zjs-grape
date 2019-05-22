/**
 * 
 * 默认实现 为ConcurrentHashMap
 * redis需加入spring-data-redis
 * echache需加入spring-cache和ehcache.jar
 * 
 * key与keyGen定义key命名方式
 * sync定义是否多线程同步
 * 
 * {@link org.springframework.cache.annotation.CacheConfig(cacheNames = {"namespace"})}
 * 定义对象级别的命名空间
 * 
 */
/**
 * @author zxin
 *
 */
package com.zxin.java.spring.cache;

