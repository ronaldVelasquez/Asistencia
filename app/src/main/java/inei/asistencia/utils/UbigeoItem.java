package inei.asistencia.utils;

/**
 * Created by Cr-Diego on 23/04/2015.
 */
public class UbigeoItem {
    private int image;
    private String title;
    private String description;

    public UbigeoItem(int image, String title, String description) {
        super();
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
