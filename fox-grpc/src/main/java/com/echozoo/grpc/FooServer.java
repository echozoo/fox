package com.echozoo.grpc;

import com.echozoo.grpc.anotation.GrpcService;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

/**
 * gppc server
 *
 * @author dujf
 * @version 1.0
 * @date 2021/7/25 22:45
 */
@GrpcService
@Service
public class FooServer extends FooServiceGrpc.FooServiceImplBase {

    @Override
    public void listFoo(Foo.FooInput request, StreamObserver<Foo.FooOutput> responseObserver) {
        final Foo.FooOutput output =
                Foo.FooOutput.newBuilder().setMessage(request.getName() + ":" + System.currentTimeMillis()).build();
        responseObserver.onNext(output);
        responseObserver.onCompleted();
    }
}
