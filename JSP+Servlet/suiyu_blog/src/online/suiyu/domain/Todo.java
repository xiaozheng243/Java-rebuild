package online.suiyu.domain;

public class Todo {
    private int id;
    private String content;
    private boolean finished;

    public Todo() {
    }

    public Todo(int id, String content, boolean finished) {
        this.id = id;
        this.content = content;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", finished=" + finished +
                '}';
    }
}