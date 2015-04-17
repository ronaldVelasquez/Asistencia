package inei.asistencia;

/**
 * Created by Cr-Diego on 15/04/2015.
 */
public class DrawerItem {
    private String title;
    private int icon;
    private int logo;

    public DrawerItem(String title, int icon) {
        this.title = title;
        this.icon = icon;

    }

    public DrawerItem(int logo) {
        this.logo = logo;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
