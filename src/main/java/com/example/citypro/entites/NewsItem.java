package com.example.citypro.entites;


import java.time.LocalDateTime;

public class NewsItem {
    private String content;
    private LocalDateTime timestamp;
    private String link;

    public NewsItem(String content, LocalDateTime timestamp, String link) {
        this.content = content;
        this.timestamp = timestamp;
        this.link = link;
    }

    // getter 和 setter 方法
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    // toString 方法（可选）
    @Override
    public String toString() {
        return "NewsItem{" +
                "content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", link='" + link + '\'' +
                '}';
    }
}