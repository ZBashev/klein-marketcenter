package com.market.center.marketcenter.repositoies;


import com.market.center.marketcenter.models.entity.ArticleDigitaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleDigitaleRepository extends JpaRepository<ArticleDigitaleEntity, String> {


    ArticleDigitaleEntity findAtricleByItemCode(String itemCode);


    @Query("select a from ArticleDigitaleEntity a where a.digitaleProdukteEnumeration = ?1")
    List<ArticleDigitaleEntity> findAllByDigitaleProdukteEnumeration(Enum enumeration);

    @Query("select a from ArticleDigitaleEntity a where a.itemCode = ?1")
    Optional<String> findByItemCode(String s);


    ArticleDigitaleEntity findEntityById(String id);

    ResponseEntity<ArticleDigitaleEntity> findArticleDigitaleEntityById(String id);


}
