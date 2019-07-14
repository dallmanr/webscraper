package com.dallman.webscraper.repositories;

import com.dallman.webscraper.sites.Site;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

@Repository
public interface SiteRepository extends CrudRepository<Site, Serializable> {

    @Query(value = "SELECT websites.id, websites.website_name, websites.website_url, websites.website_parsed FROM websites", nativeQuery = true)
    @Transactional(readOnly = true)
    Collection<Site> findAll();

    @Query(value = "SELECT * FROM websites where websites.id =:id", nativeQuery = true)
    @Transactional(readOnly = true)
    Optional<Site> findBySiteId(@Param("id") Integer id);

//    @Modifying
//    @Query(value = "INSERT INTO websites (website_url, website_name, website_parsed) values (:websiteUrl, :websiteName, :websiteParsed)", nativeQuery = true)
//    void addNewSite(@Param("url") String url, @Param("name") String name, @Param("parsed") String parsed);

    //    @Transactional
//    @Modifying
//    @Query(value = "INSERT INTO websites (website_url, website_parsed) values ")
    Site save(Site site);
//    Site update(Site entity);
//    void delete(Site entity);
//    Site findById(ID id);
//    void flush();
}
