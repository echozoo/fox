package com.echozoo.grpc;

import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * grpc client
 *
 * @author dujf
 * @version 1.0
 * @date 2021/7/24 19:07
 */
@Service
public class FooClient {

    @Autowired
    private ManagedChannel channel;

    public String listFoo(String name) {
        final Foo.FooInput input = Foo.FooInput.newBuilder().setName(name).build();
        final FooServiceGrpc.FooServiceBlockingStub fooServiceBlockingStub = FooServiceGrpc.newBlockingStub(channel);
        final Foo.FooOutput output = fooServiceBlockingStub.listFoo(input);
        return output.getMessage();
    }
}