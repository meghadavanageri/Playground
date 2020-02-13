package Model;

public class ExampleItem {
    private String mtextview;
    private String mimageview;

    public ExampleItem(String mtextview, String mimageview) {
        this.mtextview = mtextview;
        this.mimageview = mimageview;
    }

    public String getMtextview() {
        return mtextview;
    }

    public void setMtextview(String mtextview) {
        this.mtextview = mtextview;
    }

    public String getMimageview() {
        return mimageview;
    }

    public void setMimageview(String mimageview) {
        this.mimageview = mimageview;
    }
}
