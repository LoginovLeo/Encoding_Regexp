import org.apache.any23.encoding.TikaEncodingDetector;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.txt.TXTParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetEncoding {

    public static void main(String[] args) throws IOException, TikaException, SAXException {

        FileInputStream getStream = new FileInputStream(new File("C:\\Users\\Leonid\\Desktop\\Test1.txt"));
       // getEncoding(getStream);
        regexp();

    }
    public static void getEncoding(FileInputStream fileStream) throws TikaException, SAXException, IOException {
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadataOfFile = new Metadata();
        ParseContext parseContext = new ParseContext();


        TXTParser TexTParser = new TXTParser();
        TexTParser.parse(fileStream, handler, metadataOfFile, parseContext);
        System.out.println("Contents of the document:" + handler);
        System.out.println("Metadata of the document:");
        String[] metadataNames = metadataOfFile.names();

        for (String name : metadataNames) {
            System.out.println(name + " : " + metadataOfFile.get(name));
        }
    }

    public static void regexp(){

        String test = "Hello Java! Hello JavaScript! 152869JavaSE3192.168.2.1 may be 123-455-548-52 ip. orr 19.32.68.2 and correct ISBN 978-3-16-14841-0";
        Pattern ipRegexp = Pattern.compile("([0-9]{1,3}[.]){3}[0-9]{1,3}|\\d{6}|\\d{3}-\\d{3}-\\d{3}-\\d{2}|((978|979)[-0-9]{1,5}[-0-9]{1,7}[-0-9]{1,7}[-0-9])");
        Matcher matcher = ipRegexp.matcher(test);
        while(matcher.find())
            System.out.println(matcher.group());
    }
}




