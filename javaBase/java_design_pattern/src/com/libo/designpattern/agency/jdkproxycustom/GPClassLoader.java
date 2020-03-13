package com.libo.designpattern.agency.proxycustom;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * 自定义类加载器
 */
public class GPClassLoader extends ClassLoader {
    private File classPathFile;

    public GPClassLoader() {
        String path = GPClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(path);
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        String className = GPClassLoader.class.getPackage().getName() + "." + name;
        if (classPathFile != null) {
            File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()) {
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                out = new ByteArrayOutputStream();
                try {
                    in = new FileInputStream(classFile);

                    int len;
                    byte[] buff = new byte[1024];
                    while ((len = in.read(buff)) != -1) {
                        out.write(buff, 0, len);
                    }
                    return defineClass(className, out.toByteArray(), 0, out.size());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (in != null) {
                            in.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        if (out != null) {
                            out.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

}

