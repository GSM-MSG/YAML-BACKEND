package project.gsm.yaml.dto;

import lombok.*;
import project.gsm.yaml.entity.Major;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OutsideAwardDto {
    private String outsideAward;
    private String outsideAwardFileURL;

    public Major outsideAwordEntity(){
        return Major.builder()
                .outsideAward(this.outsideAward)
                .outsideAwardFileURL(this.outsideAwardFileURL)
                .build();
    }
}
