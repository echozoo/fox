package org.volans.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * TODO
 *
 * @author dujf
 * @version 1.0
 * @date 2022/12/23 18:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Content {
    private Long id;
    private String uuid;
    private String hitokoto;
    private String type;
    private String from;

    @JsonProperty("from_who")
    private String fromWho;

    private String creator;

    @JsonProperty("creator_uid")
    private Long creatorUid;

    private Long reviewer;

    @JsonProperty("commit_from")
    private String commitFrom;

    @JsonProperty("created_at")
    private String createdAt;

    private Long length;
}
