package project.gsm.yaml.entity.major;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Prize {
    GSM_FESTIVAL("GSM Festival"),
    MAJOR_CLUB_PRESENTATION_CONTEST("전공동아리 발표대회");

    private final String name;
}
