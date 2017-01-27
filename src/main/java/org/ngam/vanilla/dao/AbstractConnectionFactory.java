package org.ngam.vanilla.dao;

import java.sql.Connection;

/**
 * Created by phoenix on 15/11/16.
 */
public interface AbstractConnectionFactory {
    Connection get();
}
