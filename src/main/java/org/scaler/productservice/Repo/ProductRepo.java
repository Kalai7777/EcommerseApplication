package org.scaler.productservice.Repo;

import org.scaler.productservice.Models.Product;
import org.scaler.productservice.projection.ProductWithTitleAndDescription;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long id);// hibernate automatically write a query to get it.
    Optional<Product> findByTitle(String title);// if you want to find by name
    /*
    the chance of null pointer is increases here, so we are using optional here. sometime it can return null
    pointer exception
     */

    //SELECT *  FROM Product WHERE title="" AND description=""
    List<Product> findByTitleAndDescription(String title, String description);

    /*
    To update or save the product.
    We use save method as absurd method
    absurd meaning update if the product is present or insert
     */
    Product save(Product product);


    // HQL

    @Query("select p.title as title, p.description as description from  Product p where p.id=:id") //to tell this is a querry
    ProductWithTitleAndDescription someRandomQuery(@Param("id") Long id);


    // SQL

    @Query(value = "select title, description from product where id = :id", nativeQuery = true)
    ProductWithTitleAndDescription someRandomQuery2(@Param("id") Long id);

    Page<Product> findAll(Pageable pageable);
}
