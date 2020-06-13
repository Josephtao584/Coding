package io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO服务端
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        //1.serverSelector轮询是否有新的链接，有了之后绑定在clientSelector
        Selector serverSelector = Selector.open();
        //2.clientSelector轮询是否客户端有新数据可读
        Selector clientSelector = Selector.open();
        new Thread(() ->{
            try{
                ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                listenerChannel.socket().bind(new InetSocketAddress(3333));
                listenerChannel.configureBlocking(false);
                listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);
                while (true){
                    //检测是否有新的连接
                    if(serverSelector.select(1) > 0){
                        Set<SelectionKey> set = serverSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();
                        while (keyIterator.hasNext()){
                            SelectionKey key = keyIterator.next();
                            if(key.isAcceptable()){
                                try{
                                    SocketChannel clientChannel = ((ServerSocketChannel)key.channel()).accept();
                                    clientChannel.configureBlocking(false);
                                    clientChannel.register(clientSelector, SelectionKey.OP_READ);
                                }finally {
                                    keyIterator.remove();
                                }
                            }
                        }
                    }

                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }).start();
        new Thread(() ->{
            try {
                while (true) {
                    //批量轮询有哪些数据可读
                    if (clientSelector.select(1) > 0) {
                        Set<SelectionKey> set = clientSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();
                        while (keyIterator.hasNext()){
                            SelectionKey key = keyIterator.next();
                            if(key.isReadable()){
                                try {
                                    SocketChannel clientChannel = (SocketChannel)key.channel();
                                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                    //面向buffer操作
                                    clientChannel.read(byteBuffer);
                                    byteBuffer.flip();
                                    System.out.println(
                                            Charset.defaultCharset().newDecoder().decode(byteBuffer).toString()
                                    );
                                }finally {
                                    keyIterator.remove();
                                    key.interestOps(SelectionKey.OP_READ);
                                }
                            }
                        }
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }).start();
    }
}
