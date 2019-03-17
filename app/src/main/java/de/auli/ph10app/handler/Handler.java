package de.auli.ph10app.handler;

import android.widget.ArrayAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.auli.ph10app.util.ApiUrl;

public abstract class Handler extends HttpRequestHandler implements HandlerAble {
    private static final String TAG = Handler.class.getSimpleName();
    private static final String rootUrl = ApiUrl.REMOTE_BASE;
    protected ObjectMapper mapper = new ObjectMapper();

    public Handler(ArrayAdapter adapter, Class clazz) {
        super(adapter, clazz);
    }

    public String createUrl(String url) {
        return String.format(url, Handler.rootUrl);
    }

    public String createUrl(String url, Long id$1) {
        return String.format(url, Handler.rootUrl, id$1);
    }

    public String createUrl(String url, Long id$1, Long id$2) {
        return String.format(url, Handler.rootUrl, id$1, id$2);
    }

    public String createUrl(String url, Long id$1, Long id$2, Long id$3) {
        return String.format(url, Handler.rootUrl, id$1, id$2, id$3);
    }
}
