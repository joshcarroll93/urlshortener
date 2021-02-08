package com.assignment.urlshortener.urlshortener;

import com.assignment.urlshortener.urlshortener.model.URLMap;
import org.springframework.data.repository.CrudRepository;

public interface URLRepository extends CrudRepository<URLMap, Long> {
}
