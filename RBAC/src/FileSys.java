import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileSys {
    private Directory home; // chiamo home la directory principale che conterrà tutto
    private final String filename = "fileSys.json"

    public FileSys() {
        ObjectMapper om = new ObjectMapper();
        om.readValue(new File(filename), Directory.class);
    }

    public Directory getHome() {
        return home;
    }

    public Directory goTo(String path) {
        return home.getDirectory(path);
    }
}
