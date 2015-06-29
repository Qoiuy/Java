/**
 * Thread.run方法
 * 创建一个线程
 * Thread.start方法
 * 执行run方法调用线程
 * Thread.currentThread()方法
 * 返回当前进程的名称
 * Class.getName()方法
 * 返回线程的名称
 * 
 */

/**
 * 创建一个线程的第一种方法 继承Thread类
 * 1.定义一个类继承Thread类
 * 2.覆盖Thread类中的run方法
 * 3.直接创建Thread的子类对象创建线程
 * 4.调用start方法开启线程并调用线程的任务run方法执行
 * */

/**
 * 创建一个线程的第二种方法 实现Thread类的Runnable接口
 * 1.定义类实现Runnable接口
 * 2.覆盖接口中的run方法
 * 3.通过thread类创建线程对象
 * 4.将实现了Runnable接口的子类对象作为实际参数传递给Thread类中的构造函数
 * 5.调用Thread对象的start方法
 * */

/**
 * 线程状态
 * 被创建：run()
 * 运行：start()
 * 睡眠：sleep(time)，wait()-notify()不会被CPU执行
 * 临时阻塞状态：会被CPU执行
 * 消亡：stop()线程任务结束
 * */

/**
 * @author root
 *
 */
package Thread;