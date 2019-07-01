package com.app.chat;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

public class A {
	
	public static void sliceTest() {
		Charset utf8 = Charset.forName("UTF-8");
		ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8); //1
		ByteBuf sliced = buf.slice(0, 14);          //2
		System.out.println(sliced.toString(utf8));  //3

		buf.setByte(0, (byte) 'J');                 //4
		//assert buf.getByte(0) == sliced.getByte(0);
		
		System.out.println(buf.toString(utf8));
	}
	
	public static void testcopyTest() {
		Charset utf8 = Charset.forName("UTF-8");
		ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);     //1

		ByteBuf copy = buf.copy(0, 14);               //2
		System.out.println(copy.toString(utf8));      //3

		buf.setByte(0, (byte) 'J');                   //4
		System.out.println(buf.toString(StandardCharsets.UTF_8));
	}
	
	public static void getTest() {
		Charset utf8 = Charset.forName("UTF-8");
		ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);    //1
		System.out.println((char)buf.getByte(0));                    //2

		int readerIndex = buf.readerIndex();                        //3
		int writerIndex = buf.writerIndex();
		System.out.println("readerIndex:"+readerIndex);
		System.out.println("writerIndex:"+writerIndex);
		buf.setByte(0, (byte)'B');                            //4

		System.out.println((char)buf.getByte(0));                    //5
		assert readerIndex == buf.readerIndex();                    //6
		assert writerIndex ==  buf.writerIndex();
	}
	
	
	public static void testread() {
		Charset utf8 = Charset.forName("UTF-8");
		ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);    //1
		System.out.println((char)buf.readByte());                    //2

		int readerIndex = buf.readerIndex();                        //3
		int writerIndex = buf.writerIndex();                        //4
		System.out.println("readerIndex:"+readerIndex);
		System.out.println("writerIndex:"+writerIndex);
		buf.writeByte((byte)'?');                            //5
		
		int readerIndexx = buf.readerIndex();                        //3
		int writerIndexx = buf.writerIndex();  
		System.out.println("readerIndex:"+readerIndexx);
		System.out.println("writerIndex:"+writerIndexx);
	}
	
	public static void testByteBufHolder() {
		Channel ch=null;
		ByteBufAllocator alloc = ch.alloc();
		ByteBuf buffer = alloc.buffer();
		int capacity = buffer.capacity();
		System.out.println(capacity);
	}

	public static void main(String[] args) {
		testByteBufHolder();
	}

}
