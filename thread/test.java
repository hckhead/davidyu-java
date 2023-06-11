package thread;

public class test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Runnable task1 = () -> {
			for(int i=0; i < 10; i++) {
				System.out.println("[task1] : " + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		};
		
		Runnable task2 = () -> {
			for(int i=0; i< 10; i++) {
				System.out.println("[task2] : " + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		new Thread(task1).start();
		new Thread(task2).start();
		
		for(int i=0;i<10;i++) {
			System.out.println("[main] : " + i);
			Thread.sleep(500);
		}
	}

}
