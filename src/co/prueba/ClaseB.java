package co.prueba;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class ClaseB {

	public static int cont;

	public void saludar(Lock lock) {
		try {
			lock.lock();

			System.out.println("inicio..");
			Thread.sleep(3_000);
			System.out.println("fin..");

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
	}

	public static synchronized void saludar_Estatico() {
		try {

			System.out.println("inicio estatico..");
			Thread.sleep(3_000);
			System.out.println("fin estatico..");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String... args) throws Exception {

		try(var input = new BufferedInputStream(new FileInputStream("D:/OCP17_IO/Filea.txt"));
				var output = new BufferedOutputStream(new FileOutputStream("D:/OCP17_IO/Fileb.txt"))){
			
			byte[] buffered = new byte[1024];
			
			int readed;
			while((readed = input.read(buffered))>0) {
				output.write(buffered,0,readed);
			}
		}
		

	}
}
