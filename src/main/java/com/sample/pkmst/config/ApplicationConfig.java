package com.sample.pkmst.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.sample.pkmst.controller.ProductController;
import com.sample.pkmst.dao.IProductDao;
import com.sample.pkmst.dao.impl.ProductDaoImpl;
import com.sample.pkmst.services.IProductService;
import com.sample.pkmst.services.impl.ProductServiceImpl;



/**
 * @author Ninod Pillai
 *
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public ProductController productController(final IProductService productService) {
        return new ProductController(productService);
    }

    @Bean
    public IProductService productService(final IProductDao iProductDao) {
        return new ProductServiceImpl(iProductDao);
    }

    @Bean
    public IProductDao productDao(final JdbcTemplate jdbcTemplate) {
        return new ProductDaoImpl(jdbcTemplate);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase embeddedDatabase = embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2)
                .addScript("create-db.sql").addScript("insert-data.sql").build();
        return embeddedDatabase;
    }
}
