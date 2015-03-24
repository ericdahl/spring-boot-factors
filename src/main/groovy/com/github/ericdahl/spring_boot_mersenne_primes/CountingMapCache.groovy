package com.github.ericdahl.spring_boot_mersenne_primes

import org.springframework.boot.actuate.metrics.CounterService
import org.springframework.cache.Cache
import org.springframework.cache.concurrent.ConcurrentMapCache

class CountingMapCache implements Cache {

    final ConcurrentMapCache concurrentMapCache
    final CounterService counterService

    CountingMapCache(String name, CounterService counterService) {
        concurrentMapCache = new ConcurrentMapCache(name)
        this.counterService = counterService
    }

    @Override
    String getName() {
        return concurrentMapCache.getName()
    }

    @Override
    Object getNativeCache() {
        return concurrentMapCache.getNativeCache()
    }

    @Override
    Cache.ValueWrapper get(Object key) {
        Cache.ValueWrapper value = concurrentMapCache.get(key)
        increment(value ? "hits" : "misses")
        return value
    }

    @Override
    def <T> T get(Object key, Class<T> type) {
        T value = concurrentMapCache.get(key, type)
        increment(value ? "hits" : "misses")
        return value
    }

    @Override
    void put(Object key, Object value) {
        concurrentMapCache.put(key, value)
        increment("puts")
    }

    @Override
    Cache.ValueWrapper putIfAbsent(Object key, Object value) {
        if (null == concurrentMapCache.get(key)) {
            increment("puts")
            put(key, value)
        }
        return null
    }

    @Override
    void evict(Object key) {
        concurrentMapCache.evict(key)
    }

    @Override
    void clear() {
        concurrentMapCache.clear()
    }

    private increment(String metric) {
        counterService.increment("cache." + concurrentMapCache.name + "." + metric)
    }
}
