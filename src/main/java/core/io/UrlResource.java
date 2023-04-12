package core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author quincy
 * @create 2023 - 04 - 12 21:13
 */
public class UrlResource implements Resource{

    private final URL url;

    public UrlResource(URL url) {
        this.url = url;
    }


    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection con = this.url.openConnection();
        try {
            return con.getInputStream();
        } catch (IOException ex) {
            throw ex;
        }

    }
}
