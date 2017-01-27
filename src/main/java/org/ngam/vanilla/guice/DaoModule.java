package org.ngam.vanilla.guice;

import com.google.inject.AbstractModule;
import org.ngam.vanilla.dao.AbstractConnectionFactory;
import org.ngam.vanilla.dao.ConnectionFactory;
import org.ngam.vanilla.dao.VanillaDAO;
import org.ngam.vanilla.dao.VanillaDAO_mysqldbImpl;

/**
 * Created by phoenix on 15/11/16.
 */
public class DaoModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(VanillaDAO.class).to(VanillaDAO_mysqldbImpl.class);
        bind(AbstractConnectionFactory.class).to(ConnectionFactory.class);
    }
}
