上面我们看了CGLib动态代理的用法、实际生成的代理类以及FastClass机制，主要的调用步骤；

第一步：是经过一系列操作实例化出了Enhance对象，并设置了所需要的参数然后enhancer.create()成功创建出来了代理对象，这个就不多说了...

第二步：调用代理对象的方法，会进入到方法拦截器的intercept（）方法，在这个方法中会调用proxy.invokeSuper(obj, args);方法

第三步：invokeSuper中，通过FastClass机制调用目标类的方法

方法拦截器中只有一个invoke方法，这个方法有四个参数，obj表示代理对象，method表示目标类中的方法，args表示方法参数，proxy表示代理方法的MethodProxy对象