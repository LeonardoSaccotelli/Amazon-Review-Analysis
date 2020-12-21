package amazon.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
@Document(collection="ElectronicsReview")
public class ElectronicsReview {
    @Id
    private String id;
    private int overall;
    private String vote;
    private boolean verified;
    private Date reviewTime;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String reviewerID;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String asin;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String reviewerName;
    private String reviewText;
    private String summary;
    private int unixReviewTime;
}

