package example.app;

import java.net.URI;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

public class App {
    
    Server server;
    
    public void start() throws Exception {
        final int port = 8080;
        final String httpHost = "localhost";
        final String path = "/test";
        
        final URI appUri = URI.create(String.format("http://%s:%d", httpHost, port));
        
        server = JettyHttpContainerFactory.createServer(appUri, new MyApplication(), false);

        // Wrapping handler required to scope the resources under desired context
        final ContextHandler handler = new ContextHandler();
        handler.setContextPath(path);
        handler.setHandler(server.getHandler());
        server.setHandler(handler);
        server.start();
        System.out.println("Server has been started at: " + server.getURI());
    }
    
    public void stop() throws Exception {
        if (server != null) {
            server.stop();
            System.out.println("Server has been stoped.");
        }
    }
    
    /**
     * Main function. It is provided as a convenience for running directly through a an IDE.
     */
    public static void main(final String[] args) throws Exception {
        try {
            System.out.println("Starting...");
            final App app = new App();
            app.start();
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    System.out.println("Stopping");
                    try {
                        app.stop();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("Stopped");
                }
            });
            System.out.println("Started (CTRL+D to stop)");
            while (System.in.read() != -1) {
                Thread.sleep(100);
            }
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            System.exit(-1);
        } finally {
            System.exit(0);
        }
    }
    
}
