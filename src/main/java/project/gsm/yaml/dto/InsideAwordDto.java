package project.gsm.yaml.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import project.gsm.yaml.entity.Major;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsideAwordDto {
    private String insideAward;

    public Major insideAwordEntity(){
        return Major.builder()
                .insideAward(this.insideAward)
                .build();
    }
}
