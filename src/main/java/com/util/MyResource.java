package com.util;

/**
 * @author cc
 * @date 2023/6/30-15:26
 */

    public class MyResource {
        // 假设这是需要进行资源释放的类

        public MyResource() {
            // 初始化资源
            System.out.println("Initializing resource");
        }

        @Override
        protected void finalize() throws Throwable {
            try {
                // 资源释放操作
                System.out.println("Finalizing resource");
            } finally {
                super.finalize();
            }
        }

        public static void main(String[] args) throws InterruptedException {
            // 创建MyResource对象
            MyResource resource = new MyResource();

            // 模拟对象不再被引用
            resource = null;
            Thread.sleep(30000);

            // 垃圾回收器在适当的时间调用finalize()方法进行资源释放
//            System.gc();
        }


}
