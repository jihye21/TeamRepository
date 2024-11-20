package ThreadTest;

public class Ex02 {

	public static void main(String[] args) {
		MyThread thread01 = new MyThread("Thread-1");
		MyThread thread02 = new MyThread("Thread--2");
		MyThread thread03 = new MyThread("Thread---3");
		MyThread thread04 = new MyThread("Thread----4");
		thread01.start();
		thread02.start();
		thread03.start();
		thread04.start();
	}
	
}

class MyThread extends Thread{
	
	String name;
	public MyThread(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		long beforeTime = System.currentTimeMillis();
		int sum = 0;
		for(int i = 0; i <30000; i++) {
			for(int j = 0; j <5000; j ++)
			sum += i * j;
			System.out.println(name);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(sum);
		
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime)/1000;
		System.out.println("시간차이: " + secDiffTime);
	}
}
