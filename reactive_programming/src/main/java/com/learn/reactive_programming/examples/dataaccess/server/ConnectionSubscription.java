package com.learn.reactive_programming.examples.dataaccess.server;

import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscription;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
//import rx.Subscription;

public class ConnectionSubscription implements Disposable {
    
    private final Connection connection;
    private final HashSet<Statement> statements = new HashSet<>();
    private final HashSet<ResultSet> resultSets = new HashSet<>();

    public ConnectionSubscription(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void dispose() {
        resultSets.stream().forEach((rs) -> {
            try { rs.close(); } catch( SQLException t ) {}
        });
        statements.stream().forEach((s) -> {
            try { s.close(); } catch( SQLException t ) {}
        });
        
        if( connection != null ) {
            try { connection.close(); } catch( SQLException e ) {}
        }
    }

    @Override
    public boolean isDisposed() {
        return true;
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void registerResourceForClose( Statement s ) {
        if( s == null ) {
            throw new IllegalArgumentException();
        }
        
        statements.add(s);
    }

    public void registerResourceForClose( ResultSet rs ) {
        if( rs == null ) {
            throw new IllegalArgumentException();
        }
        resultSets.add(rs);
    }
}
