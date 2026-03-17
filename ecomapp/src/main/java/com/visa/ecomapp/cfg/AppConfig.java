package com.visa.ecomapp.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableCaching
@EnableScheduling
public class AppConfig {

    @Autowired
    CacheManager cacheManager;

    @Scheduled(fixedRate = 1000l)
//    @Scheduled(cron = "*/30 * * * *")
    public void doTask() {
        System.out.println("Called doTask...");
        cacheManager.getCacheNames().forEach(cache -> {
           cacheManager.getCache(cache).clear();
        });
    }
}
