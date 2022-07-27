package com.example.andibag.global.socket.exception;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.ExceptionListener;
import com.example.andibag.global.error.ErrorResponse;
import com.example.andibag.global.error.exception.ErrorCode;
import com.example.andibag.global.error.exception.ProjectException;
import com.example.andibag.global.socket.SocketProperty;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SocketExceptionListener implements ExceptionListener {
    @Override
    public void onEventException(Exception e, List<Object> args, SocketIOClient client) {
        runExceptionHandling(e, client);
    }

    @Override
    public void onDisconnectException(Exception e, SocketIOClient client) {
        runExceptionHandling(e, client);
    }

    @Override
    public void onConnectException(Exception e, SocketIOClient client) {
        runExceptionHandling(e, client);
        client.disconnect();
    }

    @Override
    public void onPingException(Exception e, SocketIOClient client) {
        runExceptionHandling(e, client);
    }

    @Override
    public boolean exceptionCaught(ChannelHandlerContext ctx, Throwable e) throws Exception {
        return false;
    }

    private void runExceptionHandling(Exception e, SocketIOClient client) {
        final ErrorCode errorCode;

        if (e.getCause() instanceof ProjectException) {
            errorCode = ((ProjectException) e.getCause()).getErrorCode();
        } else {
            errorCode = ErrorCode.SERVER_ERROR;
        }
        ErrorResponse message = ErrorResponse.builder()
                        .status(errorCode.getStatus())
                        .message(errorCode.getMessage())
                        .build();

        client.sendEvent(SocketProperty.ERROR_KEY, message);
    }
}
