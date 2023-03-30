package demo.restfulWebService.model.commandModel;

public enum Position {

    JUNIOR ("Junior"),
    MIDDLE ("MIDDLE"),
    SENIOR ("SENIOR"),
    MANAGER ("Manager");

    private String title;

    Position(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
