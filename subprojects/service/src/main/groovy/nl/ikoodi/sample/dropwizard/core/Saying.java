package nl.ikoodi.sample.dropwizard.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.joda.time.DateTime;

public class Saying {
    private long id;

    @Length(max = 3)
    private String content;

    private DateTime time;

    public Saying() {
        // jackson deserialization
    }

    public Saying(long id, String content, DateTime time) {
        this.id = id;
        this.content = content;
        this.time = time;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

    @JsonProperty
    public DateTime getTime() {
        return time;
    }
}
