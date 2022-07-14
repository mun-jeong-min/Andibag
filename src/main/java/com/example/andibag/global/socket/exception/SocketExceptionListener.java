package com.example.andibag.global.socket.exception;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.ExceptionListener;
import com.example.andibag.global.error.ErrorResponse;
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
        final ErrorResponse message;

        if (e instanceof ProjectException) {
            ProjectException projectException = (ProjectException) e;

            message = ErrorResponse.builder()
                    .message(projectException.getErrorCode().getMessage())
                    .status(projectException.getErrorCode().getStatus())
                    .build();
        } else if (e.getCause() instanceof ProjectException) {
            ProjectException projectException = (ProjectException) e.getCause();

            message = ErrorResponse.builder()
                    .message(projectException.getErrorCode().getMessage())
                    .status(projectException.getErrorCode().getStatus())
                    .build();
        } else {
            e.printStackTrace();
            message = ErrorResponse.builder()
                    .status(500)
                    .message("SERVER error")
                    .build();
        }
        client.sendEvent(SocketProperty.ERROR_KEY, message);
    }
}
