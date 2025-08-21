package br.edu.ifpr.pgua.eic.tads.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import freemarker.template.Configuration;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinFreemarker;
import io.javalin.rendering.template.JavalinPebble;


public class JavalinUtils {
    
    public static Javalin makeApp(int port){
        
        
        
        
        Javalin app = Javalin.create(config->{
            Configuration conf = new Configuration(Configuration.VERSION_2_3_33);
            conf.setClassForTemplateLoading(JavalinUtils.class, "/public");
            config.fileRenderer(new JavalinFreemarker(conf));
            config.requestLogger.http((ctx, ms) -> {
                System.out.println(ctx.method() +" "+ ctx.fullUrl());
            });
            config.staticFiles.add("public",Location.CLASSPATH);
            
        }).start(port);
        return app;
    }


}

