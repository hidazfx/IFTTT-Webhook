package docx.ifttt.webhooks;

import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

public class IFTTTWebhook {
	private static String HTTPOutput = null;
	public static void callWebhook(String WebHook, String Key){
        String url = "https://maker.ifttt.com/trigger/" + WebHook + "/with/key/" + Key;
        InputStream in = null;

        try {
            HttpClient client = new HttpClient();
            PostMethod method = new PostMethod(url);

            int statusCode = client.executeMethod(method);

            if (statusCode != -1) {
                in = method.getResponseBodyAsStream();
            }
            System.out.println(method.getResponseBodyAsString());
            HTTPOutput = method.getResponseBodyAsString();
            System.out.println(in);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
	
	public static String getWebhookOutput() {
		return HTTPOutput;
		
	}
}
