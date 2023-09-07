/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.SmartWaste;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 *
 * @author Pedro Augusto
 */
@Configuration
public class DataConfiguration {
    
    //Método que identificar as informações do banco de dados que vamos utilizar
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/smartwaste");
        dataSource.setUsername("root");
        dataSource.setPassword("ifbairece01");
        return dataSource;
    }
    
    //Método que cria conexão com o hibernate
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        //Abaixo é definido o tipo de database que estamos utilizando
        adapter.setDatabase(Database.MYSQL);
        //Abaixo é a configuração de mostrar informações do que está sendo feito
        // no BD no console da IDE
        adapter.setShowSql(true);
        //Abaixo permite que o hibernate crie as tabelas automaticamente
        adapter.setGenerateDdl(true);
        //Abaixo é definido o dialeto que será utilizado
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        //Abaixo é definido para que o hibernate prepare a conexão automaticamente
        adapter.setPrepareConnection(true);
        return adapter;
    }
}
