package com.experts.core.biller.statemachine.api.activemq.standers.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.atomikos.jms.AtomikosConnectionFactoryBean;
/*import com.mysql.cj.jdbc.MysqlXADataSource;*/
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import co.insight.starter.firebase.config.DatabaseConfigurationStarter;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.artemis.jms.client.ActiveMQXAConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.annotation.PostConstruct;
import javax.jms.ConnectionFactory;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = {"com.experts.core.biller.statemachine.api.gigaspace.daos.repo","com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company",
        "com.experts.core.biller.statemachine.api.gigaspace.daos.repo.contact","com.experts.core.biller.statemachine.api.gigaspace.daos.repo.crm","com.experts.core.biller.statemachine.api.gigaspace.daos.repo.employees",
        "com.experts.core.biller.statemachine.api.gigaspace.daos.repo.fastfood","com.experts.core.biller.statemachine.api.gigaspace.daos.repo.hr","com.experts.core.biller.statemachine.api.gigaspace.daos.repo.inventory",
        "com.experts.core.biller.statemachine.api.gigaspace.daos.repo.jira","com.experts.core.biller.statemachine.api.gigaspace.daos.repo.notifications"})
@EnableJpaAuditing
@EntityScan(basePackages = {"com.experts.core.biller.statemachine.api.web.syslog.security.model","com.experts.core.biller.statemachine.api.model.domain.jpa"})
@EnableTransactionManagement
public class CustomerConfig {
    private final Logger log = LoggerFactory.getLogger(DatabaseConfigurationStarter.class);

    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;

    @Autowired
    private  Environment env;

    @Bean
    @Primary
    public DataSource dataSourcePrimary() throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setURL("jdbc:mysql://localhost:3306/pdpserver?serverTimezone=UTC");
        mysqlXaDataSource.setUser("root");
        mysqlXaDataSource.setPassword("opc@2018");
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("datasource_biller_master");
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(dropSchema);
        populator.execute(xaDataSource);
        return xaDataSource;
    }

    @Bean
    @Primary
    public ConnectionFactory connectionFactory() throws Exception {
        BrokerService brokerService = new BrokerService();
        brokerService.setPersistent(false);
        brokerService.setUseJmx(false);
        brokerService.setAdvisorySupport(false);
        brokerService.setSchedulerSupport(false);
        TransportConnector connector = brokerService.addConnector("vm://localhost");
        brokerService.start();
        String connectionUri = connector.getPublishableConnectString();
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(connectionUri);
        ActiveMQXAConnectionFactory activeMQXAConnectionFactory = new ActiveMQXAConnectionFactory(connectionUri);
        activeMQXAConnectionFactory.setUser(DistTxConstants.USERNAME);
        activeMQXAConnectionFactory.setPassword(DistTxConstants.PASSWD);
        AtomikosConnectionFactoryBean atomikosConnectionFactoryBean = new AtomikosConnectionFactoryBean();
        atomikosConnectionFactoryBean.setUniqueResourceName(DistTxConstants.UNIQUE_RESOURCE_NAME_MESSAGE_QUEUE);
        atomikosConnectionFactoryBean.setLocalTransactionMode(false);
        atomikosConnectionFactoryBean.setXaConnectionFactory(activeMQXAConnectionFactory);
        atomikosConnectionFactoryBean.setMinPoolSize(25);
        atomikosConnectionFactoryBean.setMaxPoolSize(50);
        return atomikosConnectionFactoryBean;
    }

    @Bean("transactionManager")
    @Primary
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    private Properties props() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        return properties;
    }

    @Bean("entityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        final LocalContainerEntityManagerFactoryBean build = new LocalContainerEntityManagerFactoryBean();
        build.setPackagesToScan("com.experts.core.biller.statemachine.api.model.domain.jpa,com.experts.core.biller.statemachine.api.web.syslog.security.model");
        build.setPersistenceUnitName("EXPERTS-MYSQL");
        build.setPersistenceXmlLocation("classpath:META-INF/persistence-dev.xml");
        HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.transaction.jta.platform", AtomikFactoryBean.class.getName());
        properties.put("javax.persistence.transactionType", "JTA");
        build.setJtaDataSource(dataSourcePrimary());
        build.setJpaVendorAdapter(hibernateJpaVendorAdapter());
        return build;
    }

    @Bean("managerCoreFactory")
    @Order(-1000)
    public LocalContainerEntityManagerFactoryBean managerCoreFactory() throws SQLException {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        final LocalContainerEntityManagerFactoryBean build = new LocalContainerEntityManagerFactoryBean();
        build.setPackagesToScan("com.experts.core.biller.statemachine.api.model.domain.jpa,com.experts.core.biller.statemachine.api.web.syslog.security.model");
        build.setPersistenceUnitName("EXPERTS-MYSQL");
        build.setPersistenceXmlLocation("classpath:META-INF/persistence-dev.xml");
        HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.transaction.jta.platform", AtomikFactoryBean.class.getName());
        properties.put("javax.persistence.transactionType", "JTA");
        build.setJtaDataSource(dataSourcePrimary());
        build.setJpaVendorAdapter(hibernateJpaVendorAdapter());
        return build;
    }

    @Bean
    public JpaVendorAdapter hibernateJpaVendorAdapter() {
        final HibernateJpaVendorAdapter jpaAdapter = new HibernateJpaVendorAdapter();
        jpaAdapter.setShowSql(true);
        return jpaAdapter;
    }

    @Bean
    public DataSource dataSource() throws SQLException{
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/pdpserver?serverTimezone=UTC");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("opc@2018");
        hikariConfig.setDataSource(dataSourceSlave());
        hikariConfig.setMaximumPoolSize(5);
        hikariConfig.setConnectionTestQuery("SELECT 1");
        hikariConfig.setPoolName("springHikariCP");
        hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
        hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(dropSchema);
        populator.execute(dataSource);
        return dataSource;
    }

    @Bean("dataSourceSlave")
    @Qualifier("dataSourceSlave")
    public DataSource dataSourceSlave() throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setURL("jdbc:mysql://localhost:3306/pdpserver?serverTimezone=UTC");
        mysqlXaDataSource.setUser("root");
        mysqlXaDataSource.setPassword("opc@2018");
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("datasource_slave");
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(dropSchema);
        populator.execute(xaDataSource);
        return xaDataSource;
    }

    @Value("classpath:org/springframework/batch/core/schema-mysql.sql")
    private Resource schemaScript;

    @Value("classpath:org/springframework/batch/core/schema-drop-mysql.sql")
    private Resource dropSchema;

    @Bean
    public DataSourceInitializer dataSourceInitializer() throws SQLException {
        final DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource());
        initializer.setDatabasePopulator(databasePopulator());
        return initializer;
    }

    private DatabasePopulator databasePopulator() throws SQLException {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(dropSchema);
        populator.execute(dataSource());
        return populator;
    }
}
